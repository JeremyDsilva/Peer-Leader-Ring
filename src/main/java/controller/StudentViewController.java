package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StudentViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Button SignOutButton;

    @FXML
    private Label LSStudentIDLabel;

    @FXML
    private Label LSStudentNameLabel;

    @FXML
    private Label LSStudentEmailLabel;

    @FXML
    private Label LSStudentPhoneLabel;

    @FXML
    private Label LSStudentCollegeLabel;

    @FXML
    private Label LSPeerIDLabel;

    @FXML
    private Label LSPeerNameLabel;

    @FXML
    private Label LSPeerEmailLabel;

    @FXML
    private Label LSPeerPhoneLabel;

    @FXML
    private Label LSPeerCollegeLabel;

    @FXML
    private Label LSTeamIDLabel;

    @FXML
    private Label LSTeamNameLabel;

    @FXML
    private Label LSTeamEmailLabel;

    @FXML
    private Label LSTeamPhoneLabel;

    @FXML
    private Label LSTeamCollegeLabel;

    @FXML
    private Button BackButton;

    @FXML
    void BackButtonOnClick(ActionEvent event) {
        // todo

    }

    @FXML
    void SignOutButtonOnClick(ActionEvent event) {
        // todo
    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert SignOutButton != null
                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSStudentIDLabel != null
                : "fx:id=\"LSStudentIDLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSStudentNameLabel != null
                : "fx:id=\"LSStudentNameLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSStudentEmailLabel != null
                : "fx:id=\"LSStudentEmailLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSStudentPhoneLabel != null
                : "fx:id=\"LSStudentPhoneLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSStudentCollegeLabel != null
                : "fx:id=\"LSStudentCollegeLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSPeerIDLabel != null
                : "fx:id=\"LSPeerIDLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSPeerNameLabel != null
                : "fx:id=\"LSPeerNameLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSPeerEmailLabel != null
                : "fx:id=\"LSPeerEmailLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSPeerPhoneLabel != null
                : "fx:id=\"LSPeerPhoneLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSPeerCollegeLabel != null
                : "fx:id=\"LSPeerCollegeLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSTeamIDLabel != null
                : "fx:id=\"LSTeamIDLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSTeamNameLabel != null
                : "fx:id=\"LSTeamNameLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSTeamEmailLabel != null
                : "fx:id=\"LSTeamEmailLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSTeamPhoneLabel != null
                : "fx:id=\"LSTeamPhoneLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert LSTeamCollegeLabel != null
                : "fx:id=\"LSTeamCollegeLabel\" was not injected: check your FXML file 'StudentView.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'StudentView.fxml'.";

    }
}
