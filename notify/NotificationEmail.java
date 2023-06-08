package com.jbdev.orderapp.notify;

import com.jbdev.orderapp.models.Invoice;
import com.jbdev.orderapp.models.Product;

public interface NotificationEmail {
    void sub(Invoice invoice);
    double subTotal(Invoice invoice);
    double totalAmount(Invoice invoice);
}
