package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pages.Connection;

@WebServlet(name = "Main", urlPatterns = {"/"})
public class Main extends HttpServlet {
    public Main() {
        super();
        System.out.println("Main contructor triggered");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        System.out.println("Main requested !");
        response.setContentType("text/html;charset=UTF-8");
        new Connection().doGet(request, response);
    }
}