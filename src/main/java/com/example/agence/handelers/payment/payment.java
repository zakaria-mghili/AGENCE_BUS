package com.example.agence.handelers.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.stage.Stage;

public class payment {

    public static void validateAndSubmit(String cardholderName, String cardNumber, String monthExpiration, String yearExpiration, String cvv, int passengers, double montant, String emailT, Stage primaryStage) {
        // Validate fields
        if (emailT == null || emailT.isEmpty()) {
            showAlert("Validation Error", "Email client cannot be null or empty.");
            return;
        }
        if (cardholderName.isEmpty() || cardNumber.isEmpty() || monthExpiration.isEmpty() || yearExpiration.isEmpty() || cvv.isEmpty()) {
            showAlert("Validation Error", "Please complete all text fields.");
            return;
        }

        if (!validateCardDetails(cardNumber, monthExpiration, yearExpiration, cvv)) {
            showAlert("Validation Error", "Card details are incorrect. Please check and try again.");
            return;
        }

        // Database connection and insertion
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_bus", "root", "");
            String sql = "INSERT INTO reservation (email_client, id_voyage, number_passengers, montant_paye) VALUES (?, 1, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, emailT);
            statement.setInt(2, passengers);
            statement.setDouble(3, montant);
    
            statement.executeUpdate();
            connection.close();
            
            // Show success message
            showAlert("Payment Successful", "Your payment is valid!");
            
            // Open new scene for downloading tickets and close current scene
            openDownloadTicketScene(primaryStage);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            showAlert("Database Error", "An error occurred while processing your payment. Please try again.");
        }
    }

    private static boolean validateCardDetails(String cardNumber, String monthExpiration, String yearExpiration, String cvv) {
        // Implement card validation logic here
        return true; // Placeholder
    }

    private static void showAlert(String title, String message) {
        // Implement alert dialog logic here
    }

    private static void openDownloadTicketScene(Stage primaryStage) {
        // Implement scene switching logic here
    }
}