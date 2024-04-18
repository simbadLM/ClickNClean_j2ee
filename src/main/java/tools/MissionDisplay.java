package tools;

import java.time.LocalDateTime;

public class MissionDisplay {
  private int missionId;
  private LocalDateTime date;
  private String ownerFirstName;
  private double distance;
  private double duration;

public MissionDisplay(int missionId, LocalDateTime date, String ownerFirstName, double distance, double duration) {
    this.missionId = missionId;
    this.date = date;
    this.ownerFirstName = ownerFirstName;
    this.distance = distance;
    this.duration = duration;
}

public int getMissionId() {
    return missionId;
}

public LocalDateTime getDate() {
    return date;
}

public String getOwnerFirstName() {
    return ownerFirstName;
}

public double getDistance() {
    return distance;
}

public double getDuration() {
    return duration;
} 
  
}
