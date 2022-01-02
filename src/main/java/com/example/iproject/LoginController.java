package com.example.iproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    @FXML
    private Button login;

    @FXML
    private Button newAccount;

    @FXML
    private PasswordField password;

    @FXML
    private Label status;

    @FXML
    private TextField username;

    @FXML
    void changeToCreate(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("new_acc.fxml"));

        Stage scene = (Stage) login.getScene().getWindow();
        scene.setScene(new Scene(fxmlLoader, 400, 350));
    }

    @FXML
    void onLogIn(ActionEvent event){
        try{
            Connection conn = DBConnect.connect();
            String update = "";
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
