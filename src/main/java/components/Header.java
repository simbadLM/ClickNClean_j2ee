package components;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.UserStatus;

public class Header {
    public static String Render(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        UserStatus status = UserStatus.fromString((String)session.getAttribute("status")); // This needs to be casted from Object(session) -> String
        String headerId = status.toString();
        PrintWriter out = response.getWriter();
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

            default:
                    headerId = "invite";
                    System.out.println("No connected profile was found, rendering invite");
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
