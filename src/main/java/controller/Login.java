package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import tools.Db;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javatuples.Pair;

import model.Admin;
import model.Cleaner;
import model.Owner;
import model.UserStatus;

@WebServlet(name = "Connection", urlPatterns = {"/login"})

public class Login extends HttpServlet {

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String psw = request.getParameter("password");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		Pair<Integer, UserStatus> user;

    	Db connection = new Db();

		try {
			user = connection.DAOReadUser(email, psw);
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/accueil");
			session.setAttribute("connection", "failed");
			return;
		}
		try {

		
			switch (user.getValue1()) {
				case ADMIN:
					System.out.print("Admin requested");
					session.setAttribute("status", "admin");
					//Admin admin = connection.DAOReadAdmin(user.getValue0());
					response.sendRedirect(request.getContextPath() + "/AdminMain");
					break;

				case CLEANER:
					System.out.print("Cleaner requested");
					session.setAttribute("status", "cleaner");
					//Cleaner cleaner = connection.DAOReadCleaner(user.getValue0());
					response.sendRedirect(request.getContextPath() + "/CleanerMain");
					break;

				case OWNER :
					System.out.print("Owner requested");
					session.setAttribute("status", "owner");
					//Owner owner = connection.DAOReadOwner(user.getValue0());
					response.sendRedirect(request.getContextPath() + "/OwnerMain");
					break;
				
				case UNKNOWN: 
					response.sendRedirect(request.getContextPath() + "/accueil");
					break;
			}
		} catch (Exception e) {
			System.err.println("Internal error: Could not find a given " + user.getValue1()
				 + "for user: " + user.getValue0() + "\nSQL error: " + e);
		}
	
	}
}
 