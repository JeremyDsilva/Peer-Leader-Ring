/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.HibernateUtil;

/**
 *
 * @author Yash Gaikwad
 */
public class App extends Application {

    // private static Parent loadFXML(String fxml) throws IOException {
    //     FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource(fxml + ".fxml"));
    //     return fxmlLoader.load();
    // }

    // private static Scene scene;

    // @Override
    // public void start(Stage stage) throws IOException {
    //     Parent parent = loadFXML("Login");
    //     scene = new Scene(parent);
    //     stage.setScene(scene);
    //     stage.show();
    // }

    // static void setRoot(String fxml) throws IOException {
    //     scene.setRoot(loadFXML(fxml));
    // }

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(LoginController.class.getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(App.class, args);

        HibernateUtil.close();
    }

}
