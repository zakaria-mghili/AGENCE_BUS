package com.example.agence.handelers.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class payment {

    public void validateAndSubmit(TextField nameField, TextField cardNumberField, TextField expirationMonthField, TextField expirationYearField, PasswordField cvvField, Stage primaryStage) {
        String name = nameField.getText();
        String cardNumber = cardNumberField.getText();
        String expirationMonth = expirationMonthField.getText();
        String expirationYear = expirationYearField.getText();
        String cvv = cvvField.getText();
        
        // Validate fields
        if (name.isEmpty() || cardNumber.isEmpty() || expirationMonth.isEmpty() || expirationYear.isEmpty() || cvv.isEmpty()) {
            showAlert("Validation Error", "Please complete all text fields.");
            return;
        }

        if (!validateCardDetails(cardNumber, expirationMonth, expirationYear, cvv)) {
            showAlert("Validation Error", "Card details are incorrect. Please check and try again.");
            return;
        }

        // Database connection and insertion
        try {
            Connection connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
            String sql = "INSERT INTO payment_details (name, card_number, expiration_month, expiration_year, cvv) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, cardNumber);
            statement.setString(3, expirationMonth);
            statement.setString(4, expirationYear);
            statement.setString(5, cvv);
            statement.executeUpdate();
            connection.close();
            
            // Show success message
            showAlert("Payment Successful", "Your payment is valid!");
            
            // Open new scene for tickets and close current scene
            openTicketsScene(primaryStage);
            
        } catch (SQLException ex) {
            showAlert("Database Error", "Unable to connect to the database. Please try again later.");
            ex.printStackTrace();
        }
    }

    private boolean validateCardDetails(String cardNumber, String expirationMonth, String expirationYear, String cvv) {
        // Example validation logic, replace with your specific requirements
        if (cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
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
    
    public  void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void openTicketsScene(Stage currentStage) {
        // Logic to open the new scene for tickets
        // Replace this with your actual code to open the new scene
        Stage newStage = new Stage();
        newStage.setTitle("Ticket Booking");
        // Add your scene setup for the new stage here
        // Example:
        // Scene ticketsScene = new Scene(new VBox(new Label("Welcome to the Ticket Booking")));
        // newStage.setScene(ticketsScene);
        newStage.show();
        currentStage.close();
    }
    
    public  void openPreviousScene(Stage currentStage) {
        // Logic to open the previous scene
        // Replace this with your actual code to open the previous scene
        Stage previousStage = new Stage();
        previousStage.setTitle("Previous Scene");
        // Add your scene setup for the previous stage here
        // Example:
        // Scene previousScene = new Scene(new VBox(new Label("Returning to Previous Scene")));
        // previousStage.setScene(previousScene);
        previousStage.show();
        currentStage.close();
    }
}
