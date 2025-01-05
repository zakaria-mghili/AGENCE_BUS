package com.example.agence;


import com.example.agence.handelers.payment.payment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PaymentController {

    @FXML
    private TextField CVV;

    @FXML
    private Button cancelBtn;

    @FXML
    private TextField cardholderField;

    @FXML
    private TextField cardnumField;

    @FXML
    private TextField monthEXP;

    @FXML
    private Button validateBtn;

    @FXML
    private TextField yearEXP;

    @FXML

    public void paym (){
        validateBtn.setOnAction((actionEvent) -> {

            payment pay = new payment();
            pay.validateAndSubmit(cardnumField, cardholderField, monthEXP, CVV, null, null);;


        });


    }

}
