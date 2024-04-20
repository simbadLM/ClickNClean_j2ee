package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import components.Page;
import model.UserStatus;

@WebServlet(name = "Homepage", urlPatterns = {"/accueil"})
public class Homepage extends HttpServlet {
    boolean redirected; 

    String renderRedirectMessage(HttpSession currentSession, boolean redirected) {
        currentSession.setAttribute("connection", "");
        return ((redirected) ? "<p class=\"alert\">Identifiant ou mot de passe incorrect</p>" : "");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("Homepage requested !");

        HttpSession session = request.getSession();
        session.setAttribute("status", UserStatus.UNKNOWN.toString());

        if (session.getAttribute("connection") != null && session.getAttribute("connection").equals("failed")) redirected = true;

       
        PrintWriter out = response.getWriter();
        Page.TopPage(request, response);
        out.println(
            "<div id='connectionForm'>"
            +   "<h1>Connexion</h1>"
                 + renderRedirectMessage(session, redirected) 
            +   "<form method='post' action='http://localhost:9090/clickNclean_j2ee/login'>"
            +       "<input class='connectionField' type='text' name='email' placeholder='E-mail' required>"
            +       "<input class='connectionField' type='password' name='password' placeholder='Mot de passe' required>"
            +       "<input id='button' type='submit' value='JE ME CONNECTE'>"
            +   "</form>"
            +"</div>"
        );
        Page.BottomPage(response);
    }
}