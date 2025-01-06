package com.example.agence.handelers.models;

public class SharedData {
    private static SharedData instance;
    private String emailT;
    private int passengers;
    private double montant;
    private String departureStation;
    private String arrivalStation;
    private String departureDate;

    private SharedData() {
        // Private constructor to prevent instantiation
    }

    public static SharedData getInstance() {
        if (instance == null) {
            instance = new SharedData();
        }
        return instance;
    }

    // Getters and Setters
    public String getEmailT() {
        return emailT;
    }

    public void setEmailT(String emailT) {
        this.emailT = emailT;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
}