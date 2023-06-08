package com.jbdev.orderapp.services;

import com.jbdev.orderapp.models.Invoice;
import com.jbdev.orderapp.models.Product;
import com.jbdev.orderapp.notify.NotificationEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServices {
    private final NotificationEmail notificationEmail;

    @Autowired
    public InvoiceServices(NotificationEmail notificationEmail) {
        this.notificationEmail = notificationEmail;
    }

    public double getSubTotal(Invoice invoice) {
        return notificationEmail.subTotal(invoice);
    }

    public double getTotalAmountDue(Invoice invoice) {
        return notificationEmail.totalAmount(invoice);
    }

    public void setTotalSub(Invoice invoice) {notificationEmail.sub(invoice);}

    public Invoice returnInvoice() {
        return new Invoice();
    }
}
