package com.example.lukehuisman684651endassignment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MembersController extends BaseController implements Initializable {

    UserService userService = new UserService();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTableView();
    }

    private void initializeTableView() {
        userIDColumn.setCellValueFactory(new PropertyValueFactory<>("userID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("formattedBirthDate"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        membersTable.getItems().addAll(userService.getUsers());
    }

    @FXML
    public void addMemberButtonClicked(MouseEvent event) {
        controller = loadTab("crud-member-view.fxml", tab);
        controller.setTab(tab);
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
