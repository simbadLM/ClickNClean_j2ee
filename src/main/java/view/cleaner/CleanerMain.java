package view.cleaner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import components.Page;

@WebServlet(name = "CleanerMain", urlPatterns = {"/CleanerMain"})
public class CleanerMain extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println(
            Page.TopPage(request, response)
            + "<p>Bonjour, "
            +Page.BottomPage(response)
        );
    }
}