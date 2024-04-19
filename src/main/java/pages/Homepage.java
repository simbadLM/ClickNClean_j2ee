package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import components.Page;

@WebServlet(name = "Homepage", urlPatterns = {"/accueil"})
public class Homepage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("Homepage requested !");
        String title = " ";
        response.setContentType("text/html;charset=UTF-8");
        if (request.getPathInfo() != null) {
            title = request.getPathInfo().replace("/", "");
        }
        PrintWriter out = response.getWriter();
        Page.TopPage(response, title);
        Page.BottomPage(response);
    }
}