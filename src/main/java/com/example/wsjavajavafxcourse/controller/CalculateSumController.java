package com.example.wsjavajavafxcourse.controller;

import com.example.wsjavajavafxcourse.utils.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Locale;

public class CalculateSumController {

    @FXML
    private TextField txtFirstNumber;

    @FXML
    private TextField txtSecondNumber;

    @FXML
    private Label lbResult;

    @FXML
    private Button btSum;

    @FXML
    public void onBtSumAction() {
        try {
            Locale.setDefault(Locale.US);

            double firstNumber = Double.parseDouble(txtFirstNumber.getText());
            double secondNumber = Double.parseDouble(txtSecondNumber.getText());

            lbResult.setText(String.format("%.2f", firstNumber + secondNumber));
        } catch (NumberFormatException exception) {
            Alerts.showAlert("Error", "Parse Error", exception.getMessage(), AlertType.ERROR);
        }
    }
}
