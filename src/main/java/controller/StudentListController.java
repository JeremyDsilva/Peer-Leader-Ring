package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import app.AppContext;
import dto.Student;
import handler.GetStudentsHandler;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import response.Response;
import util.Helper;

public class StudentListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, String> IDColumn;

    @FXML
    private TableColumn<Student, String> NameColumn;

    @FXML
    private TableColumn<Student, String> EmailColumn;

    @FXML
    private TableColumn<Student, String> PhoneColumn;

    @FXML
    private TableColumn<Student, String> CollegeColumn;

    @FXML
    private TableColumn<Student, String> GroupColumn;

    @FXML
    private Button BackButton;

    @FXML
    private Button SignOutButton;

    @FXML
    private Button SaveButton;

    @FXML
    private Button DeleteButton;

    int editRow = -1;

    final GetStudentsHandler studentsHandler;

    public StudentListController() {
        studentsHandler = new GetStudentsHandler();

    }

    @FXML
    void BackButtonOnClick(ActionEvent event) throws IOException {
        Helper.loadView(getClass().getResource("Admin.fxml"));

    }

    @FXML
    void SignOutButtonOnClick(ActionEvent event) throws IOException {
        Helper.loadView(getClass().getResource("Login.fxml"));
    }

    @FXML
    void DeleteButtonOnClick(ActionEvent event) {
        if (!Helper.onDeleteCheck(editRow))
            return;

        var toDelete = tableView.getSelectionModel().getSelectedItem();

        int index = tableView.getItems().indexOf(toDelete);

        if (index + 1 == tableView.getItems().size()) {
            Helper.createErrorAlert("ERROR", "Invalid Selection");
            return;
        }

        var response = toDelete.delete();

        if (response.success()) {
            tableView.getItems().remove(index);
            tableView.refresh();
            Helper.createSuccessAlert("SUCCESS", "Student deleted successfully");
        } else
            Helper.createErrorAlert("ERROR", response.getException().getMessage());
    }

    @FXML
    void SaveButtonOnClick(ActionEvent event) {
        if (editRow == -1) {
            Helper.createErrorAlert("ERROR", "No row was been modified");
        } else {
            if (editRow + 1 == tableView.getItems().size()
                    && (tableView.getItems().get(editRow).getId().equals("<Insert>")
                            || tableView.getItems().get(editRow).getCollege().equals("<Insert>")
                            || tableView.getItems().get(editRow).getEmail().equals("<Insert>")
                            || tableView.getItems().get(editRow).getGroupName().equals("<Insert>")
                            || tableView.getItems().get(editRow).getName().equals("<Insert>")
                            || tableView.getItems().get(editRow).getPhone().equals("<Insert>"))) {
                Helper.createErrorAlert("ERROR", "Insert all values");
                return;
            }

            var respone = tableView.getItems().get(editRow).updateOrSave();

            if (respone.hasException()) {
                Helper.createErrorAlert("ERROR", respone.getException().getMessage());

                var resetResponse = tableView.getItems().get(editRow).reset();

                if (resetResponse.hasException()) {
                    Helper.createErrorAlert("DATABASE ERROR", resetResponse.getException().getMessage());
                    tableView.getItems().remove(editRow);
                }
            } else {
                if (editRow + 1 == tableView.getItems().size()) {
                    tableView.getItems()
                            .add(new Student("<Insert>", "<Insert>", "<Insert>", "<Insert>", "<Insert>", "<Insert>"));
                }
                Helper.createSuccessAlert("SUCCESS", "Student saved successfully");
            }

            tableView.refresh();

            editRow = -1;
        }

    }

    @FXML
    void idEditStart(CellEditEvent<Student, String> t) {
        int row = editRow != -1 ? editRow : Helper.getRow(t);

        if (row + 1 == tableView.getItems().size())
            return;

        if (editRow != -1) {
            Helper.createErrorAlert("ERROR", "Save Changes first");
            return;
        }

        AppContext.put("studentId", Long.parseLong(tableView.getSelectionModel().getSelectedItem().getId()));

        Helper.loadView(getClass().getResource("StudentView.fxml"));
    }

    @FXML
    void idEditCommit(CellEditEvent<Student, String> t) {
        int row = editRow != -1 ? editRow : Helper.getRow(t);
        if (row + 1 != tableView.getItems().size())
            Helper.createErrorAlert("ERROR: Cannot Edit", "ID is not editable");

        if (!Helper.onEditCommitCheck(t, editRow)) {
            tableView.refresh();
            return;
        }

        if (!Helper.isNumeric(t.getNewValue()) || t.getNewValue().isEmpty()) {
            Helper.createErrorAlert("ERROR: Cannot Edit", "Please follow the constraint requirements");
            tableView.refresh();
        } else {
            editRow = Helper.getRow(t);
            tableView.getSelectionModel().getSelectedItem().setId(t.getNewValue());
        }

    }

    @FXML
    void nameEditStart(CellEditEvent<Student, String> t) {

        Helper.onEditStartCheck(t, editRow);
    }

    @FXML
    void nameEditCommit(CellEditEvent<Student, String> t) {
        if (!Helper.onEditCommitCheck(t, editRow)) {
            tableView.refresh();
            return;
        }

        if (t.getNewValue().length() > 30 || t.getNewValue().isEmpty()) {
            Helper.createErrorAlert("ERROR: Cannot Edit", "Please follow the constraint requirements");
            tableView.refresh();
        } else {
            editRow = Helper.getRow(t);
            tableView.getSelectionModel().getSelectedItem().setName(t.getNewValue());
        }
    }

    @FXML
    void emailEditStart(CellEditEvent<Student, String> t) {
        Helper.onEditStartCheck(t, editRow);

    }

    @FXML
    void emailEditCommit(CellEditEvent<Student, String> t) {

        if (!Helper.onEditCommitCheck(t, editRow)) {
            tableView.refresh();
            return;
        }

        System.out.println(t.getNewValue());
        if (t.getNewValue().length() > 30 || t.getNewValue().isEmpty() || !Helper.emailValidate(t.getNewValue())) {
            Helper.createErrorAlert("ERROR: Cannot Edit", "Please follow the constraint requirements");
            tableView.refresh();
        } else {
            editRow = Helper.getRow(t);
            tableView.getSelectionModel().getSelectedItem().setEmail(t.getNewValue());
        }
    }

    @FXML
    void phoneEditStart(CellEditEvent<Student, String> t) {

        Helper.onEditStartCheck(t, editRow);

    }

    @FXML
    void phoneEditCommit(CellEditEvent<Student, String> t) {
        if (!Helper.onEditCommitCheck(t, editRow)) {
            tableView.refresh();
            return;
        }

        System.out.println(t.getNewValue());
        if (t.getNewValue().length() > 12 || !Helper.isNumeric(t.getNewValue())) {
            Helper.createErrorAlert("ERROR: Cannot Edit", "Please follow the constraint requirements");
            tableView.refresh();
        } else {
            editRow = Helper.getRow(t);
            tableView.getSelectionModel().getSelectedItem().setPhone(t.getNewValue());
        }
    }

    @FXML
    void collegeEditStart(CellEditEvent<Student, String> t) {
        Helper.onEditStartCheck(t, editRow);

    }

    @FXML
    void collegeEditCommit(CellEditEvent<Student, String> t) {
        if (!Helper.onEditCommitCheck(t, editRow)) {
            tableView.refresh();
            return;
        }

        if (t.getNewValue().length() > 5 || t.getNewValue().isEmpty()
                || (!t.getNewValue().equals("CEN") && !t.getNewValue().equals("CAAD") && !t.getNewValue().equals("CAS")
                        && !t.getNewValue().equals("SBA"))) {
            Helper.createErrorAlert("ERROR: Cannot Edit", "Please follow the constraint requirements");
            tableView.refresh();
        } else {
            editRow = Helper.getRow(t);
            tableView.getSelectionModel().getSelectedItem().setCollege(t.getNewValue());
        }
    }

    @FXML
    void groupEditStart(CellEditEvent<Student, String> t) {

        Helper.onEditStartCheck(t, editRow);

    }

    @FXML
    void groupEditCommit(CellEditEvent<Student, String> t) {
        if (!Helper.onEditCommitCheck(t, editRow)) {
            tableView.refresh();
            return;
        }

        if (t.getNewValue().length() > 20) {
            Helper.createErrorAlert("ERROR: Cannot Edit", "Please follow the constraint requirements");
            tableView.refresh();
        } else {
            editRow = Helper.getRow(t);
            tableView.getSelectionModel().getSelectedItem().setGroupName(t.getNewValue());
        }
    }

    @FXML
    void initialize() {

        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert tableView != null : "fx:id=\"tableview\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert IDColumn != null : "fx:id=\" IDColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert NameColumn != null : "fx:id=\" NameColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert EmailColumn != null : "fx:id=\"EmailColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert PhoneColumn != null : "fx:id=\"PhoneColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert CollegeColumn != null
                : "fx:id=\"CollegeColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert GroupColumn != null
                : "fx:id=\" GroupColumn\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert SignOutButton != null
                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert SaveButton != null : "fx:id=\"SaveButton\" was not injected: check your FXML file 'StudentList.fxml'.";
        assert DeleteButton != null
                : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'StudentList.fxml'.";

        Task<List<Student>> loadDataTask = new Task<List<Student>>() {
            @Override
            protected List<Student> call() throws Exception {

                Response<List<entity.Student>> response = studentsHandler.handle();

                if (response.success()) {

                    List<Student> data = new ArrayList<Student>();

                    response.getResponse().forEach(dbStudent -> data.add(new Student(dbStudent)));
                    data.add(new Student("<Insert>", "<Insert>", "<Insert>", "<Insert>", "<Insert>", "<Insert>"));
                    return data;
                } else {
                    throw new Exception();
                }

            }

        };

        loadDataTask.setOnSucceeded(e -> tableView.getItems().setAll(loadDataTask.getValue()));
        loadDataTask.setOnFailed(e -> Helper.createErrorAlert("ERROR", "Cannot load data"));

        ProgressIndicator progressIndicator = new ProgressIndicator();
        tableView.setPlaceholder(progressIndicator);

        Thread loadDataThread = new Thread(loadDataTask);
        loadDataThread.start();

        IDColumn.setCellValueFactory(new Callback<CellDataFeatures<Student, String>, ObservableValue<String>>() {

            public ObservableValue<String> call(CellDataFeatures<Student, String> p) {
                return new ReadOnlyObjectWrapper<String>(p.getValue().getId());
            }
        });

        NameColumn.setCellValueFactory(new Callback<CellDataFeatures<Student, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<Student, String> p) {
                return new ReadOnlyObjectWrapper<String>(p.getValue().getName());
            }
        });

        EmailColumn.setCellValueFactory(new Callback<CellDataFeatures<Student, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<Student, String> p) {
                return new ReadOnlyObjectWrapper<String>(p.getValue().getEmail());
            }
        });
        CollegeColumn.setCellValueFactory(new Callback<CellDataFeatures<Student, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<Student, String> p) {
                return new ReadOnlyObjectWrapper<String>(p.getValue().getCollege());
            }
        });
        PhoneColumn.setCellValueFactory(new Callback<CellDataFeatures<Student, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<Student, String> p) {
                return new ReadOnlyObjectWrapper<String>(p.getValue().getPhone());
            }
        });

        GroupColumn.setCellValueFactory(new Callback<CellDataFeatures<Student, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<Student, String> p) {
                return new ReadOnlyObjectWrapper<String>(p.getValue().getGroupName());
            }
        });

        IDColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        EmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PhoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CollegeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        GroupColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } // sleep for one tenth a second
    }

}