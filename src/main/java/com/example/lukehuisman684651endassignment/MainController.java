package com.example.lukehuisman684651endassignment;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends BaseController implements Initializable {

    protected User user;
    @FXML
    private GridPane mainStageGridPane;
    @FXML
    private Tab lendingReceivingTab;
    @FXML
    private Tab collectionTab;
    @FXML
    private Tab membersTab;


    MainController(User user) {
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //initializeTabListeners();
    }

    @FXML
    public void onCloseButtonClick(Event event) {
        closeProgram(event);
    }

//    private void initializeTabListeners() {
//        lendingReceivingTab.setOnSelectionChanged(event -> {
//            if (lendingReceivingTab.isSelected())
//                controller = new LendingReceivingController(user);
//        });
//        collectionTab.setOnSelectionChanged(event -> {
//            if (collectionTab.isSelected())
//                controller = new CollectionController(user);
//        });
//        membersTab.setOnSelectionChanged(event -> {
//            if (membersTab.isSelected())
//                controller = new MembersController(user);
//        });
//    }
}
