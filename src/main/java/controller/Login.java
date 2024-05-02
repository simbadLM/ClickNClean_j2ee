package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javatuples.Pair;

import tools.Db;

import model.Admin;
import model.Cleaner;
import model.Owner;
import model.UserStatus;

@WebServlet(name = "Connection", urlPatterns = {"/login"})

public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String psw = request.getParameter("password");
		Pair<Integer, UserStatus> user;
		Db connection = new Db();

		try {
			user = connection.DAOReadUser(email, psw);
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/home");
			session.setAttribute("connection", "failed");
			return;
		}
		try {
			switch (user.getValue1()) {
			case ADMIN:
				System.out.print("Admin requested");

				Admin admin = connection.DAOReadAdmin(user.getValue0());
				session.setAttribute("user", admin);
				session.setAttribute("status", "admin");
				response.sendRedirect(request.getContextPath() + "/adminHome");
				break;

			case CLEANER:
				System.out.print("Cleaner requested");

				Cleaner cleaner = connection.DAOReadCleaner(user.getValue0());
				session.setAttribute("user", cleaner);
				session.setAttribute("status", "cleaner");
				response.sendRedirect(request.getContextPath() + "/CleanerMainController");
				break;

			case OWNER :
				System.out.print("Owner requested");

				Owner owner = connection.DAOReadOwner(user.getValue0());
				session.setAttribute("user", owner);
				session.setAttribute("status", "owner");
				response.sendRedirect(request.getContextPath() + "/OwnerMainController");
				break;

			case UNKNOWN:
				response.sendRedirect(request.getContextPath() + "/home");
				break;
			}
		} catch (Exception e) {
			System.err.println("Internal error: Could not find a given " + user.getValue1()
			                   + "for user: " + user.getValue0() + "\nSQL error: " + e);
		}

	}
}
