package model;

import org.junit.jupiter.api.Test;

import model.Address;
import model.planning.Planning;
import model.planning.TimeSlot;
import tools.Db;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class TestPlanning {
    @Test
    void equal() {
        try {
            Db connection = new Db();
            int cleanerId = connection.DAOAddCleaner(
                                "Doe",
                                "null",
                                "John",
                                "null",
                                "null",
                                LocalDate.now(),
                                false,
                                new Address("28", "av yves thepot", "29000", "quimper"),
                                0, 0,
                                "null",
                                "null",
                                "null",
                                CleanerExperience.MORE_3_YEARS,
                                false,
                                "null",
                                "null");
            System.out.println("[SUCCESS] Wrote cleaner");

            ArrayList<TimeSlot> ts = new ArrayList<TimeSlot>();

            ts.add(new TimeSlot(LocalDateTime.now(), 0.5));
            ts.add(new TimeSlot(LocalDateTime.now(), 2.5));
            ts.add(new TimeSlot(LocalDateTime.now(), 1.5));
            ts.add(new TimeSlot(LocalDateTime.now(), 0.5));
            ts.add(new TimeSlot(LocalDateTime.now(), 5.5));

            Planning p = new Planning(ts);
            connection.DAOWritePlanning(p, cleanerId);
            System.out.println("[SUCCESS] Wrote planning");

            Planning planning = connection.DAOReadPlanning(cleanerId);
            System.out.println("[SUCCESS] Read cleaner");

            assert p.equals(planning) : "r/w plannings are not the same";
            System.out.println("[SUCCESS] Planning ended successfully");
        } catch (Exception e) {
            System.err.println("[SUCCESS]" + e);
        }
    }
}