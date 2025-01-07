package com.example.agence;

import com.example.agence.handelers.models.SharedData;
import com.example.agence.handelers.models.isNumber;
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
        isNumber isNumber = new isNumber();
        serachBtn.setOnAction(event -> {
            SharedData sharedData = SharedData.getInstance();
            if (isNumber.isNumber(passenger.getText())) {
                if (!passenger.getText().isEmpty() && passenger.getText() != null) {
                    sharedData.setPassengers(Integer.parseInt(passenger.getText()));
                }

            }
            if (!arrivalField.getText().isEmpty() && arrivalField.getText() != null) {
                sharedData.setArrivalStation(arrivalField.getText());
            }
            if (!deparField.getText().isEmpty() && deparField.getText() != null) {
                sharedData.setDepartureDate(deparField.getText());
            }
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
