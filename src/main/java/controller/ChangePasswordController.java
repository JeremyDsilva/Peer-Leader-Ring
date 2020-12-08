package controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.AppContext;
import handler.ChangePasswordHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import response.Response;
import util.Helper;

public class ChangePasswordController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Button BackButton;

    @FXML
    private PasswordField OldPasswordTextbox;

    @FXML
    private PasswordField NewPasswordTextbox;

    @FXML
    private Button ChangePasswordButton;

    @FXML
    private Label ChangePasswordLabel;

    final ChangePasswordHandler changePasswordHandler;

    public ChangePasswordController() {
        changePasswordHandler = new ChangePasswordHandler();
    }

    @FXML
    void BackButtonOnClick(ActionEvent event) {
        if (AppContext.userIsAdmin())
            Helper.loadView(getClass().getResource("Admin.fxml"));
        else if (AppContext.userIsLeader()) {
            if (AppContext.getUser().getStudentLeader().getStudentLeaderRole().equals("team_leader"))
                Helper.loadView(getClass().getResource("PeerLeaderList.fxml"));
            else
                Helper.loadView(getClass().getResource("GroupList.fxml"));
        } else
            Helper.loadView(getClass().getResource("StudentView.fxml"));

    }

    @FXML
    void ChangePasswordButtonOnClick(ActionEvent event) {

        String oldPassword = OldPasswordTextbox.getText();
        String newPassword = NewPasswordTextbox.getText();

        if (oldPassword.isEmpty() || newPassword.isEmpty()) {
            Helper.createErrorAlert("ERROR", "Please fill in the fields first");
        }

        Response<Void> response = changePasswordHandler.handle(oldPassword, newPassword);

        if (response.success())
            Helper.createSuccessAlert("SUCCESS", "Password changed successfully");
        else
            Helper.createErrorAlert("ERROR", response.getException().getMessage());
    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'ChangePassword.fxml'.";
        assert BackButton != null
                : "fx:id=\"BackButton\" was not injected: check your FXML file 'ChangePassword.fxml'.";
        assert OldPasswordTextbox != null
                : "fx:id=\"OldPasswordTextbox\" was not injected: check your FXML file 'ChangePassword.fxml'.";
        assert NewPasswordTextbox != null
                : "fx:id=\"NewPasswordTextbox\" was not injected: check your FXML file 'ChangePassword.fxml'.";
        assert ChangePasswordButton != null
                : "fx:id=\"ChangePasswordButton\" was not injected: check your FXML file 'ChangePassword.fxml'.";
        assert ChangePasswordLabel != null
                : "fx:id=\"ChangePasswordLabel\" was not injected: check your FXML file 'ChangePassword.fxml'.";

    }
}
