package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.AppContext;
import entity.Group;
import entity.StudentLeader;
import entity.User;
import handler.GetGroupHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.scene.Node;

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
        private TableColumn<?, ?> TeamLeaderPeerLeaderIDColumn;

        @FXML
        private TableColumn<?, ?> TeamLeaderPeerLeaderNameColumn;

        @FXML
        private TableColumn<?, ?> TeamLeaderPeerLeaderEmailColumn;

        @FXML
        private TableColumn<?, ?> TeamLeaderPeerLeaderPhoneColumn;

        @FXML
        private TableColumn<?, ?> TeamLeaderGroupNameColumn;

        @FXML
        private TableColumn<?, ?> TeamLeaderActiveColumn;

        @FXML
        private Button TeamLeaderViewActivityListButton;

        @FXML
        private Button TeamLeaderViewPeerButton;

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
                // Parent root = FXMLLoader.load(getClass().getResource("ActivityList.fxml"));
                // Scene Logout = new Scene(root);
                // Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // window.setScene(Logout);
                // window.show();
        }

        @FXML
        void TeamLeaderViewPeerOnClick(ActionEvent event) throws IOException {
                // todo
                // Parent root = FXMLLoader.load(getClass().getResource("LeaderList.fxml"));
                // Scene Logout = new Scene(root);
                // Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // window.setScene(Logout);
                // window.show();
        }

        // ObservableList<String> ListOfActivites =
        // FXCollections.observableArrayList("Yash","Iffa","Jeremy");
        @FXML
        void initialize() {
                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
                assert TeamLeaderNameLabel != null
                                : "fx:id=\"TeamLeaderNameLabel\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
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
                assert TeamLeaderActiveColumn != null
                                : "fx:id=\"TeamLeaderActiveColumn\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
                assert TeamLeaderViewActivityListButton != null
                                : "fx:id=\"TeamLeaderViewActivityListButton\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
                assert TeamLeaderViewPeerButton != null
                                : "fx:id=\"TeamLeaderViewPeerButton\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";

                // ListOfActivitiesComboBox.setValue("Iffa");
                // ListOfActivitiesComboBox.setItems(ListOfActivites);
        }

}
