package model;

public enum MissionStatus {
    PUBLISHED(1),
    PROPOSED(2),
    CONFIRMED_AND_PAYED(3),
    CLEANER_VALIDATED(4),
    OWNER_VALIDATED(5),
    OPENED_DISPUTE(6),
    RESOLVED_DISPUTE_CLEANER_IS_RIGHT(7),
    RESOLVED_DISPUTE_OWNER_IS_RIGHT(8);
    private final int status;

    private MissionStatus(int status) {
        this.status = status;
    }

    public static MissionStatus fromInt(int status) throws Exception{
        switch (status) {
        case 1:
            return MissionStatus.PUBLISHED;

        case 2:
            return MissionStatus.PROPOSED;

        case 3:
            return MissionStatus.CONFIRMED_AND_PAYED;

        case 4:
            return MissionStatus.CLEANER_VALIDATED;

        case 5:
            return MissionStatus.OWNER_VALIDATED;

        case 6:
            return MissionStatus.OPENED_DISPUTE;

        case 7:
            return MissionStatus.RESOLVED_DISPUTE_CLEANER_IS_RIGHT;

        case 8:
            return MissionStatus.RESOLVED_DISPUTE_OWNER_IS_RIGHT;

        default:
            throw new Exception("Given status could not be converted into MissionStatus: " + status);
        }
    }

    public int asInt() {
        return this.status;
    }
}


