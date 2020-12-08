package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.AppContext;
import dto.Attendace;
import entity.Activity;
import entity.Group;
import handler.CreateAttendanceHandler;
import handler.DeleteAttendanceHandler;
import handler.GetActivitiesHandler;
import handler.GetGroupHandler;
import handler.GetStudentsFromGroupHandler;
import handler.GetStudentsWithAttendanceHandler;
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
        private TableView<Attendace> tableView;

        @FXML
        private TableColumn<Attendace, Long> idColumn;

        @FXML
        private TableColumn<Attendace, String> nameColumn;

        @FXML
        private Button SignOutButton;

        @FXML
        private Button BackButton;

        final GetGroupHandler groupHandler;

        public MarkAttendanceController() {
                groupHandler = new GetGroupHandler();
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
        void BackButtonOnClick(ActionEvent event) {
                if(AppContext.userIsAdmin() && !AppContext.contains("groupId"))
                        Helper.loadView(getClass().getResource("Admin.fxml"));
                else if(AppContext.userIsAdmin())
                        Helper.loadView(getClass().getResource("StudentGroup.fxml"));
                else 
                     Helper.loadView(getClass().getResource("GroupList.fxml"));   
        }
    

        @FXML
        void initialize() {
                assert label != null 
                                : "fx:id=\"label\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert tableView != null
                                : "fx:id=\"tableView\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert idColumn != null : "fx:id=\"IdColumn\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert nameColumn != null
                                : "fx:id=\"nameColumn\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'GroupList.fxml'.";
                assert BackButton != null 
                                : "fx:id=\"BackButton\" was not injected: check your FXML file 'MarkAttendance.fxml'.";

                Response<List<Activity>> activities = new GetActivitiesHandler().handle();

                for (var activity : activities.getResponse()) {

                        TableColumn<Attendace, String> col = new TableColumn<Attendace, String>(
                                        String.valueOf(activity.getId()));

                        col.setMinWidth(50);

                        col.setCellValueFactory(
                                        new Callback<CellDataFeatures<Attendace, String>, ObservableValue<String>>() {
                                                public ObservableValue<String> call(
                                                                CellDataFeatures<Attendace, String> p) {

                                                        if (p.getValue().getActivity().containsKey(activity)) {
                                                                return new ReadOnlyObjectWrapper<String>(
                                                                                p.getValue().getActivity().get(activity)
                                                                                                ? "Y"
                                                                                                : "N");
                                                        } else {
                                                                p.getValue().getActivity().put(activity,
                                                                                Boolean.valueOf(false));
                                                                return new ReadOnlyObjectWrapper<String>("N");
                                                        }
                                                }
                                        });

                        col.setCellFactory(TextFieldTableCell.forTableColumn());

                        col.setOnEditCommit(new EventHandler<CellEditEvent<Attendace, String>>() {

                                public void handle(CellEditEvent<Attendace, String> t) {

                                        if (t.getNewValue().equals(t.getOldValue()))
                                                return;

                                        if (!t.getNewValue().equals("Y") && !t.getNewValue().equals("N")) {
                                                Helper.createErrorAlert("ERROR", "Enter either Y or N");
                                                tableView.refresh();
                                                return;
                                        }

                                        var attendace = tableView.getSelectionModel().getSelectedItem();
                                        var student = attendace.getStudent();

                                        if (t.getNewValue().equals("Y")) {

                                                CreateAttendanceHandler handler = new CreateAttendanceHandler();

                                                var response = handler.handle(student, activity);

                                                if (response.success()) {
                                                } else {
                                                        Helper.createErrorAlert("ERROR",
                                                                        response.getException().getMessage());
                                                        tableView.refresh();
                                                }
                                        } else {

                                                DeleteAttendanceHandler handler = new DeleteAttendanceHandler();

                                                var response = handler.handle(student, activity);

                                                if (response.success()) {
                                                        attendace.getActivity().remove(activity);
                                                        attendace.getActivity().put(activity, Boolean.valueOf(false));
                                                } else {
                                                        Helper.createErrorAlert("ERROR",
                                                                        response.getException().getMessage());
                                                        tableView.refresh();
                                                }

                                        }

                                }

                        });

                        tableView.getColumns().add(col);
                }

                Response<List<entity.Student>> students;

                if (AppContext.userIsAdmin() && !AppContext.contains("groupId")) {
                        students = new GetStudentsWithAttendanceHandler().handle();
                } else {
                        students = new GetStudentsFromGroupHandler().handle((Long) AppContext.get("groupId"));

                }

                students.getResponse().forEach(student -> tableView.getItems().add(new Attendace(student)));

                idColumn.setCellValueFactory(new Callback<CellDataFeatures<Attendace, Long>, ObservableValue<Long>>() {
                        public ObservableValue<Long> call(CellDataFeatures<Attendace, Long> p) {
                                return new ReadOnlyObjectWrapper<Long>(Long.valueOf(p.getValue().getStudent().getId()));
                        }
                });

                nameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Attendace, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Attendace, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getStudent()
                                                                .getUserDetail().getFullName());
                                        }
                                });

        }

}