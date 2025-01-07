package com.example.agence;

import java.io.IOException;

import com.almasb.fxgl.entity.action.Action;

import javafx.event.ActionEvent;
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
        DownloadBtn.setOnAction(e -> handleDownloadButtonAction(e));
    }

    private void handleDownloadButtonAction(ActionEvent event) {
        try {
            // Load the Ticket.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Ticket.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
