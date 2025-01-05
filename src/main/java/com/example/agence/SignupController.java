package com.example.agence;

import com.example.agence.handelers.sign_up.singUp_action;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController {

    @FXML
    private TextField gmailField;

    @FXML
    private TextField name;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField phone;

    @FXML
    private Button signupBtn;

    @FXML
    private Hyperlink hyperlink;

    @FXML
    public void initialize() {
        singUp_action ac = new singUp_action();
        signupBtn.setOnAction(event -> {
            System.out.println("######################################");
            ac.signUp(name, gmailField, phone, passwordField, event);
            // Get the current stage and close it
            // Stage currentStage = (Stage) ((javafx.scene.Node)
            // event.getSource()).getScene().getWindow();
            // currentStage.close();
        });

        hyperlink.setOnAction(event -> {
            System.out.println("######################################");
            // Get the current stage and close it
            try {
                // Load the FXML file for the new interface
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
