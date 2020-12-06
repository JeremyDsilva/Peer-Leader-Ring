package controller;

import java.text.SimpleDateFormat;

import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn.CellEditEvent;

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

    public static void createAlert(String title, String message) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setContentText(message);
        a.setHeaderText(null);
        a.showAndWait();
    }

}
