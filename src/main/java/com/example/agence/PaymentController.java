package com.example.agence;

import java.io.IOException;

import com.example.agence.handelers.models.SharedData;
import com.example.agence.handelers.payment.payment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PaymentController {

    @FXML
    private TextField CVV;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField cardholderField;

    @FXML
    private TextField cardnumField;

    @FXML
    private TextField monthEXP;

    @FXML
    private Button validateBtn;

    @FXML
    private TextField yearEXP;

    @FXML
    public void initialize() {
        // Initialization logic if needed
    }

    @FXML 
    private void handleValidate() {
        SharedData sharedData = SharedData.getInstance();
        String emailT = sharedData.getEmailT();
        int passengers = sharedData.getPassengers();
        double montant = sharedData.getMontant();
        String depart = sharedData.getDepartureStation();
        String arrival = sharedData.getArrivalStation();
        String departureDate = sharedData.getDepartureDate();

        System.out.println(montant);

        payment pay = new payment();
        Stage currentStage = (Stage) validateBtn.getScene().getWindow();
        pay.validateAndSubmit(cardholderField.getText(), cardnumField.getText(), monthEXP.getText(), yearEXP.getText(), CVV.getText(), passengers, montant, emailT, currentStage);
    }

    @FXML
    private void handleCancel() {
        System.out.println("Cancel button clicked");
        openVoyageContentScene();
    }

    private void openVoyageContentScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("search.fxml"));
            Parent root = loader.load();

            Scene voyageContentScene = new Scene(root);
            Stage currentStage = (Stage) cancelBtn.getScene().getWindow();
            currentStage.setScene(voyageContentScene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}