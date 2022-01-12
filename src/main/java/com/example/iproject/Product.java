package com.example.iproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Product implements Meds
{
    private int code;
    private String company, name, prescription;
    private int quantity;
    private float price;
    private int age;

    public Product(int code, String company, String name, String prescription, int quantity, float price, int age) {
        this.code = code;
        this.company = company;
        this.name = name;
        this.prescription = prescription;
        this.quantity = quantity;
        this.price = price;
        this.age = age;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setQuantity(int barcode, int quantity) {
        try {
            Connection conn = DBConnect.connect();
            String update = "UPDATE pill SET quantity=" + quantity + " WHERE bar_code=" + barcode + ";";
            Statement st;
            System.out.println(update);
            st = conn.createStatement();
            st.executeUpdate(update);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
