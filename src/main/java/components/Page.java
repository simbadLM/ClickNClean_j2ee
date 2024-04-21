package components;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserStatus;

public class Page {
    public static String url;
    public static UserStatus sessionHost;

    public static String TopPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = "";
        response.setContentType("text/html;charset=UTF-8");
        if (request.getPathInfo() != null) {
            title = request.getPathInfo().replace("/", "");
        }
        return(
            "<!DOCTYPE html>"
            + "<html lang='fr'>"
            + "<head>"
            +    "<link rel='stylesheet' href='./resources/style.css'>"
            +    "<meta charset='UTF-8'>"
            +    "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
            +        "<title> " + title + "</title>"
            + "</head>"
            + "<body>" + Page.Header(request, response)
        );
    }

    public static String BottomPage(HttpServletResponse response) throws IOException {
        return(
            "</body>"
            + "</html>"
        );
    }

    public static String Header(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        UserStatus status = UserStatus.fromString((String)session.getAttribute("status")); // This needs to be casted from Object(session) -> String
        String headerId = status.toString();
        boolean connected = false;

        switch (status) {
            case CLEANER : 
                    headerId = "cleaner";
                    connected = true;
                    break;
            case OWNER : 
                    headerId = "owner";
                    connected = true;
                    break;
            case ADMIN: 
                    headerId = "admin";
                    connected = true;
                    break;
            case UNKNOWN:
                    headerId = "invite";
                    break;
            default:
                    headerId = "invite";
        }
        if (connected) {
            return(
                "<header>"
                + " <div id='" + headerId + "'>"
                + "     <ul>"
                + "         <li id = 'logo1'><a href='http://localhost:9090/clickNclean_j2ee/accueil'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                + "         <li></li>"
                + "         <li></li>"
                + "         <li id = 'logo2'><a href='http://localhost:9090/clickNclean_j2ee/accueil'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                + "     </ul>"
                + " </div>"
                + "</header>"
            );
        }
        else {
            return(
                "<header>"
                + " <div id='" + headerId + "'>"
                + "     <ul>"
                + "         <li id = 'logo1'><a href='http://localhost:9090/clickNclean_j2ee/accueil'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                + "         <li></li>"
                + "         <li></li>"
                + "         <li id = 'logo2'><a href='http://localhost:9090/clickNclean_j2ee/accueil'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                + "     </ul>"
                + " </div>"
                + "</header>"
            );
        }
    }


    
}
