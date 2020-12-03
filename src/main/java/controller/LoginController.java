package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.AppContext;
import entity.User;
import handler.LoginHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import response.Response;
import javafx.scene.Node;

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
            if (response.getResponse().getUserRole().equals("admin")) {
                root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            } else if (response.getResponse().getUserRole().equals("leader")) {

                if (response.getResponse().getStudentLeader().getStudentLeaderRole().equals("team_leader"))
                    root = FXMLLoader.load(getClass().getResource("PeerLeaderList.fxml"));
                else
                    root = FXMLLoader.load(getClass().getResource("GroupList.fxml"));

            } else {
                // Tried the STUDENT LOGIN
                root = FXMLLoader.load(getClass().getResource("ActivityList.fxml"));
                // TODO Add
            }

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(new Scene(root));
            window.show();

        } else {
            // SignInButton.setOnAction(e->AlertBox.display("Error Window", "Please Input
            // valid credentials"));
            System.out.println("Failed");
            // TODO Add message to error label
        }

        // System.out.println(input);
        // if (input.equals("Peer")) {
        // Parent root = FXMLLoader.load(getClass().getResource("GroupList.fxml"));
        // Scene Signin = new Scene(root);
        // System.out.println("Peer");
        // Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // window.setScene(Signin);
        // window.show();
        // } else if (input.equals("Admin")) {
        // Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        // Scene Signin = new Scene(root);
        // System.out.println("Admin");
        // Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // window.setScene(Signin);
        // window.show();
        // } else if (input.equals("Team")) {
        // Parent root = FXMLLoader.load(getClass().getResource("PeerLeaderList.fxml"));
        // Scene Signin = new Scene(root);
        // System.out.println("Team");
        // Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // window.setScene(Signin);
        // window.show();
        // }

        // else
        // {

        // }

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
