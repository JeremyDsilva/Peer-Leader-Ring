package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import app.AppContext;
import dto.Activities;
import entity.Activity;
import handler.GetActivitiesHandler;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import response.Response;

public class ActivityListController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label label;

        @FXML
        private TableView<Activities> tableView;

        @FXML
        private TableColumn<Activities, Long> ActivityListActivityIDColumn;

        @FXML
        private TableColumn<Activities, String> ActivityListActivityNameColumn;

        @FXML
        private TableColumn<Activities, Date> ActivityListDateColumn;

        @FXML
        private TableColumn<Activities, String> ActivityListOrganizedbyColumn;

        @FXML
        private TableColumn<Activities, String> ActivityListNoteColumn;

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
                // todo
                // This removed the selected row from the table. The first line selects the ID
                // of the selected cell.
                // Could use it to check
                // todo JEREMY
                // long data = tableview.getSelectionModel().getSelectedItem().getId();
                // System.out.println(data);
                // tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItems());

        }

        @FXML
        void SaveButtonOnClick(ActionEvent event) {
                //endEditMode();
                // todo
                Activities l = tableView.getSelectionModel().getSelectedItem();
                System.out.println(l);
                if (l == null) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Save");
                        a.setContentText("Please select a row and SAVE");
                        a.setHeaderText(null);
                        a.showAndWait();
                }
                editRow = -1;
        }

        @FXML
        void ActivityListnameEditStart(CellEditEvent<Activities, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void ActivityListnameEditCommit(CellEditEvent<Activities, String> t) {
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
        void ActivityListDOAEditStart(CellEditEvent<Activities, Date> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void ActivityListDOAEditCommit(CellEditEvent<Activities, Date> t) {
                // if (!Helper.onEditCommitCheck(t, editRow)) {
                // tableView.refresh();
                // return;
                // }

                // // to do your valiidation
                // System.out.println(t.getNewValue());
                // // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
                // if (t.getNewValue().length() > 5 || t.getNewValue().isEmpty()) {
                // Helper.createAlert("Cannot Edit", "Please follow the constraint
                // requirements");
                // } else {
                // editRow = Helper.getRow(t);
                // tableView.getSelectionModel().getSelectedItem().setCollege(t.getNewValue());
                // // dataLeaders.get(editRow).setCollege();
                // }
        }

        @FXML
        void ActivityListorganizedEditStart(CellEditEvent<Activities, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void ActivityListorganizedEditCommit(CellEditEvent<Activities, String> t) {
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
        void ActivityListnoteEditStart(CellEditEvent<Activities, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void ActivityListnoteEditCommit(CellEditEvent<Activities, String> t) {
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
                assert ActivityListActivityIDColumn != null
                                : "fx:id=\"ActivityListActivityIDColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert ActivityListActivityNameColumn != null
                                : "fx:id=\"ActivityListActivityNameColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert ActivityListDateColumn != null
                                : "fx:id=\"ActivityListDateColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert ActivityListOrganizedbyColumn != null
                                : "fx:id=\"ActivityListOrganizedbyColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert ActivityListNoteColumn != null
                                : "fx:id=\"ActivityListNoteColumn\" was not injected: check your FXML file 'ActivityList.fxml'.";
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

                Response<List<Activity>> response = activitiesHandler.handle();

                if (response.success()) {

                        List<Activity> activities = response.getResponse();

                        for (var activity : activities) {
                                Activities tbActivity = new Activities(Long.valueOf(activity.getId()),
                                                activity.getName(), (Date) activity.getDateOfActivity(),
                                                activity.getOrganizedBy(), activity.getNote());

                                tableView.getItems().add(tbActivity);
                        }

                }

                ActivityListActivityIDColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Activities, Long>, ObservableValue<Long>>() {
                                        public ObservableValue<Long> call(CellDataFeatures<Activities, Long> p) {
                                                return new ReadOnlyObjectWrapper<Long>(p.getValue().getId());
                                        }
                                });
                ActivityListActivityNameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Activities, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Activities, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getName());
                                        }
                                });

                ActivityListDateColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Activities, Date>, ObservableValue<Date>>() {
                                        public ObservableValue<Date> call(CellDataFeatures<Activities, Date> p) {
                                                return new ReadOnlyObjectWrapper<Date>(p.getValue().getDate());
                                        }
                                });
                ActivityListOrganizedbyColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Activities, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Activities, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getOrganizedby());
                                        }
                                });
                ActivityListNoteColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Activities, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Activities, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getNote());
                                        }
                                });

                // Haven't done the ID column again
                // Since only admin can edit activities.
                if (AppContext.getUser().getUserRole().equals("admin")) {
                        DeleteButton.setVisible(true);
                        SaveButton.setVisible(true);

                        ActivityListActivityNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                        // ActivityListActivityNameColumn
                        // .setOnEditCommit(new EventHandler<CellEditEvent<Activities, String>>() {
                        // public void handle(CellEditEvent<Activities, String> t) {
                        // System.out.println("It works1!");
                        // }

                        // });
                        // Need to check how to make the date editable
                        // ActivityListDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                        // ActivityListDateColumn.setOnEditCommit(new
                        // EventHandler<CellEditEvent<Activities, Date>>() {
                        // public void handle(CellEditEvent<Activities, Date> t) {
                        // // add error checking
                        // // is this an actual date

                        // System.out.println("It works2!");
                        // }
                        // });

                        ActivityListOrganizedbyColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                        // ActivityListOrganizedbyColumn
                        // .setOnEditCommit(new EventHandler<CellEditEvent<Activities, String>>() {
                        // public void handle(CellEditEvent<Activities, String> t) {
                        // System.out.println("It works3!");
                        // }

                        // });

                        ActivityListNoteColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                        // ActivityListNoteColumn.setOnEditCommit(new
                        // EventHandler<CellEditEvent<Activities, String>>() {
                        // public void handle(CellEditEvent<Activities, String> t) {
                        // System.out.println("It works4!");
                        // }

                        // });
                }

        }
}
