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
        private TableColumn<Leader, String> NameColumn;

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
                Helper.loadView(getClass().getResource("Admin.fxml"));
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
                                tableView.getItems().add(new Leader("<Insert>", "<Insert>", "<Insert>", "<Insert>",
                                                "<Insert>", "<Insert>", "<Insert>"));
                        }

                        tableView.refresh();

                        editRow = -1;
                }
        }

        @FXML
        void idEditStart(CellEditEvent<Leader, String> t) {
                int row = editRow != -1 ? editRow : Helper.getRow(t);
                if (row + 1 != tableView.getItems().size())
                        Helper.createAlert("Cannot Edit", "ID is not editable");

                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void idEditCommit(CellEditEvent<Leader, String> t) {
                int row = editRow != -1 ? editRow : Helper.getRow(t);
                if (row + 1 != tableView.getItems().size())
                        Helper.createAlert("Cannot Edit", "ID is not editable");

                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                System.out.println(t.getNewValue());
                if (!Helper.isNumeric(t.getNewValue()) || t.getNewValue().isEmpty()) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setId(t.getNewValue());
                }

        }

        @FXML
        void nameEditStart(CellEditEvent<Leader, String> t) {
                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void nameEditCommit(CellEditEvent<Leader, String> t) {
                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                // to do your valiidation
                System.out.println(t.getNewValue());

                if (t.getNewValue().length() > 30 || t.getNewValue().isEmpty()) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setName(t.getNewValue());
                }
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

                if (t.getNewValue().length() > 5 || t.getNewValue().isEmpty()
                                || (!t.getNewValue().equals("CEN") && !t.getNewValue().equals("CAAD")
                                                && !t.getNewValue().equals("CAS") && !t.getNewValue().equals("SBA"))) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setCollege(t.getNewValue());
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

                System.out.println(t.getNewValue());
                if (t.getNewValue().length() > 9 || !t.getNewValue().isEmpty()
                                || (!t.getNewValue().equals("Freshman") && !t.getNewValue().equals("Sophomore")
                                                && !t.getNewValue().equals("Junior")
                                                && !t.getNewValue().equals("Senior"))) {
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
                if (t.getNewValue().length() > 11 || t.getNewValue().isEmpty()
                                || (!t.getNewValue().equals("team_leader") && !t.getNewValue().equals("peer_leader"))) {
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
                                : "fx:id=\"IDColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert NameColumn != null
                                : "fx:id=\"NameColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert CollegeColumn != null
                                : "fx:id=\"CollegeColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
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

                        tableView.getItems().add(new Leader("<Insert>", "<Insert>", "<Insert>", "<Insert>", "<Insert>",
                                        "<Insert>", "<Insert>"));
                }

                IDColumn.setCellValueFactory(new Callback<CellDataFeatures<Leader, String>, ObservableValue<String>>() {
                        public ObservableValue<String> call(CellDataFeatures<Leader, String> p) {
                                return new ReadOnlyObjectWrapper<String>(p.getValue().getId());
                        }
                });

                NameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leader, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Leader, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getName());
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

                IDColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                CollegeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                YearColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                RoleColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                EmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                PhoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        }
}
