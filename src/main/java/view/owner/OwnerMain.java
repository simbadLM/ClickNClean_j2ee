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
import model.Property;

@WebServlet(name = "OwnerMain", urlPatterns = {"/OwnerMain"})
public class OwnerMain extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println(
            Page.TopPage(request, response)
            + "<section class='sec1owner'>"
            +   "<div>"
            +       "<h2 class='sec1title'>DÉPOSEZ VOTRE MÉNAGE PONCTUEL</h2>"
            +   "</div>"
            +   "<div id='createMission'>"
            +       "<form method='post' action='http://localhost:9090/clickNclean_j2ee/ownerMission'>"
            +           selectProperties(request, response)
            +           "<input type='date' name='date'>"
            +           "<input class='button' type='submit' value='Click & CLEAN'>"
            +       "</form>"
            +   "</div>"
            + "</section>"
            +Page.BottomPage(response)
        );
    }
    public String selectProperties(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        ArrayList<Property> properties = (ArrayList<Property>)session.getAttribute("properties");
        String propertiesString = (
            "<select class='inputFieldProp' name='property' required>"
            +   "<option value='' >--Merci de choisir une option--</option>"
        );

        for (Property currentPro : properties) {
            String display = currentPro.getPropertyAddress().toString();
            propertiesString += display;
        }

        return (
            propertiesString 
            + "<option onclick='addProp();'> + Ajouter une nouvelle propriété</option>"
            + "</select>");
    }
}