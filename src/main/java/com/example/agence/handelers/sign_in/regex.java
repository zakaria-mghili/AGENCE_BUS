package com.example.agence.handelers.sign_in;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



public class regex {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._]+@[A-Za-z0-9]+\\.+[a-z]+$";
    private static final String PASSWD_REGEX = "^.{8,}+$";

    //Email
    public static Boolean isEmail(TextField email){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);

        Matcher matcher = pattern.matcher(email.getText().trim());
        return matcher.matches();
    }

    //password
    public static Boolean bigger_8(PasswordField passwd){
        Pattern pattern = Pattern.compile(PASSWD_REGEX);

        String ps = new String(passwd.getText());
        Matcher matcher = pattern.matcher(ps);
        return matcher.matches();
    }

    
}
