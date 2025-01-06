package com.example.agence;

import com.example.agence.handelers.models.SharedData;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TicketController {

    @FXML
    private Label arivalvilleticket;

    @FXML
    private Label datearrivaleticket;

    @FXML
    private Label datedepartureticket;

    @FXML
    private Label departurevilleticket;

    @FXML
    private Label npassengerticket;

    @FXML
    private Label priceticket;

    @FXML
    private void initialize() {
        setTicketData();
    }

    private void setTicketData() {
        SharedData sharedData = SharedData.getInstance();
        arivalvilleticket.setText(sharedData.getArrivalStation());
        datearrivaleticket.setText(sharedData.getArrivalDate());
        datedepartureticket.setText(sharedData.getDepartureDate());
        departurevilleticket.setText(sharedData.getDepartureStation());
        npassengerticket.setText(Double.toString(sharedData.getPassengers()));
        priceticket.setText(Double.toString(sharedData.getMontant()));
    }
}