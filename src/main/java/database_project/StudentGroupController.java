package database_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class StudentGroupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Label StudentGroupNameLabel;

    @FXML
    private Label StudentGroupGroupNameLabel1;

    @FXML
    private Label StudentGroupTeamLeaderLabel1;

    @FXML
    private Button SignOutButton;

    @FXML
    private TableColumn<?, ?> StudentGroupStudentIDColumn;

    @FXML
    private TableColumn<?, ?> StudentGroupStudentNameColumn;

    @FXML
    private TableColumn<?, ?> StudentGroupStudentEmailColumn;

    @FXML
    private TableColumn<?, ?> StudentGroupStudentPhoneColumn;

    @FXML
    private TableColumn<?, ?> StudentGroupCollegeColumn;

    @FXML
    private TableColumn<?, ?> StudentGroupActiveColumn;

    @FXML
    void SignOutButtonOnClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupNameLabel != null : "fx:id=\"StudentGroupNameLabel\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupGroupNameLabel1 != null : "fx:id=\"StudentGroupGroupNameLabel1\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupTeamLeaderLabel1 != null : "fx:id=\"StudentGroupTeamLeaderLabel1\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert SignOutButton != null : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupStudentIDColumn != null : "fx:id=\"StudentGroupStudentIDColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupStudentNameColumn != null : "fx:id=\"StudentGroupStudentNameColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupStudentEmailColumn != null : "fx:id=\"StudentGroupStudentEmailColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupStudentPhoneColumn != null : "fx:id=\"StudentGroupStudentPhoneColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupCollegeColumn != null : "fx:id=\"StudentGroupCollegeColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupActiveColumn != null : "fx:id=\"StudentGroupActiveColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";

    }
}
