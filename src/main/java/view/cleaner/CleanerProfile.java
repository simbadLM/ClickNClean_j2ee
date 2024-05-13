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
import model.CleanerExperience;

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
            // + "<p>Bonjour, ici vous pourrez éditer votre profile"
            + "<form action='http://localhost:9090/clickNclean_j2ee/CleanerProfileController' method='POST'>"
            + "     <table class='profile_input'><tbody>"
            + "         <tr>"
            + "             <td class='profile_input'>name: </td>"
            + "             <td><input class='profile_input' type='text' name='name' value='" + cleaner.getName() + "'></td>"
            + "         </tr>"
            + "         <tr>"
            + "             <td class='profile_input'>surname: </td>"
            + "             <td><input class='profile_input' type='text' name='surname' value='" + cleaner.getSurname() + "'></td>"
            + "         </tr>"
            + "         <tr>"
            + "             <td class='profile_input'>email: </td>"
            + "             <td><input class='profile_input' type='text' name='email' value='" + cleaner.getEmail() + "'></td>"
            + "         </tr>"
            + "         <tr>"
            + "             <td class='profile_input'>phoneNbr: </td>"
            + "             <td><input class='profile_input' type='text' onkeypress='return event.charCode >= 48 && event.charCode <= 57' name='phoneNbr' value='" + cleaner.getPhoneNumber() + "'></td>"
            + "         </tr>"
            + "         <tr>"
            + "             <td class='profile_input'>kmRange: </td>"
            + "             <td><input class='profile_input' type='text' onkeypress='return event.charCode >= 48 && event.charCode <= 57' name='kmRange' value='" + cleaner.getKmRange() + "'></td>"
            + "         </tr>"
            + "         <tr>"
            + "             <td class='profile_input'>hourlyRate: </td>"
            + "             <td><input class='profile_input' type='text' onkeypress='return event.charCode >= 48 && event.charCode <= 57' name='hourlyRate' value='" + cleaner.getHourlyRate() + "'></td>"
            + "         </tr>"
            + "         <tr>"
            + "             <td class='profile_input'>biography: </td>"
            + "             <td><input class='profile_input' type='text' name='biography' value='" + cleaner.getBiography() + "'></td>"
            + "         </tr>"
            + "         <tr>"
            + "             <td class='profile_input'>motivation: </td>"
            + "             <td><input class='profile_input' type='text' name='motivation' value='" + cleaner.getMotivation() + "'></td>"
            + "         </tr>"
            + "         <tr>"
            + "             <td class='profile_input'>experience: </td>"
            + "             <td>"
            + "                 <select name='experience' id='experience' class='profile_input'>"
            +                       this.createCleanerExperienceSelect(cleaner)
            + "                 </select>"
            + "             </td>"
            + "         </tr>"
            + "     </tbody></table>"
            + "     <input type='submit' value='Valider' class='profile_input'>"
            + "</form>"
            + Page.BottomPage(response)
        );
    }
    private String createCleanerExperienceSelect(Cleaner instance) {
        String out = new String();

        CleanerExperience instance_xp = instance.getExperience();

        for (CleanerExperience xp : CleanerExperience.values()) {
            System.out.println("Test cleaner xp loop: " + xp);

            String html = "<option value= " + xp.asInt() + "  " + ((instance_xp.asInt() == xp.asInt()) ? "selected" : "") + ">" + xp.toString() + "</option>";

            System.out.println(html);
            out += html;
        }

        return out;
    }
}