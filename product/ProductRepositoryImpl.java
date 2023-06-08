package com.jbdev.orderapp.product;

import com.jbdev.orderapp.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository{
    List<Product> products = new ArrayList<>();
    List<Integer> quantities = new ArrayList<>();
    List<Double> prices = new ArrayList<>();
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
        quantities.add(product.getQuantity());
        prices.add(product.getProductPrice());
    }

    @Override
    public List<Integer> quantities() {
        return quantities;
    }

    @Override
    public List<Double> getPrices() {
        return prices;
    }
}
