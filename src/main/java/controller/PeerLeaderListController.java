package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.AppContext;
import dto.PeerLeader;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import response.Response;
import util.Helper;

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
        private Button ChangePasswordButton;    

        @FXML
        private TableView<PeerLeader> tableview;

        @FXML
        private TableColumn<PeerLeader, Long> TeamLeaderPeerLeaderIDColumn;

        @FXML
        private TableColumn<PeerLeader, String> TeamLeaderPeerLeaderNameColumn;

        @FXML
        private TableColumn<PeerLeader, String> TeamLeaderPeerLeaderEmailColumn;

        @FXML
        private TableColumn<PeerLeader, String> TeamLeaderPeerLeaderPhoneColumn;

        @FXML
        private TableColumn<PeerLeader, String> TeamLeaderGroupNameColumn;

        @FXML
        private Button TeamLeaderViewActivityListButton;

        int editRow = -1;

        final GetGroupsUnderLeaderHandler getGroupsUnderLeaderHandler;

        public PeerLeaderListController() {
                getGroupsUnderLeaderHandler = new GetGroupsUnderLeaderHandler();
        }

        @FXML
        void SignOutButtonOnClick(ActionEvent event) throws IOException {
                Helper.loadView(getClass().getResource("Login.fxml"));

        }

        @FXML
        void ChangePasswordButtonOnClick(ActionEvent event) {
                Helper.loadView(getClass().getResource("ChangePassword.fxml"));
        }
        

        @FXML
        void TeamLeaderViewActivityListOnClick(ActionEvent event) {
               Helper.loadView(getClass().getResource("ActivityList.fxml"));
        }

        @FXML
        public void onClick(MouseEvent event) {
                if (event.getClickCount() == 2) // Checking double click
                {
                        AppContext.put("groupId", tableview.getSelectionModel().getSelectedItem().getGroupId());

                        Helper.loadView(getClass().getResource("GroupList.fxml"));
                }
        }

        @FXML
        void initialize() {
                assert label != null 
                                : "fx:id=\"label\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
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
                assert ChangePasswordButton != null 
                                : "fx:id=\"ChangePasswordButton\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";

                Response<List<Group>> response = getGroupsUnderLeaderHandler.handle(AppContext.getUser().getId());

                TeamLeaderNameLabel.setText(AppContext.getUser().getFullName());

                if (response.success()) {

                        List<Group> groups = response.getResponse();

                        for (var group : groups) {
                                StudentLeader leader = group.getPeerLeader();
                                PeerLeader tbLeaders = new PeerLeader(Long.valueOf(leader.getId()),
                                                leader.getUserDetail().getFullName(),
                                                leader.getUserDetail().getPhoneNumber(),
                                                leader.getUserDetail().getEmail(), group.getName(), group.getId());

                                tableview.getItems().add(tbLeaders);
                        }

                }else {
                        Helper.createErrorAlert("ERROR", "Cannot load page");
                }

                TeamLeaderPeerLeaderIDColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<PeerLeader, Long>, ObservableValue<Long>>() {
                                        public ObservableValue<Long> call(CellDataFeatures<PeerLeader, Long> p) {
                                                return new ReadOnlyObjectWrapper<Long>(
                                                                Long.valueOf(p.getValue().getPid()));
                                        }
                                });

                TeamLeaderPeerLeaderNameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<PeerLeader, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<PeerLeader, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPname());
                                        }
                                });
                TeamLeaderPeerLeaderEmailColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<PeerLeader, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<PeerLeader, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPemail());
                                        }
                                });
                TeamLeaderPeerLeaderPhoneColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<PeerLeader, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<PeerLeader, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPphone());
                                        }
                                });
                TeamLeaderGroupNameColumn.setCellValueFactory(
                                new Callback<CellDataFeatures<PeerLeader, String>, ObservableValue<String>>() {
                                        public ObservableValue<String> call(CellDataFeatures<PeerLeader, String> p) {
                                                return new ReadOnlyObjectWrapper<String>(p.getValue().getPgroupname());
                                        }
                                });

        }

}
