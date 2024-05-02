package controller.owner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Owner;
import model.Address;
import tools.Db;

@WebServlet(name = "ownerNewProp", urlPatterns = {"/ownerNewProp"})
public class OwnerNewProp extends HttpServlet {
   
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("OwnerNewprop requested !");
        HttpSession session = request.getSession();
        String houseNumber = request.getParameter("houseN");
        String label = request.getParameter("label");
        String postCode = request.getParameter("postcode");
        String city = request.getParameter("city");
        int surface = Integer.parseInt(request.getParameter("surfaceProperty"));
        int ownerId = ((Owner)session.getAttribute("user")).getOwnerID();
        Db connection = new Db();
        Address address;

        //TODO : test if postcode = 5
        try {
            address = new Address(houseNumber, label, postCode, city);
        } catch (Exception e) {
            //TODO: Show the user that there was an error with the address
            return;
        }

        try {
            connection.DAOCreateNewProperty(address, surface, "accesscode", "keyBoxCode", "specialInstruction", ownerId);
        } catch (Exception e) {
            System.err.println("Failed to create new property due to : " + e);
        }
        response.sendRedirect(request.getContextPath() + "/OwnerMainController");
    }
}