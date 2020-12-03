package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.AppContext;
import dto.Student;
import entity.Group;
import handler.GetGroupHandler;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import javafx.scene.Node;

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
        private TableView<Student> tableView;

        @FXML
        private TableColumn<Student, Long> idColumn;

        @FXML
        private TableColumn<Student, String> nameColumn;

        @FXML
        private TableColumn<Student, String> emailCloumn;

        @FXML
        private TableColumn<Student, String> phoneColumn;

        @FXML
        private TableColumn<Student, String> collegeColumn;

        @FXML
        private Button GroupListMarkAttendButton;

        @FXML
        private Button GroupListViewActButton;

        @FXML
        private Button SignOutButton;

        final GetGroupHandler groupHandler;

        public GroupListController() {
                groupHandler = new GetGroupHandler();
        }

        @FXML
        void GroupListMarkAttendOnClick(ActionEvent event) {
                // todo
        }

        @FXML
        void GroupListViewActButtonOnClick(ActionEvent event) throws IOException {
                // todo
                Parent root = FXMLLoader.load(getClass().getResource("ActivityList.fxml"));
                Scene Activity = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(Activity);
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
        void studentidEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void studentidEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void studentnameEditCommit(ActionEvent event) {
                System.out.println("Commit2");
        }

        @FXML
        void studentnameEditStart(ActionEvent event) {
                System.out.println("Edit2");
        }

        @FXML
        void studentemailEditCommit(ActionEvent event) {
                System.out.println("Commit3");
        }

        @FXML
        void studentemailEditStart(ActionEvent event) {
                System.out.println("Edit3");
        }

        @FXML
        void studentphoneEditCommit(ActionEvent event) {
                System.out.println("Commit4");
        }

        @FXML
        void studentphoneEditStart(ActionEvent event) {
                System.out.println("Edit4");
        }

        @FXML
        void studentcollegeEditCommit(ActionEvent event) {
                System.out.println("Commit5");
        }

        @FXML
        void studentcollegeEditStart(ActionEvent event) {
                System.out.println("Edit5");
        }

        @FXML
        void initialize() {
                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert GroupListNameLabel != null
                                : "fx:id=\"GroupListNameLabel\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert GroupListGroupNameLabel != null
                                : "fx:id=\"GroupListGroupNameLabel\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert GroupListTeamLeaderLabel != null
                                : "fx:id=\"GroupListTeamLeaderLabel\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert tableView != null
                                : "fx:id=\"tableView\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert idColumn != null : "fx:id=\"IdColumn\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert nameColumn != null
                                : "fx:id=\"nameColumn\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert emailCloumn != null
                                : "fx:id=\"emailCloumn\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert phoneColumn != null
                                : "fx:id=\"phoneColumn\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert collegeColumn != null
                                : "fx:id=\"collegeColumn\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert GroupListMarkAttendButton != null
                                : "fx:id=\"GroupListMarkAttendButton\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert GroupListViewActButton != null
                                : "fx:id=\"GroupListViewActButton\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'GroupList.fxml'.";

                Response<Group> response = groupHandler.handle(122434L);

                GroupListNameLabel.setText(AppContext.getUser().getFullName());
                GroupListTeamLeaderLabel.setText(String.valueOf(response.getResponse().getTeamLeader().));
                
                if (response.success()) {

                        Group group = response.getResponse();

                        for (var student : group.getStudents()) {
                                Student tbStudent = new Student(Long.valueOf(student.getUserDetail().getId()),
                                                student.getUserDetail().getFullName(), student.getCollege().getId(),
                                                student.getUserDetail().getEmail(),
                                                student.getUserDetail().getPhoneNumber());

                                tableView.getItems().add(tbStudent);
                        }
                } else {

                }

                nameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Student, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Student, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getName());
                                        }
                                });

                emailCloumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Student, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Student, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getEmail());
                                        }
                                });
                collegeColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Student, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Student, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getCollege());
                                        }
                                });
                phoneColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Student, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Student, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPhone());
                                        }
                                });
                idColumn.setCellValueFactory(new Callback<CellDataFeatures<Student, Long>, ObservableValue<Long>>() {
                        public ObservableValue<Long> call(CellDataFeatures<Student, Long> p) {
                                return new ReadOnlyObjectWrapper<Long>(Long.valueOf(p.getValue().getId()));
                        }
                });

                // Making the columns editable except the ID field
                nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                nameColumn.setOnEditCommit(new EventHandler<CellEditEvent<Student, String>>() {
                        public void handle(CellEditEvent<Student, String> t) {
                                System.out.println("It works1!");
                        }

                });

                emailCloumn.setCellFactory(TextFieldTableCell.forTableColumn());

                emailCloumn.setOnEditCommit(new EventHandler<CellEditEvent<Student, String>>() {
                        public void handle(CellEditEvent<Student, String> t) {
                                System.out.println("It works2!");
                        }

                });

                collegeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                collegeColumn.setOnEditCommit(new EventHandler<CellEditEvent<Student, String>>() {
                        public void handle(CellEditEvent<Student, String> t) {
                                System.out.println("It works3!");
                        }

                });

                phoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                phoneColumn.setOnEditCommit(new EventHandler<CellEditEvent<Student, String>>() {
                        public void handle(CellEditEvent<Student, String> t) {
                                System.out.println("It works4!");
                        }

                });

                // The ID is primary. So lets keep it uneditable.
                // idColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // idColumn.setOnEditCommit(new EventHandler<CellEditEvent<Student, Long>>() {
                // public void handle(CellEditEvent<Student, String> t) {
                // System.out.println("It works!");
                // }

                // });

        }

}