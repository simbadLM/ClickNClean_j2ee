package pages;

import static j2html.TagCreator.*;
import static j2html.TagCreator.html;
import static j2html.TagCreator.label;
import static j2html.TagCreator.label;
import j2html.tags.ContainerTag;
import j2html.tags.Text;

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("Homepage requested !");

        HttpSession session = request.getSession();
        session.setAttribute("status", UserStatus.UNKNOWN.toString());
            
    
        String title = " ";
        response.setContentType("text/html;charset=UTF-8");
        if (request.getPathInfo() != null) {
            title = request.getPathInfo().replace("/", "");
        }
        PrintWriter out = response.getWriter();
        Page.TopPage(request, response, title);
        out.println(
            "<div id='connectionForm'>"
            +   "<h1>Connexion</h1>"
            +   "<form method='post' action='http://localhost:9090/clickNclean_j2ee/login'>"
            +       "<input class='connectionField' type='text' placeholder='E-mail'>"
            +       "<input class='connectionField' type='text' placeholder='Mot de passe'>"
            +       "<input id='button' type='submit' value='JE ME CONNECTE'>"
            +   "</form>"
            +"</div>"
        );
        Page.BottomPage(response);
    }
}