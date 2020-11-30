package database_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

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
    void BackButtonOnClick(ActionEvent event) {

    }

    @FXML
    void LeaderListAddButtonOnClick(ActionEvent event) {

    }

    @FXML
    void LeaderListManageButtonOnClick(ActionEvent event) {

    }

    @FXML
    void SignOutButtonOnClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'LeaderList.fxml'.";
        assert LeaderListIDColumn != null : "fx:id=\"LeaderListIDColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
        assert LeaderListCollegeColumn != null : "fx:id=\"LeaderListCollegeColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
        assert LeaderListYearColumn != null : "fx:id=\"LeaderListYearColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
        assert LeaderListRoleColumn != null : "fx:id=\"LeaderListRoleColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
        assert LeaderListEmailColumn != null : "fx:id=\"LeaderListEmailColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
        assert LeaderListPhoneColumn != null : "fx:id=\"LeaderListPhoneColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
        assert LeaderListActiveColumn != null : "fx:id=\"LeaderListActiveColumn\" was not injected: check your FXML file 'LeaderList.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'LeaderList.fxml'.";
        assert SignOutButton != null : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'LeaderList.fxml'.";
        assert LeaderListAddButton != null : "fx:id=\"LeaderListAddButton\" was not injected: check your FXML file 'LeaderList.fxml'.";
        assert LeaderListManageButton != null : "fx:id=\"LeaderListManageButton\" was not injected: check your FXML file 'LeaderList.fxml'.";

    }
}
