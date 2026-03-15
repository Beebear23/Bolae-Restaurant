package com.example.bolaerestaurant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                HelloApplication.class.getResource("/com/example/bolaerestaurant/LoginView.fxml"));

        Scene scene = new Scene(loader.load(), 720, 480);

        stage.setTitle("Bolae Markets Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}