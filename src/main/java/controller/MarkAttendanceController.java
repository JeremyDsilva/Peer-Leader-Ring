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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import response.Response;
import util.Helper;

public class MarkAttendanceController {

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
        private Button GroupListMarkAttendButton;

        @FXML
        private Button GroupListViewActButton;

        @FXML
        private Button SignOutButton;

        final GetGroupHandler groupHandler;

        public MarkAttendanceController() {
                groupHandler = new GetGroupHandler();
        }

        @FXML
        void GroupListMarkAttendOnClick(ActionEvent event) {
                // todo
        }

        @FXML
        void GroupListViewActButtonOnClick(ActionEvent event) throws IOException {
                Helper.loadView(getClass().getResource("ActivityList.fxml"));
        }

        @FXML
        void SignOutButtonOnClick(ActionEvent event) throws IOException {
                Helper.loadView(getClass().getResource("Login.fxml"));
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
                assert GroupListMarkAttendButton != null
                                : "fx:id=\"GroupListMarkAttendButton\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert GroupListViewActButton != null
                                : "fx:id=\"GroupListViewActButton\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'GroupList.fxml'.";

                Response<Group> response = groupHandler.handle(AppContext.getUser().getId());

                GroupListNameLabel.setText(AppContext.getUser().getFullName());
                GroupListGroupNameLabel.setText(response.getResponse().getName());
                GroupListTeamLeaderLabel.setText(response.getResponse().getTeamLeader().getUserDetail().getFullName());
                // GroupListTeamLeaderLabel.setText(String.valueOf(response.getResponse().getTeamLeader()));

                nameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Student, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Student, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getName());
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

        }

}