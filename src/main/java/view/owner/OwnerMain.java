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
import model.Property;

@WebServlet(name = "OwnerMain", urlPatterns = {"/ownerHome"})
public class OwnerMain extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println(
            Page.TopPage(request, response)
            + missionCreatedMessage(request, response)
            + "<section class='sec1owner'>"
            +   "<div>"
            +       "<h2 class='sec1title'>DÉPOSEZ VOTRE MÉNAGE PONCTUEL</h2>"
            +   "</div>"
            +   "<div id='createMission'>"
            +       "<form method='post' action='http://localhost:9090/clickNclean_j2ee/ownerMission'>"
            +           selectProperties(request, response)
            +           "<input type='date' name='date' required>"
            +           "<input class='button' type='submit' value='CLICK & CLEAN'>"
            +       "</form>"
            +   "</div>"
            + "</section>"
            + "<section class='sec2owner'>"
            +   "<div>"
            +       "<div id=sec2owner_container>"
            +           "<div>"
            +               "<h2>CLICK & CLEAN ?</h2>"
            +           "</div>"
            +           "<div>"
            +               "<p>"
            +                   "CLICK & CLEAN, c’est : tu CLICK pour déposer ton offre de ménage et tu CLEAN pour "
            +                       "le faire nettoyer par un SUPER Cleaner<br>Maîtres mots :"
            +               "</p>"
            +                   "<ul>"
            +                       "<li>Facilité</li>"
            +                       "<li>Rapidité</li>"
            +                       "<li>Propreté</li>"
            +                   "</ul>"
            +               "<p>"
            +                   "En 1 click, nettoie ton bien !"
            +               "</p>"
            +           "</div>"
            +       "</div>"
            +   "</div>"
            +   "<div>"
            +       "<img id='cleaner_pic' src='./resources/cleaner_pic.png'>"
            +   "</div>"
            + "</section>"
            +Page.BottomPage(response)
        );
    }

    public String missionCreatedMessage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String date = "";
        String message = "";

        if (session.getAttribute("dateMission") != null) date = (String)session.getAttribute("dateMission");
        if (session.getAttribute("missionCreation") != null && session.getAttribute("missionCreation").equals("succed")) {
            message = ("<h3 id='mission1'>Votre mission du " + date + " a été publiée avec succès</h3>");
            session.removeAttribute("dateMission");
            session.removeAttribute("missionCreation");
        }
        else if (session.getAttribute("missionCreation") != null && session.getAttribute("missionCreation").equals("failed")) {
            message = ("<h3 id='mission0'>Échec lors de la création de la mission du " + date + ", veuillez "
                +" réessayer.</h3>");
            session.removeAttribute("dateMission");
            session.removeAttribute("missionCreation");
        }
        return message;
    }

    public String selectProperties(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        ArrayList<Property> properties = (ArrayList<Property>)session.getAttribute("properties");
        String propertiesString = (
            "<select class='inputFieldProp' name='property' required onchange='addProp(value);'>"
            +   "<option value='' >--Choix des propriétés--</option>"
        );

        for (Property currentPro : properties) {
            String display = "<option value ='"+ currentPro.getPropertyId() + "' >" +currentPro.getPropertyAddress().asString()
                + "</option>";
            propertiesString += display;   
        }
        return (
                   propertiesString
                   + "<option value='addProp'> + Ajouter une nouvelle propriété</option>"
                   + "</select>");
    }
}