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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    @FXML
    private Button login;

    @FXML
    private Button addNewItems;

    @FXML
    private Button listOfItems;

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
        if(Account.role.equals("Administrator")){
            Parent fxmlLoader = FXMLLoader.load(getClass().getResource("new_acc.fxml"));

            Stage scene = (Stage) login.getScene().getWindow();
            scene.setScene(new Scene(fxmlLoader, GUI.SIZE_OF_CREATE_X.getValue(), GUI.SIZE_OF_CREATE_Y.getValue()));
        }
        else
            status.setText("You need Administrator privileges to create accounts");
    }

    @FXML
    void goToList(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("search_for_product.fxml"));

        Stage scene = (Stage) login.getScene().getWindow();
        scene.setScene(new Scene(fxmlLoader, GUI.SIZE_OF_LIST_X.getValue(), GUI.SIZE_OF_LIST_Y.getValue()));
    }

    @FXML
    void addItems(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("insert_scene.fxml"));

        Stage scene = (Stage) login.getScene().getWindow();
        scene.setScene(new Scene(fxmlLoader, GUI.SIZE_OF_ADD_X.getValue(), GUI.SIZE_OF_ADD_Y.getValue()));
    }

    @FXML
    void onLogIn(ActionEvent event){
        try{
            Connection conn = DBConnect.connect();
            String update = "SELECT EXISTS (SELECT * from users where (username='" +
                    username.getText()+"') and (password='" +
                    password.getText()+"'));";
            Statement st;
            System.out.println(update);
            st = conn.createStatement();
            ResultSet result = st.executeQuery(update);
            result.next();
            if(result.getInt(1)==1) {
                Connection conn_user = DBConnect.connect();
                Account.username=username.getText();
                Account.password=password.getText();

                String user = "SELECT * from users where (username='" +
                        username.getText()+"') and (password='" +
                        password.getText()+"');";
                Statement st_user;
                System.out.println(user);
                st_user = conn_user.createStatement();
                ResultSet res = st_user.executeQuery(user);
                res.next();

                Account.role=res.getString("role");

                status.setText("You've been logged in successfully as "+Account.username+" with "+Account.role+" privileges");

            }
            else
                status.setText("Invalid username or password, please try again");

        }catch(SQLException s){
            status.setText("Please check the entered values");
        }
    }
}
