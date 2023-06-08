package com.jbdev.orderapp.services;

import com.jbdev.orderapp.models.Product;
import com.jbdev.orderapp.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public double totalPrice() {
        List<Double> prices = productRepository.getPrices();
        List<Integer> quantities = productRepository.quantities();
        double sum = 0;
        for(int i = 0; i < prices.size(); i++) {
            sum += prices.get(i) * quantities.get(i);
        }
        return sum;
    }

}
