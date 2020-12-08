package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.AppContext;
import dto.Activity;
import handler.GetActivitiesHandler;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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

public class ActivityListController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label label;

        @FXML
        private TableView<Activity> tableView;

        @FXML
        private TableColumn<Activity, String> ActivityIDColumn;

        @FXML
        private TableColumn<Activity, String> ActivityNameColumn;

        @FXML
        private TableColumn<Activity, String> DateColumn;

        @FXML
        private TableColumn<Activity, String> OrganizedbyColumn;

        @FXML
        private TableColumn<Activity, String> NoteColumn;

        @FXML
        private Button BackButton;

        @FXML
        private Button SignOutButton;

        @FXML
        private Button SaveButton;

        @FXML
        private Button DeleteButton;

        private Boolean isInEditMode = false;

        int editRow = -1;

        Boolean rejectChange = false;

        final GetActivitiesHandler activitiesHandler;

        public ActivityListController() {
                activitiesHandler = new GetActivitiesHandler();
        }

        public void startEditMode() {
                isInEditMode = true;
                DeleteButton.setVisible(isInEditMode);
                SaveButton.setVisible(isInEditMode);
        }

        public void endEditMode() {
                isInEditMode = false;
                DeleteButton.setVisible(isInEditMode);
                SaveButton.setVisible(isInEditMode);
        }

        @FXML
        void BackButtonOnClick(ActionEvent event) throws IOException {
                if (AppContext.userIsLeader()) {
                        if (AppContext.getUser().getStudentLeader().getStudentLeaderRole().equals("peer_leader")) {
                                Helper.loadView(getClass().getResource("GroupList.fxml"));
                        } else if (AppContext.getUser().getStudentLeader().getStudentLeaderRole()
                                        .equals("team_leader")) {
                                Helper.loadView(getClass().getResource("PeerLeaderList.fxml"));
                        }
                } else if (AppContext.userIsAdmin()) {
                        Helper.loadView(getClass().getResource("Admin.fxml"));
                } else {
                        Helper.loadView(getClass().getResource("StudentView.fxml"));
                }
        }

        @FXML
        void SignOutButtonOnClick(ActionEvent event) throws IOException {
                Helper.loadView(getClass().getResource("Login.fxml"));
        }

        @FXML
        void DeleteButtonOnClick(ActionEvent event) {
                if (!Helper.onDeleteCheck(editRow))
                        return;

                var toDelete = tableView.getSelectionModel().getSelectedItem();

                int index = tableView.getItems().indexOf(toDelete);

                if (index + 1 == tableView.getItems().size()) {
                        Helper.createErrorAlert("ERROR", "Invalid Selection");
                        return;
                }

                var response = toDelete.delete();

                if (response.success()) {
                        tableView.getItems().remove(index);
                        tableView.refresh();
                        Helper.createSuccessAlert("SUCCESS", "Activity deleted successfully");
                } else
                        Helper.createErrorAlert("ERROR", response.getException().getMessage());

        }

        @FXML
        void SaveButtonOnClick(ActionEvent event) {
                if (editRow == -1) {
                        Helper.createErrorAlert("ERROR", "No row was been modified");
                } else {
                        if(editRow + 1 == tableView.getItems().size() && (tableView.getItems().get(editRow).getName().equals("<Insert>") 
                        || tableView.getItems().get(editRow).getDate().equals("<Insert>") 
                        || tableView.getItems().get(editRow).getOrganizedby().equals("<Insert>") 
                        || tableView.getItems().get(editRow).getNote().equals("<Insert>"))){
                                Helper.createErrorAlert("ERROR", "Insert all values");
                                return;
                            }

                        var respone = tableView.getItems().get(editRow).updateOrSave();

                        if (respone.hasException()) {
                                Helper.createErrorAlert("ERROR", respone.getException().getMessage());

                                var resetResponse = tableView.getItems().get(editRow).reset();
                                
                                if (resetResponse.hasException()) {
                                        Helper.createErrorAlert("DATABASE ERROR",
                                                        resetResponse.getException().getMessage());
                                        tableView.getItems().remove(editRow);
                                }
                        } else {
                                if (editRow + 1 == tableView.getItems().size()) {
                                        tableView.getItems().add(new Activity("<Default>", "<Insert>", "<Insert>",
                                                        "<Insert>", "<Insert>"));

                                }
                                Helper.createSuccessAlert("SUCCESS", "Activity saved successfully");
                        }

                        tableView.refresh();

                        editRow = -1;
                }
        }

        @FXML
        void nameEditStart(CellEditEvent<Activity, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void nameEditCommit(CellEditEvent<Activity, String> t) {
                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                System.out.println(t.getNewValue());
                if (t.getNewValue().length() > 100 || t.getNewValue().isEmpty()) {
                        Helper.createErrorAlert("ERROR: Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setName(t.getNewValue());
                }
        }

        @FXML
        void dateEditStart(CellEditEvent<Activity, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void dateEditCommit(CellEditEvent<Activity, String> t) {
                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                System.out.println(t.getNewValue());
                if (t.getNewValue().isEmpty() || !Helper.isDate(t.getNewValue())) {
                        Helper.createErrorAlert("ERROR: Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setDate(t.getNewValue());
                }
        }

        @FXML
        void organizedEditStart(CellEditEvent<Activity, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void organizedEditCommit(CellEditEvent<Activity, String> t) {
                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                System.out.println(t.getNewValue());
                if (t.getNewValue().length() > 50 || t.getNewValue().isEmpty()) {
                        Helper.createErrorAlert("ERROR: Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setOrganizedby(t.getNewValue());
                }
        }

        @FXML
        void noteEditStart(CellEditEvent<Activity, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void noteEditCommit(CellEditEvent<Activity, String> t) {
                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                System.out.println(t.getNewValue());
                if (t.getNewValue().length() > 200) {
                        Helper.createErrorAlert("ERROR: Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setNote(t.getNewValue());
                }
        }

        @FXML
        void initialize() {
                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert ActivityIDColumn != null
                                : "fx:id=\"ActivityIDColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert ActivityNameColumn != null
                                : "fx:id=\"ActivityNameColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert DateColumn != null
                                : "fx:id=\"DateColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert OrganizedbyColumn != null
                                : "fx:id=\"OrganizedbyColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert NoteColumn != null
                                : "fx:id=\"NoteColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert BackButton != null
                                : "fx:id=\"BackButton\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert SaveButton != null
                                : "fx:id=\"SaveButton\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert DeleteButton != null
                                : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'ActivityList.fxml'.";

                DeleteButton.setVisible(false);
                SaveButton.setVisible(false);

                Response<List<entity.Activity>> response = activitiesHandler.handle();

                if (response.success()) {
                        response.getResponse()
                                        .forEach(dbActivity -> tableView.getItems().add(new Activity(dbActivity)));

                        tableView.getItems()
                                        .add(new Activity("<Default>", "<Insert>", "<Insert>", "<Insert>", "<Insert>"));
                } else {
                        Helper.createErrorAlert("ERROR", "Cannot load page");
                }

                ActivityIDColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Activity, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Activity, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getId());
                                        }
                                });
                ActivityNameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Activity, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Activity, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getName());
                                        }
                                });

                DateColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Activity, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Activity, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getDate());
                                        }
                                });
                OrganizedbyColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Activity, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Activity, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getOrganizedby());
                                        }
                                });
                NoteColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Activity, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Activity, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getNote());
                                        }
                                });

                if (AppContext.getUser().getUserRole().equals("admin")) {
                        DeleteButton.setVisible(true);
                        SaveButton.setVisible(true);

                        ActivityNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                        OrganizedbyColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                        NoteColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                        DateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                }

        }
}
