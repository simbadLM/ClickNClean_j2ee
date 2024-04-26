package components;

public enum ErrorMessage {
    LOGIN(1),
    ADDRESS(2),
    BETWEEN_1_3(3),
    MORE_3_YEARS(4);

    private int reason;

    ErrorMessage(int reason) {
        this.reason = reason;
    }

    public static ErrorMessage fromInt(int reason) throws Exception {
        switch (reason) {
        case 1:
            return ErrorMessage.LOGIN;
        case 2:
            return ErrorMessage.ADDRESS;
        case 3:
            return ErrorMessage.BETWEEN_1_3;
        case 4:
            return ErrorMessage.MORE_3_YEARS;
        default:
            throw new Exception("Given experience doesn't match with cleaner experience" + reason);
        }
    }

    public int asInt() {
        return this.reason;
    }

    public String toString() {
        switch (this) {
        case LOGIN:
            return "<p class=\"alert\">Identifiant ou mot de passe incorrect</p>";
        case ADDRESS:
            return "<p class=\"alert\">Addresse incorrecte</p>";
        case BETWEEN_1_3:
            return "1 à 3 ans d'expérience";
        case MORE_3_YEARS:
            return "plus de 3 ans d'expérience";
        default:
            return "Given experience doesn't match with cleaner experience" + this.reason;
        }
    }
}
