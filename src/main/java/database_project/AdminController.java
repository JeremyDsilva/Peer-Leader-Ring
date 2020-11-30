package database_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignOutButton;

    @FXML
    private Button AdminStudentButton;

    @FXML
    private Button AdminStudentGroupButton;

    @FXML
    private Button AdminActivityListButton;

    @FXML
    private Button AdminDashboardButton;

    @FXML
    private Button AdminAddAdminButton;

    @FXML
    private Button AdminManageAdminButton;

    @FXML
    private Button AdminLeadersButton;

    @FXML
    void AdminActivityListButtonOnClick(ActionEvent event) {

    }

    @FXML
    void AdminAddAdminButtonOnClick(ActionEvent event) {

    }

    @FXML
    void AdminDashboardButtonOnClick(ActionEvent event) {

    }

    @FXML
    void AdminLeadersButtonOnlick(ActionEvent event) {

    }

    @FXML
    void AdminManageAdminButtonOnClick(ActionEvent event) {

    }

    @FXML
    void AdminStudentButtonOnClick(ActionEvent event) {

    }

    @FXML
    void AdminStudentGroupButtonOnClick(ActionEvent event) {

    }

    @FXML
    void SignOutButtonOnClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert SignOutButton != null : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminStudentButton != null : "fx:id=\"AdminStudentButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminStudentGroupButton != null : "fx:id=\"AdminStudentGroupButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminActivityListButton != null : "fx:id=\"AdminActivityListButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminDashboardButton != null : "fx:id=\"AdminDashboardButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminAddAdminButton != null : "fx:id=\"AdminAddAdminButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminManageAdminButton != null : "fx:id=\"AdminManageAdminButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminLeadersButton != null : "fx:id=\"AdminLeadersButton\" was not injected: check your FXML file 'Admin.fxml'.";

    }
}
