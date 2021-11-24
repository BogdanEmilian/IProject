package com.example.iproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
        bar_code_col.setCellValueFactory(new PropertyValueFactory<Product, Integer>("Bar Code"));
        company_col.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        product_name_col.setCellValueFactory(new PropertyValueFactory<Product, String>("active"));

        pills_table.getItems().setAll(parseProductList());
    }

    private List<Product> parseProductList(){
        List<Product> productList = new ArrayList<>();
        return productList;
    }

}