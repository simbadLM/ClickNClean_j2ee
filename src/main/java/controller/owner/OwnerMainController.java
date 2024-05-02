package controller.owner;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Property;
import model.Owner;
import tools.Db;


@WebServlet(name = "OwnerMainController", urlPatterns = {"/OwnerMainController"})


public class OwnerMainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Db connection = new Db();
        ArrayList<Property> properties = new ArrayList<>();
        int ownerId = ((Owner)session.getAttribute("user")).getOwnerId();

        try {
            properties = connection.DAOReadOwnerProperties(ownerId);
            session.setAttribute("properties", properties);
            response.sendRedirect((request.getContextPath() + "/ownerHome"));
            
        } catch (Exception e) {
            System.err.println("couldn't read properties for owner with Id : " + ownerId + "due to : " + e);
            return;
        }
    }
}
