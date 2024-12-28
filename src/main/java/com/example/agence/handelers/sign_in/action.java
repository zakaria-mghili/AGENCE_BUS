package com.example.agence.handelers.sign_in;

import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.example.agence.handelers.sign_up.databaseConn;

public class action {
    ResultSet rs = null;
    public void sing_in(TextField email, PasswordField passwd){

                String emailT = email.getText();
                String passwdT = passwd.getText();

                if (!emailT.trim().isEmpty() && !passwdT.trim().isEmpty()) {
                    System.out.println("befor data");
                    if (regex.isEmail(email) && regex.bigger_8(passwd)) {
                    System.out.println("befor data in regex");

                        String query = "SELECT * FROM client WHERE email = ?";
                        try(java.sql.PreparedStatement stmt = databaseConn.getConnection().prepareStatement(query)){
                            stmt.setString(1, emailT);
                            rs = stmt.executeQuery();
                    System.out.println("after data");

                            //to show if cleint exist
                            if(!rs.next()){
                                JOptionPane.showMessageDialog(null, "this email not exist");
                                return;
                            }
                            //compare hash in database with the new 
                            String hash = hashPassword.hashPasswd(passwdT);
                            System.out.println("befor hash ");
                            if (hashPassword.compareHashes(hash, rs.getString("password"))) {
                    System.out.println("###########after hash ");

                                JOptionPane.showMessageDialog(null, "welcom to application ");
                                //to switch to another tab
                                /*desing searshDesing = new desing(stage);
                                searchResult flt = new searchResult();
                                searshDesing.getSearchButton().setOnAction(flt.search(searshDesing));*/
                            }else{
                                JOptionPane.showMessageDialog(null, "password not correct");
                            }
                        }catch (SQLException e) {
                            System.out.println("Erreur SQL !");
                            e.printStackTrace();
                        }
                    }else{
                        /*if (!regex.isEmail(email)) {
                            form.getErrorLabel().setText("Invalid email format.");
                            form.getErrorLabel().setVisible(true);
                            System.out.println("invalid email");
                        }else if (!regex.bigger_8(passwd)) {
                            form.getErrorLabel().setText("Password must be at least 8 characters.");
                            form.getErrorLabel().setVisible(true);
                            System.out.println("invalid password");
                        }else{
                            form.getErrorLabel().setVisible(false);
                        }*/
                    }
                }
            
    }
}



