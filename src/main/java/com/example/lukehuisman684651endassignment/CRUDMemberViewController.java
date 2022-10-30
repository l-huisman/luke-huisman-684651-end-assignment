package com.example.lukehuisman684651endassignment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CRUDMemberViewController extends BaseController implements Initializable {

    UserService userService = new UserService();
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private DatePicker birthDatePicker;
    @FXML
    private Label errorLabel;
    private User user;

    public CRUDMemberViewController() {
    }

    public CRUDMemberViewController(User user) {
        this.user = user;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (user != null) {
            firstNameTextField.setText(user.getFirstName());
            lastNameTextField.setText(user.getLastName());
            birthDatePicker.setValue(user.getBirthDate());
        }
    }

    @FXML
    private void addMemberButtonClicked(MouseEvent event) {
        if (!checkIfFieldsAreFilled()) {
            errorLabel.setText("Please fill in all fields\n(No numbers allowed in first name and last name!)");
            return;
        }
        user = new User();
        user.setFirstName(firstNameTextField.getText());
        user.setLastName(lastNameTextField.getText());
        user.setBirthDate(birthDatePicker.getValue());
        userService.addUser(user);

        controller = loadTab("members-view.fxml", tab);
        controller.setTab(tab);
    }

    @FXML
    private void cancelButtonClicked(MouseEvent event) {
        controller = loadTab("members-view.fxml", tab);
        controller.setTab(tab);
    }

    private boolean checkIfFieldsAreFilled() {
        return true;
    }
}
