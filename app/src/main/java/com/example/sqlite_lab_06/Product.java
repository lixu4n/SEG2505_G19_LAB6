package com.example.sqlite_lab_06;

public class Product {
    private int _id;
    private String _productname;
    private int _quantity;


    public Product() {
    }
    public Product(int id, String productname, int quantity) {
        _id = id;
        _productname = productname;
        _quantity = quantity;
    }
    public Product(String productname, int quantity) {
        _productname = productname;
        _quantity = quantity;
    }

    public void setID(int id) {
        _id = id;
    }
    public int getID() {
        return _id;
    }
    public void setProductName(String productname) {
        _productname = productname;
    }
    public String getProductName() {
        return _productname;
    }
    public void setQuantity(int quantity) {
        _quantity = quantity;
    }
    public int getQuantity() {
        return _quantity;
    }

    public void setSku(int parseInt) {
    }
}
