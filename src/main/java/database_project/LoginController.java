package database_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FXMLDocumentController {

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
    private Label ForgotPassword;

    @FXML
    private Label SignIn;

    @FXML
    void SignInOnClick(ActionEvent event) {
        // todo
    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Login.fxml'.";
        assert EmailUsernameTextbox != null
                : "fx:id=\"EmailUsernameTextbox\" was not injected: check your FXML file 'Login.fxml'.";
        assert PasswordTextbook != null
                : "fx:id=\"PasswordTextbook\" was not injected: check your FXML file 'Login.fxml'.";
        assert SignInButton != null : "fx:id=\"SignInButton\" was not injected: check your FXML file 'Login.fxml'.";
        assert ForgotPassword != null : "fx:id=\"ForgotPassword\" was not injected: check your FXML file 'Login.fxml'.";
        assert SignIn != null : "fx:id=\"SignIn\" was not injected: check your FXML file 'Login.fxml'.";

    }
}
