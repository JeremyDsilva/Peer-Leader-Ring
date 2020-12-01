package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

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
    void SignOutButtonOnClick(ActionEvent event) {

    }

    @FXML
    void TeamLeaderViewActivityListOnClick(ActionEvent event) {

    }

    @FXML
    void TeamLeaderViewPeerOnClick(ActionEvent event) {

    }
    // ObservableList<String> ListOfActivites = FXCollections.observableArrayList("Yash","Iffa","Jeremy");
    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
        assert TeamLeaderNameLabel != null : "fx:id=\"TeamLeaderNameLabel\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
        assert SignOutButton != null : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
        assert TeamLeaderPeerLeaderIDColumn != null : "fx:id=\"TeamLeaderPeerLeaderIDColumn\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
        assert TeamLeaderPeerLeaderNameColumn != null : "fx:id=\"TeamLeaderPeerLeaderNameColumn\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
        assert TeamLeaderPeerLeaderEmailColumn != null : "fx:id=\"TeamLeaderPeerLeaderEmailColumn\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
        assert TeamLeaderPeerLeaderPhoneColumn != null : "fx:id=\"TeamLeaderPeerLeaderPhoneColumn\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
        assert TeamLeaderGroupNameColumn != null : "fx:id=\"TeamLeaderGroupNameColumn\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
        assert TeamLeaderActiveColumn != null : "fx:id=\"TeamLeaderActiveColumn\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
        assert TeamLeaderViewActivityListButton != null : "fx:id=\"TeamLeaderViewActivityListButton\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";
        assert TeamLeaderViewPeerButton != null : "fx:id=\"TeamLeaderViewPeerButton\" was not injected: check your FXML file 'PeerLeaderList.fxml'.";


        // ListOfActivitiesComboBox.setValue("Iffa");
        // ListOfActivitiesComboBox.setItems(ListOfActivites);
    }
    
}
