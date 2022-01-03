package com.example.iproject;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SearchController implements Initializable {

    @FXML
    private TableColumn<Product, Integer> bar_code_col;

    @FXML
    private TableColumn<Product, String> company_col;

    @FXML
    private TableColumn<Product, String> product_name_col;

    @FXML
    private TableColumn<Product, String> prescription_col;

    @FXML
    private TableColumn<Product, Integer> quantity_col;

    @FXML
    private TableColumn<Product, Float> price_col;

    @FXML
    private TableColumn<Product, Integer> age_col;

    @FXML
    private TextField med_search_text;

    @FXML
    private Button med_search_button;

    @FXML
    private TableView<Product> pills_table;

    @FXML
    private Button addNew;

    @FXML
    private Button backToLogIn;

    @FXML
    void onSearchButtonClick(ActionEvent event) {
        ObservableList<Product> resultArray = FXCollections.observableArrayList();

        try{
            Connection conn = DBConnect.connect();
            String update = "SELECT * FROM pill WHERE product_name='"+med_search_text.getText()+"';";

            if(med_search_text.getText().equals("")) {
                update = "SELECT * FROM pill";
            }

            Statement st;
            st = conn.createStatement();
            ResultSet result = st.executeQuery(update);
            while(result.next()) {
                resultArray.add(new Product(result.getInt("bar_code"),
                        result.getString("company"),
                        result.getString("product_name"),
                        result.getString("prescription_required"),
                        result.getInt("quantity"),
                        result.getFloat("price"),
                        result.getInt("min_age")
                ));
            }

        }catch(SQLException s){
            System.out.println("Something went wrong, please try again or contact the administrator");
        }

        bar_code_col.setCellValueFactory(new PropertyValueFactory<>("Code"));
        company_col.setCellValueFactory(new PropertyValueFactory<>("Company"));
        product_name_col.setCellValueFactory(new PropertyValueFactory<>("Name"));
        prescription_col.setCellValueFactory(new PropertyValueFactory<>("Prescription"));
        quantity_col.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        price_col.setCellValueFactory(new PropertyValueFactory<>("Price"));
        age_col.setCellValueFactory(new PropertyValueFactory<>("Age"));

        pills_table.setItems(resultArray);
    }

    @FXML
    void goToInsert(ActionEvent event) throws IOException{
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("insert_scene.fxml"));

        Stage scene = (Stage) addNew.getScene().getWindow();
        scene.setScene(new Scene(fxmlLoader, GUI.SIZE_OF_ADD_X.getValue(), GUI.SIZE_OF_ADD_Y.getValue()));
        scene.setTitle("Add new products");
    }

    @FXML
    void goToLogIn(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("login.fxml"));

        Stage scene = (Stage) backToLogIn.getScene().getWindow();
        scene.setScene(new Scene(fxmlLoader, GUI.SIZE_OF_LOGIN_X.getValue(), GUI.SIZE_OF_LOGIN_Y.getValue()));
        scene.setTitle("Logging in");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<Product> resultArray = FXCollections.observableArrayList();

        try{
            Connection conn = DBConnect.connect();
            String update = "SELECT * FROM pill";
            Statement st;
            st = conn.createStatement();
            ResultSet result = st.executeQuery(update);
            while(result.next()) {
                resultArray.add(new Product(result.getInt("bar_code"),
                        result.getString("company"),
                        result.getString("product_name"),
                        result.getString("prescription_required"),
                        result.getInt("quantity"),
                        result.getFloat("price"),
                        result.getInt("min_age")
                        ));
            }

        }catch(SQLException s){
            System.out.println("Something went wrong, please try again or contact the administrator");
        }

        bar_code_col.setCellValueFactory(new PropertyValueFactory<>("Code"));
        company_col.setCellValueFactory(new PropertyValueFactory<>("Company"));
        product_name_col.setCellValueFactory(new PropertyValueFactory<>("Name"));
        prescription_col.setCellValueFactory(new PropertyValueFactory<>("Prescription"));
        quantity_col.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        price_col.setCellValueFactory(new PropertyValueFactory<>("Price"));
        age_col.setCellValueFactory(new PropertyValueFactory<>("Age"));

        pills_table.setItems(resultArray);
    }


}