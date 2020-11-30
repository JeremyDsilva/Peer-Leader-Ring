package database_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private TextField EmailUsernameTextbox;

    @FXML
    private PasswordField PasswordTextbook;

    @FXML
    private Button SignInButton;

    @FXML
    private Label SignInLabel;

    @FXML
    void SignInOnClick(ActionEvent event) {
        
    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Login.fxml'.";
        assert EmailUsernameTextbox != null : "fx:id=\"EmailUsernameTextbox\" was not injected: check your FXML file 'Login.fxml'.";
        assert PasswordTextbook != null : "fx:id=\"PasswordTextbook\" was not injected: check your FXML file 'Login.fxml'.";
        assert SignInButton != null : "fx:id=\"SignInButton\" was not injected: check your FXML file 'Login.fxml'.";
        assert SignInLabel != null : "fx:id=\"SignInLabel\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
