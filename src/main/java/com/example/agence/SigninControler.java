package com.example.agence;


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
    public void initialize() {
        gmailField.setText("hihihihihihihihhi");
        System.out.println("######################################");
        signinBtn.setOnAction(event -> handleSignin());
    }

    private void handleSignin() {
        String username = gmailField.getText();
        String passwd = password.getText();

        System.out.println("Username: " + username);
        System.out.println("Password: " + passwd);
        // Add signup logic here
    }

    }
