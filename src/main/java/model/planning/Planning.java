package model.planning;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class Planning {

    private ArrayList<TimeSlot> slots;

    public Planning(ArrayList<TimeSlot> slots) {
        this.slots = slots;
    }

    public String toString() {
        String out = new String();

        out += "Class Planning{Slots: {";

        for (TimeSlot ts : this.slots) {
            out += ts.toString();
        }

        out += "}}";
        return out;
    }

    public ArrayList<TimeSlot> getTimeSlots() {
        return this.slots;
    }

    public void setAvailableSlots(LocalDateTime targetLocalDateTime, int newIdMission) {
        for (TimeSlot timeSlotObserved : this.slots) {
            if (timeSlotObserved.getLocalDateTime().equals(targetLocalDateTime)) {
                timeSlotObserved.setIdMission(newIdMission);
            }
        }
    }

    public static void main() {
        Planning plan = new Planning(new ArrayList<>());
        for (TimeSlot slot : plan.slots ) {
            System.out.println(slot.toString());
        }
        System.out.println(plan.slots.size());
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Planning)) {
            return false;
        }

        Planning p = (Planning) o;

        if (this.getTimeSlots().size() != p.getTimeSlots().size()) {
            return false;
        }

        int i = 0;

        while (i < this.slots.size()) {
            if (!this.getTimeSlots().get(i).equals(p.getTimeSlots().get(i))) {
                System.out.println("Time slot check failled at " + i);
                return false;
            }

            i++;
        }

        return true;
    }
}