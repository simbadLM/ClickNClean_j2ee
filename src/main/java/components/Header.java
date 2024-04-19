package components;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import models.UserStatus;

public class Header {
    public static String Render(HttpServletResponse response, UserStatus status) throws IOException {
        PrintWriter out = response.getWriter();
        String headerId = "invite";
        boolean connected = false;

        switch (status) {
        case CLEANER : {
            headerId = "cleaner";
            connected = true;
        }
        case OWNER : {
            headerId = "owner";
            connected = true;
        }
        case ADMIN: {
            headerId = "admin";
            connected = true;
        }

        case UNKNOWN: {
            break;
        }


        }
        if (connected == true ) {
            return (
                       "<header>"
                       + " <div id='" + headerId + "'>"
                       + "     <ul>"
                       + "         <li id = 'logo1'><a href='http://localhost:9090/clickNclean_j2ee/accueil'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                       + "         <li></li>"
                       + "         <li></li>"
                       + "         <li id = 'logo2><a href='http://localhost:9090/clickNclean_j2ee/accueil'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                       + "     </ul>"
                       + " </div>"
                       + "</header>"
                   );
        }

        else {
            return (
                       "<header>"
                       + " <div id='" + headerId + "'>"
                       + "     <ul>"
                       + "         <li id = 'logo1'><a href='http://localhost:9090/clickNclean_j2ee/accueil'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                       + "         <li></li>"
                       + "         <li></li>"
                       + "         <li id = 'logo2><a href='http://localhost:9090/clickNclean_j2ee/accueil'> <img id='logo' src='./resources/logo_cnc_noBg.png'></a></li>"
                       + "     </ul>"
                       + " </div>"
                       + "</header>"
                   );
        }

    }
}
