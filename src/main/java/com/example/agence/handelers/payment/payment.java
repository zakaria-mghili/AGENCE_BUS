package com.example.agence.handelers.payment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.agence.handelers.sign_up.databaseConn;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class payment {

    public void validateAndSubmit(String cardholderName, String cardNumber, String monthExpiration, String yearExpiration, String cvv, int passengers, double montant, String email, Stage primaryStage) {
        // Validate fields

        String emailClient = email; // Assuming this method retrieves the email client value

    if (emailClient == null || emailClient.isEmpty()) {
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
            statement.setString(1, email);
            statement.setInt(2,passengers);
            statement.setDouble(3,montant);
            statement.executeUpdate();
            connection.close();
            
            // Show success message
            showAlert("Payment Successful", "Your payment is valid!");
            
            // Open new scene for downloading tickets and close current scene
            openDownloadTicketScene(primaryStage);
            
        } catch (SQLException ex) {
            showAlert("Database Error", "Unable to connect to the database. Please try again later.");
            ex.printStackTrace();
        }
    }

    private boolean validateCardDetails(String cardNumber, String expirationMonth, String expirationYear, String cvv) {
        // Example validation logic, replace with your specific requirements
        if (cardNumber.length() != 1 || !cardNumber.matches("\\d+")) {
            return false;
        }
        if (expirationMonth.length() != 2 || !expirationMonth.matches("\\d{2}") || Integer.parseInt(expirationMonth) > 12) {
            return false;
        }
        if (expirationYear.length() != 2 || !expirationYear.matches("\\d{2}")) {
            return false;
        }
        if (cvv.length() != 3 || !cvv.matches("\\d{3}")) {
            return false;
        }
        return true;
    }
    
    public void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void openDownloadTicketScene(Stage currentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/download_ticket.fxml"));
            Parent root = loader.load();

            Scene downloadTicketScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setTitle("Download Ticket");
            newStage.setScene(downloadTicketScene);
            newStage.show();

            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Unable to load the download ticket scene.");
        }
    }
}