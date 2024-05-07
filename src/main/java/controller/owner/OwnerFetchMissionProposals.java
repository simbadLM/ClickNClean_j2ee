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
import model.Cleaner;
import model.Mission;
import model.MissionStatus;
import tools.Db;

@WebServlet(name = "ownerFetchMissionProposals", urlPatterns = {"/ownerFetchMissionProposals"})
public class OwnerFetchMissionProposals extends HttpServlet {
   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("OwnerFetchMissionProposals requested !");
        HttpSession session = request.getSession();
        ArrayList<Cleaner> cleanerList = new ArrayList<>();
        int missionId = Integer.parseInt(request.getParameter("missionId"));

        Db connection = new Db();

        try {
            cleanerList = connection.DAOReadMissionProposal(missionId);
            session.setAttribute("missionProposalId", missionId);
            session.setAttribute("missionProposal", cleanerList);
        } catch (Exception e) {
            System.err.println("Failed to fetch mission proposals for mission n° : " + missionId + "due to : " + e);
            //TODO: Alert owner that fetching mission proposals has failed.
            return;
        }

        response.sendRedirect(request.getContextPath() + "/owner-pick-a-cleaner");

    }
}