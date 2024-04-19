package model;

public class Dispute {
    private int disputeId;	
    private String content;
    private String decision;
    private String ownerDisplay;
    private String cleanerDisplay;		
    private int ownerId;
    private int cleanerId;	
    private int missionId;	
    private int disputeCreatorId;	
    private int adminId;
    private DisputeType type;
    
    public Dispute(int disputeId, String content, String decision, String ownerDisplay, String cleanerDisplay,
            int ownerId, int cleanerId, int missionId, int disputeCreatorId, int adminId, DisputeType type) {

        this.disputeId = disputeId;
        this.content = content;
        this.decision = decision;
        this.ownerDisplay = ownerDisplay;
        this.cleanerDisplay = cleanerDisplay;
        this.ownerId = ownerId;
        this.cleanerId = cleanerId;
        this.missionId = missionId;
        this.disputeCreatorId = disputeCreatorId;
        this.adminId = adminId;
        this.type  = type;
    }
    public int getDisputeId() {
        return disputeId;
    }
    public String getContent() {
        return content;
    }
    public String getDecision() {
        return decision;
    }
    public String getOwnerDisplay() {
        return ownerDisplay;
    }
    public String getCleanerDisplay() {
        return cleanerDisplay;
    }
    public int getOwnerId() {
        return ownerId;
    }
    public int getCleanerId() {
        return cleanerId;
    }
    public int getMissionId() {
        return missionId;
    }
    public int getDisputeCreatorId() {
        return disputeCreatorId;
    }
    public int getAdminId() {
        return adminId;
    }
    public DisputeType getType() {
        return type;
    }
    @Override
    public String toString() {
        return "Dispute [disputeId=" + disputeId + ", content=" + content + ", decision=" + decision + ", ownerDisplay="
                + ownerDisplay + ", cleanerDisplay=" + cleanerDisplay + ", ownerId=" + ownerId + ", cleanerId="
                + cleanerId + ", missionId=" + missionId + ", disputeCreatorId=" + disputeCreatorId + ", adminId="
                + adminId + "]";
    }

    
    
}