package com.example.lukehuisman684651endassignment;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends BaseController implements Initializable {

    protected User user;
    @FXML
    private GridPane mainStageGridPane;
    @FXML
    private TabPane mainStageTabPane;
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
        initializeTabListeners();
        loadTab("lending-receiving-view.fxml", lendingReceivingTab);
    }

    private void initializeTabListeners() {
        mainStageTabPane.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Tab>() {
                @Override
                public void changed(ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                    switch (t1.getId()) {
                        case "lendingReceivingTab":
                            loadTab("lending-receiving-view.fxml", lendingReceivingTab);
                            break;
                        case "collectionTab":
                            controller = loadTab("collection-view.fxml", collectionTab);
                            controller.setTab(collectionTab);
                            break;
                        case "membersTab":
                            controller = loadTab("members-view.fxml", membersTab);
                            controller.setTab(membersTab);
                            break;
                    }
                }
            }
        );
    }



    @FXML
    public void onCloseButtonClick(Event event) {
        closeProgram(event);
    }

}
