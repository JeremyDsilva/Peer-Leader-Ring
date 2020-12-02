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

public class StudentGroupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Button SignOutButton;

    @FXML
    private TableColumn<?, ?> StudentGroupGroupIDcolumn;

    @FXML
    private TableColumn<?, ?> StudentGroupGroupNameColumn;

    @FXML
    private TableColumn<?, ?> StudentGroupPeerLeaderColumn;

    @FXML
    private TableColumn<?, ?> StudentGroupTeamLeaderColumn;

    @FXML
    private TableColumn<?, ?> StudentGroupStudentColumn;

    @FXML
    private Button BackButton;

    @FXML
    private Button StudentGroupAddButton;

    @FXML
    private Button StudentGroupManageButton;

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
    void SignOutButtonOnClick(ActionEvent event) throws IOException {
        // todo
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene Logout = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(Logout);
        window.show();
    }

    @FXML
    void StudentGroupAddButtonOnClick(ActionEvent event) {
        // todo
    }

    @FXML
    void StudentGroupManageButtonOnClick(ActionEvent event) {
        // todo
    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert SignOutButton != null
                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupGroupIDcolumn != null
                : "fx:id=\"StudentGroupGroupIDcolumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupGroupNameColumn != null
                : "fx:id=\"StudentGroupGroupNameColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupPeerLeaderColumn != null
                : "fx:id=\"StudentGroupPeerLeaderColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupTeamLeaderColumn != null
                : "fx:id=\"StudentGroupTeamLeaderColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupStudentColumn != null
                : "fx:id=\"StudentGroupStudentColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupAddButton != null
                : "fx:id=\"StudentGroupAddButton\" was not injected: check your FXML file 'StudentGroup.fxml'.";
        assert StudentGroupManageButton != null
                : "fx:id=\"StudentGroupManageButton\" was not injected: check your FXML file 'StudentGroup.fxml'.";

    }
}