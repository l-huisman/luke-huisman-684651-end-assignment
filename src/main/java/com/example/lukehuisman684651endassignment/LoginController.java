package com.example.lukehuisman684651endassignment;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController extends BaseController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label errorLabel;
    @FXML
    public void onLoginButtonClick(Event event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        if (checkCredentials(username, password))
            switchStage("main-view.fxml", new MainController(), event);
        errorLabel.setText("Invalid username or password");
    }

    private boolean checkCredentials(String username, String password) {
        // TODO: Create a more proper login system
        return username.equals("admin") && password.equals("admin");
    }

    @FXML
    public void onCloseButtonClick(Event event) {
        closeProgram(event);
    }
}