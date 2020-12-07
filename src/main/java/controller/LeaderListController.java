package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dto.Leader;
import handler.GetLeadersHandler;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import response.Response;
import util.Helper;

public class LeaderListController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label label;

        @FXML
        private TableView<Leader> tableView;

        @FXML
        private TableColumn<Leader, String> IDColumn;

        @FXML
        private TableColumn<Leader, String> CollegeColumn;

        @FXML
        private TableColumn<Leader, String> YearColumn;

        @FXML
        private TableColumn<Leader, String> RoleColumn;

        @FXML
        private TableColumn<Leader, String> EmailColumn;

        @FXML
        private TableColumn<Leader, String> PhoneColumn;

        @FXML
        private Button BackButton;

        @FXML
        private Button SignOutButton;

        @FXML
        private Button SaveButton;

        @FXML
        private Button DeleteButton;

        int editRow = -1;

        Boolean rejectChange = false;

        final GetLeadersHandler getLeadersHandler;

        public LeaderListController() {
                getLeadersHandler = new GetLeadersHandler();
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
                // todo
                Leader l = tableView.getSelectionModel().getSelectedItem();
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
        void collegeEditStart(CellEditEvent<Leader, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void collegeEditCommit(CellEditEvent<Leader, String> t) {
                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                // to do your valiidation
                System.out.println(t.getNewValue());
                // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
                if (t.getNewValue().length() > 5 || t.getNewValue().isEmpty() || !t.getNewValue().equals("CEN")
                                || !t.getNewValue().equals("CAAD") || !t.getNewValue().equals("CAS")
                                || !t.getNewValue().equals("SBA")) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setCollege(t.getNewValue());
                        // dataLeaders.get(editRow).setCollege();
                }
        }

        @FXML
        void yearStartCommit(CellEditEvent<Leader, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void yearEditCommit(CellEditEvent<Leader, String> t) {
                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                // to do your valiidation
                System.out.println(t.getNewValue());
                if (t.getNewValue().length() > 9 || !t.getNewValue().isEmpty() || !t.getNewValue().equals("Freshman")
                                || !t.getNewValue().equals("Sophmore") || !t.getNewValue().equals("Junior")
                                || !t.getNewValue().equals("Senior")) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setYear(t.getNewValue());
                }
        }

        @FXML
        void roleStartCommit(CellEditEvent<Leader, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void roleEditCommit(CellEditEvent<Leader, String> t) {
                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                // to do your valiidation
                System.out.println(t.getNewValue());
                if (t.getNewValue().length() > 11 || t.getNewValue().isEmpty() || !t.getNewValue().equals("team_leader")
                                || !t.getNewValue().equals("peer_leader")) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setRole(t.getNewValue());
                }
        }

        @FXML
        void emailStartCommit(CellEditEvent<Leader, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void emailEditCommit(CellEditEvent<Leader, String> t) {
                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                // to do your valiidation
                System.out.println(t.getNewValue());
                if (t.getNewValue().length() > 30 || t.getNewValue().isEmpty()
                                || !Helper.emailValidate(t.getNewValue())) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();

                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setEmail(t.getNewValue());
                }
        }

        @FXML
        void phoneStartCommit(CellEditEvent<Leader, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void phoneEditCommit(CellEditEvent<Leader, String> t) {
                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                // to do your valiidation
                System.out.println(t.getNewValue());
                if (t.getNewValue().length() > 12 || !Helper.isNumeric(t.getNewValue())) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();

                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setPhone(t.getNewValue());
                }
        }

        @FXML
        void initialize() {
                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert tableView != null
                                : "fx:id=\"tableview\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert IDColumn != null
                                : "fx:id=\"LeaderListIDColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert CollegeColumn != null
                                : "fx:id=\"LeaderListCollegeColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert YearColumn != null
                                : "fx:id=\"YearColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert RoleColumn != null
                                : "fx:id=\"RoleColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert EmailColumn != null
                                : "fx:id=\"EmailColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert PhoneColumn != null
                                : "fx:id=\"PhoneColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert BackButton != null
                                : "fx:id=\"BackButton\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert SaveButton != null
                                : "fx:id=\"SaveButton\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert DeleteButton != null
                                : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'LeaderList.fxml'.";

                Response<List<entity.StudentLeader>> response = getLeadersHandler.handle();

                if (response.success()) {
                        response.getResponse().forEach(dbLeader -> tableView.getItems().add(new Leader(dbLeader)));
                }

                IDColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leader, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Leader, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getId());
                                        }
                                });

                CollegeColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leader, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Leader, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getCollege());
                                        }
                                });

                YearColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leader, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Leader, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getYear());
                                        }
                                });
                RoleColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leader, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Leader, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getRole());
                                        }
                                });

                EmailColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leader, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Leader, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getEmail());
                                        }
                                });
                PhoneColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leader, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Leader, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPhone());
                                        }
                                });

                CollegeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                YearColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                RoleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                EmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                PhoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        }
}
