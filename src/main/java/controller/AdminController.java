package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import util.Helper;

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
    private Button AdminManageAdminButton;

    @FXML
    private Button AdminLeadersButton;

    @FXML
    void AdminActivityListButtonOnClick(ActionEvent event) throws IOException {
        Helper.loadView(getClass().getResource("ActivityList.fxml"));
    }

    @FXML
    void AdminDashboardButtonOnClick(ActionEvent event) throws IOException {
        Helper.loadView(getClass().getResource("Dashboard.fxml"));
    }

    @FXML
    void AdminLeadersButtonOnlick(ActionEvent event) throws IOException {
        Helper.loadView(getClass().getResource("LeaderList.fxml"));
    }

    @FXML
    void AdminManageAdminButtonOnClick(ActionEvent event) throws IOException {
        Helper.loadView(getClass().getResource("ManageAdmin.fxml"));
    }

    @FXML
    void AdminStudentButtonOnClick(ActionEvent event) throws IOException {
        Helper.loadView(getClass().getResource("StudentList.fxml"));
    }

    @FXML
    void AdminStudentGroupButtonOnClick(ActionEvent event) throws IOException {
        Helper.loadView(getClass().getResource("StudentGroup.fxml"));
    }

    @FXML
    void SignOutButtonOnClick(ActionEvent event) throws IOException {
        Helper.loadView(getClass().getResource("Login.fxml"));
    }

    @FXML
    void initialize() {
        assert SignOutButton != null : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminStudentButton != null
                : "fx:id=\"AdminStudentButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminStudentGroupButton != null
                : "fx:id=\"AdminStudentGroupButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminActivityListButton != null
                : "fx:id=\"AdminActivityListButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminDashboardButton != null
                : "fx:id=\"AdminDashboardButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminManageAdminButton != null
                : "fx:id=\"AdminManageAdminButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminLeadersButton != null
                : "fx:id=\"AdminLeadersButton\" was not injected: check your FXML file 'Admin.fxml'.";

    }
}
