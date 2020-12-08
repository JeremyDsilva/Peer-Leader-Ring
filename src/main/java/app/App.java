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


public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        try {
            HibernateUtil.getSession().close();
        } catch (Exception e){
            return;
        }

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
