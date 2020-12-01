package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class GroupListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Label GroupListNameLabel;

    @FXML
    private Label GroupListGroupNameLabel;

    @FXML
    private Label GroupListTeamLeaderLabel;

    @FXML
    private Button SignOutButton;

    @FXML
    private TableColumn<?, ?> PeerLeaderStudentIDColumn;

    @FXML
    private TableColumn<?, ?> PeerLeaderStudentNameColumn;

    @FXML
    private TableColumn<?, ?> PeerLeaderStudentEmailColumn;

    @FXML
    private TableColumn<?, ?> PeerLeaderStudentPhoneColumn;

    @FXML
    private TableColumn<?, ?> PeerLeaderCollegeColumn;

    @FXML
    private TableColumn<?, ?> PeerLeaderActiveColumn;

    @FXML
    private Button GroupListMarkAttendButton;

    @FXML
    private Button GroupListViewActButton;

    @FXML
    void GroupListMarkAttendOnClick(ActionEvent event) {

    }

    @FXML
    void GroupListViewActButtonOnClick(ActionEvent event) {

    }

    @FXML
    void SignOutButtonOnClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'GroupList.fxml'.";
        assert GroupListNameLabel != null : "fx:id=\"GroupListNameLabel\" was not injected: check your FXML file 'GroupList.fxml'.";
        assert GroupListGroupNameLabel != null : "fx:id=\"GroupListGroupNameLabel\" was not injected: check your FXML file 'GroupList.fxml'.";
        assert GroupListTeamLeaderLabel != null : "fx:id=\"GroupListTeamLeaderLabel\" was not injected: check your FXML file 'GroupList.fxml'.";
        assert SignOutButton != null : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'GroupList.fxml'.";
        assert PeerLeaderStudentIDColumn != null : "fx:id=\"PeerLeaderStudentIDColumn\" was not injected: check your FXML file 'GroupList.fxml'.";
        assert PeerLeaderStudentNameColumn != null : "fx:id=\"PeerLeaderStudentNameColumn\" was not injected: check your FXML file 'GroupList.fxml'.";
        assert PeerLeaderStudentEmailColumn != null : "fx:id=\"PeerLeaderStudentEmailColumn\" was not injected: check your FXML file 'GroupList.fxml'.";
        assert PeerLeaderStudentPhoneColumn != null : "fx:id=\"PeerLeaderStudentPhoneColumn\" was not injected: check your FXML file 'GroupList.fxml'.";
        assert PeerLeaderCollegeColumn != null : "fx:id=\"PeerLeaderCollegeColumn\" was not injected: check your FXML file 'GroupList.fxml'.";
        assert PeerLeaderActiveColumn != null : "fx:id=\"PeerLeaderActiveColumn\" was not injected: check your FXML file 'GroupList.fxml'.";
        assert GroupListMarkAttendButton != null : "fx:id=\"GroupListMarkAttendButton\" was not injected: check your FXML file 'GroupList.fxml'.";
        assert GroupListViewActButton != null : "fx:id=\"GroupListViewActButton\" was not injected: check your FXML file 'GroupList.fxml'.";

    }
}
