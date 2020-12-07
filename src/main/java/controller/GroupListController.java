package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.AppContext;
import dto.Students;
import entity.Group;
import handler.GetGroupHandler;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import response.Response;

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
        private TableView<Students> tableView;

        @FXML
        private TableColumn<Students, Long> idColumn;

        @FXML
        private TableColumn<Students, String> nameColumn;

        @FXML
        private TableColumn<Students, String> emailCloumn;

        @FXML
        private TableColumn<Students, String> phoneColumn;

        @FXML
        private TableColumn<Students, String> collegeColumn;

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
        void initialize() {
                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert GroupListNameLabel != null
                                : "fx:id=\"GroupListNameLabel\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert GroupListGroupNameLabel != null
                                : "fx:id=\"GroupListGroupNameLabel\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert GroupListTeamLeaderLabel != null
                                : "fx:id=\"GroupListTeamLeaderLabel\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert tableView != null
                                : "fx:id=\"tableview\" was not injected: check your FXML file 'GroupList.fxml'.";
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

                Response<Group> response = null;

                if (AppContext.getUser().getUserRole().equals("leader")) {

                        if (AppContext.getUser().getStudentLeader().getStudentLeaderRole().equals("peer_leader"))
                                response = groupHandler.handle(AppContext.getUser().getStudentLeader().getPeerGroup().get(0).getId());
                        else
                                response = groupHandler.handle((Long) AppContext.get("groupId"));
                }

                if (response != null && response.success()) {

                        GroupListNameLabel.setText(AppContext.getUser().getFullName());
                        GroupListGroupNameLabel.setText(response.getResponse().getName());
                        GroupListTeamLeaderLabel
                                        .setText(response.getResponse().getTeamLeader().getUserDetail().getFullName());

                        Group group = response.getResponse();

                        for (var student : group.getStudents()) {
                                Students tbStudent = new Students(Long.valueOf(student.getUserDetail().getId()),
                                                student.getUserDetail().getFullName(), student.getCollege().getId(),
                                                student.getUserDetail().getEmail(),
                                                student.getUserDetail().getPhoneNumber());

                                tableView.getItems().add(tbStudent);
                        }
                }

                nameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getName());
                                        }
                                });

                emailCloumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getEmail());
                                        }
                                });
                collegeColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getCollege());
                                        }
                                });
                phoneColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPhone());
                                        }
                                });
                idColumn.setCellValueFactory(new Callback<CellDataFeatures<Students, Long>, ObservableValue<Long>>() {
                        public ObservableValue<Long> call(CellDataFeatures<Students, Long> p) {
                                return new ReadOnlyObjectWrapper<Long>(Long.valueOf(p.getValue().getId()));
                        }
                });

        }

}