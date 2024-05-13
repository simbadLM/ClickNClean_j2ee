package view.owner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import components.Page;
import model.Mission;
import model.MissionStatus;


@WebServlet(name = "OwnerSeeMissions", urlPatterns = {"/owner-my-missions"})
public class OwnerSeeMissions extends HttpServlet {

    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        ArrayList<Mission> missionList = new ArrayList<>();
       
        if (session.getAttribute("missionList") != null) {
           missionList = (ArrayList<Mission>)session.getAttribute("missionList");
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
            +  renderMissions(request, missionList)
            +Page.BottomPage(response)
        );
    }
    public String renderMissions(HttpServletRequest request, ArrayList<Mission> missions) {
        String display = "";

        for (Mission currentMission : missions) {
            if (currentMission.getState() != MissionStatus.PROPOSED) {
                display += (
                    "<div class='missionField'>"
                    +   currentMission.getMissionDate() + " : " + " pour le bien au <i>" 
                    +   currentMission.getProperty().getPropertyAddress().asString() + "</i>"
                    +   "<br>Statut : " + currentMission.getState().asString()
                    + "</div>"
                );
            }
            else if (currentMission.getState() == MissionStatus.PROPOSED) {
                display += (
                    "<div class='missionField'>"
                    +   currentMission.getMissionDate() + " : " + " pour le bien au <i>" 
                    +   currentMission.getProperty().getPropertyAddress().asString() + "</i>"
                    +   "<br>Statut : " + currentMission.getState().asString()
                    +   "<form method='get' action='"+ request.getContextPath() + "/ownerFetchMissionProposals'>"
                    +       "<input name= 'missionId' type='hidden' value='"+ currentMission.getMissionId() +"'>"
                    +       "<input type='submit' value='Sélectionner un Cleaner'/>"
                    +    "</form>"
                    + "</div>"
                );
            }
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