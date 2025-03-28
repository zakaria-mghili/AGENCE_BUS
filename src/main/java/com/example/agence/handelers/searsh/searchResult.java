package com.example.agence.handelers.searsh;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.example.agence.ListeController;
import com.example.agence.Main;
import com.example.agence.handelers.models.alert;
import com.example.agence.handelers.models.isNumber;
import com.example.agence.handelers.sign_up.databaseConn;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class searchResult {
    ResultSet result;
    List<String[]> rlt = new ArrayList<>();
    alert alert = new alert();
    isNumber isnumber = new isNumber();

    public void search(TextField deparField, TextField arrivalField, DatePicker dateField, TextField passenger,
            ActionEvent event) {
        String query;
        String departureStation = deparField.getText();
        String arrivalStation = arrivalField.getText();
        LocalDate departureDate = dateField.getValue();
        // String timeDepare = inter.getTimeDepare().getValue();
        String passengers = passenger.getText();

        if (!departureStation.trim().isEmpty() && !arrivalStation.trim().isEmpty() && passengers != null
                && !passengers.isEmpty() && departureDate != null) {
            if (isnumber.isNumber(passengers) && regex.validcity(arrivalField) && regex.validcity(deparField) && regex.validPassenger(passenger)) {

                int passengerCount = Integer.parseInt(passengers);
                    System.out.println(passengerCount);
                    
                query = "SELECT MONTH(date_debut) AS monthD, MONTH(date_arrival) AS monthA, DAY(date_debut) AS dayD, DAY(date_arrival) AS dayA, destination, depart, FORMAT(date_debut, 'HH:mm') AS timeD, FORMAT(date_arrival, 'HH:mm') AS timeA, prix FROM voyage WHERE depart = ? AND destination = ? AND CAST(date_debut AS DATE) = ? ";

                try (PreparedStatement stmt = databaseConn.getConnection().prepareStatement(query)) {
                    stmt.setString(1, departureStation);
                    if (arrivalStation.trim().equalsIgnoreCase("fes") || arrivalStation.trim().equalsIgnoreCase("fés")
                            || arrivalStation.trim().equalsIgnoreCase("fès")) {
                        stmt.setString(2, "Fès");
                    } else {
                        stmt.setString(2, arrivalStation);
                    }
                    stmt.setString(3, departureDate.toString());

                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        // String value = rs.getString("destination");
                        do {
                            String[] voy = new String[8];
                            voy[0] = rs.getString("destination");
                            voy[1] = rs.getString("depart");
                            voy[2] = rs.getString("timeD");
                            voy[3] = rs.getString("timeA");
                            voy[4] = passenger.getText();
                            voy[5] = rs.getString("prix");
                            voy[6] = rs.getString("dayD");
                            // voy[7] = rs.getString("dayA");
                            voy[7] = rs.getString("monthD");
                            // voy[9] = rs.getString("monthA");

                            rlt.add(voy);

                        } while (rs.next());
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("liste.fxml"));
                            Parent root = fxmlLoader.load();

                            // Get the controller instance created by the FXMLLoader
                            ListeController listeController = fxmlLoader.getController();
                            listeController.setData(rlt);

                            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Aucune donnée trouvée !");
                        JOptionPane.showMessageDialog(null, "data not found !");
                    }

                    // displayResults.display(rs);
                    /*
                     * try {
                     * FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("liste.fxml"));
                     * Parent root = fxmlLoader.load();
                     * Stage stage = (Stage) ((javafx.scene.Node)
                     * event.getSource()).getScene().getWindow();
                     * Scene scene = new Scene(root);
                     * stage.setScene(scene);
                     * stage.show();
                     * 
                     * } catch (Exception e) {
                     * e.printStackTrace();
                     * }
                     */

                } catch (SQLException e) {
                    System.out.println("Erreur SQL !");
                    e.printStackTrace();
                }
            } else {
                if (!regex.validcity(deparField)) {
                    //JOptionPane.showMessageDialog(null, "Departure city not valid");
                    alert.showAlert("Error", "Departure city not valid");
                } else if (!regex.validcity(arrivalField)) {
                    //JOptionPane.showMessageDialog(null, "Arrival city not valid");
                    alert.showAlert("Error", "Arrival city not valid");
                } else if (!regex.validPassenger(passenger)) {
                    //JOptionPane.showMessageDialog(null,"Passenger count not valid (The number must be between 1 and 9)");
                    alert.showAlert("Error", "Passenger count not valid (The number must be between 1 and 9)");
                }else if (!isnumber.isNumber(passengers)) {
                    //JOptionPane.showMessageDialog(null, "Passenger count not valid (The number must be between 1 and 9)");
                    alert.showAlert("Error", "Passenger count not valid (The number must be between 1 and 9)");
                }
            }
        } else {
            System.out.println("your input is empty");
            //JOptionPane.showMessageDialog(null, "your input is empty");
            alert.showAlert("Error", "your input is empty");
        }
    }

    public List<String[]> getVoyage() {
        return rlt;
    }

}
