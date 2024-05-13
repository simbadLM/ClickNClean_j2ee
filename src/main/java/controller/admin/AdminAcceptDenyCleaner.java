package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.Db;
import model.ActivityType;

@WebServlet(name = "AdminAcceptDenyCleaner", urlPatterns = { "/AdminAcceptDenyCleaner" })
public class AdminAcceptDenyCleaner extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Db db = new Db();

        int cleanerId = Integer.parseInt(request.getParameter("cleaner_id"));
        boolean accepted = Boolean.parseBoolean(request.getParameter("accepted"));

        if (accepted) {
            try {
                db.DAOConfirmCleaner(cleanerId);
                db.DAOaddActivity(ActivityType.CLEANER_ACCOUNT_CONFIRMED, cleanerId, null, cleanerId, null,
                                  null, 1);
                System.out.println("Cleaner with id: " + cleanerId + " has been accepted by the admin");
            } catch (Exception e) {
                System.err.println("Failled to confirm the account of cleaner with id: " + cleanerId + " due to: " +  e);
            }
        } else {
            try {
                db.DAOSuspendUser(cleanerId, true);
                System.out.println("Cleaner with id: " + cleanerId + " has been denined the admin");
            } catch (Exception e) {
                System.err.println("Failled to deny the account of cleaner with id: " + cleanerId + " due to: " +  e);
            }
        }

        response.sendRedirect((request.getContextPath() + "/adminHome"));
    }
}