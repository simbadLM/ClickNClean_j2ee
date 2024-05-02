package model;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;

public class Mission {
    int missionId;
    Property property;
    LocalDateTime missionDateTime;
    double duration;
    double cost;
    double commission;
    int ownerId;
    int cleanerId;
    ArrayList<Cleaner> cleanerList;
    MissionStatus state;

    public Mission(
        int missionId,
        Property property,
        LocalDateTime missionDateTime,
        double duration,
        double cost,
        double commission,
        int ownerId,
        int cleanerId,
        MissionStatus state
    ) {
        this.missionId = missionId;
        this.property = property;
        this.missionDateTime = missionDateTime;
        this.duration = setDuration(property.getPropertySurface());
        this.cost = cost;
        this.commission = commission;
        this.ownerId = ownerId;
        this.cleanerId = cleanerId;
        this.state = state;
    }

    public int getMissionId() {
        return missionId;
    }

    public LocalDate getMissionDate() {
        return missionDateTime.toLocalDate();
    }

    public void setMissionDate(LocalDateTime missionDateTime) {
        this.missionDateTime = missionDateTime;
    }

    public double getDuration() {
        return duration;
    }

    /**
     * Changes duration using mission's property surface
     *  → < 30m2 → 1h
        → 30-40m2 → 2h
        → 40-60m2 → 2h30
        → 60-80m2 → 3h
        → 80-100m2 → 3h30
        → >100m2 → 4h
     * @param surface
     */
    public static double setDuration(int surface) {
        double duration = 0;
        if (surface <= 30) duration = 1.0;
        else if (surface > 30 && surface <= 40) duration = 2.;
        else if (surface > 40 && surface <= 60) duration = 2.5;
        else if (surface > 60 && surface <= 80) duration = 3.;
        else if (surface > 80 && surface <= 100) duration = 3.5;
        else if (surface > 100) duration = 4.;

        return duration;
    }

    public Property getProperty() {
        return property;
    }

    public LocalDateTime getMissionDateTime() {
        return missionDateTime;
    }

    public ArrayList<Cleaner> getCleanerList() {
        return cleanerList;
    }

    public double getCost() {
        return cost;
    }

    public double getCommission() {
        return commission;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(int cleanerId) {
        this.cleanerId = cleanerId;
    }

    public MissionStatus getState() {
        return state;
    }

    public void setState(MissionStatus state) {
        this.state = state;
    }

}
