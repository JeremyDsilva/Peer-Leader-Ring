package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dto.Leaders;
import entity.StudentLeader;
import handler.GetLeadersHandler;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import net.bytebuddy.asm.Advice.Return;
import response.Response;

public class LeaderListController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label label;

        @FXML
        private TableView<Leaders> tableView;

        @FXML
        private TableColumn<Leaders, Long> LeaderListIDColumn;

        @FXML
        private TableColumn<Leaders, String> LeaderListCollegeColumn;

        @FXML
        private TableColumn<Leaders, String> LeaderListYearColumn;

        @FXML
        private TableColumn<Leaders, String> LeaderListRoleColumn;

        @FXML
        private TableColumn<Leaders, String> LeaderListEmailColumn;

        @FXML
        private TableColumn<Leaders, String> LeaderListPhoneColumn;

        @FXML
        private Button BackButton;

        @FXML
        private Button SignOutButton;

        @FXML
        private Button SaveButton;

        @FXML
        private Button DeleteButton;

        int editRow = -1;

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
                Leaders l = tableView.getSelectionModel().getSelectedItem();
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

        int getRow(CellEditEvent<Leaders, ?> t) {
                // todo
                return t.getTablePosition().getRow();
        }

        @FXML
        void listofleaderscollegeEditStart(CellEditEvent<Leaders, String> t) {
                if (editRow == -1) { // no row is being edit, dont care
                }

                else if (getRow(t) == editRow) {// if the I started editing the row i was editing , dont care
                }

                else {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Start Editing");
                        a.setContentText("Please select the previous edited row and SAVE");
                        a.setHeaderText(null);
                        a.showAndWait();
                }
        }

        @FXML
        void listofleaderscollegeEditCommit(CellEditEvent<Leaders, String> t) {
                if (editRow == -1) {
                        // no row is being edit, dont care
                }
                if (getRow(t) != editRow) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Edit");
                        a.setContentText("Please select the previous edited row and SAVE");
                        a.setHeaderText(null);
                        a.showAndWait();
                        // if the I started editing the row i was editing , I care
                        tableView.getSelectionModel().getSelectedItem().setCollege(t.getOldValue());
                        // set it back to prev value
                }
                // to do your valiidation
                System.out.println(t.getNewValue());
                // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
                if (t.getNewValue().length() > 5 || t.getNewValue().isEmpty()) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Edit");
                        a.setContentText("Please follow the constraint requirements");
                        a.setHeaderText(null);
                        a.showAndWait();
                }

                editRow = getRow(t);
        }

        @FXML
        void listofleadersyearStartCommit(CellEditEvent<Leaders, String> t) {
                if (editRow == -1) { // no row is being edit, dont care
                }

                else if (getRow(t) == editRow) {// if the I started editing the row i was editing , dont care
                }

                else {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Start Editing");
                        a.setContentText("Please select the previous edited row and SAVE");
                        a.setHeaderText(null);
                        a.showAndWait();
                }
        }

        @FXML
        void listofleadersyearEditCommit(CellEditEvent<Leaders, String> t) {
                if (editRow == -1) {
                        // no row is being edit, dont care
                }
                if (getRow(t) != editRow) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Edit");
                        a.setContentText("Please select the previous edited row and SAVE");
                        a.setHeaderText(null);
                        a.showAndWait();
                        // if the I started editing the row i was editing , I care
                        tableView.getSelectionModel().getSelectedItem().setYear(t.getOldValue());
                        // set it back to prev value
                }
                // to do your valiidation
                System.out.println(t.getNewValue());
                if (t.getNewValue().length() > 9 || t.getNewValue().isEmpty()) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Edit");
                        a.setContentText("Please follow the constraint requirements");
                        a.setHeaderText(null);
                        a.showAndWait();
                }

                editRow = getRow(t);
        }

        @FXML
        void listofleadersroleStartCommit(CellEditEvent<Leaders, String> t) {
                if (editRow == -1) { // no row is being edit, dont care
                }

                else if (getRow(t) == editRow) {// if the I started editing the row i was editing , dont care
                }

                else {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Start Editing");
                        a.setContentText("Please select the previous edited row and SAVE");
                        a.setHeaderText(null);
                        a.showAndWait();
                }
        }

        @FXML
        void listofleadersroleEditCommit(CellEditEvent<Leaders, String> t) {
                if (editRow == -1) {
                        // no row is being edit, dont care
                }
                if (getRow(t) != editRow) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Edit");
                        a.setContentText("Please select the previous edited row and SAVE");
                        a.setHeaderText(null);
                        a.showAndWait();
                        // if the I started editing the row i was editing , I care
                        tableView.getSelectionModel().getSelectedItem().setRole(t.getOldValue());
                        // set it back to prev value
                }
                // to do your valiidation
                System.out.println(t.getNewValue());
                if (t.getNewValue().length() > 7 || t.getNewValue().isEmpty()) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Edit");
                        a.setContentText("Please follow the constraint requirements");
                        a.setHeaderText(null);
                        a.showAndWait();
                }

                editRow = getRow(t);
        }

        @FXML
        void listofleadersemailStartCommit(CellEditEvent<Leaders, String> t) {
                if (editRow == -1) { // no row is being edit, dont care
                }

                else if (getRow(t) == editRow) {// if the I started editing the row i was editing , dont care
                }

                else {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Start Editing");
                        a.setContentText("Please select the previous edited row and SAVE");
                        a.setHeaderText(null);
                        a.showAndWait();
                }
        }

        @FXML
        void listofleadersemailEditCommit(CellEditEvent<Leaders, String> t) {
                if (editRow == -1) {
                        // no row is being edit, dont care
                }
                if (getRow(t) != editRow) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Edit");
                        a.setContentText("Please select the previous edited row and SAVE");
                        a.setHeaderText(null);
                        a.showAndWait();
                        // if the I started editing the row i was editing , I care
                        tableView.getSelectionModel().getSelectedItem().setEmail(t.getOldValue());
                        // set it back to prev value
                }
                // to do your valiidation
                System.out.println(t.getNewValue());
                if (t.getNewValue().length() > 30 || t.getNewValue().isEmpty()) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Edit");
                        a.setContentText("Please follow the constraint requirements");
                        a.setHeaderText(null);
                        a.showAndWait();
                }

                editRow = getRow(t);
        }

        @FXML
        void listofleadersphoneStartCommit(CellEditEvent<Leaders, String> t) {
                if (editRow == -1) { // no row is being edit, dont care
                }

                else if (getRow(t) == editRow) {// if the I started editing the row i was editing , dont care
                }

                else {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Start Editing");
                        a.setContentText("Please select the previous edited row and SAVE");
                        a.setHeaderText(null);
                        a.showAndWait();
                }
        }

        @FXML
        void listofleadersphoneEditCommit(CellEditEvent<Leaders, String> t) {
                if (editRow == -1) {
                        // no row is being edit, dont care
                }
                if (getRow(t) != editRow) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Edit");
                        a.setContentText("Please select the previous edited row and SAVE");
                        a.setHeaderText(null);
                        a.showAndWait();
                        // if the I started editing the row i was editing , I care
                        tableView.getSelectionModel().getSelectedItem().setPhone(t.getOldValue());
                        // set it back to prev value
                }
                // to do your valiidation
                System.out.println(t.getNewValue());
                if (t.getNewValue().length() > 10 || t.getNewValue().isEmpty()) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Cannot Edit");
                        a.setContentText("Please follow the constraint requirements");
                        a.setHeaderText(null);
                        a.showAndWait();
                }

                editRow = getRow(t);
        }

        @FXML
        void initialize() {
                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert tableView != null
                                : "fx:id=\"tableView\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert LeaderListIDColumn != null
                                : "fx:id=\"LeaderListIDColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert LeaderListCollegeColumn != null
                                : "fx:id=\"LeaderListCollegeColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert LeaderListYearColumn != null
                                : "fx:id=\"LeaderListYearColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert LeaderListRoleColumn != null
                                : "fx:id=\"LeaderListRoleColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert LeaderListEmailColumn != null
                                : "fx:id=\"LeaderListEmailColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert LeaderListPhoneColumn != null
                                : "fx:id=\"LeaderListPhoneColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert BackButton != null
                                : "fx:id=\"BackButton\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert SaveButton != null
                                : "fx:id=\"SaveButton\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert DeleteButton != null
                                : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'LeaderList.fxml'.";

                Response<List<StudentLeader>> response = getLeadersHandler.handle();

                if (response.success()) {

                        List<StudentLeader> leaders = response.getResponse();

                        for (var leader : leaders) {
                                Leaders tbLeaders = new Leaders(Long.valueOf(leader.getId()),
                                                leader.getCollege().getId(), leader.getYear(),
                                                leader.getStudentLeaderRole(), leader.getUserDetail().getEmail(),
                                                leader.getUserDetail().getPhoneNumber());

                                tableView.getItems().add(tbLeaders);
                        }
                }

                LeaderListIDColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leaders, Long>, ObservableValue<Long>>() {
                                        public ObservableValue<Long> call(CellDataFeatures<Leaders, Long> p) {
                                                return new ReadOnlyObjectWrapper<Long>(
                                                                Long.valueOf(p.getValue().getId()));
                                        }
                                });

                LeaderListCollegeColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leaders, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Leaders, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getCollege());
                                        }
                                });

                LeaderListYearColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leaders, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Leaders, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getYear());
                                        }
                                });
                LeaderListRoleColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leaders, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Leaders, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getRole());
                                        }
                                });
                LeaderListEmailColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leaders, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Leaders, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getEmail());
                                        }
                                });
                LeaderListPhoneColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<Leaders, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<Leaders, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPhone());
                                        }
                                });

                LeaderListCollegeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // LeaderListCollegeColumn.setOnEditCommit(new
                // EventHandler<CellEditEvent<Leaders, String>>() {
                // public void handle(CellEditEvent<Leaders, String> t)
                // {
                // System.out.println("It works1!");
                // }

                // });

                LeaderListYearColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // LeaderListYearColumn.setOnEditCommit(new EventHandler<CellEditEvent<Leaders,
                // String>>() {
                // public void handle(CellEditEvent<Leaders, String> t)
                // {
                // System.out.println("It works1!");
                // }

                // });

                LeaderListRoleColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // LeaderListRoleColumn.setOnEditCommit(new EventHandler<CellEditEvent<Leaders,
                // String>>() {
                // public void handle(CellEditEvent<Leaders, String> t)
                // {
                // System.out.println("It works1!");
                // }

                // });

                LeaderListEmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // LeaderListEmailColumn.setOnEditCommit(new EventHandler<CellEditEvent<Leaders,
                // String>>() {
                // public void handle(CellEditEvent<Leaders, String> t)
                // {
                // System.out.println("It works1!");
                // }

                // });

                LeaderListPhoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // LeaderListPhoneColumn.setOnEditCommit(new EventHandler<CellEditEvent<Leaders,
                // String>>() {
                // public void handle(CellEditEvent<Leaders, String> t)
                // {
                // System.out.println("It works1!");
                // }

                // });

        }
}
