package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.AppContext;
import dto.PeerLeaders;
import entity.Group;
import entity.StudentLeader;
import handler.GetGroupsUnderLeaderHandler;
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
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import response.Response;

public class PeerLeaderListController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label label;

        @FXML
        private Label TeamLeaderNameLabel;

        @FXML
        private Button SignOutButton;

        @FXML
        private TableView<PeerLeaders> tableview;

        @FXML
        private TableColumn<PeerLeaders, Long> TeamLeaderPeerLeaderIDColumn;

        @FXML
        private TableColumn<PeerLeaders, String> TeamLeaderPeerLeaderNameColumn;

        @FXML
        private TableColumn<PeerLeaders, String> TeamLeaderPeerLeaderEmailColumn;

        @FXML
        private TableColumn<PeerLeaders, String> TeamLeaderPeerLeaderPhoneColumn;

        @FXML
        private TableColumn<PeerLeaders, String> TeamLeaderGroupNameColumn;

        @FXML
        private Button TeamLeaderViewActivityListButton;

        int editRow = -1;

        final GetGroupsUnderLeaderHandler getGroupsUnderLeaderHandler;

        public PeerLeaderListController() {
                getGroupsUnderLeaderHandler = new GetGroupsUnderLeaderHandler();
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
        void TeamLeaderViewActivityListOnClick(ActionEvent event) throws IOException {
                // todo
                Parent root = FXMLLoader.load(getClass().getResource("ActivityList.fxml"));
                Scene Logout = new Scene(root);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(Logout);
                window.show();
        }

        // @FXML
        // void peerleadernameEditCommit(CellEditEvent<PeerLeaders, String> t) {
        // System.out.println("Commit1");
        // }

        // @FXML
        // void peerleadernameEditStart(CellEditEvent<PeerLeaders, String> t) {
        // System.out.println("Edit1");
        // }

        // @FXML
        // void peerleaderemailEditCommit(CellEditEvent<PeerLeaders, String> t) {
        // System.out.println("Commit1");
        // }

        // @FXML
        // void peerleaderemailEditStart(CellEditEvent<PeerLeaders, String> t) {
        // System.out.println("Edit1");
        // }

        // @FXML
        // void peerleaderphoneEditCommit(CellEditEvent<PeerLeaders, String> t) {
        // System.out.println("Commit1");
        // }

        // @FXML
        // void peerleaderphoneEditStart(CellEditEvent<PeerLeaders, String> t) {
        // System.out.println("Edit1");
        // }

        // @FXML
        // void peerleadergroupnameEditCommit(CellEditEvent<PeerLeaders, String> t) {
        // System.out.println("Commit1");
        // }

        // @FXML
        // void peerleadergroupnameEditStart(CellEditEvent<PeerLeaders, String> t) {
        // System.out.println("Edit1");
        // }

        @FXML
        void initialize() {
                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
                assert TeamLeaderNameLabel != null
                                : "fx:id=\"TeamLeaderNameLabel\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
                assert tableview != null
                                : "fx:id=\"tableview\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
                assert TeamLeaderPeerLeaderIDColumn != null
                                : "fx:id=\"TeamLeaderPeerLeaderIDColumn\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
                assert TeamLeaderPeerLeaderNameColumn != null
                                : "fx:id=\"TeamLeaderPeerLeaderNameColumn\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
                assert TeamLeaderPeerLeaderEmailColumn != null
                                : "fx:id=\"TeamLeaderPeerLeaderEmailColumn\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
                assert TeamLeaderPeerLeaderPhoneColumn != null
                                : "fx:id=\"TeamLeaderPeerLeaderPhoneColumn\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
                assert TeamLeaderGroupNameColumn != null
                                : "fx:id=\"TeamLeaderGroupNameColumn\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
                assert TeamLeaderViewActivityListButton != null
                                : "fx:id=\"TeamLeaderViewActivityListButton\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";

                Response<List<Group>> response = getGroupsUnderLeaderHandler.handle(AppContext.getUser().getId());

                TeamLeaderNameLabel.setText(AppContext.getUser().getFullName());

                if (response.success()) {

                        List<Group> groups = response.getResponse();

                        // if(response.getResponse().getStudentLeaderRole().equals("peer_leader")){
                        for (var group : groups) {
                                StudentLeader leader = group.getPeerLeader();
                                PeerLeaders tbLeaders = new PeerLeaders(Long.valueOf(leader.getId()),
                                                leader.getUserDetail().getFullName(),
                                                leader.getUserDetail().getPhoneNumber(),
                                                leader.getUserDetail().getEmail(), group.getName());

                                tableview.getItems().add(tbLeaders);
                        }
                        // }

                }

                TeamLeaderPeerLeaderIDColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<PeerLeaders, Long>, ObservableValue<Long>>() {
                                        public ObservableValue<Long> call(CellDataFeatures<PeerLeaders, Long> p) {
                                                return new ReadOnlyObjectWrapper<Long>(
                                                                Long.valueOf(p.getValue().getPid()));
                                        }
                                });

                TeamLeaderPeerLeaderNameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<PeerLeaders, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<PeerLeaders, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPname());
                                        }
                                });
                TeamLeaderPeerLeaderEmailColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<PeerLeaders, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<PeerLeaders, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPemail());
                                        }
                                });
                TeamLeaderPeerLeaderPhoneColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<PeerLeaders, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<PeerLeaders, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPphone());
                                        }
                                });
                TeamLeaderGroupNameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<PeerLeaders, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<PeerLeaders, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPgroupname());
                                        }
                                });

                // Skipped making the ID editable
                // TeamLeaderPeerLeaderNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // // TeamLeaderPeerLeaderNameColumn.setOnEditCommit(new
                // // EventHandler<CellEditEvent<PeerLeaders, String>>() {
                // // public void handle(CellEditEvent<PeerLeaders, String> t) {
                // // System.out.println("It works1!");
                // // }

                // // });

                // TeamLeaderPeerLeaderEmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // // TeamLeaderPeerLeaderEmailColumn.setOnEditCommit(new
                // // EventHandler<CellEditEvent<PeerLeaders, String>>() {
                // // public void handle(CellEditEvent<PeerLeaders, String> t) {
                // // System.out.println("It works1!");
                // // }

                // // });

                // TeamLeaderPeerLeaderPhoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // // TeamLeaderPeerLeaderPhoneColumn.setOnEditCommit(new
                // // EventHandler<CellEditEvent<PeerLeaders, String>>() {
                // // public void handle(CellEditEvent<PeerLeaders, String> t) {
                // // System.out.println("It works1!");
                // // }

                // // });

                // TeamLeaderGroupNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                // // TeamLeaderGroupNameColumn.setOnEditCommit(new
                // // EventHandler<CellEditEvent<PeerLeaders, String>>() {
                // // public void handle(CellEditEvent<PeerLeaders, String> t) {
                // // System.out.println("It works1!");
                // // }

                // // });

        }

}
