package database_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignOutButton;

    @FXML
    private Button AdminStudentButton;

    @FXML
    private Button AdminStudentGroupButton;

    @FXML
    private Button AdminActivityListButton;

    @FXML
    private Button AdminDashboardButton;

    @FXML
    private Button AdminAddAdminButton;

    @FXML
    private Button AdminManageAdminButton;

    @FXML
    private Button AdminLeadersButton;

    @FXML
    void AdminActivityListButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ActivityList.fxml"));
        Scene Activity = new Scene(root);
        //System.out.println("Activity");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Activity);
        window.show();
    }

    @FXML
    void AdminAddAdminButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddAdmin.fxml"));
        Scene Add = new Scene(root);
        //System.out.println("Peer");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Add);

        //window.show();
        window.showAndWait();
    }

    @FXML
    void AdminDashboardButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Scene Dashboard = new Scene(root);
        //System.out.println("Peer");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Dashboard);
        window.show();
    }

    @FXML
    void AdminLeadersButtonOnlick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LeaderList.fxml"));
        Scene Leaders = new Scene(root);
        //System.out.println("Peer");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Leaders);
        window.show();
    }

    @FXML
    void AdminManageAdminButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ManageAdmin.fxml"));
        Scene Manage = new Scene(root);
        //System.out.println("Peer");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Manage);
        window.showAndWait();
    }

    @FXML
    void AdminStudentButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StudentList.fxml"));
        Scene Student = new Scene(root);
        //System.out.println("Peer");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Student);
        window.show();
    }

    @FXML
    void AdminStudentGroupButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StudentGroup.fxml"));
        Scene Group = new Scene(root);
        //System.out.println("Peer");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(Group);
        window.show();
    }

    @FXML
    void SignOutButtonOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene login = new Scene(root);
        //System.out.println("Peer");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(login);
        window.show();
    }

    @FXML
    void initialize() {
        assert SignOutButton != null : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminStudentButton != null : "fx:id=\"AdminStudentButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminStudentGroupButton != null : "fx:id=\"AdminStudentGroupButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminActivityListButton != null : "fx:id=\"AdminActivityListButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminDashboardButton != null : "fx:id=\"AdminDashboardButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminAddAdminButton != null : "fx:id=\"AdminAddAdminButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminManageAdminButton != null : "fx:id=\"AdminManageAdminButton\" was not injected: check your FXML file 'Admin.fxml'.";
        assert AdminLeadersButton != null : "fx:id=\"AdminLeadersButton\" was not injected: check your FXML file 'Admin.fxml'.";

    }
}
