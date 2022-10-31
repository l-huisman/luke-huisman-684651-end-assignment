package com.example.lukehuisman684651endassignment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML
    private Button editMemberButton;
    @FXML
    private Button deleteMemberButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTableView();
        initializeListeners();
    }

    private void initializeListeners() {
        membersTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            editMemberButton.setDisable(false);
            deleteMemberButton.setDisable(false);
        });
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
        controller = loadTabWithEvent("crud-member-view.fxml", tab, event);
        controller.setTab(tab);
    }

    @FXML
    public void editMemberButtonClicked(MouseEvent event) {
        User user = membersTable.getSelectionModel().getSelectedItem();
        controller = loadTabWithEvent("crud-member-view.fxml", tab, event);
        controller.setTab(tab);
        ((CRUDMemberViewController) controller).fillFields(user);
    }

    @FXML
    public void deleteMemberButtonClicked() {
        User user = membersTable.getSelectionModel().getSelectedItem();
        userService.deleteUser(user);
        membersTable.getItems().remove(user);
    }
}
