package com.example.agence;


import com.example.agence.handelers.models.SharedData;
import com.example.agence.handelers.sign_in.action;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
            ac.sing_in(gmailField,password, event);
            String email = gmailField.getText();
            SharedData.getInstance().setEmailT(email);
            //Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            //currentStage.close();
        });
    }

    }
