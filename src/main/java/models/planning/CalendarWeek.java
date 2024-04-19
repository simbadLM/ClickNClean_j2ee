package models.planning;
import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarWeek {
    private ArrayList<TimeSlot> calendarDay;

    public CalendarWeek(ArrayList<TimeSlot> calendarDay) {
        this.calendarDay = calendarDay;
    }

    public ArrayList<TimeSlot> getCalendarDay() {
        return calendarDay;
    }
}