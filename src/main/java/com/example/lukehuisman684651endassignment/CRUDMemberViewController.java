package com.example.lukehuisman684651endassignment;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CRUDMemberViewController extends BaseController implements Initializable {

    UserService userService = new UserService();
    @FXML
    private Label userIDLabel;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private DatePicker birthDatePicker;
    @FXML
    private ChoiceBox<Role> roleChoiceBox;
    @FXML
    private Label errorLabel;
    private User user;
    boolean existingUserEdited = false;

    public CRUDMemberViewController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeChoiceBox();

    }

    private void initializeChoiceBox()
    {
        roleChoiceBox.getItems().add(Role.CUSTOMER);
        roleChoiceBox.getItems().add(Role.EMPLOYEE);
        roleChoiceBox.setValue(Role.CUSTOMER);
    }

    public void fillFields(User user)
    {
        this.user = user;
        if (user != null) {
            firstNameTextField.setText(user.getFirstName());
            lastNameTextField.setText(user.getLastName());
            birthDatePicker.setValue(user.getBirthDate());
            roleChoiceBox.setValue(user.getRole());
            existingUserEdited = true;
        }
    }

    @FXML
    private void addMemberButtonClicked(MouseEvent event) {
        if (!checkIfFieldsAreFilled()) {
            errorLabel.setText("Please fill in all fields\n(No numbers allowed in first name and last name!)");
            return;
        }
        if (!existingUserEdited)
            user = new User();
        user.setFirstName(firstNameTextField.getText());
        user.setLastName(lastNameTextField.getText());
        user.setBirthDate(getBirthDate());
        user.setRole(roleChoiceBox.getValue());
        if (existingUserEdited) {
            confirmPassword();
            userService.editUser(user);
        }
        else
            userService.addUser(user);
        controller = loadTabWithEvent("members-view.fxml", tab, event);
        controller.setTab(tab);
    }

    private void confirmPassword()
    {
        if (passwordField.getText().isEmpty() || passwordField.getText().isEmpty())
            return;
        if (passwordField.getText().equals(confirmPasswordField.getText()))
            user.setPassword(passwordField.getText());
        return;
    }

    //code below: https://stackoverflow.com/questions/32346893/javafx-datepicker-not-updating-value by user: https://stackoverflow.com/users/833070/draken
    private LocalDate getBirthDate()
    {
        return birthDatePicker.getConverter().fromString(birthDatePicker.getEditor().getText());
    }

    @FXML
    private void cancelButtonClicked(MouseEvent event) {
        controller = loadTabWithEvent("members-view.fxml", tab, event);
        controller.setTab(tab);
    }

    private boolean checkIfFieldsAreFilled() {
        return true;
    }
}
