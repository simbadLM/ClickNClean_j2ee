package view.cleaner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import components.Page;
import model.Cleaner;

@WebServlet(name = "CleanerProfile", urlPatterns = {"/cleanerProfile"})
public class CleanerProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();

        Cleaner cleaner = (Cleaner) session.getAttribute("user");

        PrintWriter out = response.getWriter();
        out.println(
            Page.TopPage(request, response)
            + "<p>Bonjour, ici vous pourrez éditer votre profile"
            + "<form action='http://localhost:9090/clickNclean_j2ee/CleanerProfileController' method='POST'>"
            + "    <span>name</span> <input class='profile_input' type='text' name='name' value='" + cleaner.getName() + "'><br>"
            + "    <span>surname</span> <input class='profile_input' type='text' name='surname' value='" + cleaner.getSurname() + "'><br>"
            + "    <span>email</span> <input class='profile_input' type='text' name='email' value='" + cleaner.getEmail() + "'><br>"
            + "    <span>phoneNbr</span> <input class='profile_input' type='text' onkeypress='return event.charCode >= 48 && event.charCode <= 57' name='phoneNbr' value='" + cleaner.getPhoneNumber() + "'><br>"
            + "    <span>kmRange</span> <input class='profile_input' type='text' onkeypress='return event.charCode >= 48 && event.charCode <= 57' name='kmRange' value='" + cleaner.getKmRange() + "'><br>"
            + "    <span>hourlyRate</span> <input class='profile_input' type='text' onkeypress='return event.charCode >= 48 && event.charCode <= 57' name='hourlyRate' value='" + cleaner.getHourlyRate() + "'><br>"
            + "    <span>biography</span> <input class='profile_input' type='text' name='biography' value='" + cleaner.getBiography() + "'><br>"
            + "    <span>motivation</span> <input class='profile_input' type='text' name='motivation' value='" + cleaner.getMotivation() + "'><br>"
            + "    <span>experience</span> <input class='profile_input' type='text' name='experience' value='" + cleaner.getExperience() + "'><br>"
            + "    <input type='submit' value='Submit'>"
            + "</form>"
            + Page.BottomPage(response)
        );
    }
}