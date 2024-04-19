package models;

public enum CleanerExperience {
    NONE(1),
    LESS_1_YEARS(2),
    BETWEEN_1_3(3),
    MORE_3_YEARS(4);

    private int experience;

    CleanerExperience(int experience) {
        this.experience = experience;
    }

    public static CleanerExperience fromInt(int experience) throws Exception {
        switch (experience) {
        case 1:
            return CleanerExperience.NONE;
        case 2:
            return CleanerExperience.LESS_1_YEARS;
        case 3:
            return CleanerExperience.BETWEEN_1_3;
        case 4:
            return CleanerExperience.MORE_3_YEARS;
        default:
            throw new Exception("Given experience doesn't match with cleaner experience" + experience);
        }
    }

    public int asInt() {
        return this.experience;
    }


    // public static CleanerExperience fromString(String strExp) thows Exception{
    //     switch (strExp) {
    //     case "Aucune expérience":
    //         return CleanerExperience.NONE;
    //     case "Aucune expérience":
    //     }
    // }

    public String toString() {
        switch (this) {
        case NONE:
            return "Aucune expérience";
        case LESS_1_YEARS:
            return "Moins d'un an d'expérience en ménages";
        case BETWEEN_1_3:
            return "1 à 3 ans d'expérience";
        case MORE_3_YEARS:
            return "plus de 3 ans d'expérience";
        default:
            return "Given experience doesn't match with cleaner experience" + this.experience;
        }
    }
}
