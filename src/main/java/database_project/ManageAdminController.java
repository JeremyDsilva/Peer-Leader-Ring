package database_project;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ManageAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ManageAdminIDTextField;

    @FXML
    private TextField ManageAdminEmailTextField;

    @FXML
    private TextField ManageAdminFullNameTextField;

    @FXML
    private TextField ManageAdminPhoneTextField;

    @FXML
    private Button NextButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button UpdateButton;

    @FXML
    private Button PreviousButton;

    @FXML
    void DeleteButtonOnClick(ActionEvent event) {

    }

    @FXML
    void NextButtonOnClick(ActionEvent event) {

    }

    @FXML
    void PreviousButtonOnClick(ActionEvent event) {

    }

    @FXML
    void UpdateButtonOnClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert ManageAdminIDTextField != null : "fx:id=\"ManageAdminIDTextField\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert ManageAdminEmailTextField != null : "fx:id=\"ManageAdminEmailTextField\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert ManageAdminFullNameTextField != null : "fx:id=\"ManageAdminFullNameTextField\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert ManageAdminPhoneTextField != null : "fx:id=\"ManageAdminPhoneTextField\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert NextButton != null : "fx:id=\"NextButton\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert DeleteButton != null : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert UpdateButton != null : "fx:id=\"UpdateButton\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert PreviousButton != null : "fx:id=\"PreviousButton\" was not injected: check your FXML file 'ManageAdmin.fxml'.";

    }
}
