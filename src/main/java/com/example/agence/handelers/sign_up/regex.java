package com.example.agence.handelers.sign_up;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import javax.swing.JOptionPane;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class regex {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._]+@[A-Za-z0-9]+\\.+[a-z]+$";
    private static final String PHONE_REGEX = "^\\d{10}$";
    private static final String PASSWD_REGEX = "^.{8,}+$";

    //Email
    public static Boolean isEmail(TextField email){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);

        Matcher matcher = pattern.matcher(email.getText().trim());
        return matcher.matches();
    }

    public static void emailNotValid(){
        System.out.println("this enmail not valid");
    }

    //phone number
    public static Boolean isNumb(TextField num){
        Pattern pattern = Pattern.compile(PHONE_REGEX);

        Matcher matcher = pattern.matcher(num.getText().trim());
        return matcher.matches();
    }

    public static void numNotValid(){
        System.out.println("this phone number not valid");
    }

    //password
    public static Boolean bigger_8(PasswordField passwd){
        Pattern pattern = Pattern.compile(PASSWD_REGEX);

        String ps = passwd.getText();
        Matcher matcher = pattern.matcher(ps);
        return matcher.matches();
    }

    public static void passwdNotValid(){
        System.out.println("this password os short");
    }

    //To display errors to the client
    /*public static String[] inputsNotValid(TextField email, TextField num, PasswordField passwd){
        String[] errors = {"","",""};
        if (!isEmail(email)) {
            emailNotValid();
            errors[0] = "Invalid email. Please correct it.";
        }if (!isNumb(num)) {
            numNotValid();
            errors[1] = "Invalid phome number. Please correct it.";
        }if (!bigger_8(passwd)) {
            passwdNotValid();
            errors[2] = "password is short. Please correct it.";
        }

            //JOptionPane.showMessageDialog(null, String.join("\n", errors));
        return errors;
    }*/
    
}
