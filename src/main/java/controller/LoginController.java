package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import entity.User;
import handler.LoginHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import response.Response;
import util.Helper;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private TextField UserIDTextbox;

    @FXML
    private PasswordField PasswordTextbox;

    @FXML
    private Button SignInButton;

    @FXML
    private Label SignInLabel;

    final LoginHandler loginHandler;
    
    @FXML
    void SignInOnClick(ActionEvent event) throws IOException {
        System.out.println("one");
        String idInput = UserIDTextbox.getText();
        String passwordInput = PasswordTextbox.getText();

        Response<User> response = loginHandler.handle(Long.parseLong(idInput), passwordInput);
        if (response.success()) {

            Parent root = null;
            if (response.getResponse().getUserRole().equals("student")) {
                root = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
            } else if (response.getResponse().getUserRole().equals("leader")) {

                if (response.getResponse().getStudentLeader().getStudentLeaderRole().equals("team_leader"))
                    root = FXMLLoader.load(getClass().getResource("PeerLeaderList.fxml"));
                else
                    root = FXMLLoader.load(getClass().getResource("GroupList.fxml"));

            } else {
                // Tried the STUDENT LOGIN
                root = FXMLLoader.load(getClass().getResource("admin.fxml"));
                // TODO Add
            }

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(new Scene(root));
            window.show();

        } else {
            Helper.createAlert("Unsuccessful Login", "Please Enter your valid credentials");
            // TODO Add message to error label
        }

    }

    public LoginController() {
        loginHandler = new LoginHandler();
    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Login.fxml'.";
        assert UserIDTextbox != null
                : "fx:id=\"EmailUsernameTextbox\" was not injected: check your FXML file 'Login.fxml'.";
        assert PasswordTextbox != null
                : "fx:id=\"PasswordTextbox\" was not injected: check your FXML file 'Login.fxml'.";
        assert SignInButton != null : "fx:id=\"SignInButton\" was not injected: check your FXML file 'Login.fxml'.";
        assert SignInLabel != null : "fx:id=\"SignInLabel\" was not injected: check your FXML file 'Login.fxml'.";
    }
}
