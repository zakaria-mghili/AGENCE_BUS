package com.example.agence.handelers.sign_up;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.agence.Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class singUp_action {
    static ResultSet result = null;

    public static Boolean clientExist(TextField email) throws SQLException{
        String emailT = email.getText();
        Boolean ver = true;
        if (!emailT.trim().isEmpty()) {
            String query = "SELECT * FROM client WHERE email = ? ";
            try (java.sql.PreparedStatement stmt = databaseConn.getConnection().prepareStatement(query)) {
            stmt.setString(1, emailT);
            result = stmt.executeQuery();
            if (result.next()) {
                ver = true;
            }else{
                ver = false;
            }
        }
        }
        return ver;
    }

    public void signUp(TextField name,TextField email,TextField phone,PasswordField passwd){
                //ResultSet rs = null;

                String nameT = name.getText();
                String emailT = email.getText();
                String phoneNum = phone.getText();
                String password = passwd.getText();

                if (!nameT.trim().isEmpty() && !emailT.trim().isEmpty() && !phoneNum.trim().isEmpty() && !password.trim().isEmpty()) {
                    //if (!emailT.trim().isEmpty() ) {
            
                        if (regex.isEmail(email) && regex.isNumb(phone)&& regex.bigger_8(passwd)) {
                            //if (regex.isEmail(email)) {
                        String query = "INSERT INTO client (name, email, contact, password) VALUES (?, ?, ?, ?)";
                        try(java.sql.PreparedStatement stmt = databaseConn.getConnection().prepareStatement(query)){
                            if (!clientExist(email)) {
                                stmt.setString(1, nameT);
                                stmt.setString(2, emailT);
                                stmt.setString(3, phoneNum);
                                stmt.setString(4, hashPassword.hashPasswd(password));
                                stmt.executeUpdate();

                                try {
                                    // Load the FXML file for the new interface
                                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
                                    Parent root = fxmlLoader.load();

                                    // Create a new stage for the new interface
                                    Stage stage = new Stage();
                                    stage.setTitle("New Interface");
                                    stage.setScene(new Scene(root));
                                    stage.show();
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }

                                System.out.println("it is added");
                                System.out.println("########### match");
                            } else{
                                //JOptionPane.showMessageDialog(null, "this email already exist");
                            }
                        }catch (SQLException e1) {
                            System.out.println("Erreur SQL !");
                            e1.printStackTrace();
                        }
                    }else{
                        //System.out.println(regex.inputsNotValid(email, phone, passwd,form));
                            /*if (!regex.isEmail(email)) {
                                form.getErrorLabel().setText("Invalid email format.");
                                form.getErrorLabel().setVisible(true);
                                System.out.println("invalid email");
                            }else if (!regex.bigger_8(passwd)) {
                                form.getErrorLabel().setText("Password must be at least 8 characters.");
                                form.getErrorLabel().setVisible(true);
                                System.out.println("invalid password");
                            }else if (!regex.isNumb(phone)) {
                                form.getErrorLabel().setText("invalid number phone.");
                                form.getErrorLabel().setVisible(true);
                            }
                            else{
                                form.getErrorLabel().setVisible(false);
                            }*/
                        
                    }
                }else{
                    System.out.println("your input is empty");
                }
            }
    
            //to function singup work when click on button
            //public static void action(JTextField name, JTextField phone, JTextField email, JPasswordField passwd, JButton singUp, design frame){
            //singUp.addActionListener(e->{
              //  singUp(name,phone, email,passwd,frame);
            //});


    /*public  signUp(TextField name,TextField email,TextField phone,PasswordField passwd){
        return sing_up(name, email, phone, passwd);
    }*/
}






