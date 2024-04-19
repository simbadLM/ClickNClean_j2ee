package models.planning;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;


public class TimeSlot {
    private LocalDateTime datetime;
    private double durationH;
    private int idMission;
    public static final int NOT_AVAILABLE = 0;
    public static final int AVAILABLE = 1;
    public static final int ENGAGED_IN_MISSION = 2;

    public TimeSlot(LocalDateTime datetime, double durationH) {
        this.datetime = datetime.truncatedTo(ChronoUnit.SECONDS); // Round to seconds for better compare to
        this.durationH = durationH;
        this.idMission = -1;
    }

    public TimeSlot(LocalDateTime datetime, double durationH, int idMission) {
        this.datetime = datetime.truncatedTo(ChronoUnit.SECONDS); // Round to seconds for better compare to
        this.durationH = durationH;
        this.idMission = idMission;
    }

    public LocalDateTime getLocalDateTime() {
        return this.datetime;
    }

    public void setLocalDateTime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public double getDurationH() {
        return this.durationH;
    }

    public void setDurationH(double durationH) {
        this.durationH = durationH;
    }

    public boolean getIsAvailable() {
        return this.idMission == -1;
    }

    public void setIdMission(int idMission) {
        this.idMission = idMission;
    }

    public int getIdMission() {
        return this.idMission;
    }

    public String toString() {
        return "TimeSlot{" +
               "date: " + this.datetime +
               ", duration_h: " + this.durationH +
               ", id_mission: " + this.idMission +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof TimeSlot)) {
            return false;
        }

        TimeSlot t = (TimeSlot) o;

        return this.datetime.equals(t.datetime) && this.durationH == t.durationH
               && this.idMission == t.idMission;
    }
}