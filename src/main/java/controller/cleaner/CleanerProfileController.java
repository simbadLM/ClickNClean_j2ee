package controller.cleaner;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cleaner;
import model.CleanerExperience;

@WebServlet(name = "CleanerProfileController", urlPatterns = { "/CleanerProfileController" })
public class CleanerProfileController extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();

		Cleaner cleaner = (Cleaner) session.getAttribute("user");

		String new_name = request.getParameter("name");
		String new_surname = request.getParameter("surname");
		String new_email = request.getParameter("email");
		String new_phoneNbr = request.getParameter("phoneNbr");
		int new_kmRange = Integer.parseInt(request.getParameter("kmRange"));
		int new_hourlyRate = Integer.parseInt(request.getParameter("hourlyRate"));
		String new_biography = request.getParameter("biography");
		String new_motivation = request.getParameter("motivation");
		CleanerExperience new_experience;
		try {
			new_experience = CleanerExperience
			                 .fromInt(Integer.parseInt(request.getParameter("experience")));
		} catch (Exception e) {
			System.err.println("An error occured while parsing cleaner experience: " + e);
			return;
		}

		System.out.println("Got name: " + new_name);

	}
}