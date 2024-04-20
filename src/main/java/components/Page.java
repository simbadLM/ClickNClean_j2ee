package components;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserStatus;

public class Page {
    public static String url;
    public static UserStatus sessionHost;

    public static void TopPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = "";
        response.setContentType("text/html;charset=UTF-8");
        if (request.getPathInfo() != null) {
            title = request.getPathInfo().replace("/", "");
        }
        PrintWriter out = response.getWriter();
        out.println(
            "<!DOCTYPE html>"
            + "<html lang='fr'>"
            + "<head>"
            +    "<link rel='stylesheet' href='./resources/style.css'>"
            +    "<meta charset='UTF-8'>"
            +    "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
            +        "<title> " + title + "</title>"
            + "</head>"
            + "<body>" + Header.Render(request, response)
        );
    }

    public static void BottomPage(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println(
            "</body>"
            + "</html>"
        );
    }
}
