package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dto.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
        private TableView<Student> ListOfStudentTableView;

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
        private TableColumn<?, ?> StudentListStudentGroupColumn;

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
        void initialize() {
                // //sets the columns in the table
                // StudentListStudentIDColumn.setCellValueFactory(new
                // PropertyValueFactory<Student, Long>("id"));
                // StudentListStudentNameColumn.setCellValueFactory(new
                // PropertyValueFactory<Student, String>("name"));
                // StudentListStudentEmailColumn.setCellValueFactory(new
                // PropertyValueFactory<Student, String>("email"));
                // StudentListStudentPhoneColumn.setCellValueFactory(new
                // PropertyValueFactory<Student, String>("phone"));
                // StudentListCollegeColumn.setCellValueFactory(new
                // PropertyValueFactory<Student, String>("college"));

                // //loading dummy values
                // ListOfStudentTableView.setItems(getStudents());

                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'StudentList.fxml'.";
                assert ListOfStudentTableView != null
                                : "fx:id=\"ListOfStudentTableView\" was not injected: check your FXML file 'StudentList.fxml'.";
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

        }

        // //This will return an observablelist of student objects
        // private ObservableList<Student> getStudents() {
        // ObservableList<Student> stu = FXCollections.observableArrayList();
        // stu.add(new Student(1, "Yash", "CEN", "YashGaikwad@", 0501234567));
        // stu.add(new Student(1, "Iffa", "CEN", "IffaCM@", 0501234567));
        // stu.add(new Student(1, "Jeremy", "CEN", "JeremyDSilva@", 0501234567));
        // stu.add(new Student(1, "dsgv", "CEN", "sdfs@", 0501234567));
        // stu.add(new Student(1, "dfawe", "CEN", "wef@", 0501234567));

        // return stu;

        // }

}
