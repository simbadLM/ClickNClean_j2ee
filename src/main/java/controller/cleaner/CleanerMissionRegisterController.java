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

import components.Page;
import tools.Db;
import tools.MissionDisplay;
import model.Cleaner;
import model.Mission;
import model.MissionStatus;
import model.Owner;

@WebServlet(name = "CleanerRegisterMissionController", urlPatterns = { "/CleanerRegisterMissionController" })
public class CleanerMissionRegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();

        Cleaner cleaner = (Cleaner) session.getAttribute("user");

        int mission_id = Integer.parseInt(request.getParameter("id"));

        Db db = new Db();

        System.out.println(
            "Cleaner with id: " + cleaner.getCleanerId() + " wants to register on mission with id: " + mission_id);

        try {
            Mission mission = db.DAOReadMission(mission_id);
            db.DAOCreateNewMissionProposal(mission_id, cleaner.getCleanerId(), mission.getMissionDateTime());
        } catch (Exception e) {
            System.err.println(e);
        }

        response.sendRedirect((request.getContextPath() + "/CleanerMainController"));

    }
}