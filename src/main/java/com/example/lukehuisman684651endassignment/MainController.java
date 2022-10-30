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
    private BaseController controller;


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
                            loadTab("collection-view.fxml", collectionTab);
                            break;
                        case "membersTab":
                            loadTab("members-view.fxml", membersTab);
                            break;
                    }
                }
            }
        );
    }

    private void loadTab(String s, Tab tab) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(s));
            tab.setContent(loader.load());
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onCloseButtonClick(Event event) {
        closeProgram(event);
    }

}
