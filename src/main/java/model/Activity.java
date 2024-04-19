package model;

public class Activity {
    private int activityId;
    private ActivityType type;
    private boolean read;
    private int ownerId;
    private int cleanerId;
    private int missionId;
    private int disputeId;
    private int adminId;
    private int targetId;

    public Activity(
        int activityId,
        ActivityType type,
        boolean read,
        int ownerId,
        int cleanerId,
        int missionId,
        int disputeId,
        int adminId,
        int targetId
    ) {

        this.activityId = activityId;
        this.type = type;
        this.read = read;
        this.ownerId = ownerId;
        this.cleanerId = cleanerId;
        this.missionId = missionId;
        this.disputeId = disputeId;
        this.adminId = adminId;
        this.targetId = targetId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public boolean isRead() {
        return this.read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(int cleanerId) {
        this.cleanerId = cleanerId;
    }

    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    public int getDisputeId() {
        return disputeId;
    }

    public void setDisputeId(int disputeId) {
        this.disputeId = disputeId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
}