package com.example.agence;


import com.example.agence.handelers.sign_in.action;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    public void initialize() {
        signinBtn.setOnAction(event -> {
            System.out.println("###################sign in###################");
            action ac = new action();
            ac.sing_in(gmailField,password);
            Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            //currentStage.close();
        });
    }

    }
