package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dto.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;

public class StudentListController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label label;

        @FXML
        private TableView<Student> tableview;

        @FXML
        private TableColumn<Student, Long> StudentListStudentIDColumn;

        @FXML
        private TableColumn<Student, String> StudentListStudentNameColumn;

        @FXML
        private TableColumn<Student, String> StudentListStudentEmailColumn;

        @FXML
        private TableColumn<Student, String> StudentListStudentPhoneColumn;

        @FXML
        private TableColumn<Student, String> StudentListCollegeColumn;

        @FXML
        private TableColumn<Student, String> StudentListStudentGroupColumn;

        @FXML
        private TableColumn<?, ?> StudentListActiveColumn;

        @FXML
        private Button BackButton;

        @FXML
        private Button SignOutButton;

        @FXML
        private Button StudentListAddButton;

        @FXML
        private Button StudentListManageButton;

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
        void StudentListAddButtonOnClick(ActionEvent event) {
                // todo
        }

        @FXML
        void StudentListManageButtonOnClick(ActionEvent event) {
                // todo
        }

        @FXML
        void listofstudentsidEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void listofstudentsidEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void listofstudentsnameEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void listofstudentsnameEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void listofstudentsemailEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void listofstudentsemailEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void listofstudentsphoneEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void listofstudentsphoneEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void listofstudentscollegeEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void listofstudentscollegeEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void listofstudentsgroupEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void listofstudentsgroupEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void initialize() {

                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert tableview != null
                                : "fx:id=\"tableview\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert StudentListStudentIDColumn != null
                                : "fx:id=\"StudentListStudentIDColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert StudentListStudentNameColumn != null
                                : "fx:id=\"StudentListStudentNameColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert StudentListStudentEmailColumn != null
                                : "fx:id=\"StudentListStudentEmailColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert StudentListStudentPhoneColumn != null
                                : "fx:id=\"StudentListStudentPhoneColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert StudentListCollegeColumn != null
                                : "fx:id=\"StudentListCollegeColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert StudentListStudentGroupColumn != null
                                : "fx:id=\"StudentListStudentGroupColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert StudentListActiveColumn != null
                                : "fx:id=\"StudentListActiveColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert BackButton != null
                                : "fx:id=\"BackButton\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert StudentListAddButton != null
                                : "fx:id=\"StudentListAddButton\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert StudentListManageButton != null
                                : "fx:id=\"StudentListManageButton\" was not injected: check your FXML file 'StudentList.fxml'.";

                // Skipped making the ID editable
                StudentListStudentNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentListStudentNameColumn.setOnEditCommit(new EventHandler<CellEditEvent<Student, String>>() {
                        public void handle(CellEditEvent<Student, String> t) {
                                System.out.println("It works1!");
                        }

                });

                StudentListStudentEmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentListStudentEmailColumn.setOnEditCommit(new EventHandler<CellEditEvent<Student, String>>() {
                        public void handle(CellEditEvent<Student, String> t) {
                                System.out.println("It works1!");
                        }

                });

                StudentListStudentPhoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentListStudentPhoneColumn.setOnEditCommit(new EventHandler<CellEditEvent<Student, String>>() {
                        public void handle(CellEditEvent<Student, String> t) {
                                System.out.println("It works1!");
                        }

                });

                StudentListCollegeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentListCollegeColumn.setOnEditCommit(new EventHandler<CellEditEvent<Student, String>>() {
                        public void handle(CellEditEvent<Student, String> t) {
                                System.out.println("It works1!");
                        }

                });

                StudentListStudentGroupColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentListStudentGroupColumn.setOnEditCommit(new EventHandler<CellEditEvent<Student, String>>() {
                        public void handle(CellEditEvent<Student, String> t) {
                                System.out.println("It works1!");
                        }

                });

        }

}
