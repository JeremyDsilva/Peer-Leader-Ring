package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import app.AppContext;
import dto.Activities;
import javafx.event.EventHandler;
import handler.LoginHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ActivityListController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label label;

        @FXML
        private TableView<Activities> tableview;

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
        private Button ActivityListAddButton;

        @FXML
        private Button ActivityListManageButton;

        @FXML
        void ActivityListAddButtonOnClick(ActionEvent event) {
                // todo
        }

        @FXML
        void ActivityListManageButtonOnClick(ActionEvent event) {
                // todo
        }

        @FXML
        void BackButtonOnClick(ActionEvent event) throws IOException {
                //No need to check for student login as no BACK BUTTON needed.
                if (AppContext.getUser().getUserRole().equals("leader")) {
                        if (AppContext.getUser().getStudentLeader().getStudentLeaderRole().equals("peer_leader")) {
                                Parent root = FXMLLoader.load(getClass().getResource("GroupList.fxml"));
                                Scene back = new Scene(root);
                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                window.setScene(back);
                                window.show();
                        } else if (AppContext.getUser().getUserRole().equals("team_leader")) {
                                Parent root = FXMLLoader.load(getClass().getResource("PeerLeaderList.fxml"));
                                Scene back = new Scene(root);
                                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                window.setScene(back);
                                window.show();
                        }
                }
                else {
                        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
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
        void activityidEditCommit(ActionEvent event) {
                System.out.println("Commit1");
        }

        @FXML
        void activityidEditStart(ActionEvent event) {
                System.out.println("Edit1");
        }

        @FXML
        void activitynameEditCommit(ActionEvent event) {
                System.out.println("Commit2");
        }

        @FXML
        void activitynameEditStart(ActionEvent event) {
                System.out.println("Edit2");
        }

        @FXML
        void activitydateofactivityEditCommit(ActionEvent event) {
                System.out.println("Commit3");
        }

        @FXML
        void activitydateofactivityEditStart(ActionEvent event) {
                System.out.println("Edit3");
        }

        @FXML
        void activityoragnizedbyEditCommit(ActionEvent event) {
                System.out.println("Commit4");
        }

        @FXML
        void activityorganizedbyEditStart(ActionEvent event) {
                System.out.println("Edit4");
        }

        @FXML
        void activitynoteEditCommit(ActionEvent event) {
                System.out.println("Commit5");
        }

        @FXML
        void activitynoteEditStart(ActionEvent event) {
                System.out.println("Edit5");
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
                assert ActivityListAddButton != null
                                : "fx:id=\"ActivityListAddButton\" was not injected: check your FXML file 'ActivityList.fxml'.";
                assert ActivityListManageButton != null
                                : "fx:id=\"ActivityListManageButton\" was not injected: check your FXML file 'ActivityList.fxml'.";

                // If a STUDENT logs in, he can ONLY view the Acivities list. There is no need
                // of BACK BUTTON. He should directly LOG OUT.
                if (AppContext.getUser().getUserRole().equals("student")) {
                        BackButton.setVisible(false);
                }


                // Haven't done the ID column again
                //Since only admin can edit activities.
                if(AppContext.getUser().getUserRole().equals("admin"))
                {
                ActivityListActivityNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                ActivityListActivityNameColumn.setOnEditCommit(new EventHandler<CellEditEvent<Activities, String>>() {
                        public void handle(CellEditEvent<Activities, String> t) {
                                System.out.println("It works1!");
                        }

                });
                // // Need to check how to make the date editable
                // ActivityListDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // ActivityListDateColumn.setOnEditCommit(new EventHandler<CellEditEvent<Activities, Date>>() {
                // public void handle(CellEditEvent<Activities, Date> t) {
                // System.out.println("It works2!");
                // }
                // });

                ActivityListOrganizedbyColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                ActivityListOrganizedbyColumn.setOnEditCommit(new EventHandler<CellEditEvent<Activities, String>>() {
                        public void handle(CellEditEvent<Activities, String> t) {
                                System.out.println("It works3!");
                        }

                });

                ActivityListNoteColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                ActivityListNoteColumn.setOnEditCommit(new EventHandler<CellEditEvent<Activities, String>>() {
                        public void handle(CellEditEvent<Activities, String> t) {
                                System.out.println("It works4!");
                        }

                });
        }

        }
}
