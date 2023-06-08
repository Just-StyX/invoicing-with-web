package com.jbdev.orderapp.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String productName;
    private double productPrice;
    private int quantity;


    public Product(String productName, double productPrice, int quantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }
}
