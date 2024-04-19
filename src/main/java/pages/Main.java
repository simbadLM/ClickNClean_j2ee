package pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Main", urlPatterns = {"/"})
public class Main extends HttpServlet {
    public Main() {
        super();
        System.out.println("Main contructor triggered");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("Main requested !");
        response.setContentType("text/html;charset=UTF-8");
        // response.getWriter().println("<h1>Hello, from Main view</h1>");
        response.sendRedirect("/clickNclean_j2ee/accueil");
    }
}