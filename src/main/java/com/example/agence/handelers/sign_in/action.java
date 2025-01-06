package com.example.agence.handelers.sign_in;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.example.agence.Main;
import com.example.agence.handelers.sign_up.databaseConn;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class action {
    ResultSet rs = null;

    public void sing_in(TextField email, PasswordField passwd, ActionEvent event) {
        String emailT = email.getText();
        String passwdT = passwd.getText();

        if (!emailT.trim().isEmpty() && !passwdT.trim().isEmpty()) {
            if (regex.isEmail(email) && regex.bigger_8(passwd)) {
                String query = "SELECT * FROM client WHERE email = ?";
                try (java.sql.PreparedStatement stmt = databaseConn.getConnection().prepareStatement(query)) {
                    stmt.setString(1, emailT);
                    rs = stmt.executeQuery();

                    // to show if cleint exist
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "this email not exist");
                        return;
                    }
                    // compare hash in database with the new
                    String hash = hashPassword.hashPasswd(passwdT);
                    if (hashPassword.compareHashes(hash, rs.getString("password"))) {

                        // JOptionPane.showMessageDialog(null, "welcom to application ");

                        /* open interface of search */
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search.fxml"));
                            Parent root = fxmlLoader.load();
                            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "password not correct");
                    }
                } catch (SQLException e) {
                    System.out.println("Erreur SQL !");
                    e.printStackTrace();
                }
            } else {
                if (!regex.isEmail(email)) {
                    // form.getErrorLabel().setText("Invalid email format.");
                    // form.getErrorLabel().setVisible(true);
                    JOptionPane.showMessageDialog(null, "invalid email");
                    System.out.println("invalid email");
                } else if (!regex.bigger_8(passwd)) {
                    // form.getErrorLabel().setText("Password must be at least 8 characters.");
                    // form.getErrorLabel().setVisible(true);
                    JOptionPane.showMessageDialog(null, "invalid password");
                    System.out.println("invalid password");
                } else {
                    // form.getErrorLabel().setVisible(false);
                }
            }
        } else {
            System.out.println("your input is empty");
            JOptionPane.showMessageDialog(null, "your input is empty");
        }
    }
}
