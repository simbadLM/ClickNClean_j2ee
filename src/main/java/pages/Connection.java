package pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Connection", urlPatterns = {"/login"})
public class Connection extends HttpServlet {
    public Connection() {
        super();
        System.out.println("Connection contructor triggered");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("Connection requested !");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h1>Hello, from connection view</h1>");
    }
}