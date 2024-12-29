package com.example.agence.handelers.searsh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.example.agence.handelers.sign_up.databaseConn;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class searchResult {
    public void search(TextField deparField, TextField arrivalField, DatePicker dateField, TextField passenger, ActionEvent event) {
        String query;
        String departureStation = deparField.getText();
        String arrivalStation = arrivalField.getText();
        LocalDate departureDate = dateField.getValue();
        // String timeDepare = inter.getTimeDepare().getValue();
        String passengers = passenger.getText();

        if (!departureStation.trim().isEmpty() && !arrivalStation.trim().isEmpty() && passengers != null) {
            System.out.println("#########");
                query = " SELECT * FROM voyage WHERE depart = ? AND destination = ? AND DATE(date_debut) = ? ";
            

            try (PreparedStatement stmt = databaseConn.getConnection().prepareStatement(query)) {
                stmt.setString(1, departureStation);
                stmt.setString(2, arrivalStation);
                stmt.setString(3, departureDate.toString());
                

                ResultSet rs = stmt.executeQuery();
                displayResults.display(rs);

            } catch (SQLException e) {
                System.out.println("Erreur SQL !");
                e.printStackTrace();
            }
        } else {
            System.out.println("your input is empty");
            JOptionPane.showMessageDialog(null, "your input is empty");
        }
    }
}
