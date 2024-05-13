package view.owner;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import components.Page;
import model.Cleaner;

@WebServlet(name = "OwnerSeeMissionProposals", urlPatterns = {"/owner-pick-a-cleaner"})
public class OwnerSeeMissionProposals extends HttpServlet {

    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        ArrayList<Cleaner> cleanerList = new ArrayList<>();
        int missionProposalId = -1;

        if (session.getAttribute("missionProposalId") != null) {
            missionProposalId = (Integer) session.getAttribute("missionProposalId");
        }
       
        if (session.getAttribute("missionProposal") != null) {
           cleanerList = (ArrayList<Cleaner>)session.getAttribute("missionProposal");
        }

        out.println(
            Page.TopPage(request, response)
            + "<section class='sec1addProp'>"
            +   "<div>"
            +       "<h2 class='sec1title'>MES MISSIONS</h2>"
            +   "</div>"
            +   "<div>"
            +   "</div>"
            + "</section>"
            +  renderCleaner(request, cleanerList, missionProposalId)
            +Page.BottomPage(response)
        );
    }
    public String renderCleaner(HttpServletRequest request, ArrayList<Cleaner> cleaners, int missionProposalId) {
        String display = "";

        for (Cleaner currentCleaner : cleaners) {
                int age = LocalDate.now().getYear() - currentCleaner.getBirthDate().getYear();
                display += (
                    "<div class='missionField'>"
                    +   currentCleaner.getName() + " " + currentCleaner.getSurname() + " ("+ age +" ans), <i>" 
                    +   " inscrit depuis le " + currentCleaner.getAccountDate() + "</i>"
                    +   "<br>Motivation : <i>" + currentCleaner.getMotivation() + "</i>"
                    +   "<br>Expérience en ménage : " + currentCleaner.getExperience().toString()
                    +   "<form method='get' action='"+ request.getContextPath() + "/ownerFetchMissions'>"
                    +       "<input name = 'cleanerId' type='hidden' value='"+ currentCleaner.getCleanerId() +"'>"
                    +       "<input name = 'missionId' type='hidden' value='"+ missionProposalId +"'>"
                    +       "<input type='submit' value='Sélectionner un Cleaner'/>"
                    +    "</form>"
                    + "</div>"
                );
        }

        return (
            "<section>"
            +   "<div class='missionContainer'>"
            +       display
            +   "</div>"
            +"</section"
        );
    }
}