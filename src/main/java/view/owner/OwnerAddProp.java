package view.owner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import components.Page;


@WebServlet(name = "OwnerAddProp", urlPatterns = {"/newProperty"})
public class OwnerAddProp extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println(
            Page.TopPage(request, response)
            + "<section class='sec1addProp'>"
            +   "<div>"
            +       "<h2 class='sec1title'>AJOUT D'UNE NOUVELLE PROPRIÉTÉ</h2>"
            +   "</div>"
            +   "<div>"
            +       "<form  id='propertyForm' method='post' action='http://localhost:9090/clickNclean_j2ee/ownerNewProp'>"
            +           "<h2>Adresse du bien</h2>"
            +           "<input class='inputField' type='text' name='houseN' placeholder='Numéro' required>"
            +           "<input class='inputField' type='text' name='label' placeholder='Nom de la rue, voie' required>"
            +           "<input class='inputField' type='text' name='postcode' placeholder='Code postal' required>"
            +           "<input class='inputField' type='text' name='city' placeholder='Ville' required>"
            +           "<input class='inputField' type='text' name='surfaceProperty' placeholder='Surface du bien en m2' required>"
            +           "<input class='button' type='submit' value='AJOUTER LA PROPRIÉTÉ'>"
            +       "</form>"
            +   "</div>"
            + "</section>"
            +Page.BottomPage(response)
        );
    }
}