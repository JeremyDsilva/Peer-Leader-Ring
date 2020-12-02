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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ActivityListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private TableColumn<?, ?> ActivityListActivityIDColumn;

    @FXML
    private TableColumn<?, ?> ActivityListActivityNameColumn;

    @FXML
    private TableColumn<?, ?> ActivityListDateColumn;

    @FXML
    private TableColumn<?, ?> ActivityListOrganizedbyColumn;

    @FXML
    private TableColumn<?, ?> ActivityListNoteColumn;

    @FXML
    private Button BackButton;

    @FXML
    private Button SignOutButton;

    @FXML
    private Button ActivityListAddButton;

    @FXML
    private Button ActivityListManageButton;

    @FXML
    void ActivityListAddButtonOnClick(ActionEvent event) {
//todo
    }

    @FXML
    void ActivityListManageButtonOnClick(ActionEvent event) {
//todo
    }

    @FXML
    void BackButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        Scene Back = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Back);
        window.show();
    }

    @FXML
    void SignOutButtonOnClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene Logout = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Logout);
        window.show();
    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'ActivityList.fxml'.";
        assert ActivityListActivityIDColumn != null
                : "fx:id=\"ActivityListActivityIDColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
        assert ActivityListActivityNameColumn != null
                : "fx:id=\"ActivityListActivityNameColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
        assert ActivityListDateColumn != null
                : "fx:id=\"ActivityListDateColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
        assert ActivityListOrganizedbyColumn != null
                : "fx:id=\"ActivityListOrganizedbyColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
        assert ActivityListNoteColumn != null
                : "fx:id=\"ActivityListNoteColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ActivityList.fxml'.";
        assert SignOutButton != null
                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'ActivityList.fxml'.";
        assert ActivityListAddButton != null
                : "fx:id=\"ActivityListAddButton\" was not injected: check your FXML file 'ActivityList.fxml'.";
        assert ActivityListManageButton != null
                : "fx:id=\"ActivityListManageButton\" was not injected: check your FXML file 'ActivityList.fxml'.";

    }
}
