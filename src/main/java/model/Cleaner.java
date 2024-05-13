package model;

import java.time.LocalDate;
import java.util.ArrayList;

import model.planning.Planning;

public class Cleaner extends User {
    private int cleanerId;
    private Address departureAddress;
    private int kmRange;
    private int hourlyRate;
    private String biography;
    private String idPhoto;
    private String profilePhoto;
    private String livePhoto;
    private String motivation;
    private CleanerExperience experience;
    private boolean confirmedId;

    private ArrayList<Integer> reviews;
    private Planning planning;

    // Creates a Cleaner object from loaded data
    public Cleaner(
        int cleanerId,
        Address departureAddress,
        int kmRange,
        int hourlyRate,
        String biography,
        String idPhoto,
        String profilePhoto,
        String livePhoto,
        String motivation,
        CleanerExperience experience,
        boolean confirmed,
        String name,
        String pwd,
        String surname,
        String email,
        String phoneNumber,
        LocalDate birthLocalDate,
        boolean suspended,
        ArrayList<Integer> arrayList,
        Planning planning
    ) {

        super(name, pwd, surname, email, phoneNumber, birthLocalDate, suspended, UserStatus.CLEANER);

        this.cleanerId = cleanerId;
        this.departureAddress = departureAddress;
        this.kmRange = kmRange;
        this.hourlyRate = hourlyRate;
        this.biography = biography;
        this.idPhoto = idPhoto;
        this.profilePhoto = profilePhoto;
        this.motivation = motivation;
        this.experience = experience;
        this.confirmedId = confirmed;
        this.planning = planning;
    }



    public int getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(int cleanerId) {
        this.cleanerId = cleanerId;
    }

    public Address getDepartureAddress() {
        return this.departureAddress;
    }

    public void setDepartureAddress(Address departureAddress) {
        this.departureAddress = departureAddress;
    }

    public int getKmRange() {
        return kmRange;
    }

    public void setKmRange(int kmRange) {
        this.kmRange = kmRange;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getBiography() {
        return this.biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(String idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getProfilePhoto() {
        return this.profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getMotivation() {
        return this.motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public CleanerExperience getExperience() {
        return this.experience;
    }

    public void setExperience(CleanerExperience experience) {
        this.experience = experience;
    }

    public boolean isConfirmedId() {

        return this.confirmedId;
    }

    public void setConfirmedId(boolean confirmed) {
        this.confirmedId = confirmed;

    }

    public ArrayList<Integer> getReviews() {
        return this.reviews;
    }

    public void setReviews(ArrayList<Integer> reviews) {
        this.reviews = reviews;
    }

    public Planning getPlanning() {
        return this.planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }



    @Override
    public String toString() {
        return "Cleaner [cleanerId=" + cleanerId + ", departureAddress=" + departureAddress + ", kmRange=" + kmRange
               + ", hourlyRate=" + hourlyRate + ", biography=" + biography + ", idPhoto=" + idPhoto + ", profilePhoto="
               + profilePhoto + ", livePhoto=" + livePhoto + ", motivation=" + motivation + ", experience="
               + experience + ", confirmedId=" + confirmedId + ", reviews=" + reviews + ", planning=" + planning + "]";
    }

    // public UserStatus getStatus() {
    //     return this.status;
    // }



}