package controller.cleaner;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CleanerConnectedController", urlPatterns = {"/cleaner_connected"})
public class CleanerConnectedController extends HttpServlet {
    public CleanerConnectedController() {
        super();
        System.out.println("CleanerConnectedController contructor triggered");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("CleanerConnectedController requested !");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Hello, from connection view</h1>");
    }
}