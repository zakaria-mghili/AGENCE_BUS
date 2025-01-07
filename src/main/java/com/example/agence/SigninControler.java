package com.example.agence;

import com.example.agence.handelers.models.SharedData;
import com.example.agence.handelers.sign_in.action;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SigninControler {

    @FXML
    private TextField gmailField;

    @FXML
    private PasswordField password;

    @FXML
    private Button signinBtn;

    @FXML
    private Hyperlink createyours;

    @FXML
    public void initialize() {
        signinBtn.setOnAction(event -> {
            System.out.println("###################sign in###################");
            action ac = new action();
            ac.sing_in(gmailField, password, event);
            SharedData.getInstance().setEmailT(gmailField.getText());
        });
        /*
         * createyours.setOnAction(event -> {
         * try {
         * FXMLLoader fxmlLoader = new
         * FXMLLoader(Main.class.getResource("signup.fxml"));
         * Parent root = fxmlLoader.load();
         * Stage stage = (Stage) ((javafx.scene.Node)
         * event.getSource()).getScene().getWindow();
         * Scene scene = new Scene(root);
         * stage.setScene(scene);
         * stage.show();
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         * }
         * });
         */
    }
}
