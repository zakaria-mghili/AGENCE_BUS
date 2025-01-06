package com.example.agence;

import com.example.agence.handelers.models.SharedData;
import com.example.agence.handelers.searsh.searchResult;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
            SharedData sharedData = SharedData.getInstance();
            
            sharedData.setPassengers(Integer.parseInt(passenger.getText()));
        
            sharedData.setArrivalStation(arrivalField.getText());
            sharedData.setDepartureDate(deparField.getText());
            searchResult ac = new searchResult();
            ac.search(deparField, arrivalField, dateField, passenger, event);

        });
    }

}
