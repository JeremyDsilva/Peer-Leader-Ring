package database_project;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AddAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AddAdminIDTextField;

    @FXML
    private TextField AddAdminEmailTextField;

    @FXML
    private TextField AddAdminFullNameTextField;

    @FXML
    private TextField AddAdminPhoneTextField;

    @FXML
    private Button AddButton;

    @FXML
    void AddButtonOnClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AddAdminIDTextField != null : "fx:id=\"AddAdminIDTextField\" was not injected: check your FXML file 'AddAdmin.fxml'.";
        assert AddAdminEmailTextField != null : "fx:id=\"AddAdminEmailTextField\" was not injected: check your FXML file 'AddAdmin.fxml'.";
        assert AddAdminFullNameTextField != null : "fx:id=\"AddAdminFullNameTextField\" was not injected: check your FXML file 'AddAdmin.fxml'.";
        assert AddAdminPhoneTextField != null : "fx:id=\"AddAdminPhoneTextField\" was not injected: check your FXML file 'AddAdmin.fxml'.";
        assert AddButton != null : "fx:id=\"AddButton\" was not injected: check your FXML file 'AddAdmin.fxml'.";

    }
}
