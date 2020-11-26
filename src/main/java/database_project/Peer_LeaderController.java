package database_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class Peer_LeaderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private Label PeerLeaderTeamLeaderNameLabel;

    @FXML
    private Text PeerLeaderGroupName;

    @FXML
    private Text PeerLEaderTeamLeaderName;

    @FXML
    private ComboBox<?> ListOfActivitiesComboBox;

    @FXML
    private Label PeerLeaderListOfActivitesLabel;

    @FXML
    private Button MarkAttendanceButton;

    @FXML
    private TableView<?> PeerLeaderTable;

    @FXML
    private TableColumn<?, ?> PeerLeaderTableID;

    @FXML
    private TableColumn<?, ?> PeerLeaderTableName;

    @FXML
    private TableColumn<?, ?> PeerLeaderTableCollege;

    @FXML
    private TableColumn<?, ?> PeerLeaderTableYear;

    @FXML
    private TableColumn<?, ?> PeerLeaderTableStatus;

    @FXML
    private Button PeerLeaderSubmitButton;

    @FXML
    private Label PeerLeaderNameLabel;

    @FXML
    private Label PeerLeaderGroupNameLabel;

    @FXML
    private Text PeerLeaderName;

    @FXML
    void MarkAttendanceOnClick(ActionEvent event) {
     ////todo   
    }

    @FXML
    void PeerLeaderSubmitButtonOnClick(ActionEvent event) {
    //todo
    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderTeamLeaderNameLabel != null : "fx:id=\"PeerLeaderTeamLeaderNameLabel\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderGroupName != null : "fx:id=\"PeerLeaderGroupName\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLEaderTeamLeaderName != null : "fx:id=\"PeerLEaderTeamLeaderName\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert ListOfActivitiesComboBox != null : "fx:id=\"ListOfActivitiesComboBox\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderListOfActivitesLabel != null : "fx:id=\"PeerLeaderListOfActivitesLabel\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert MarkAttendanceButton != null : "fx:id=\"MarkAttendanceButton\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderTable != null : "fx:id=\"PeerLeaderTable\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderTableID != null : "fx:id=\"PeerLeaderTableID\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderTableName != null : "fx:id=\"PeerLeaderTableName\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderTableCollege != null : "fx:id=\"PeerLeaderTableCollege\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderTableYear != null : "fx:id=\"PeerLeaderTableYear\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderTableStatus != null : "fx:id=\"PeerLeaderTableStatus\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderSubmitButton != null : "fx:id=\"PeerLeaderSubmitButton\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderNameLabel != null : "fx:id=\"PeerLeaderNameLabel\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderGroupNameLabel != null : "fx:id=\"PeerLeaderGroupNameLabel\" was not injected: check your FXML file 'Peer_Leader.fxml'.";
        assert PeerLeaderName != null : "fx:id=\"PeerLeaderName\" was not injected: check your FXML file 'Peer_Leader.fxml'.";

    }
}
