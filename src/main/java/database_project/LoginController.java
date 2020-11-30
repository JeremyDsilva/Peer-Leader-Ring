package database_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.Node;

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
    void SignInOnClick(ActionEvent event) throws IOException {
        System.out.println("one");
        String input = EmailUsernameTextbox.getText();
        System.out.println(input);
        if(input.equals("Peer")){
            Parent root = FXMLLoader.load(getClass().getResource("GroupList.fxml"));
            Scene Signin = new Scene(root);
            System.out.println("Peer");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(Signin);
            window.show();
        }
        else if(input.equals("Admin")){
            Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            Scene Signin = new Scene(root);
            System.out.println("Admin");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(Signin);
            window.show();
        }
        else if(input.equals("Team")){
            Parent root = FXMLLoader.load(getClass().getResource("PeerLeaderList.fxml"));
            Scene Signin = new Scene(root);
            System.out.println("Team");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(Signin);
            window.show();
        }
    
        // else
        // {

        // }
       
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
