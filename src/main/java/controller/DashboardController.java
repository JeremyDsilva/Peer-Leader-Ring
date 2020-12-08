package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dto.AppUserCount;
import dto.CountPerCollege;
import dto.LeaderCount;
import handler.AppUserCountHandler;
import handler.CountPerCollegeHandler;
import handler.LeaderCountHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DashboardController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Label label;

        @FXML
        private Button BackButton;

        @FXML
        private Button SignOutButton;

        @FXML
        private PieChart AppUserPie;

        @FXML
        private PieChart LeadersPie;

        @FXML
        private StackedBarChart<String, Number> CollegeStudentCount;

        @FXML
        private Label GroupCount;

        @FXML
        private Label ActivityCount;

        @FXML
        private Label StudentCount;

        @FXML
        private Label MaxLeaderCollege;

        @FXML
        private Label MinAttendActivity;

        @FXML
        private Label TLCount;

        @FXML
        private Label ActiveStudent;

        @FXML
        private Label MaxAttendActivity;

        @FXML
        private Label PLCount;

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
                assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert BackButton != null
                                : "fx:id=\"BackButton\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert SignOutButton != null
                                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert AppUserPie != null
                                : "fx:id=\"AppUserPie\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert LeadersPie != null
                                : "fx:id=\"LeadersPie\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert CollegeStudentCount != null
                                : "fx:id=\"CollegeStudentCount\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert GroupCount != null
                                : "fx:id=\"GroupCount\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert ActivityCount != null
                                : "fx:id=\"ActivityCount\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert StudentCount != null
                                : "fx:id=\"StudentCount\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert MaxLeaderCollege != null
                                : "fx:id=\"MaxLeaderCollege\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert MinAttendActivity != null
                                : "fx:id=\"MinAttendActivity\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert TLCount != null : "fx:id=\"TLCount\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert ActiveStudent != null
                                : "fx:id=\"ActiveStudent\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert MaxAttendActivity != null
                                : "fx:id=\"MaxAttendActivity\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert PLCount != null : "fx:id=\"PLCount\" was not injected: check your FXML file 'Dashboard.fxml'.";

                AppUserCount appUserCount = new AppUserCountHandler().handle();

                FXCollections.observableArrayList(new PieChart.Data("Admin", appUserCount.getNumberOfAdmins()),
                                new PieChart.Data("Leaders", appUserCount.getNumberOfLeaders()),
                                new PieChart.Data("Students", appUserCount.getNumberOfStudents()))
                                .forEach(data -> AppUserPie.getData().add(data));

                AppUserPie.setCenterShape(true);
                AppUserPie.setLabelsVisible(false);

                LeaderCount leaderCount = new LeaderCountHandler().handle();

                FXCollections.observableArrayList(new PieChart.Data("Team Leaders", leaderCount.getTeamLeaderCount()),
                                new PieChart.Data("Peer Leaders", leaderCount.getPeerLeaderCount()))
                                .forEach(data -> LeadersPie.getData().add(data));

                LeadersPie.setCenterShape(true);
                LeadersPie.setLabelsVisible(false);

                // final String CEN = "CEN";
                // final String CAAD = "CAAD";
                // final String CAS = "CAS";
                // final String SBA = "SBA";

                final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();

                xAxis.setLabel("College");
                yAxis.setLabel("Value");

                XYChart.Series series1 = new XYChart.Series();
                XYChart.Series series2 = new XYChart.Series();

                series1.setName("Students");
                series2.setName("Leaders");

                CountPerCollege countPerCollege = new CountPerCollegeHandler().handle();

                countPerCollege.getStudents().forEach(
                                data -> series1.getData().add(new XYChart.Data((String) data[0], (Long) data[1])));

                countPerCollege.getLeaders().forEach(
                                data -> series2.getData().add(new XYChart.Data((String) data[0], (Long) data[1])));

                // series1.getData().add(new XYChart.Data(CEN,
                // countPerCollege.getStudents().size()));
                // series1.getData().add(new XYChart.Data(CAAD, 20148.82));
                // series1.getData().add(new XYChart.Data(CAS, 10000));
                // series1.getData().add(new XYChart.Data(SBA, 35407.15));

                // series2.getData().add(new XYChart.Data(CEN, 57401.85));
                // series2.getData().add(new XYChart.Data(CAAD, 41941.19));
                // series2.getData().add(new XYChart.Data(CAS, 45263.37));
                // series2.getData().add(new XYChart.Data(SBA, 117320.16));

                CollegeStudentCount.getData().addAll(series1, series2);

                GroupCount.setText("0");
                ActivityCount.setText("0");
                StudentCount.setText(String.valueOf(appUserCount.getNumberOfStudents()));
                MaxLeaderCollege.setText("0");
                MinAttendActivity.setText("0");
                TLCount.setText(String.valueOf(leaderCount.getTeamLeaderCount()));
                ActiveStudent.setText("0");
                MaxAttendActivity.setText("0");
                PLCount.setText(String.valueOf(leaderCount.getPeerLeaderCount()));

        }
}
