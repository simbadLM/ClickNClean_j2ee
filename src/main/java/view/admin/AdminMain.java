package view.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import components.Page;
import model.Cleaner;
//import model.Mission;
//import model.Dispute;

@WebServlet(name = "AdminMain", urlPatterns = { "/adminHome" })
public class AdminMain extends HttpServlet {

    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<Cleaner> cleanerToConfirm = (ArrayList<Cleaner>) session.getAttribute("cleanerToConfirm");
        //ArrayList<Pair<Dispute, Mission>> disputes = (ArrayList<Pair<Dispute, Mission>>) session
        //        .getAttribute("dispute");
        // ----------Keep that so the feature of resolving disputes might be implemented later -----------

        System.out.println("We have " + cleanerToConfirm.size() + " cleaners to confirm");

        String html = Page.TopPage(request, response);

        for (Cleaner cleaner : cleanerToConfirm) {
            html += ""
                    + "<div class='admin_cleaner_confirmation'>"
                    + "     <label>Nom: " + cleaner.getName() + "</label>"
                    + "     <p>Né le: " + cleaner.getBirthDate() + "<br>Compte créé le: " + cleaner.getAccountDate()
                    + "         <br>Biographie:<br>&nbsp" + cleaner.getBiography() + "</p>"
                    + "     <span>"
                    + "       <button onclick='acceptCleaner(" + cleaner.getCleanerId() + "," + false + ")'>Deny</button>"
                    + "       <button onclick='acceptCleaner(" + cleaner.getCleanerId() + "," + true + ")'>Accept</button>"
                    + "     </span>"
                    + "</div>";
        }

        html += Page.BottomPage(response);

        response.getWriter().println(html);
    }
}