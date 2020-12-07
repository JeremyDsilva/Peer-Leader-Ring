package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private BarChart<?, ?> GroupStudentCountBar;

    @FXML
    private PieChart AppUserPie;

    @FXML
    private LineChart<?, ?> AvgLine;

    @FXML
    void BackButtonOnClick(ActionEvent event) {

    }

    @FXML
    void SignOutButtonOnClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert SignOutButton != null : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert GroupStudentCountBar != null : "fx:id=\"GroupStudentCountBar\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert AppUserPie != null : "fx:id=\"AppUserPie\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert AvgLine != null : "fx:id=\"AvgLine\" was not injected: check your FXML file 'Dashboard.fxml'.";
        
                
         ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Grapefruit", 13),
                new PieChart.Data("Oranges", 25),
                new PieChart.Data("Plums", 10),
                new PieChart.Data("Pears", 22),
                new PieChart.Data("Apples", 30));
        
        AppUserPie.getData().add(pieChartData);

    }
}
