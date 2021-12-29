package com.example.iproject;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    void onSearchButtonClick(ActionEvent event) {

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
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }catch(SQLException s){
            s.printStackTrace();
        }


        bar_code_col.setCellValueFactory(new PropertyValueFactory<>("Code"));
        company_col.setCellValueFactory(new PropertyValueFactory<>("Company"));
        product_name_col.setCellValueFactory(new PropertyValueFactory<>("Name"));
        prescription_col.setCellValueFactory(new PropertyValueFactory<>("Prescription"));
        quantity_col.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        price_col.setCellValueFactory(new PropertyValueFactory<>("Price"));
        age_col.setCellValueFactory(new PropertyValueFactory<>("Age"));


        pills_table.setItems(resultArray);
//        pills_table.getColumns().addAll(bar_code_col, company_col, product_name_col, prescription_col, quantity_col, price_col, age_col);

//        pills_table.getItems().setAll(parseProductList(resultArray));
    }


}