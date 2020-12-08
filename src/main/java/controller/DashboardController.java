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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import util.Helper;

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
        private Label AvgStudentCount;

        @FXML
        private Label AvgActivityCount;

        @FXML
        private Label AvgPeerLeaderCount;

        @FXML
        private Label GroupCount;

        @FXML
        private Label ActivityCount;

        @FXML
        private Label SeniorCount;

        @FXML
        private Label MinAttendActivity;

        @FXML
        private Label ActiveStudent;

        @FXML
        private Label MaxAttendActivity;

        @FXML
        void BackButtonOnClick(ActionEvent event) throws IOException {
                Helper.loadView(getClass().getResource("Admin.fxml"));
        }

        @FXML
        void SignOutButtonOnClick(ActionEvent event) throws IOException {
                Helper.loadView(getClass().getResource("Login.fxml"));
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
                assert AvgStudentCount != null
                                : "fx:id=\"AvgStudentCount\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert AvgActivityCount != null
                                : "fx:id=\"AvgActivityCount\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert MinAttendActivity != null
                                : "fx:id=\"MinAttendActivity\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert SeniorCount != null
                                : "fx:id=\"SeniorCount\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert ActiveStudent != null
                                : "fx:id=\"ActiveStudent\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert MaxAttendActivity != null
                                : "fx:id=\"MaxAttendActivity\" was not injected: check your FXML file 'Dashboard.fxml'.";
                assert AvgPeerLeaderCount != null
                                : "fx:id=\"AvgPeerLeaderCount\" was not injected: check your FXML file 'Dashboard.fxml'.";

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

                CollegeStudentCount.getData().addAll(series1, series2);

                GroupCount.setText("0");
                ActivityCount.setText("0");
                SeniorCount.setText("0");
                AvgActivityCount.setText("0");
                AvgPeerLeaderCount.setText(String
                                .valueOf(leaderCount.getPeerLeaderCount() * 1.0 / leaderCount.getTeamLeaderCount()));
                AvgStudentCount.setText(String
                                .valueOf(appUserCount.getNumberOfStudents() * 1.0 / appUserCount.getNumberOfLeaders()));
                MinAttendActivity.setText("0");
                ActiveStudent.setText("0");
                MaxAttendActivity.setText("0");

        }
}
