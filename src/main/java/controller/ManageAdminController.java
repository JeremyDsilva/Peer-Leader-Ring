package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ManageAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ManageAdminIDTextField;

    @FXML
    private TextField ManageAdminEmailTextField;

    @FXML
    private TextField ManageAdminFullNameTextField;

    @FXML
    private TextField ManageAdminPhoneTextField;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button UpdateButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button AddButton;

    @FXML
    void AddButtonOnClick(ActionEvent event) {

    }

    @FXML
    void BackButtonOnClick(ActionEvent event) throws IOException {
         // todo
         Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
         Scene Back = new Scene(root);
         Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
         window.setScene(Back);
         window.show();

    }

    @FXML
    void DeleteButtonOnClick(ActionEvent event) {

    }

    @FXML
    void UpdateButtonOnClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert ManageAdminIDTextField != null : "fx:id=\"ManageAdminIDTextField\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert ManageAdminEmailTextField != null : "fx:id=\"ManageAdminEmailTextField\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert ManageAdminFullNameTextField != null : "fx:id=\"ManageAdminFullNameTextField\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert ManageAdminPhoneTextField != null : "fx:id=\"ManageAdminPhoneTextField\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert DeleteButton != null : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert UpdateButton != null : "fx:id=\"UpdateButton\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert AddButton != null : "fx:id=\"AddButton\" was not injected: check your FXML file 'ManageAdmin.fxml'.";

    }
}
