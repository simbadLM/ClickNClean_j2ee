package controller.owner;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Owner;
import model.Mission;
import model.Property;
import tools.Db;

@WebServlet(name = "ownerFetchMission", urlPatterns = {"/ownerFetchMissions"})
public class OwnerFetchMissions extends HttpServlet {
   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("OwnerFetchMissions requested !");
        HttpSession session = request.getSession();

        int ownerId = ((Owner)session.getAttribute("user")).getOwnerID();
        ArrayList<Mission> missionList = new ArrayList<>();

        Db connection = new Db();

        try {
            missionList = connection.DAOReadMissionsOwner(ownerId);
            session.setAttribute("missionList", missionList);
        } catch (Exception e) {
            System.err.println("Failed to fetch missions for owner n° : " + ownerId + "due to : " + e);
            //TODO: Alert owner that fetching missions has failed.
            return;
        }
        response.sendRedirect(request.getContextPath() + "/owner-my-missions");
    }
}