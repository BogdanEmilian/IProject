package com.example.iproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), GUI.SIZE_OF_LOGIN_X.getValue(), GUI.SIZE_OF_LOGIN_Y.getValue());

        stage.setTitle("Logging in");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(Account.role = "User");
    }
}