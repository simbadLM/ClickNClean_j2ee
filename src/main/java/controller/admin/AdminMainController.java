package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javatuples.Pair;

import tools.Db;
import model.Activity;
import model.Admin;
import model.Cleaner;
import model.Dispute;
import model.DisputeType;
import model.Mission;

@WebServlet(name = "AdminMainController", urlPatterns = { "/AdminMainController" })
public class AdminMainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Db db = new Db();
        Admin admin = (Admin) session.getAttribute("user");

        ArrayList<Activity> activities = new ArrayList<Activity>();
        try {
            activities = db.DAOReadActivities(admin.getAdminId());
        } catch (Exception e) {
            System.err.println("Could not fetch activies for admin with id: " + admin.getAdminId() + " due to: " + e);
            return;
        }

        ArrayList<Cleaner> cleanerToConfirm = new ArrayList<Cleaner>();
        ArrayList<Pair<Dispute, Mission>> disputes = new ArrayList<Pair<Dispute, Mission>>();

        for (Activity activity : activities) {
            System.out.println("Parsing activity: " + activity.getType());
            switch (activity.getType()) {
            case CLEANER_WAITING_TO_BE_CONFIRMED:
                Cleaner cleaner;
                try {
                    cleaner = db.DAOReadCleaner(activity.getCleanerId());
                } catch (Exception e) {
                    // TODO: handle exception
                    System.err.println(e);
                    break;
                }

                if (cleaner.isConfirmedId() || cleaner.isSuspended()) {
                    // Ignore
                    break;
                }

                cleanerToConfirm.add(cleaner);

                break;
            case DISPUTE_OPENED:
                Dispute dispute;
                Mission mission;

                try {
                    dispute = db.DAOReadDispute(activity.getDisputeId());
                    mission = db.DAOReadMission(activity.getMissionId());
                } catch (Exception e) {
                    System.err.println(e);
                    break;
                }

                if (dispute.getType() == DisputeType.NO_TYPE) {
                    // ignore
                    break;
                }

                disputes.add(new Pair<Dispute, Mission>(dispute, mission));

                break;
            default:
                // pass
                break;
            }
        }

        session.setAttribute("cleanerToConfirm", cleanerToConfirm);
        session.setAttribute("dispute", disputes);

        response.sendRedirect((request.getContextPath() + "/adminHome"));

    }
}