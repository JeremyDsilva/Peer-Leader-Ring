package database_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ManageStudentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ManageStudentIDTextField;

    @FXML
    private TextField ManageStudentEmailTextField;

    @FXML
    private TextField ManageStudentFullNameTextField;

    @FXML
    private TextField ManageStudentPhoneTextField;

    @FXML
    private Button BackButton;

    @FXML
    private TextField ManageStudentCollegeTextField;

    @FXML
    private TextField ManageStudentGroupTextField;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button UpdateButton;

    @FXML
    private Button AddButton;

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
        assert ManageStudentIDTextField != null : "fx:id=\"ManageStudentIDTextField\" was not injected: check your FXML file 'ManageStudent.fxml'.";
        assert ManageStudentEmailTextField != null : "fx:id=\"ManageStudentEmailTextField\" was not injected: check your FXML file 'ManageStudent.fxml'.";
        assert ManageStudentFullNameTextField != null : "fx:id=\"ManageStudentFullNameTextField\" was not injected: check your FXML file 'ManageStudent.fxml'.";
        assert ManageStudentPhoneTextField != null : "fx:id=\"ManageStudentPhoneTextField\" was not injected: check your FXML file 'ManageStudent.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ManageStudent.fxml'.";
        assert ManageStudentCollegeTextField != null : "fx:id=\"ManageStudentCollegeTextField\" was not injected: check your FXML file 'ManageStudent.fxml'.";
        assert ManageStudentGroupTextField != null : "fx:id=\"ManageStudentGroupTextField\" was not injected: check your FXML file 'ManageStudent.fxml'.";
        assert DeleteButton != null : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'ManageStudent.fxml'.";
        assert UpdateButton != null : "fx:id=\"UpdateButton\" was not injected: check your FXML file 'ManageStudent.fxml'.";
        assert AddButton != null : "fx:id=\"AddButton\" was not injected: check your FXML file 'ManageStudent.fxml'.";

    }
}
