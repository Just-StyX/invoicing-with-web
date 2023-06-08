package com.jbdev.orderapp.notify;

import com.jbdev.orderapp.models.Invoice;
import com.jbdev.orderapp.models.Product;
import com.jbdev.orderapp.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationEmailImpl implements NotificationEmail{

    private final ProductServices productServices;

    @Autowired
    public NotificationEmailImpl(ProductServices productServices) {
        this.productServices = productServices;
    }

    @Override
    public void sub(Invoice invoice) {
        invoice.setSub(productServices.totalPrice());
    }

    @Override
    public double subTotal(Invoice invoice) {
        return invoice.getSub();
    }

    @Override
    public double totalAmount(Invoice invoice) {
        return invoice.total();
    }
}
