package com.example.iproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class DBConnect {

    private static Connection connection;

    public static Connection connect() {
        if (connection == null) {
            try {
                connection =
                        DriverManager.getConnection("jdbc:mysql://localhost/pharmacydb?" +
                                "user=root&password=root");

            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                //            try {
//                Class.forName(DATABASE_DRIVER);
//                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
//            } catch (ClassNotFoundException | SQLException e) {
//                e.printStackTrace();
            }
        }
        return connection;
    }
}

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

            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }catch(SQLException s){
            s.printStackTrace();
        }

    }

}
