package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.AppContext;
import entity.Group;
import entity.StudentLeader;
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

public class LeaderListController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label label;

        @FXML
        private TableColumn<?, ?> LeaderListIDColumn;

        @FXML
        private TableColumn<?, ?> LeaderListCollegeColumn;

        @FXML
        private TableColumn<?, ?> LeaderListYearColumn;

        @FXML
        private TableColumn<?, ?> LeaderListRoleColumn;

        @FXML
        private TableColumn<?, ?> LeaderListEmailColumn;

        @FXML
        private TableColumn<?, ?> LeaderListPhoneColumn;

        @FXML
        private TableColumn<?, ?> LeaderListActiveColumn;

        @FXML
        private Button BackButton;

        @FXML
        private Button SignOutButton;

        @FXML
        private Button LeaderListAddButton;

        @FXML
        private Button LeaderListManageButton;

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
        void LeaderListAddButtonOnClick(ActionEvent event) {
                // todo

        }

        @FXML
        void LeaderListManageButtonOnClick(ActionEvent event) {
                // todo

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
        void initialize() {
                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'LeaderList.fxml'.";
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
                assert LeaderListActiveColumn != null
                                : "fx:id=\"LeaderListActiveColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert BackButton != null
                                : "fx:id=\"BackButton\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert LeaderListAddButton != null
                                : "fx:id=\"LeaderListAddButton\" was not injected: check your FXML file 'LeaderList.fxml'.";
                assert LeaderListManageButton != null
                                : "fx:id=\"LeaderListManageButton\" was not injected: check your FXML file 'LeaderList.fxml'.";

        }
}
