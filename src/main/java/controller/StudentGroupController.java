package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dto.Groups;
import entity.Group;
import handler.GetGroupsHandler;
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
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import response.Response;

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
        private TableView<Groups> tableView;

        @FXML
        private TableColumn<Groups, Long> StudentGroupGroupIDcolumn;

        @FXML
        private TableColumn<Groups, String> StudentGroupGroupNameColumn;

        @FXML
        private TableColumn<Groups, String> StudentGroupPeerLeaderColumn;

        @FXML
        private TableColumn<Groups, String> StudentGroupTeamLeaderColumn;

        @FXML
        private Button BackButton;

        @FXML
        private Button SaveButton;

        @FXML
        private Button DeleteButton;

        final GetGroupsHandler getGroupsHandler;

        int editRow = -1;

        Boolean rejectChange = false;

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
                // todo
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
                // todo
                Groups g = tableView.getSelectionModel().getSelectedItem();
                System.out.println(g);
                if (g == null) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Save");
                        a.setContentText("Please select a row and SAVE");
                        a.setHeaderText(null);
                        a.showAndWait();
                }
                editRow = -1;

        }

        // int getRow(CellEditEvent<Groups, ?> t) {
        // // todo
        // return t.getTablePosition().getRow();
        // }

        @FXML
        void groupnameEditStart(CellEditEvent<Groups, String> t) {

                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void groupnameEditCommit(CellEditEvent<Groups, String> t) {

                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                // to do your valiidation
                System.out.println(t.getNewValue());
                // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
                if (t.getNewValue().length() > 20) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setName(t.getNewValue());
                        // dataLeaders.get(editRow).setCollege();
                }
        }

        @FXML
        void grouppeerleaderEditStart(CellEditEvent<Groups, String> t) {

                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void grouppeerleaderEditCommit(CellEditEvent<Groups, String> t) {
                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                // to do your valiidation
                System.out.println(t.getNewValue());
                // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
                if (t.getNewValue().length() > 30 || t.getNewValue().isEmpty()) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setPname(t.getNewValue());

                }
        }

        @FXML
        void groupteamleaderEditStart(CellEditEvent<Groups, String> t) {

                Helper.onEditStartCheck(t, editRow);
        }

        @FXML
        void groupteamleaderEditCommit(CellEditEvent<Groups, String> t) {
                if (!Helper.onEditCommitCheck(t, editRow)) {
                        tableView.refresh();
                        return;
                }

                // to do your valiidation
                System.out.println(t.getNewValue());
                // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
                if (t.getNewValue().length() > 30 || t.getNewValue().isEmpty()) {
                        Helper.createAlert("Cannot Edit", "Please follow the constraint requirements");
                        tableView.refresh();
                } else {
                        editRow = Helper.getRow(t);
                        tableView.getSelectionModel().getSelectedItem().setTname(t.getNewValue());

                }
        }

        @FXML
        void initialize() {
                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'StudentGroup.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'StudentGroup.fxml'.";
                assert tableView != null
                                : "fx:id=\"tableview\" was not injected: check your FXML file 'StudentGroup.fxml'.";
                assert StudentGroupGroupIDcolumn != null
                                : "fx:id=\"StudentGroupGroupIDcolumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
                assert StudentGroupGroupNameColumn != null
                                : "fx:id=\"StudentGroupGroupNameColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
                assert StudentGroupPeerLeaderColumn != null
                                : "fx:id=\"StudentGroupPeerLeaderColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
                assert StudentGroupTeamLeaderColumn != null
                                : "fx:id=\"StudentGroupTeamLeaderColumn\" was not injected: check your FXML file 'StudentGroup.fxml'.";
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
                                                group.getTeamLeader().getUserDetail().getFullName());

                                tableView.getItems().add(tbGroup);
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

                // Skipped making the ID editable
                StudentGroupGroupNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // StudentGroupGroupNameColumn.setOnEditCommit(new
                // EventHandler<CellEditEvent<Groups, String>>() {
                // public void handle(CellEditEvent<Groups, String> t) {
                // System.out.println("It works1!");
                // }

                // });

                StudentGroupPeerLeaderColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // StudentGroupPeerLeaderColumn.setOnEditCommit(new
                // EventHandler<CellEditEvent<Groups, String>>() {
                // public void handle(CellEditEvent<Groups, String> t) {
                // System.out.println("It works1!");
                // }

                // });

                StudentGroupTeamLeaderColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // StudentGroupTeamLeaderColumn.setOnEditCommit(new
                // EventHandler<CellEditEvent<Groups, String>>() {
                // public void handle(CellEditEvent<Groups, String> t) {
                // System.out.println("It works1!");
                // }

                // });

        }
}
