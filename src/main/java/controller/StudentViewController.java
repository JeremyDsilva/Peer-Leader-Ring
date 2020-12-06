package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.AppContext;
import dto.Students;
import entity.Student;
import handler.GetStudentHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import response.Response;

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
        private Button ViewActivityListButton;

        final GetStudentHandler studentHandler;

        public StudentViewController() {
                studentHandler = new GetStudentHandler();
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
        void ViewActivityListButtonOnClick(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("ActivityList.fxml"));
                Scene Logout = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(Logout);
                window.show();

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
                assert ViewActivityListButton != null
                                : "fx:id=\"ViewActivityListButton\" was not injected: check your FXML file 'StudentView.fxml'.";

                Response<Student> response = studentHandler.handle(AppContext.getUser().getId());

                if (response.success()) {
                        LSStudentIDLabel.setText(String.valueOf(AppContext.getUser().getId()));
                        LSStudentNameLabel.setText(String.valueOf(AppContext.getUser().getFullName()));
                        LSStudentCollegeLabel.setText(String.valueOf(response.getResponse().getCollege().getId()));
                        LSStudentPhoneLabel.setText(
                                        String.valueOf(response.getResponse().getUserDetail().getPhoneNumber()));
                        LSStudentEmailLabel.setText(String.valueOf(AppContext.getUser().getEmail()));

                        // -----------------------------------------------------------

                        LSPeerIDLabel.setText(String.valueOf(
                                        response.getResponse().getGroup().getPeerLeader().getUserDetail().getId()));
                        LSPeerNameLabel.setText(String.valueOf(response.getResponse().getGroup().getPeerLeader()
                                        .getUserDetail().getFullName()));
                        LSPeerCollegeLabel.setText(String.valueOf(
                                        response.getResponse().getGroup().getPeerLeader().getCollege().getId()));
                        LSPeerPhoneLabel.setText(String.valueOf(response.getResponse().getGroup().getPeerLeader()
                                        .getUserDetail().getPhoneNumber()));
                        LSPeerEmailLabel.setText(String.valueOf(
                                        response.getResponse().getGroup().getPeerLeader().getUserDetail().getEmail()));

                        // -----------------------------------------------------------

                        LSTeamIDLabel.setText(String.valueOf(
                                        response.getResponse().getGroup().getTeamLeader().getUserDetail().getId()));
                        LSTeamNameLabel.setText(String.valueOf(response.getResponse().getGroup().getTeamLeader()
                                        .getUserDetail().getFullName()));
                        LSTeamCollegeLabel.setText(String.valueOf(
                                        response.getResponse().getGroup().getTeamLeader().getCollege().getId()));
                        LSTeamPhoneLabel.setText(String.valueOf(response.getResponse().getGroup().getTeamLeader()
                                        .getUserDetail().getPhoneNumber()));
                        LSTeamEmailLabel.setText(String.valueOf(
                                        response.getResponse().getGroup().getTeamLeader().getUserDetail().getEmail()));

                }

        }
}
