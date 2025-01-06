package com.example.agence.handelers.models;

public class SharedData {
    private static SharedData instance;
    private String emailT;
    private int passengers;
    private double montant;

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
    public String getemailT() {
        return emailT;
    }

    public void setemailT(String emailT) {
        this.emailT = emailT;
    }

    public int getpassengers() {
        return passengers;
    }

    public void setpassengers(int passengers) {
        this.passengers = passengers;
    }

    public double getmontant() {
        return montant;
    }

    public void setmontant(double montant) {
        this.montant = montant;
    }
}