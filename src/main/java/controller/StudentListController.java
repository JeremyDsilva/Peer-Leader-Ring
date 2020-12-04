package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dto.Students;
import entity.Student;
import handler.GetStudentsHandler;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import response.Response;

public class StudentListController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label label;

        @FXML
        private TableView<Students> tableview;

        @FXML
        private TableColumn<Students, Long> StudentListStudentIDColumn;

        @FXML
        private TableColumn<Students, String> StudentListStudentNameColumn;

        @FXML
        private TableColumn<Students, String> StudentListStudentEmailColumn;

        @FXML
        private TableColumn<Students, String> StudentListStudentPhoneColumn;

        @FXML
        private TableColumn<Students, String> StudentListCollegeColumn;

        @FXML
        private TableColumn<Students, String> StudentListStudentGroupColumn;

        @FXML
        private Button BackButton;

        @FXML
        private Button SignOutButton;

        @FXML
        private Button SaveButton;

        @FXML
        private Button DeleteButton;

        final GetStudentsHandler studentsHandler;

        public StudentListController() {
                studentsHandler = new GetStudentsHandler();
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
        void SignOutButtonOnClick(ActionEvent event) throws IOException {
                // todo
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Scene Logout = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(Logout);
                window.show();
        }

        @FXML
        void DeleteButtonOnClick(ActionEvent event) {

        }

        @FXML
        void SaveButtonOnClick(ActionEvent event) {

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
                assert BackButton != null
                                : "fx:id=\"BackButton\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert SaveButton != null
                                : "fx:id=\"SaveButton\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert DeleteButton != null
                                : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'StudentList.fxml'.";

                Response<List<Student>> response = studentsHandler.handle();

                if (response.success()) {

                        List<Student> students = response.getResponse();

                        for (var student : students) {

                                Students tbStudent = new Students(Long.valueOf(student.getUserDetail().getId()),
                                                student.getUserDetail().getFullName(), student.getCollege().getId(),
                                                student.getUserDetail().getEmail(),
                                                student.getUserDetail().getPhoneNumber(),
                                                student.getGroup().getName());

                                tableview.getItems().add(tbStudent);
                        }
                }
                StudentListStudentIDColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Students, Long>, ObservableValue<Long>>() {
                                        public ObservableValue<Long> call(CellDataFeatures<Students, Long> p) {
                                                return new ReadOnlyObjectWrapper<Long>(
                                                                Long.valueOf(p.getValue().getId()));
                                        }
                                });

                StudentListStudentNameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getName());
                                        }
                                });

                StudentListStudentEmailColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getEmail());
                                        }
                                });
                StudentListCollegeColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getCollege());
                                        }
                                });
                StudentListStudentPhoneColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPhone());
                                        }
                                });

                StudentListStudentGroupColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getGname());
                                        }
                                });

                // Skipped making the ID editable
                StudentListStudentNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentListStudentNameColumn.setOnEditCommit(new EventHandler<CellEditEvent<Students, String>>() {
                        public void handle(CellEditEvent<Students, String> t) {
                                System.out.println("It works1!");
                        }

                });

                StudentListStudentEmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentListStudentEmailColumn.setOnEditCommit(new EventHandler<CellEditEvent<Students, String>>() {
                        public void handle(CellEditEvent<Students, String> t) {
                                System.out.println("It works1!");
                        }

                });

                StudentListStudentPhoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentListStudentPhoneColumn.setOnEditCommit(new EventHandler<CellEditEvent<Students, String>>() {
                        public void handle(CellEditEvent<Students, String> t) {
                                System.out.println("It works1!");
                        }

                });

                StudentListCollegeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentListCollegeColumn.setOnEditCommit(new EventHandler<CellEditEvent<Students, String>>() {
                        public void handle(CellEditEvent<Students, String> t) {
                                System.out.println("It works1!");
                        }

                });

                StudentListStudentGroupColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentListStudentGroupColumn.setOnEditCommit(new EventHandler<CellEditEvent<Students, String>>() {
                        public void handle(CellEditEvent<Students, String> t) {
                        System.out.println("It works1!");
                        }

                });

        }

}
