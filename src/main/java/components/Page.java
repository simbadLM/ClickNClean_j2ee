package components;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserStatus;
import model.Mission;

/*--------------------------------------⬇-Basic components-⬇----------------------------------------*/

public class Page {
    public static String url;
    public static UserStatus sessionHost;

    public static String TopPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = "";
        response.setContentType("text/html;charset=UTF-8");
        if (request.getPathInfo() != null) {
            title = request.getPathInfo().replace("/", "");
        }

        return ("<!DOCTYPE html>"
                + "<html lang='fr'>"
                + "<head>"
                + "<script src='./functions.js'></script>"
                + "<script defer src='./resources/collapsible_menu.js'></script>"
                + "<link rel='stylesheet' href='./resources/style.css'>"
                + "<meta charset='UTF-8'>"
                + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
                + "<title> " + title + "</title>"
                + "</head>"
                + "<body>" + Page.Header(request, response));
    }

    public static String BottomPage(HttpServletResponse response) throws IOException {
        return ("</body>"
                + "</html>");
    }

    public static String Header(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        UserStatus status = UserStatus.fromString((String) session.getAttribute("status")); // This needs to be casted
        // from Object(session) ->
        // String
        String headerId = status.toString();

        switch (status) {
        case CLEANER:
            headerId = "cleaner";
            return ("<header>"
                    + " <div id='" + headerId + "'>"
                    + "     <ul>"
                    + "         <li><a href='http://localhost:9090/clickNclean_j2ee/home'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                    + "         <li></li>"
                    + "         <li></li>"
                    + "         <li><b>Mode Cleaner</b><br>Prestataire de ménage</li>"
                    + "     </ul>"
                    + " </div>"
                    + Menu(request, response)
                    + "</header>");
        case OWNER:
            headerId = "owner";
            return ("<header>"
                    + " <div id='" + headerId + "'>"
                    + "     <ul>"
                    + "         <li><a href='http://localhost:9090/clickNclean_j2ee/home'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                    + "         <li></li>"
                    + "         <li></li>"
                    + "         <li><b>Mode Tidi-seeker</b><br>Chercheur de prestataire</li>"
                    + "     </ul>"
                    + " </div>"
                    + Menu(request, response)
                    + "</header>");
        case ADMIN:
            headerId = "admin";
            return ("<header>"
                    + " <div id='" + headerId + "'>"
                    + "     <ul>"
                    + "         <li><a href='http://localhost:9090/clickNclean_j2ee/home'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                    + "         <li></li>"
                    + "         <li></li>"
                    + "         <li><b>Mode Administrateur</b></li>"
                    + "     </ul>"
                    + " </div>"
                    + Menu(request, response)
                    + "</header>");

        default:
            headerId = "invite";
            return ("<header>"
                    + " <div id='" + headerId + "'>"
                    + "     <ul>"
                    + "         <li><a href='http://localhost:9090/clickNclean_j2ee/home'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                    + "         <li><b>Mode Cleaner</b><br>Prestataire de ménage</li>"
                    + "         <li><b>Mode Tidi-seeker</b><br>Chercheur de prestataire</li>"
                    + "         <li><a href='http://localhost:9090/clickNclean_j2ee/home'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                    + "     </ul>"
                    + " </div>"
                    + "</header>");
        }
    }

    public static String Menu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        UserStatus status = UserStatus.fromString((String) session.getAttribute("status")); // This needs to be casted
        // from Object(session) ->
        // String
        String headerId = status.toString();

        String base_url = request.getContextPath();

        System.out.println("\nHeaderId: " + headerId);
        switch (status) {
        case CLEANER:
            return ("<button type='button' id='menu_button'> <img id='icon' src='./resources/person.png'></button>"
                    + "<div id='dropdown_menu_container'>"
                    + "  <div id='dropdown_menu'>"
                    + "      <a href=" + base_url + "/cleanerNotifications> Notifications </a><br>"
                    + "      <a href=" + base_url + "/cleanerProfile> Compte </a><br>"
                    + "      <hr>"
                    + "      <a href=" + base_url + "/helpCenter> Centre d'aide </a><br>"
                    + "      <a href=" + base_url + "/contact> Contact </a><br>"
                    + "      <a href=" + base_url + "/logout> Déconnexion </a><br>"
                    + "  </div>"
                    + "</div>");
        case OWNER:
            return ("<button type='button' id='menu_button'> <img id='icon' src='./resources/person.png'></button>"
                    + "<div id='dropdown_menu_container'>"
                    + "  <div id='dropdown_menu'>"
                    + "      <a href=" + base_url + "/ownerProfile> Compte </a><br>"
                    + "      <hr>"
                    + "      <a href=" + base_url + "/ownerFetchMissions> Mes missions </a><br>"
                    + "      <hr>"
                    + "      <a href=" + base_url + "/helpCenter> Centre d'aide </a><br>"
                    + "      <a href=" + base_url + "/contact> Contact </a><br>"
                    + "      <a href=" + base_url + "/logout> Déconnexion </a><br>"
                    + "  </div>"
                    + "</div>");

        case ADMIN:
            return ("<button type='button' id='menu_button'> <img id='icon' src='./resources/person.png'></button>"
                    + "<div id='dropdown_menu_container'>"
                    + "  <div id='dropdown_menu'>"
                    + "      <a href=" + base_url + "/helpCenter> Centre d'aide </a><br>"
                    + "      <a href=" + base_url + "/contact> Contact </a><br>"
                    + "      <a href=" + base_url + "/logout> Déconnexion </a><br>"
                    + "  </div>"
                    + "</div>");
        
        default :  return "Menu";
        }
    }
}