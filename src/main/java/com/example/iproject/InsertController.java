package com.example.iproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class InsertController {

    @FXML
    private TextField bar_code_text;

    @FXML
    private TextField company_text;

    @FXML
    private Button enter_values_button;

    @FXML
    private TextField minimum_age_text;

    @FXML
    private ChoiceBox<String> prescription_text;

    @FXML
    private TextField price_text;

    @FXML
    private TextField product_name_text;

    @FXML
    private TextField quantity_text;

    @FXML
    private Label status;

    @FXML
    private Button listOfItems;

    @FXML
    private Button login;

    @FXML
    void goToList(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("search_for_product.fxml"));

        Stage scene = (Stage) login.getScene().getWindow();
        scene.setScene(new Scene(fxmlLoader, GUI.SIZE_OF_LIST_X.getValue(), GUI.SIZE_OF_LIST_Y.getValue()));
        scene.setTitle("List of products");
    }

    @FXML
    void goToLogIn(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("login.fxml"));

        Stage scene = (Stage) login.getScene().getWindow();
        scene.setScene(new Scene(fxmlLoader, GUI.SIZE_OF_LOGIN_X.getValue(), GUI.SIZE_OF_LOGIN_Y.getValue()));
        scene.setTitle("Logging in");
    }

    @FXML
    void onEnterValuesButton(ActionEvent event) {
        try{
            Connection conn = DBConnect.connect();
            String update = "INSERT INTO pill VALUES("+
                    bar_code_text.getText()+", '"+
                    company_text.getText()+"', '"+
                    product_name_text.getText()+"', '"+
                    prescription_text.getValue()+"', "+
                    quantity_text.getText()+", "+
                    price_text.getText()+", "+
                    minimum_age_text.getText()+");";
            Statement st;
            System.out.println(update);
            st = conn.createStatement();
            st.executeUpdate(update);

        }catch(SQLException s){
            status.setText("Please check if all the text fields are entered correctly");
        }

    }

}
