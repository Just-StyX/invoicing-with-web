package com.jbdev.orderapp.product;

import com.jbdev.orderapp.models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void addProduct(Product product);

    List<Integer> quantities();

    List<Double> getPrices();
}
