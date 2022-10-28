package com.example.lukehuisman684651endassignment;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends BaseController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("MainController initialized");
    }

    @FXML
    public void onCloseButtonClick(Event event) {
        closeProgram(event);
    }
}
