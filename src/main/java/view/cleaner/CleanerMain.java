package view.cleaner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import components.Page;
import model.Mission;
import model.Property;
import tools.MissionDisplay;

@WebServlet(name = "CleanerMain", urlPatterns = {"/cleanerHome"})
public class CleanerMain extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<MissionDisplay> missions = (ArrayList<MissionDisplay>)session.getAttribute("missions");

        PrintWriter out = response.getWriter();

        String html =
            Page.TopPage(request, response)
            + "<p>Bonjour </p>"
            + "<br><p>Les missions disponibles</p>";

        for (MissionDisplay m : missions) {
            html +=
                "<div class='mission_list'>"
                + " <div class='mission_proposal'>"
                + "     <p>Mission de " + m.getOwnerFirstName() + ":<br>" + m.getDuration() + "heure(s), le " + m.getDate() + "</p>"
                + "     <button onclick='acceptMission(" + m.getMissionId() + ")'/>Postuler pour la mission</button>"
                + " </div>"
                + "</div>";
        }

        html += Page.BottomPage(response);
        out.println(
            html
        );
    }
}