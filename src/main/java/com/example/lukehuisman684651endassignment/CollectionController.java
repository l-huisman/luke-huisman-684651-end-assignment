package com.example.lukehuisman684651endassignment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CollectionController implements Initializable {
    @FXML
    private TableView<LibraryItem> libraryItemsTable;
    @FXML
    private TableColumn<LibraryItem, String> itemCodeColumn;
    @FXML
    private TableColumn<LibraryItem, String>  availableColumn;
    @FXML
    private TableColumn<LibraryItem, String>  titleColumn;
    @FXML
    private TableColumn<LibraryItem, String>  authorDirectorColumn;
    private LibraryService libraryService = new LibraryService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTableView();
    }

    private void initializeTableView() {
        List<LibraryItem> libraryItems = libraryService.getLibraryItems();

        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("availability"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        if (checkIfBook(libraryItems))
            authorDirectorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        else
            authorDirectorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));
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
