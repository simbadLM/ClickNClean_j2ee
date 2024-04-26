package controller;

import java.io.IOException;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ActivityType;
import model.Address;
import model.Cleaner;
import model.CleanerExperience;
import model.Owner;
import model.OwnerMotivation;
import tools.Db;

@WebServlet(name = "Inscription", urlPatterns = {"/register"})

public class Register extends HttpServlet {

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String rawPwd = request.getParameter("rawPwd");
		String rawConfirmPwd = request.getParameter("rawConfirmedPwd");
        String email = request.getParameter("mail");
        String phone = request.getParameter("phone");
		LocalDate birth = LocalDate.parse(request.getParameter("birth"));

/*---------------------------------------⬇-Cleaner Registration-⬇-------------------------------------------*/

        if(request.getParameter("status").equals("c")) {
            System.out.println("entered in c section");

            String label = request.getParameter("label");
            String houseN = request.getParameter("houseN");
            String postcode = request.getParameter("postcode");
            String city = request.getParameter("city");
            String bio = request.getParameter("bio");
            String motivation = request.getParameter("motiv");
            String photo = ""; // Leave empty so it may be implemented in the future if needed
            String idPhoto =  "";// Leave empty so it may be implemented in the future if needed
            String photoLive = "";// Leave empty so it may be implemented in the future if needed
            int km = Integer.parseInt(request.getParameter("range").toString());
            int hourlyRate = Integer.parseInt(request.getParameter("hourlyRate").toString());
            CleanerExperience exp;
            int currentCleanerId = 0;
    
            try {
               exp = CleanerExperience
                .fromInt(Integer.parseInt(request.getParameter("exp")));
            } catch (Exception e) {
                System.out.println("failed to set Cleaner Experience due to : " + e);
                exp = CleanerExperience.NONE;
            }
    
                if (rawPwd.equals(rawConfirmPwd)) {
                    Db connection = new Db();
    
                    Address address;
                    try {
                        address = new Address(houseN, label, postcode, city);
                    } catch (Exception e) {
                        // TODO: Show the user that there was an error with the address
                        return;
                    }
                    try {
                        currentCleanerId = connection.DAOAddCleaner(
                            lastname,
                            rawPwd,
                            firstname,
                            email,
                            phone,
                            birth,
                            false,
                            address,
                            km,
                            hourlyRate,
                            bio,
                            idPhoto,
                            motivation,
                            exp,
                            false,
                            photo,
                            photoLive
                        );
            
                    } catch (Exception e) {
                        System.out.println("Failed to register Cleaner due to : " + e);
                        // TODO: avert user failed to register cleaner
                        return;
                    }
                    
                    try {
                        Cleaner currentCleaner = connection.DAOReadCleaner(currentCleanerId);
                        connection.DAOaddActivity(ActivityType.WELCOME_CLEANER, currentCleanerId, null, null, null, null, null);
                        connection.DAOaddActivity(ActivityType.CLEANER_WAITING_TO_BE_CONFIRMED, 1, null, currentCleanerId, null, null, null);
                        session.setAttribute("user", currentCleaner);
                        session.setAttribute("status", "owner");
                        response.sendRedirect(request.getContextPath() + "/CleanerMain");
                    } catch (Exception e) {
                        System.out.println("Could not read newly created cleaner due to: " + e);
                        return;
                    }
                    
                }
                //TODO : else avert pwd don't match
        }
/*---------------------------------------⬇-Owner Registration-⬇-------------------------------------------*/

        else if(request.getParameter("status").equals("o")) {

            OwnerMotivation motiv; 
            int currentOwnerId = 0;

            try {
                motiv = OwnerMotivation.fromInt(Integer.parseInt(request.getParameter("service")));
            } catch (Exception e) {
                System.out.println("failed to set Owner motivation due to : " + e);
                motiv = OwnerMotivation.GUEST_ROOM;
            }
            if (rawPwd.equals(rawConfirmPwd)) {
                Db connection = new Db();
                try {
                    currentOwnerId = connection.DAOAddOwner(
                        lastname, 
                        rawPwd, 
                        firstname, 
                        email, 
                        phone, 
                        birth, 
                        false, 
                        motiv
                    );
                    Owner currentOwner = connection.DAOReadOwner(currentOwnerId);
                    session.setAttribute("user", currentOwner);
                    session.setAttribute("status", "owner");
                    response.sendRedirect(request.getContextPath() + "/OwnerMain");
                }
                catch (Exception e) {
                    System.out.println("Failed to register Cleaner due to : " + e);
                    // TODO: avert user failed to register Owner
                    return;
                }
            }
            // TODO : avert user pwd don't match 
            
            
        }
    }


    public boolean isEmailAdress(String email) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
        Matcher m = p.matcher(email.toUpperCase());
        return m.matches();
    }
}
