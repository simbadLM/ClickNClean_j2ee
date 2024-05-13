package controller.owner;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Owner;
import model.Mission;
import model.MissionStatus;
import tools.Db;

@WebServlet(name = "ownerFetchMission", urlPatterns = {"/ownerFetchMissions"})
public class OwnerFetchMissions extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("OwnerFetchMissions requested !");
        HttpSession session = request.getSession();

        int ownerId = ((Owner)session.getAttribute("user")).getOwnerId();
        int missionId = -1;
        int cleanerId = -1;

        ArrayList<Mission> missionList = new ArrayList<>();
        
        if (request.getParameter("missionId") != null) {
            missionId = Integer.parseInt(request.getParameter("missionId"));
        }
       
        if (request.getParameter("cleanerId") != null) {
           cleanerId = Integer.parseInt(request.getParameter("cleanerId"));
        }

        Db connection = new Db();

        if (request.getParameter("cleanerId") != null) {
            try {
                connection.DAOOwnerMissionSetCleaner(missionId, cleanerId);
            } catch (Exception e) {
                System.err.println("[ERROR] Failed to set cleaner for mission (" + missionId + ") due to: " + e);
            }
        }

        try {
            missionList = connection.DAOReadMissionsOwner(ownerId);
            missionList.removeIf(m -> (m.getState() == MissionStatus.RESOLVED_DISPUTE_OWNER_IS_RIGHT 
                || m.getState() == MissionStatus.RESOLVED_DISPUTE_CLEANER_IS_RIGHT 
                || m.getState() == MissionStatus.OPENED_DISPUTE 
                || m.getState() == MissionStatus.OWNER_VALIDATED)); 
            session.setAttribute("missionList", missionList);
        } catch (Exception e) {
            System.err.println("Failed to fetch missions for owner n° : " + ownerId + "due to : " + e);
            //TODO: Alert owner that fetching missions has failed.
            return;
        }

        
        response.sendRedirect(request.getContextPath() + "/owner-my-missions");

    }
}