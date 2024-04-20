package pages.admin;

import static j2html.TagCreator.*;
import static j2html.TagCreator.html;
import static j2html.TagCreator.label;
import static j2html.TagCreator.label;
import j2html.tags.ContainerTag;
import j2html.tags.Text;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import components.Page;
import model.UserStatus;

@WebServlet(name = "AdminMain", urlPatterns = {"/AdminMain"})
public class AdminMain extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();
        Page.TopPage(request, response);
        out.println(
            "<p>Bonjour, "
        );
        Page.BottomPage(response);
    }
}