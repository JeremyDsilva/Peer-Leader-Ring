package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.AppContext;
import dto.Admin;
import handler.GetAdminsHandler;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import response.Response;
import util.Helper;

public class ManageAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label;

    @FXML
    private TableView<Admin> tableView;

    @FXML
    private TableColumn<Admin, String> IDColumn;

    @FXML
    private TableColumn<Admin, String> NameColumn;

    @FXML
    private TableColumn<Admin, String> EmailColumn;

    @FXML
    private TableColumn<Admin, String> PhoneColumn;

    @FXML
    private Button BackButton;

    @FXML
    private Button SignOutButton;

    @FXML
    private Button SaveButton;

    @FXML
    private Button DeleteButton;

    int editRow = -1;

    final GetAdminsHandler getAdminsHandler;

    public ManageAdminController() {
        getAdminsHandler = new GetAdminsHandler();
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
            Helper.createSuccessAlert("SUCCESS", "Admin deleted successfully");
        } else
            Helper.createErrorAlert("ERROR", response.getException().getMessage());
    }

    @FXML
    void SaveButtonOnClick(ActionEvent event) {
        if (editRow == -1) {
            Helper.createErrorAlert("ERROR", "No row was been modified");
        } else {
            var respone = tableView.getItems().get(editRow).updateOrSave();

            if (respone.hasException()) {
                Helper.createErrorAlert("ERROR", respone.getException().getMessage());

                var resetResponse = tableView.getItems().get(editRow).reset();

                if (resetResponse.hasException()) {
                    Helper.createErrorAlert("DATABASE ERROR", resetResponse.getException().getMessage());
                    tableView.getItems().remove(editRow);
                }
            } else if (editRow + 1 == tableView.getItems().size()) {
                tableView.getItems().add(new Admin("<Insert>", "<Insert>", "<Insert>", "<Insert>"));
                Helper.createSuccessAlert("SUCCESS", "Admin saved successfully");
            }

            tableView.refresh();

            editRow = -1;
        }

    }

    @FXML
    void idEditStart(CellEditEvent<Admin, String> t) {
        if (editRow + 1 != tableView.getItems().size())
            Helper.createErrorAlert("ERROR: Cannot Edit", "ID is not editable");

        Helper.onEditStartCheck(t, editRow);
    }

    @FXML
    void idEditCommit(CellEditEvent<Admin, String> t) {
        if (editRow + 1 != tableView.getItems().size())
            Helper.createErrorAlert("ERROR: Cannot Edit", "ID is not editable");

        if (!Helper.onEditCommitCheck(t, editRow)) {
            tableView.refresh();
            return;
        }

        System.out.println(t.getNewValue());
        if (!Helper.isNumeric(t.getNewValue()) || t.getNewValue().isEmpty()) {
            Helper.createErrorAlert("ERROR: Cannot Edit", "Please follow the constraint requirements");
            tableView.refresh();
        } else {
            editRow = Helper.getRow(t);
            tableView.getSelectionModel().getSelectedItem().setName(t.getNewValue());
        }
    }

    @FXML
    void nameEditStart(CellEditEvent<Admin, String> t) {

        Helper.onEditStartCheck(t, editRow);
    }

    @FXML
    void nameEditCommit(CellEditEvent<Admin, String> t) {
        if (!Helper.onEditCommitCheck(t, editRow)) {
            tableView.refresh();
            return;
        }

        System.out.println(t.getNewValue());
        if (t.getNewValue().length() > 30 || t.getNewValue().isEmpty()) {
            Helper.createErrorAlert("ERROR: Cannot Edit", "Please follow the constraint requirements");
            tableView.refresh();
        } else {
            editRow = Helper.getRow(t);
            tableView.getSelectionModel().getSelectedItem().setName(t.getNewValue());
        }
    }

    @FXML
    void emailEditStart(CellEditEvent<Admin, String> t) {

        Helper.onEditStartCheck(t, editRow);
    }

    @FXML
    void emailEditCommit(CellEditEvent<Admin, String> t) {
        if (!Helper.onEditCommitCheck(t, editRow)) {
            tableView.refresh();
            return;
        }

        // to do your valiidation
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
    void phoneEditStart(CellEditEvent<Admin, String> t) {

        Helper.onEditStartCheck(t, editRow);
    }

    @FXML
    void phoneEditCommit(CellEditEvent<Admin, String> t) {
        if (!Helper.onEditCommitCheck(t, editRow)) {
            tableView.refresh();
            return;
        }

        // to do your valiidation
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
    void initialize() {
        assert label != null : "fx:id=\"label\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert IDColumn != null : "fx:id=\"IDColumn\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert NameColumn != null : "fx:id=\"NameColumn\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert EmailColumn != null : "fx:id=\"EmailColumn\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert PhoneColumn != null : "fx:id=\"PhoneColumn\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert SignOutButton != null
                : "fx:id=\"SignOutButton\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert SaveButton != null : "fx:id=\"SaveButton\" was not injected: check your FXML file 'ManageAdmin.fxml'.";
        assert DeleteButton != null
                : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'ManageAdmin.fxml'.";

        Response<List<entity.User>> response = getAdminsHandler.handle(AppContext.getUser().getId());

        if (response.success()) {
            response.getResponse().forEach(dbAdmin -> tableView.getItems().add(new Admin(dbAdmin)));
            tableView.getItems().add(new Admin("<Insert>", "<Insert>", "<Insert>", "<Insert>"));
        }

        IDColumn.setCellValueFactory(new Callback<CellDataFeatures<Admin, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<Admin, String> p) {
                return new ReadOnlyObjectWrapper<String>(p.getValue().getId());
            }
        });

        NameColumn.setCellValueFactory(new Callback<CellDataFeatures<Admin, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<Admin, String> p) {
                return new ReadOnlyObjectWrapper<String>(p.getValue().getName());
            }
        });

        EmailColumn.setCellValueFactory(new Callback<CellDataFeatures<Admin, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<Admin, String> p) {
                return new ReadOnlyObjectWrapper<String>(p.getValue().getEmail());
            }
        });

        PhoneColumn.setCellValueFactory(new Callback<CellDataFeatures<Admin, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<Admin, String> p) {
                return new ReadOnlyObjectWrapper<String>(p.getValue().getPhone());
            }
        });

        IDColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        EmailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PhoneColumn.setCellFactory(TextFieldTableCell.forTableColumn());

    }
}
