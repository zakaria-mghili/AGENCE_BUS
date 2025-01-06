package com.example.agence;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DownloadTicketController {

    @FXML
    private Button DownloadBtn;


    @FXML
    private void initialize() {
        DownloadBtn.setOnAction(e -> handleDownloadButtonAction());
    }

    private void handleDownloadButtonAction() {
        try {
            // Load the Ticket.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ticket.fxml"));
            Parent root = loader.load();

            // Create a new stage for the ticket interface
            Stage stage = new Stage();
            stage.setTitle("Ticket");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}


