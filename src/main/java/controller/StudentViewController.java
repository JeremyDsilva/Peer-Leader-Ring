package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.AppContext;
import entity.Student;
import handler.GetStudentHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import response.Response;
import util.Helper;

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

        @FXML
        private Button BackButton;

        @FXML
        private Button ChangePasswordButton;

        final GetStudentHandler studentHandler;

        public StudentViewController() {
                studentHandler = new GetStudentHandler();
        }

        @FXML
        void BackButtonOnClick(ActionEvent event) throws IOException {
                AppContext.remove("studentId");
                Helper.loadView(getClass().getResource("StudentList.fxml"));
        }

        @FXML
        void ChangePasswordButtonOnClick(ActionEvent event) {
                Helper.loadView(getClass().getResource("ChangePassword.fxml"));
        }

        @FXML
        void SignOutButtonOnClick(ActionEvent event) throws IOException {
                Helper.loadView(getClass().getResource("Login.fxml"));
        }

        @FXML
        void ViewActivityListButtonOnClick(ActionEvent event) throws IOException {
                Helper.loadView(getClass().getResource("ActivityList.fxml"));
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
                assert BackButton != null 
                                : "fx:id=\"BackButton\" was not injected: check your FXML file 'StudentView.fxml'.";
                assert ChangePasswordButton != null 
                                : "fx:id=\"ChangePasswordButton\" was not injected: check your FXML file 'StudentView.fxml'.";

                Response<Student> response = null;
                if (AppContext.userIsStudent()){
                        response = studentHandler.handle(AppContext.getUser().getId());
                        BackButton.setVisible(false);
                }
                else {
                        response = studentHandler.handle((Long) AppContext.get("studentId"));
                        BackButton.setVisible(true);
                        ViewActivityListButton.setVisible(false);
                        ChangePasswordButton.setVisible(false);
                }

                if (response != null && response.success()) {
                        Student student = response.getResponse();
                        LSStudentIDLabel.setText(String.valueOf(student.getId()));
                        LSStudentNameLabel.setText(String.valueOf(student.getUserDetail().getFullName()));
                        LSStudentCollegeLabel.setText(String.valueOf(student.getCollege()));
                        LSStudentPhoneLabel.setText(
                                        String.valueOf(student.getUserDetail().getPhoneNumber()));
                        LSStudentEmailLabel.setText(String.valueOf(AppContext.getUser().getEmail()));

                        LSPeerIDLabel.setText(String.valueOf(
                                        student.getGroup().getPeerLeader().getUserDetail().getId()));
                        LSPeerNameLabel.setText(String.valueOf(student.getGroup().getPeerLeader()
                                        .getUserDetail().getFullName()));
                        LSPeerCollegeLabel.setText(
                                        String.valueOf(student.getGroup().getPeerLeader().getCollege()));
                        LSPeerPhoneLabel.setText(String.valueOf(student.getGroup().getPeerLeader()
                                        .getUserDetail().getPhoneNumber()));
                        LSPeerEmailLabel.setText(String.valueOf(
                                        student.getGroup().getPeerLeader().getUserDetail().getEmail()));

                        LSTeamIDLabel.setText(String.valueOf(
                                        student.getGroup().getTeamLeader().getUserDetail().getId()));
                        LSTeamNameLabel.setText(String.valueOf(student.getGroup().getTeamLeader()
                                        .getUserDetail().getFullName()));
                        LSTeamCollegeLabel.setText(
                                        String.valueOf(student.getGroup().getTeamLeader().getCollege()));
                        LSTeamPhoneLabel.setText(String.valueOf(student.getGroup().getTeamLeader()
                                        .getUserDetail().getPhoneNumber()));
                        LSTeamEmailLabel.setText(String.valueOf(
                                        student.getGroup().getTeamLeader().getUserDetail().getEmail()));

                }  else {
                        Helper.createErrorAlert("ERROR", "Cannot load page");
                }

        }
}
