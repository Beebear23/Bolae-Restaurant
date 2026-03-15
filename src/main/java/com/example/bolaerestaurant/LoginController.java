package com.example.bolaerestaurant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private void login() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.isEmpty() || password.isEmpty()){

            messageLabel.setText("Please enter username and password");

        } else {

            try {

                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/com/example/bolaerestaurant/hello-view.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(loader.load(), 600, 500);

                stage.setTitle("Bolae Restaurant POS System");
                stage.setScene(scene);
                stage.show();

                usernameField.getScene().getWindow().hide();

            } catch(Exception e){
                e.printStackTrace();
            }

        }
    }
}