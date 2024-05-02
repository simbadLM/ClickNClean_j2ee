package controller.cleaner;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import components.Page;
import tools.Db;
import tools.MissionDisplay;
import model.Cleaner;
import model.Mission;
import model.MissionStatus;
import model.Owner;

@WebServlet(name = "CleanerMainController", urlPatterns = {"/CleanerMainController"})
public class CleanerMainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Db db = new Db();
        Cleaner cleaner = (Cleaner)session.getAttribute("user");

        ArrayList<Mission> missions = new ArrayList<Mission>();

        try {
            missions = db.DAOReadMissions();
        } catch (Exception e) {
            System.err.println("Could not fetch missions from db due to: " + e);
        }

        System.out.println("Fetched " + missions.size() + " missions");

        missions.removeIf(m -> (m.getState() != MissionStatus.PUBLISHED || m.getMissionDateTime().isBefore(LocalDateTime.now())));

        missions.removeIf(m -> {
            return cleaner.getKmRange() < Math.abs(m.getProperty().getPropertyAddress().calculateDistance(cleaner.getDepartureAddress()));
        });

        missions.removeIf(m -> {
            ArrayList<Cleaner> proposals;
            try{
                proposals = db.DAOReadMissionProposal(m.getMissionId());
            } catch (Exception e) {
                System.err.println("Could not get proposals for mission: " + m.getMissionId() + " due to: " + e);
                return true;
            }
            System.out.println("Checking " + proposals.size() + " proposals");

            for (Cleaner c : proposals) {
                if (c.getCleanerId() == cleaner.getCleanerId()) {
                    return true;
                }
            }

            return false;

        });

        System.out.println("Writing " + missions.size() + " missions");

        ArrayList<MissionDisplay> missions_display = new ArrayList<MissionDisplay>();

        for (Mission m : missions) {
            Owner owner;
            try {
                owner = db.DAOReadOwner(m.getOwnerId());
            } catch (Exception e) {
                System.err.println("Could not get the owner for mission: " + m.getMissionId() + " due to :" + e);
                continue;
            }

            double range = m.getProperty().getPropertyAddress().calculateDistance(cleaner.getDepartureAddress());

            missions_display.add(new MissionDisplay(m.getMissionId(), m.getMissionDateTime() , owner.getSurname(), Math.abs(range), m.getDuration()));
        }


        session.setAttribute("missions", missions_display);

        response.sendRedirect((request.getContextPath() + "/cleanerHome"));

    }
}