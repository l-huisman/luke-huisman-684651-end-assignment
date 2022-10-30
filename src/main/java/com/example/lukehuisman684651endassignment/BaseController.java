package com.example.lukehuisman684651endassignment;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseController {
    @FXML
    protected Tab tab;
    protected BaseController controller;

    public void setController(BaseController controller) {
        this.controller = controller;
    }

    public void setTab(Tab tab) {
        this.tab = tab;
    }

    // Method to change the stage to the next scene
    protected void switchStage(String fxmlFileName, BaseController controller, Event event) {
        Scene scene = loadScene(fxmlFileName, controller);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        event.consume();
    }

    // Method to return a loaded scene
    private Scene loadScene(String fxmlFileName, BaseController controller) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
        if (controller != null)
            loader.setController(controller);
        return new Scene(tryLoading(loader));
    }

    // Method to try loading the scene
    private Parent tryLoading(FXMLLoader loader) {
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Unable to run " + loader.getLocation() + "\nException: " + e);
        }
        return root;
    }

    // Everything the same but without a controller
    protected void switchStageWithoutController(String fxmlFileName, Event event) {
        Scene scene = loadSceneWithoutController(fxmlFileName);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        event.consume();
    }

    private Scene loadSceneWithoutController(String fxmlFileName) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
        return new Scene(tryLoading(loader));
    }

    // Method to close the Program
    protected void closeProgram(Event event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
        event.consume();
    }

    protected BaseController loadTab(String s, Tab tab) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(s));
            tab.setContent(loader.load());
            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
