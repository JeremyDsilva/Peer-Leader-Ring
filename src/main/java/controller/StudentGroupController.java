package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dto.Groups;
import entity.Group;
import handler.GetGroupsHandler;
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
import javafx.stage.Stage;
import response.Response;
import javafx.scene.Node;
import javafx.util.Callback;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn.CellDataFeatures;

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
        private TableView<Groups> tableview;

        @FXML
        private TableColumn<Groups, Long> StudentGroupGroupIDcolumn;

        @FXML
        private TableColumn<Groups, String> StudentGroupGroupNameColumn;

        @FXML
        private TableColumn<Groups, String> StudentGroupPeerLeaderColumn;

        @FXML
        private TableColumn<Groups, String> StudentGroupTeamLeaderColumn;

        @FXML
        private TableColumn<Groups, String> StudentGroupStudentColumn;

        @FXML
        private Button BackButton;

        @FXML
        private Button SaveButton;

        @FXML
        private Button DeleteButton;

        final GetGroupsHandler getGroupsHandler;

        public StudentGroupController() {
                getGroupsHandler = new GetGroupsHandler();
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
        void groupidEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void groupidEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void groupnameEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void groupnameEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void grouppeerleaderEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void grouppeerleaderEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void groupteamleaderEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void groupteamleaderEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void groupstudentEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void groupstudentEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void initialize() {
                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'StudentGroup.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'StudentGroup.fxml'.";
                assert tableview != null
                                : "fx:id=\"tableview\" was not injected: check your FXML file 'StudentGroup.fxml'.";
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
                assert BackButton != null
                                : "fx:id=\"BackButton\" was not injected: check your FXML file 'StudentGroup.fxml'.";
                assert SaveButton != null
                                : "fx:id=\"SaveButton\" was not injected: check your FXML file 'StudentGroup.fxml'.";
                assert DeleteButton != null
                                : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'StudentGroup.fxml'.";

                Response<List<Group>> response = getGroupsHandler.handle();

                if (response.success()) {

                        List<Group> groups = response.getResponse();

                        for (var group : groups) {
                                Groups tbGroup = new Groups(group.getId(), group.getName(),
                                                group.getPeerLeader().getUserDetail().getFullName(),
                                                group.getTeamLeader().getUserDetail().getFullName(), 
                                                group.getName()
                                                );

                                tableview.getItems().add(tbGroup);
                        }
                }
                StudentGroupGroupIDcolumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Groups, Long>, ObservableValue<Long>>() {
                                        public ObservableValue<Long> call(CellDataFeatures<Groups, Long> p) {
                                                return new ReadOnlyObjectWrapper<Long>(
                                                                Long.valueOf(p.getValue().getId()));
                                        }
                                });

                StudentGroupGroupNameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Groups, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Groups, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getName());
                                        }
                                });

                StudentGroupPeerLeaderColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Groups, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Groups, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPname());
                                        }
                                });
                StudentGroupTeamLeaderColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Groups, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Groups, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getTname());
                                        }
                                });
                StudentGroupStudentColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Groups, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Groups, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getSname());
                                        }
                                });

                // Skipped making the ID editable
                StudentGroupGroupNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentGroupGroupNameColumn.setOnEditCommit(new EventHandler<CellEditEvent<Groups, String>>() {
                        public void handle(CellEditEvent<Groups, String> t) {
                                System.out.println("It works1!");
                        }

                });

                StudentGroupPeerLeaderColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentGroupPeerLeaderColumn.setOnEditCommit(new EventHandler<CellEditEvent<Groups, String>>() {
                        public void handle(CellEditEvent<Groups, String> t) {
                                System.out.println("It works1!");
                        }

                });

                StudentGroupTeamLeaderColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentGroupTeamLeaderColumn.setOnEditCommit(new EventHandler<CellEditEvent<Groups, String>>() {
                        public void handle(CellEditEvent<Groups, String> t) {
                                System.out.println("It works1!");
                        }

                });

                StudentGroupStudentColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                StudentGroupStudentColumn.setOnEditCommit(new EventHandler<CellEditEvent<Groups, String>>() {
                        public void handle(CellEditEvent<Groups, String> t) {
                                System.out.println("It works1!");
                        }

                });

        }
}
