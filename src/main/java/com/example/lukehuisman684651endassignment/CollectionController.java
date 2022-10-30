package com.example.lukehuisman684651endassignment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CollectionController extends BaseController implements Initializable {
    @FXML
    private TableView<LibraryItem> libraryItemsTable;
    @FXML
    private TableColumn<LibraryItem, String> itemCodeColumn;
    @FXML
    private TableColumn<LibraryItem, Boolean> availableColumn;
    @FXML
    private TableColumn<LibraryItem, String> titleColumn;
    @FXML
    private TableColumn<LibraryItem, String> authorDirectorColumn;
    private LibraryService libraryService = new LibraryService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTableView();
        initializeListeners();
    }

    private void initializeListeners() {
        availableColumn.setCellFactory(column -> new TableCell<LibraryItem, Boolean>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(Boolean.TRUE.equals(item) ? "Yes" : "No");
                }
            }
        });
    }

    private void initializeTableView() {
        List<LibraryItem> libraryItems = libraryService.getLibraryItems();

        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorDirectorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        libraryItemsTable.getItems().addAll(libraryItems);
    }

    @FXML
    public void addItemButtonClicked() {
        //TODO
    }

    @FXML
    public void editItemButtonClicked() {
        //TODO
    }

    @FXML
    public void deleteItemButtonClicked() {
        //TODO
    }
}
