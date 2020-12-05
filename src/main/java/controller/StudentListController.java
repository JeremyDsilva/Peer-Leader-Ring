package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dto.Students;
import entity.Student;
import handler.GetStudentsHandler;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import response.Response;
import javafx.scene.control.TablePosition;

public class StudentListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private TableView<Students> tableview;

    @FXML
    private TableColumn<Students, Long> StudentListStudentIDColumn;

    @FXML
    private TableColumn<Students, String> StudentListStudentNameColumn;

    @FXML
    private TableColumn<Students, String> StudentListStudentEmailColumn;

    @FXML
    private TableColumn<Students, String> StudentListStudentPhoneColumn;

    @FXML
    private TableColumn<Students, String> StudentListCollegeColumn;

    @FXML
    private TableColumn<Students, String> StudentListStudentGroupColumn;

    @FXML
    private Button BackButton;

    @FXML
    private Button SignOutButton;

    @FXML
    private Button SaveButton;

    @FXML
    private Button DeleteButton;

    // boolean editrow = true;

    int editRow = -1;

    final GetStudentsHandler studentsHandler;

    public StudentListController() {
        studentsHandler = new GetStudentsHandler();
    }

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
    void DeleteButtonOnClick(ActionEvent event) {
        // This removed the selected row from the table. The first line selects the ID
        // of the selected cell.
        // Could use it to check
        // todo JEREMY
        // long data = tableview.getSelectionModel().getSelectedItem().getId();
        // System.out.println(data);
        // tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItems());
    }

    @FXML
    void SaveButtonOnClick(ActionEvent event) {

        // todo getData that has cahnged using editRow because editRow contains row
        // number pull the enter row
        // todo Jeremy save the data
        Students s = tableview.getSelectionModel().getSelectedItem();
        System.out.println(s);
        if (s == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Save");
            a.setContentText("Please select a row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
        }
        editRow = -1;

        // todo
        // tableview.setEditable(true);
        // tableview.setSelectionModel(defaultSelectionModel);
        // editrow = true;
        // String data = tableview.getSelectionModel().getSelectedItem().getName();
        // System.out.println(data);
        // if (data.length() > 10) {
        // Alert a = new Alert(Alert.AlertType.ERROR);
        // a.setTitle("Wrong Input");
        // a.setContentText("Please enter Valid Credentials");
        // a.setHeaderText(null);
        // a.showAndWait();
        // }
    }

    int getRow(CellEditEvent<Students, ?> t) {
        // todo
        return t.getTablePosition().getRow();
    }

    @FXML
    void listofstudentsnameEditStart(CellEditEvent<Students, String> t) {

        if (editRow == -1) { // no row is being edit, dont care
        }

        else if (getRow(t) == editRow) {// if the I started editing the row i was editing , dont care
        }

        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Start Editing");
            a.setContentText("Please select the previous edited row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
        }
        // if (editRow == -1) // no row is being edit, dont care
        // return;

        // if (getRow(t) == editRow) // if the I started editing the row i was editing ,
        // dont care
        // return;

        // // to do alert
        // Alert a = new Alert(Alert.AlertType.ERROR);
        // a.setTitle("Wrong Input");
        // a.setContentText("Please enter Valid Credentials");
        // a.setHeaderText(null);
        // a.showAndWait();

    }

    @FXML
    void listofstudentsnameEditCommit(CellEditEvent<Students, String> t) {
        if (editRow == -1) {
            // no row is being edit, dont care
        }
        if (getRow(t) != editRow) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Edit");
            a.setContentText("Please select the previous edited row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
            // if the I started editing the row i was editing , I care
            tableview.getSelectionModel().getSelectedItem().setName(t.getOldValue());
            // set it back to prev value
        }
        // to do your valiidation
        System.out.println(t.getNewValue());
        // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
        if (t.getNewValue().length() > 20 || t.getNewValue().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Edit");
            a.setContentText("Please follow the constraint requirements");
            a.setHeaderText(null);
            a.showAndWait();
        }

        editRow = getRow(t);
    }
    // if (editRow == -1) // no row is being edit, dont care
    // System.out.println("i dont care");
    // else if (getRow(t) != editRow) {
    // Alert a = new Alert(Alert.AlertType.ERROR);
    // a.setTitle("Wrong Input");
    // a.setContentText("Please enter Valid Credentials");
    // a.setHeaderText(null);
    // a.showAndWait();
    // // if the I started editing the row i was editing , I care
    // System.out.println("Error"); // todo
    // // set it back to prev value
    // }

    // // to do your val;idation

    // editRow = getRow(t);
    // // Alert a = new Alert(Alert.AlertType.ERROR);
    // // a.setTitle("Wrong Input");
    // // a.setContentText("Please enter Valid Credentials");
    // // a.setHeaderText(null);
    // // a.showAndWait();

    // tableview.setEditable(false);
    // String data = tableview.getSelectionModel().getSelectedItem().getName();
    // System.out.println(data);
    // if (data.length() > 10) {
    // Alert a = new Alert(Alert.AlertType.ERROR);
    // a.setTitle("Wrong Input");
    // a.setContentText("Please enter Valid Credentials");
    // a.setHeaderText(null);
    // a.showAndWait();

    // checking();
    // TablePosition tp = tableview.getSelectionModel().getSelectedCells().get(1);
    // System.out.println("tp");
    // int row = tp.getRow();
    // Students item = tableview.getItems().get(row);
    // TableColumn tc = tp.getTableColumn();
    // String data = (String) tc.getCellObservableValue(item).getValue();
    // System.out.println(data);

    @FXML
    void listofstudentsemailEditStart(CellEditEvent<Students, String> t) {
        if (editRow == -1) { // no row is being edit, dont care
        }

        else if (getRow(t) == editRow) {// if the I started editing the row i was editing , dont care
        }

        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Start Editing");
            a.setContentText("Please select the previous edited row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    @FXML
    void listofstudentsemailEditCommit(CellEditEvent<Students, String> t) {

        if (editRow == -1) {
            // no row is being edit, dont care
        }
        if (getRow(t) != editRow) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Edit");
            a.setContentText("Please select the previous edited row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
            // if the I started editing the row i was editing , I care
            tableview.getSelectionModel().getSelectedItem().setEmail(t.getOldValue());
            // set it back to prev value
        }
        // to do your valiidation
        System.out.println(t.getNewValue());
        // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
        if (t.getNewValue().length() > 30 || t.getNewValue().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Edit");
            a.setContentText("Please follow the constraint requirements");
            a.setHeaderText(null);
            a.showAndWait();
        }

        editRow = getRow(t);
        // if (editRow == -1) // no row is being edit, dont care
        // System.out.println("i dont care");
        // else if (getRow(t) != editRow) { // if the I started editing the row i was
        // editing , I care
        // System.out.println("Error"); // todo
        // // set it back to prev value
        // }

        // // to do your val;idation

        // editRow = getRow(t);

        // System.out.println("Commit1");
    }

    @FXML
    void listofstudentsphoneEditStart(CellEditEvent<Students, String> t) {

        if (editRow == -1) { // no row is being edit, dont care
        }

        else if (getRow(t) == editRow) {// if the I started editing the row i was editing , dont care
        }

        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Start Editing");
            a.setContentText("Please select the previous edited row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    @FXML
    void listofstudentsphoneEditCommit(CellEditEvent<Students, String> t) {
        if (editRow == -1) {
            // no row is being edit, dont care
        }
        if (getRow(t) != editRow) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Edit");
            a.setContentText("Please select the previous edited row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
            // if the I started editing the row i was editing , I care
            tableview.getSelectionModel().getSelectedItem().setPhone(t.getOldValue());
            // set it back to prev value
        }
        // to do your valiidation
        System.out.println(t.getNewValue());
        // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
        if (t.getNewValue().length() > 10 || t.getNewValue().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Edit");
            a.setContentText("Please follow the constraint requirements");
            a.setHeaderText(null);
            a.showAndWait();
        }

        editRow = getRow(t);
    }

    @FXML
    void listofstudentscollegeEditStart(CellEditEvent<Students, String> t) {
        if (editRow == -1) { // no row is being edit, dont care
        }

        else if (getRow(t) == editRow) {// if the I started editing the row i was editing , dont care
        }

        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Start Editing");
            a.setContentText("Please select the previous edited row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    @FXML
    void listofstudentscollegeEditCommit(CellEditEvent<Students, String> t) {
        if (editRow == -1) {
            // no row is being edit, dont care
        }
        if (getRow(t) != editRow) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Edit");
            a.setContentText("Please select the previous edited row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
            // if the I started editing the row i was editing , I care
            tableview.getSelectionModel().getSelectedItem().setCollege(t.getOldValue());
            // set it back to prev value
        }
        // to do your valiidation
        System.out.println(t.getNewValue());
        // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
        if (t.getNewValue().length() > 5 || t.getNewValue().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Edit");
            a.setContentText("Please follow the constraint requirements");
            a.setHeaderText(null);
            a.showAndWait();
        }

        editRow = getRow(t);
    }

    @FXML
    void listofstudentsgroupEditStart(CellEditEvent<Students, String> t) {

        if (editRow == -1) { // no row is being edit, dont care
        }

        else if (getRow(t) == editRow) {// if the I started editing the row i was editing , dont care
        }

        else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Start Editing");
            a.setContentText("Please select the previous edited row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    @FXML
    void listofstudentsgroupEditCommit(CellEditEvent<Students, String> t) {
        if (editRow == -1) {
            // no row is being edit, dont care
        }
        if (getRow(t) != editRow) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Edit");
            a.setContentText("Please select the previous edited row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
            // if the I started editing the row i was editing , I care
            tableview.getSelectionModel().getSelectedItem().setGname(t.getOldValue());
            // set it back to prev value
        }
        // to do your valiidation
        System.out.println(t.getNewValue());
        // FOR SOME REASON THIS CHECKING CRITERIA SHOWS FUNCTION DEFINITON NOT FOUND
        if (t.getNewValue().length() > 20 || t.getNewValue().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Edit");
            a.setContentText("Please follow the constraint requirements");
            a.setHeaderText(null);
            a.showAndWait();
        }

        editRow = getRow(t);
    }

    // void checking()
    // {
    // TablePosition<Students,String> tp =
    // tableview.getSelectionModel().getSelectedCells().get(1);
    // System.out.println("tp");
    // int row = tp.getRow();
    // Students item = tableview.getItems().get(row);
    // TableColumn tc = tp.getTableColumn();
    // String data = (String) tc.getCellObservableValue(item).getValue();
    // System.out.println(data);
    // String data = tableview.getSelectionModel().getSelectedItem().getName();
    // System.out.println(data);
    // if(data.length() >10)
    // {
    // Alert a = new Alert(Alert.AlertType.ERROR);
    // a.setTitle("Wrong Input");
    // a.setContentText("Please enter Valid Credentials");
    // a.setHeaderText(null);
    // a.showAndWait();
    // }

    @FXML
    void initialize() {

        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert tableview != null : "fx:id=\"tableview\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListStudentIDColumn != null
                : "fx:id=\"StudentListStudentIDColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListStudentNameColumn != null
                : "fx:id=\"StudentListStudentNameColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListStudentEmailColumn != null
                : "fx:id=\"StudentListStudentEmailColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListStudentPhoneColumn != null
                : "fx:id=\"StudentListStudentPhoneColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListCollegeColumn != null
                : "fx:id=\"StudentListCollegeColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert StudentListStudentGroupColumn != null
                : "fx:id=\"StudentListStudentGroupColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert SignOutButton != null
                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert SaveButton != null : "fx:id=\"SaveButton\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert DeleteButton != null
                : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'StudentList.fxml'.";
        // TableViewSelectionModel<Students> defaultSelectionModel =
        // tableviewgetSelectionModel();

        // tableview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        Response<List<Student>> response = studentsHandler.handle();

        if (response.success()) {

            List<Student> students = response.getResponse();

            for (var student : students) {

                Students tbStudent = new Students(Long.valueOf(student.getUserDetail().getId()),
                        student.getUserDetail().getFullName(), student.getCollege().getId(),
                        student.getUserDetail().getEmail(), student.getUserDetail().getPhoneNumber(),
                        student.getGroup().getName());

                tableview.getItems().add(tbStudent);
            }
        }
        StudentListStudentIDColumn
                .setCellValueFactory(new Callback<CellDataFeatures<Students, Long>, ObservableValue<Long>>() {
                    public ObservableValue<Long> call(CellDataFeatures<Students, Long> p) {
                        return new ReadOnlyObjectWrapper<Long>(Long.valueOf(p.getValue().getId()));
                    }
                });

        StudentListStudentNameColumn
                .setCellValueFactory(new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                        return new ReadOnlyObjectWrapper<String>(p.getValue().getName());
                    }
                });

        StudentListStudentEmailColumn
                .setCellValueFactory(new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                        return new ReadOnlyObjectWrapper<String>(p.getValue().getEmail());
                    }
                });
        StudentListCollegeColumn
                .setCellValueFactory(new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                        return new ReadOnlyObjectWrapper<String>(p.getValue().getCollege());
                    }
                });
        StudentListStudentPhoneColumn
                .setCellValueFactory(new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                        return new ReadOnlyObjectWrapper<String>(p.getValue().getPhone());
                    }
                });

        StudentListStudentGroupColumn
                .setCellValueFactory(new Callback<CellDataFeatures<Students, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Students, String> p) {
                        return new ReadOnlyObjectWrapper<String>(p.getValue().getGname());
                    }
                });
        // Skipped making the ID editable
        StudentListStudentNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // StudentListStudentNameColumn.setOnEditCommit(new
        // EventHandler<CellEditEvent<Students, String>>() {
        // public void handle(CellEditEvent<Students, String> t) {
        // System.out.println("It works1!");
        // }

        // });

        StudentListStudentEmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // StudentListStudentEmailColumn.setOnEditCommit(new
        // EventHandler<CellEditEvent<Students, String>>() {
        // public void handle(CellEditEvent<Students, String> t) {
        // System.out.println("It works1!");
        // }

        // });

        StudentListStudentPhoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // StudentListStudentPhoneColumn.setOnEditCommit(new
        // EventHandler<CellEditEvent<Students, String>>() {
        // public void handle(CellEditEvent<Students, String> t) {
        // System.out.println("It works1!");
        // }

        // });

        StudentListCollegeColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // StudentListCollegeColumn.setOnEditCommit(new
        // EventHandler<CellEditEvent<Students, String>>() {
        // public void handle(CellEditEvent<Students, String> t) {
        // System.out.println("It works1!");
        // }

        // });

        StudentListStudentGroupColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // StudentListStudentGroupColumn.setOnEditCommit(new
        // EventHandler<CellEditEvent<Students, String>>() {
        // public void handle(CellEditEvent<Students, String> t) {
        // System.out.println("It works1!");
        // }

        // });

    }

}