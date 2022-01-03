package com.example.iproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccountController {

    @FXML
    private Button login;

    @FXML
    private Button newAccount;

    @FXML
    private PasswordField password;

    @FXML
    private ChoiceBox<String> roles;

    @FXML
    private Label status;

    @FXML
    private TextField username;

    @FXML
    void changeToLogin(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("login.fxml"));

        Stage scene = (Stage) login.getScene().getWindow();
        scene.setScene(new Scene(fxmlLoader, GUI.SIZE_OF_LOGIN_X.getValue(), GUI.SIZE_OF_LOGIN_Y.getValue()));
    }

    @FXML
    void onCreate(ActionEvent event) {
        try{
            Connection conn = DBConnect.connect();
            String update = "INSERT INTO users VALUES('"+
                    username.getText()+"', '"+
                    password.getText()+"', '"+
                    roles.getValue()+"');";
            Statement st;
            System.out.println(update);
            st = conn.createStatement();
            st.executeUpdate(update);

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch(SQLException s){
            status.setText("The username already exists, please try another");
        }
    }
}
