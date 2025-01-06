package com.example.agence.handelers.payment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class payment {

    public static void validateAndSubmit(String cardholderName, String cardNumber, String monthExpiration, String yearExpiration, String cvv, int passengers, double montant, String emailT, Stage primaryStage) {
        // Validate fields
        if (!validateFields(cardholderName, cardNumber, monthExpiration, yearExpiration, cvv, emailT)) {
            return;
        }

        // Database connection and insertion
        String sql = "INSERT INTO reservation (email_client, id_voyage, number_passengers, montant_paye) VALUES (?, 1, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_bus", "root", "");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, emailT);
            statement.setInt(2, passengers);
            statement.setDouble(3, montant);
            statement.executeUpdate();
            
            // Show success message
            showAlert("Payment Successful", "Your payment is valid!");
            
            // Open new scene for downloading tickets and close current scene
            openDownloadTicketScene(primaryStage);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            showAlert("Database Error", "An error occurred while processing your payment. Please try again.");
        }
    }

    private static boolean validateFields(String cardholderName, String cardNumber, String monthExpiration, String yearExpiration, String cvv, String emailT) {
        if (emailT == null || emailT.isEmpty()) {
            showAlert("Validation Error", "Email client cannot be null or empty.");
            return false;
        }
        if (cardholderName.isEmpty() || cardNumber.isEmpty() || monthExpiration.isEmpty() || yearExpiration.isEmpty() || cvv.isEmpty()) {
            showAlert("Validation Error", "Please complete all text fields.");
            return false;
        }
      
        if (!cardNumber.matches("\\d{16}")) {
            showAlert("Validation Error", "Invalid card number format. Please enter a 16-digit card number.");
            return false;
        }
        if (!monthExpiration.matches("\\d{2}") || Integer.parseInt(monthExpiration) < 1 || Integer.parseInt(monthExpiration) > 12) {
            showAlert("Validation Error", "Invalid month format. Please enter a valid month (01-12).");
            return false;
        }
        if (!yearExpiration.matches("\\d{4}")) {
            showAlert("Validation Error", "Invalid year format. Please enter a 4-digit year.");
            return false;
        }
        if (!cvv.matches("\\d{3}")) {
            showAlert("Validation Error", "Invalid CVV format. Please enter a 3-digit CVV.");
            return false;
        }
        return true;
    }

    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private static void openDownloadTicketScene(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(payment.class.getResource("download.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Scene Error", "An error occurred while opening the download ticket scene.");
        }
    }
    ////////////
}