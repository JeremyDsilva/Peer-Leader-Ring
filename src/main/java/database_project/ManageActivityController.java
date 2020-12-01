package database_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ManageActivityController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ManageActivityNameTextField;

    @FXML
    private TextField ManageActivityDateTextField;

    @FXML
    private TextField ManageActivityMonthTextField;

    @FXML
    private TextField ManageActivityYearTextField;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button UpdateButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button AddButton;

    @FXML
    private TextField ManageActivityOrganizedByTextField;

    @FXML
    private TextArea ManageActivityNoteTextArea;

    @FXML
    void AddButtonOnClick(ActionEvent event) {

    }

    @FXML
    void BackButtonOnClick(ActionEvent event) {

    }

    @FXML
    void DeleteButtonOnClick(ActionEvent event) {

    }

    @FXML
    void UpdateButtonOnClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert ManageActivityNameTextField != null : "fx:id=\"ManageActivityNameTextField\" was not injected: check your FXML file 'ManageActivity.fxml'.";
        assert ManageActivityDateTextField != null : "fx:id=\"ManageActivityDateTextField\" was not injected: check your FXML file 'ManageActivity.fxml'.";
        assert ManageActivityMonthTextField != null : "fx:id=\"ManageActivityMonthTextField\" was not injected: check your FXML file 'ManageActivity.fxml'.";
        assert ManageActivityYearTextField != null : "fx:id=\"ManageActivityYearTextField\" was not injected: check your FXML file 'ManageActivity.fxml'.";
        assert DeleteButton != null : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'ManageActivity.fxml'.";
        assert UpdateButton != null : "fx:id=\"UpdateButton\" was not injected: check your FXML file 'ManageActivity.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ManageActivity.fxml'.";
        assert AddButton != null : "fx:id=\"AddButton\" was not injected: check your FXML file 'ManageActivity.fxml'.";
        assert ManageActivityOrganizedByTextField != null : "fx:id=\"ManageActivityOrganizedByTextField\" was not injected: check your FXML file 'ManageActivity.fxml'.";
        assert ManageActivityNoteTextArea != null : "fx:id=\"ManageActivityNoteTextArea\" was not injected: check your FXML file 'ManageActivity.fxml'.";

    }
}
