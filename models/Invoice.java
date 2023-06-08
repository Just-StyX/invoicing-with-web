package com.jbdev.orderapp.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invoice {
    public static final double TAX = 0.015;
    private String invoiceNumber;
    private double sub;

    public double total() {
        return this.sub * (1 + TAX);
    }
}
