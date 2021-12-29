package com.example.iproject;

public class Product
{
    private int code;
    private String company, name, prescription;
    private int quantity;
    private float price;
    private int age;

    public Product(int bar_code, String company, String product_name, String prescription_required, int quantity, float price, int min_age)
    {
        this.bar_code = bar_code;
        this.company = company;
        this.product_name = product_name;
        this.prescription_required = prescription_required;
        this.quantity = quantity;
        this.price = price;
        this.min_age = min_age;
    }

    public int getBar_code() {
        return bar_code;
    }

    public void setBar_code(int bar_code) {
        this.bar_code = bar_code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getPrescription_required() {
        return prescription_required;
    }

    public void setPrescription_required(String prescription_required) {
        this.prescription_required = prescription_required;
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

    public int getMin_age() {
        return min_age;
    }

    public void setMin_age(int min_age) {
        this.min_age = min_age;
    }
}
