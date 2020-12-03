package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ManageLeadersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ManageLeadersIDTextField;

    @FXML
    private TextField ManageLeadersCollegeTextField;

    @FXML
    private TextField ManageLeadersStatusTextField;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button UpdateButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button AddButton;

    @FXML
    private ComboBox<?> ManageLeadersRoleComboBox;

    @FXML
    private ComboBox<?> ManageLeadersYearComboBox;

    @FXML
    void AddButtonOnClick(ActionEvent event) {
//todo
    }

    @FXML
    void BackButtonOnClick(ActionEvent event) {
//todo
    }

    @FXML
    void DeleteButtonOnClick(ActionEvent event) {
//todo
    }

    @FXML
    void UpdateButtonOnClick(ActionEvent event) {
//todo
    }

    @FXML
    void initialize() {
        assert ManageLeadersIDTextField != null : "fx:id=\"ManageLeadersIDTextField\" was not injected: check your FXML file 'ManageLeaders.fxml'.";
        assert ManageLeadersCollegeTextField != null : "fx:id=\"ManageLeadersCollegeTextField\" was not injected: check your FXML file 'ManageLeaders.fxml'.";
        assert ManageLeadersStatusTextField != null : "fx:id=\"ManageLeadersStatusTextField\" was not injected: check your FXML file 'ManageLeaders.fxml'.";
        assert DeleteButton != null : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'ManageLeaders.fxml'.";
        assert UpdateButton != null : "fx:id=\"UpdateButton\" was not injected: check your FXML file 'ManageLeaders.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ManageLeaders.fxml'.";
        assert AddButton != null : "fx:id=\"AddButton\" was not injected: check your FXML file 'ManageLeaders.fxml'.";
        assert ManageLeadersRoleComboBox != null : "fx:id=\"ManageLeadersRoleComboBox\" was not injected: check your FXML file 'ManageLeaders.fxml'.";
        assert ManageLeadersYearComboBox != null : "fx:id=\"ManageLeadersYearComboBox\" was not injected: check your FXML file 'ManageLeaders.fxml'.";

    }
}
