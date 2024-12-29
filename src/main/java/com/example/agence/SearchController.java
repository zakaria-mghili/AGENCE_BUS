package com.example.agence;


import java.time.LocalDate;

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
        System.out.println("###################search interface###################");
        serachBtn.setOnAction(event -> {
            searchResult ac = new searchResult();
            ac.search(deparField, arrivalField, dateField, passenger, event);

            //Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            //currentStage.close();
        });
    }

}

