package model;

public enum DisputeType {
    NO_TYPE(0),
    CLEANER_WINS(1),
    OWNER_WINS(2);
    

    private Integer type;

    DisputeType (Integer type) {
        this.type = type;
    }

    public static DisputeType fromInt(Integer type) throws Exception {
        switch (type) {
        
        case 0 : 
            return DisputeType.NO_TYPE;
        case 1:
            return DisputeType.CLEANER_WINS;
        case 2:
            return DisputeType.OWNER_WINS;

        default: return null;
        }
    }
    public Integer asInt() {
        return this.type;
    }
}
