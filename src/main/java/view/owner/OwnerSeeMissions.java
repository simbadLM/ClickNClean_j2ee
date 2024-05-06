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


@WebServlet(name = "OwnerSeeMissions", urlPatterns = {"/owner-my-missions"})
public class OwnerSeeMissions extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        @SuppressWarnings("unchecked")
        ArrayList<Mission> missionList = (ArrayList<Mission>) session.getAttribute("MissionList");

        out.println(
            Page.TopPage(request, response)
            + "<section class='sec1addProp'>"
            +   "<div>"
            +       "<h2 class='sec1title'>MES MISSIONS</h2>"
            +   "</div>"
            +   "<div>"
            +   "</div>"
            + "</section>"
            +Page.BottomPage(response)
        );
    }
    public String renderMissions(HttpServletRequest request, ArrayList<Mission> missions) {
        String display = "";

        for (Mission currentMission : missions) {

        }

        return (
            "<section>"
            +   "<div class='missionContainer'>"
            +       "<>"
            +   "</div>"
            +"</section"
        );
    }
}