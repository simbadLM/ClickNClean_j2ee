package controller.owner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OwnerAskAddPropertyController", urlPatterns = {"/owner_ask_add_property"})
public class OwnerAskAddPropertyController extends HttpServlet {
    public OwnerAskAddPropertyController() {
        super();
        System.out.println("OwnerAskAddPropertyController contructor triggered");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("OwnerAskAddPropertyController requested !");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Hello, from connection view</h1>");
    }
}