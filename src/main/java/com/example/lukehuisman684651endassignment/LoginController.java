package com.example.lukehuisman684651endassignment;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

public class LoginController extends BaseController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label errorLabel;
    UserService userService = new UserService();

    @FXML
    public void onLoginButtonClick(Event event) {
        int userID = Integer.parseInt(usernameField.getText());
        String password = passwordField.getText();
        User user = userService.checkCredentialsOfEmployee(userID, password);
        if (!Objects.isNull(user))
            switchStage("main-view.fxml", new MainController(user), event);
        errorLabel.setText("Invalid username or password");
    }

    @FXML
    public void onCloseButtonClick(Event event) {
        closeProgram(event);
    }
}