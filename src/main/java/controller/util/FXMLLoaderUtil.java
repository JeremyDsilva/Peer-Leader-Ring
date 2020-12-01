package controller.util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLLoaderUtil {

    public static Scene getScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(FXMLLoaderUtil.class.getResource("/controller/" + fxml + ".fxml"));
        return new Scene(root);
    }

}
