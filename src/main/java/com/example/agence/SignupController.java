package com.example.agence;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        private Hyperlink alreadylink;
    
    @FXML
    public void initialize() {
        //name.setText("hihihihihihihihhi");
        //System.out.println("######################################");
        alreadylink.setOnAction(event -> handleSignUp());
    }

    private void handleSignUp() {
        String username = name.getText();
        String password = passwordField.getText();

        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        // Add signup logic here
    }
}
