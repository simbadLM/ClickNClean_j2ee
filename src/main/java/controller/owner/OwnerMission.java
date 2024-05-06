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

import model.Property;
import tools.Db;

@WebServlet(name = "ownerMission", urlPatterns = {"/ownerMission"})
public class OwnerMission extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("OwnerMission requested !");

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
            //TODO: Avert user mission has been created successfully
        } catch (Exception e) {
            System.err.println("Failed to create a mission with : \n"
                               + "property n° " + propertyId
                               + "\n date : " + date
                              );
            //TODO: Avert user that the mission wouldn't be created
            return;
        }
        response.sendRedirect(request.getContextPath() + "/OwnerMainController");
    }
}