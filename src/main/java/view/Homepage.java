package view;

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
        if (session.getAttribute("askedRegistered") == null) session.setAttribute("askedregistered", "none");
       
        PrintWriter out = response.getWriter();
        
        out.println(
            Page.TopPage(request, response)
            + "<section class='sec1'>"
            +   "<div>"
            +       "<h2>RECHERCHEZ UNE PRESTATION DE MÉNAGE</h2>"
            +   "</div>"
            +   "<div>"
            +       "<h2>DÉPOSEZ VOTRE ANNONCE DE MÉNAGE PONCTUEL</h2>"
            +   "</div>"
            + "</section>"
            + "<section class='sec2'>"
            +   "<div class='buttonContainer'>"
            +       "<button id='buttonCleaner' onclick='registerCleaner();'><b>S'INSCRIRE</b> comme <b>CLEANER</b></button>"
            +       "<p>Du temps libre  à transformer en argent ? Besoin d’un complément de revenu ?  "
            +           "Ou tout simplement vous adorez faire le ménage ! "
            +           "CLICK & CLEAN est LA plateforme PARFAITE pour combler votre activité le temps de quelques heures par semaine. "
            +           "PAS ❌ de contrat, PAS ❌ de contrainte, votre rémunération vous va directement dans votre POCHE ✅ "
            +           "Et oui, je ne suis pas votre employeur ! 😁 Vous êtes LIBRE !"
            +       "</p>"
            +   "</div>"
            +       "<div id='mainContent'>"
            +           "<div id='connectionForm'>"
            +               "<h1>Connexion</h1>"
            +               renderRedirectMessage(session, redirected) 
            +               "<form method='post' action='http://localhost:9090/clickNclean_j2ee/login'>"
            +                   "<input class='inputField' type='text' name='email' placeholder='E-mail' required>"
            +                   "<input class='inputField' type='password' name='password' placeholder='Mot de passe' required>"
            +                   "<input class='button' type='submit' value='JE ME CONNECTE'>"
            +               "</form>"
            +           "</div>"
            +       "</div>"
            +   "<div class='buttonContainer'>"
            +       "<button id='buttonOwner' onclick='registerOwner();'><b>S'INSCRIRE</b> comme <b>TIDI-SEEKER</b></button>"
            +       "<p>Besoin d’un ménage ponctuel ? Pas envie de vous embêter avec un contrat ?<br>"
            +           "CLICK & CLEAN est LA plateforme parfaite pour trouver un Cleaner MOTIVÉ, FORMÉ, VÉRIFIÉ rapidement."
            +           "Et oui, faire le ménage ça demande du temps et c’est un métier ! 😁 "
            +           "Réservez votre service de ménage en quelques clics ! Simplifiez-vous la vie et profitez d'un environnement propre et accueillant, sans les complications d'un contrat à long terme."
            +       "</p>"
            +   "</div>"
            + "</section>"
            +Page.BottomPage(response)
        ); 
    }
}