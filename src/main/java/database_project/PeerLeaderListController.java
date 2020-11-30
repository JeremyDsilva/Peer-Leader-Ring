package database_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class Team_LeaderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private Label TeamLeaderTeamLeaderNameLabel;

    @FXML
    private Text TeamLeaderGroupName;

    @FXML
    private Text TeamLeaderTeamLeaderName;

    @FXML
    private TableView<?> TeamLeaderTable;

    @FXML
    private TableColumn<?, ?> TeamLeaderTableID;

    @FXML
    private TableColumn<?, ?> TeamLeaderTableName;

    @FXML
    private TableColumn<?, ?> TeamLeaderTableCollege;

    @FXML
    private TableColumn<?, ?> TeamLeaderTableYear;

    @FXML
    private TableColumn<?, ?> TeamLeaderTableStatus;

    @FXML
    private Label TeamLeaderNameLabel;

    @FXML
    private Label TeamLeaderGroupNameLabel;

    @FXML
    private Text TeamLeaderName;

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Team_Leader.fxml'.";
        assert TeamLeaderTeamLeaderNameLabel != null : "fx:id=\"TeamLeaderTeamLeaderNameLabel\" was not injected: check your FXML file 'Team_Leader.fxml'.";
        assert TeamLeaderGroupName != null : "fx:id=\"TeamLeaderGroupName\" was not injected: check your FXML file 'Team_Leader.fxml'.";
        assert TeamLeaderTeamLeaderName != null : "fx:id=\"TeamLeaderTeamLeaderName\" was not injected: check your FXML file 'Team_Leader.fxml'.";
        assert TeamLeaderTable != null : "fx:id=\"TeamLeaderTable\" was not injected: check your FXML file 'Team_Leader.fxml'.";
        assert TeamLeaderTableID != null : "fx:id=\"TeamLeaderTableID\" was not injected: check your FXML file 'Team_Leader.fxml'.";
        assert TeamLeaderTableName != null : "fx:id=\"TeamLeaderTableName\" was not injected: check your FXML file 'Team_Leader.fxml'.";
        assert TeamLeaderTableCollege != null : "fx:id=\"TeamLeaderTableCollege\" was not injected: check your FXML file 'Team_Leader.fxml'.";
        assert TeamLeaderTableYear != null : "fx:id=\"TeamLeaderTableYear\" was not injected: check your FXML file 'Team_Leader.fxml'.";
        assert TeamLeaderTableStatus != null : "fx:id=\"TeamLeaderTableStatus\" was not injected: check your FXML file 'Team_Leader.fxml'.";
        assert TeamLeaderNameLabel != null : "fx:id=\"TeamLeaderNameLabel\" was not injected: check your FXML file 'Team_Leader.fxml'.";
        assert TeamLeaderGroupNameLabel != null : "fx:id=\"TeamLeaderGroupNameLabel\" was not injected: check your FXML file 'Team_Leader.fxml'.";
        assert TeamLeaderName != null : "fx:id=\"TeamLeaderName\" was not injected: check your FXML file 'Team_Leader.fxml'.";

    }
}
