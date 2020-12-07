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
                // No need to check for student login as no BACK BUTTON needed.
                if (AppContext.getUser().getUserRole().equals("leader")) {
                        if (AppContext.getUser().getStudentLeader().getStudentLeaderRole().equals("peer_leader")) {
                                Parent root = FXMLLoader.load(getClass().getResource("GroupList.fxml"));
                                Scene back = new Scene(root);
                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                window.setScene(back);
                                window.show();
                        } else if (AppContext.getUser().getStudentLeader().getStudentLeaderRole()
                                        .equals("team_leader")) {
                                Parent root = FXMLLoader.load(getClass().getResource("PeerLeaderList.fxml"));
                                Scene back = new Scene(root);
                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                window.setScene(back);
                                window.show();
                        }
                } else if (AppContext.getUser().getUserRole().equals("admin")) {
                        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                        Scene Back = new Scene(root);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(Back);
                        window.show();

                } else {
                        Parent root = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
                        Scene Back = new Scene(root);
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        window.setScene(Back);
                        window.show();
                }
        }

        @FXML
        void SignOutButtonOnClick(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Scene Logout = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(Logout);
                window.show();
        }

        @FXML
        void DeleteButtonOnClick(ActionEvent event) {
                if (!Helper.onDeleteCheck(editRow))
                        return;

                var toDelete = tableView.getSelectionModel().getSelectedItem();

                int index = tableView.getItems().indexOf(toDelete);

                if (index + 1 == tableView.getItems().size()) {
                        Helper.createAlert("Error in Deletion", "Invalid Selection");
                        return;
                }

                var response = toDelete.delete();

                if (response.success()) {
                        tableView.getItems().remove(index);
                        tableView.refresh();
                } else
                        Helper.createAlert("Error in Deletion", response.getException().getMessage());

        }

        @FXML
        void SaveButtonOnClick(ActionEvent event) {
                if (editRow == -1) {
                        Helper.createAlert("Error", "No row was been modified");
                } else {
                        var respone = tableView.getItems().get(editRow).updateOrSave();

                        if (respone.hasException()) {
                                Helper.createAlert("Error", respone.getException().getMessage());

                                var resetResponse = tableView.getItems().get(editRow).reset();

                                if (resetResponse.hasException()) {
                                        Helper.createAlert("Database Error", resetResponse.getException().getMessage());
                                        tableView.getItems().remove(editRow);
                                }
                        } else if (editRow + 1 == tableView.getItems().size()) {
                                tableView.getItems().add(new Activity("<Insert>", "<Insert>", "<Insert>", "<Insert>",
                                                "<Insert>"));
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

                // to do your valiidation
                System.out.println(t.getNewValue());
                // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
                if (t.getNewValue().length() > 100 || t.getNewValue().isEmpty()) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
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

                // to do your valiidation
                System.out.println(t.getNewValue());
                // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
                if (t.getNewValue().isEmpty() || !Helper.isDate(t.getNewValue())) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
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

                // to do your valiidation
                System.out.println(t.getNewValue());
                // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
                if (t.getNewValue().length() > 50 || t.getNewValue().isEmpty()) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
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

                // to do your valiidation
                System.out.println(t.getNewValue());
                // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
                if (t.getNewValue().length() > 200) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
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
                                        .add(new Activity("<Insert>", "<Insert>", "<Insert>", "<Insert>", "<Insert>"));
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

                // Haven't done the ID column again
                // Since only admin can edit activities.
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
