package com.example.agence;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import com.example.agence.handelers.searsh.searchResult;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchController {

    @FXML
    private TextField arrivalField;

    @FXML
    private DatePicker dateField;

    @FXML
    private TextField deparField;

    @FXML
    private TextField passenger;

    @FXML
    private Button serachBtn;

    @FXML
    public void initialize() {
        serachBtn.setOnAction(event -> {
            searchResult ac = new searchResult();
            ac.search(deparField, arrivalField, dateField, passenger, event);
        });
        
    }
    public void setData(String cityA, String cityD, String pass) {
        arrivalField.setText(cityA);
        deparField.setText(cityD);
        passenger.setText(pass);
    }
}
