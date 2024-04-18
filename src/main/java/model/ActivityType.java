package model;

public enum ActivityType {
    WELCOME_CLEANER(1), // for cleaner DONE
    CLEANER_WAITING_TO_BE_CONFIRMED(2), // for admin DONE
    CLEANER_ACCOUNT_CONFIRMED(3), // for cleaner DONE
    PROPERTY_IS_PUBLISHED(4), // for owner DONE
    NEW_MISSION_AVAILABLE(5), // for cleaner DONE
    CLEANER_OFFERS_SERVICE(6), // for owner TODO once quentin pushed his code of cleanermain.java
    PROPOSAL_ACCEPTED(7), // for cleaner TODO once lina pushed her code of ownermain.java
    MISSION_CANCELED(8), // for cleaner AND owner
    MISSION_FINISHED_BY_CLEANER(9), // for owner
    DISPUTE_OPENED(10), // for cleaner AND owner AND admin
    DISPUTE_RESOLVED(11), // for cleaner AND owner
    MISSION_FINISHED_BY_OWNER(12), // for cleaner
    REVIEW_THE_MISSION(13), // for cleaner AND owner
    REVIEW_HAS_BEEN_RECEIVED(14); // for cleaner OR owner
    private int type;

    private ActivityType(int type) {
        this.type = type;
    }

    public static ActivityType fromInt(int type) throws Exception {
        switch (type) {
        case 1:
            return WELCOME_CLEANER;
        case 2:
            return CLEANER_WAITING_TO_BE_CONFIRMED;
        case 3:
            return CLEANER_ACCOUNT_CONFIRMED;
        case 4:
            return PROPERTY_IS_PUBLISHED;
        case 5:
            return  NEW_MISSION_AVAILABLE;
        case 6:
            return CLEANER_OFFERS_SERVICE;
        case 7:
            return PROPOSAL_ACCEPTED;
        case 8:
            return  MISSION_CANCELED;
        case 9:
            return  MISSION_FINISHED_BY_CLEANER;
        case 10:
            return DISPUTE_OPENED;
        case 11:
            return DISPUTE_RESOLVED;
        case 12:
            return MISSION_FINISHED_BY_OWNER;
        case 13:
            return REVIEW_THE_MISSION;
        case 14:
            return REVIEW_HAS_BEEN_RECEIVED;
        default : throw new Exception("Given type could not be converted to Activity Type :" + type);
        }
    }

    public int asInt() {
        return this.type;
    }

    public String toString() {

        switch (this) {
        case WELCOME_CLEANER:
            return "WELCOME_CLEANER";
        case CLEANER_WAITING_TO_BE_CONFIRMED:
            return "CLEANER_WAITING_TO_BE_CONFIRMED";
        case CLEANER_ACCOUNT_CONFIRMED:
            return "CLEANER_ACCOUNT_CONFIRMED";
        case PROPERTY_IS_PUBLISHED:
            return "PROPERTY_IS_PUBLISHED";
        case NEW_MISSION_AVAILABLE:
            return "NEW_MISSION_AVAILABLE";
        case CLEANER_OFFERS_SERVICE:
            return "CLEANER_OFFERS_SERVICE";
        case PROPOSAL_ACCEPTED:
            return "PROPOSAL_ACCEPTED";
        case MISSION_CANCELED:
            return "MISSION_CANCELED";
        case MISSION_FINISHED_BY_CLEANER:
            return "MISSION_FINISHED_BY_CLEANER";
        case DISPUTE_OPENED:
            return "DISPUTE_OPENED";
        case DISPUTE_RESOLVED:
            return "DISPUTE_RESOLVED";
        case MISSION_FINISHED_BY_OWNER:
            return "MISSION_FINISHED_BY_OWNER";
        case REVIEW_THE_MISSION:
            return "REVIEW_THE_MISSION";
        case REVIEW_HAS_BEEN_RECEIVED:
            return "REVIEW_HAS_BEEN_RECEIVED";
        default:
            return "Default";
        }
    }
}
