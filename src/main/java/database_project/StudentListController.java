package database_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class StudentListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Button SignOutButton;

    @FXML
    private TableColumn<?, ?> StudentListStudentIDColumn;

    @FXML
    private TableColumn<?, ?> StudentListStudentNameColumn;

    @FXML
    private TableColumn<?, ?> StudentListStudentEmailColumn;

    @FXML
    private TableColumn<?, ?> StudentListStudentPhoneColumn;

    @FXML
    private TableColumn<?, ?> StudentListCollegeColumn;

    @FXML
    private TableColumn<?, ?> StudentListStudentRoleColumn;

    @FXML
    private TableColumn<?, ?> StudentListActiveColumn;

    @FXML
    void SignOutButtonOnClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert SignOutButton != null : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListStudentIDColumn != null : "fx:id=\"StudentListStudentIDColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListStudentNameColumn != null : "fx:id=\"StudentListStudentNameColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListStudentEmailColumn != null : "fx:id=\"StudentListStudentEmailColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListStudentPhoneColumn != null : "fx:id=\"StudentListStudentPhoneColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListCollegeColumn != null : "fx:id=\"StudentListCollegeColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListStudentRoleColumn != null : "fx:id=\"StudentListStudentRoleColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListActiveColumn != null : "fx:id=\"StudentListActiveColumn\" was not injected: check your FXML file 'StudentList.fxml'.";

    }
}
