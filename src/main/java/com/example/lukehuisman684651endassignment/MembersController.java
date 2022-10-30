package com.example.lukehuisman684651endassignment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MembersController implements Initializable {

    @FXML
    private TableView<User> membersTable;
    @FXML
    private TableColumn<User, String> userIDColumn;
    @FXML
    private TableColumn<User, String> firstNameColumn;
    @FXML
    private TableColumn<User, String> lastNameColumn;
    @FXML
    private TableColumn<User, String> birthDateColumn;
    @FXML
    private TableColumn<User, String> roleColumn;

    UserService userService = new UserService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTableView();
    }

    private void initializeTableView()
    {
        userIDColumn.setCellValueFactory(new PropertyValueFactory<>("userID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        membersTable.getItems().addAll(userService.getUsers());
    }

    @FXML
    public void addMemberButtonClicked() {
        //TODO
    }

    @FXML
    public void editMemberButtonClicked() {
        //TODO
    }

    @FXML
    public void deleteMemberButtonClicked() {
        //TODO
    }
}
