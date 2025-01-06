package com.example.agence;

import java.io.IOException;

import com.example.agence.handelers.models.SharedData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VoyageController {

    @FXML
    private Label arrivalcityid;

    @FXML
    private Label arrivaltimeid;

    @FXML
    private Label departurecityid;

    @FXML
    private Label departuretimeid;

    @FXML
    private Label numberpassengerid;

    @FXML
    private Label priceid;

    @FXML
    private Button book;

    public void setData(String[] arr) {
        // this.voyage = voyage;
        arrivalcityid.setText(arr[0]);
        departurecityid.setText(arr[1]);
        departuretimeid.setText(arr[2]);
        arrivaltimeid.setText(arr[3]);
        numberpassengerid.setText(arr[4]);
        priceid.setText(arr[5]);
        SharedData.getInstance().setArrivalStation(arr[0]);
        SharedData.getInstance().setDepartureStation(arr[1]);
        SharedData.getInstance().setDepartureDate(arr[2]);
        SharedData.getInstance().setArrivalDate(arr[3]);
        SharedData.getInstance().setPassengers(Integer.parseInt(arr[4]));
        SharedData.getInstance().setMontant(Double.parseDouble(arr[5]));
        book.setOnAction(e -> handleBookButtonAction(e));
    }

    private void handleBookButtonAction(ActionEvent event) {
        try {
            // Load the payment.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("payment.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
