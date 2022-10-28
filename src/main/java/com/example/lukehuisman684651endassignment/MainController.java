package com.example.lukehuisman684651endassignment;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends BaseController implements Initializable {

    @FXML
    private GridPane mainStageGridPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void onCloseButtonClick(Event event) {
        closeProgram(event);
    }

}
