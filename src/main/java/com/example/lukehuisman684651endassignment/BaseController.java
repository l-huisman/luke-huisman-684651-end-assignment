package com.example.lukehuisman684651endassignment;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseController {
    // Method to change the stage to the next scene
    protected void switchStage(String fxmlFileName, BaseController controller, Event event) {
        Scene scene = loadScene(fxmlFileName, controller);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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

    // Method to close the Program
    protected void closeProgram(Event event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
        event.consume();
    }
}
