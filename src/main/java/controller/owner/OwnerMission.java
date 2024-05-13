package controller.owner;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Property;
import tools.Db;

@WebServlet(name = "ownerMission", urlPatterns = {"/ownerMission"})
public class OwnerMission extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("OwnerMission requested !");
        HttpSession session = request.getSession();

        int propertyId = Integer.parseInt(request.getParameter("property"));
        Db connection = new Db();
        Property property = null;
        LocalDateTime date = LocalDateTime.of(LocalDate.parse(request.getParameter("date")), LocalTime.now());

        try {
            property = connection.DAOReadProperty(propertyId);
        } catch (Exception e) {
            System.err.println("Failed to read property for property's id : " + propertyId + " due to : " + e);
        }

        try {
            connection.DAOCreateNewMission(property, date);
            session.setAttribute("missionCreation", "succed");
        } catch (Exception e) {
            System.out.println("Failed to create a mission with : \n"
                               + "property n° " + propertyId
                               + "\n date : " + date
                              );
            session.setAttribute("missionCreation", "failed");
            response.sendRedirect(request.getContextPath() + "/OwnerMainController");
        }
        String dateDisplay = (
                                 Integer.toString(date.getDayOfMonth()) + "/"
                                 + Integer.toString(date.getMonthValue()) + "/"
                                 + Integer.toString(date.getYear())
                             );
        session.setAttribute("dateMission", dateDisplay);
        response.sendRedirect(request.getContextPath() + "/OwnerMainController");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}