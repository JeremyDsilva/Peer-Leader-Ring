package util;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class Helper {

    public static int getRow(CellEditEvent<?, ?> t) {
        return t.getTablePosition().getRow();
    }

    public static boolean onEditCommitCheck(CellEditEvent<?, ?> t, int editRow) {
        if (editRow != -1 && getRow(t) != editRow) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Edit");
            a.setContentText("Please select the previous edited row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
            t.consume();
            return false;
        }

        return true;
    }

    public static boolean onEditStartCheck(CellEditEvent<?, ?> t, int editRow) {
        if (editRow != -1 && getRow(t) != editRow) { // no row is being edit, dont care
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Start Editing");
            a.setContentText("Please select the previous edited row and SAVE");
            a.setHeaderText(null);
            a.showAndWait();
            t.consume();
            return false;
        }
        return true;
    }

    public static boolean onDeleteCheck(int editRow) {
        if (editRow != -1) { // no row is being edit, dont care
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Cannot Delete");
            a.setContentText("First SAVE changes before delete");
            a.setHeaderText(null);
            a.showAndWait();
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String s) {
        try {
            Long.parseLong(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isDate(String s) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            format.parse(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean emailValidate(String email) {
        Matcher matcher = Pattern
                .compile("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}(.[a-z]{2,3})+$|^$", Pattern.CASE_INSENSITIVE)
                .matcher(email);

        return matcher.find();
    }

    public static void createErrorAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setContentText(message);
        a.setHeaderText(null);
        a.showAndWait();
    }

    public static void createSuccessAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle(title);
        a.setContentText(message);
        a.setHeaderText(null);
        a.showAndWait();
    }
    public static void loadView(URL fxml) {
        try {
            Parent root = FXMLLoader.load(fxml);
            Scene scene = new Scene(root);
            Stage window = (Stage) Stage.getWindows().stream().filter(Window::isShowing).findAny().get();
            window.setResizable(false);
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            Helper.createErrorAlert("Error", "Cannot Load " + fxml.toString());
        }

    }

}
