package com.example.lukehuisman684651endassignment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LendingReceivingController extends BaseController implements Initializable {
    // Regex expression in the code is from https://stackoverflow.com/questions/3802192/regexp-java-for-numbers by user https://stackoverflow.com/users/18771/tomalak
    private static final String NUMBERSREGEX = "[0-9]+";
    @FXML
    private TextField lendingItemCodeTextField;
    @FXML
    private TextField lendingMemberIdentifierTextField;
    @FXML
    private TextField receivingItemCodeTextField;
    @FXML
    private TextField receivingMemberIdentifierTextField;
    @FXML
    private Label lendingErrorLabel;
    @FXML
    private Label receivingErrorLabel;
    @FXML
    private Label lendingCriteriaLabel;
    @FXML
    private Label receivingCriteriaLabel;
    private LibraryService libraryService = new LibraryService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void lendingButtonClicked() {
        if (hasValidTextFieldInputForLending())
            lendingCriteriaLabel.setText(libraryService.lendLibraryItem(Integer.parseInt(lendingItemCodeTextField.getText()), Integer.parseInt(lendingMemberIdentifierTextField.getText())));

    }

    @FXML
    private void receivingButtonClicked() {
        if (hasValidTextFieldInputForReceiving())
            receivingCriteriaLabel.setText(libraryService.receiveLibraryItem(Integer.parseInt(receivingItemCodeTextField.getText()), Integer.parseInt(receivingMemberIdentifierTextField.getText())));
    }

    private boolean hasValidTextFieldInputForLending() {

        if (lendingItemCodeTextField.getText().isEmpty() || lendingMemberIdentifierTextField.getText().isEmpty()) {
            lendingErrorLabel.setText("Please fill in all fields");
            return false;
        }
        if (!lendingItemCodeTextField.getText().matches(NUMBERSREGEX) || !lendingMemberIdentifierTextField.getText().matches(NUMBERSREGEX)) {
            lendingErrorLabel.setText("Please enter numbers only");
            return false;
        }
        if (Integer.parseInt(lendingMemberIdentifierTextField.getText()) == 0) {
            lendingErrorLabel.setText("Please enter a valid member identifier");
            return false;
        }
        return true;
    }


    private boolean hasValidTextFieldInputForReceiving() {

        if (receivingItemCodeTextField.getText().isEmpty() || receivingMemberIdentifierTextField.getText().isEmpty()) {
            receivingErrorLabel.setText("Please fill in all fields");
            return false;
        }
        if (!receivingItemCodeTextField.getText().matches(NUMBERSREGEX) || !receivingMemberIdentifierTextField.getText().matches(NUMBERSREGEX)) {
            receivingErrorLabel.setText("Please enter numbers only");
            return false;
        }
        if (Integer.parseInt(receivingMemberIdentifierTextField.getText()) == 0) {
            receivingErrorLabel.setText("Please enter a valid member identifier");
            return false;
        }
        return true;
    }
}
