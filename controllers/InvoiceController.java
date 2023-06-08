package com.jbdev.orderapp.controllers;

import com.jbdev.orderapp.models.Product;
import com.jbdev.orderapp.services.InvoiceServices;
import com.jbdev.orderapp.services.LoggedUserManagerServices;
import com.jbdev.orderapp.services.ProductServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InvoiceController {
    private final InvoiceServices invoiceServices;
    private final ProductServices productServices;
    private final LoggedUserManagerServices loggedUserManagerServices;

    public InvoiceController(InvoiceServices invoiceServices, ProductServices productServices, LoggedUserManagerServices loggedUserManagerServices) {
        this.invoiceServices = invoiceServices;
        this.productServices = productServices;
        this.loggedUserManagerServices = loggedUserManagerServices;
    }


    @RequestMapping(path = "/invoice", method = RequestMethod.GET)
    public String invoice(Model model, @RequestParam(required = false) String logout) {
        if(logout != null) {
            loggedUserManagerServices.setUsername(null);
        }
        String username = loggedUserManagerServices.getUsername();

        if (username == null) {
            return "redirect:/";
        }

        var products = productServices.findAll();
        model.addAttribute("products", products);

        return "invoice";
    }

    @RequestMapping(path = "/invoice", method = RequestMethod.POST)
    public String invoicePost(
            Model model,
            @RequestParam String productName,
            @RequestParam double productPrice,
            @RequestParam int quantity
    ) {
        Product product = new Product(productName, productPrice, quantity);
        productServices.addProduct(product);
        var products = productServices.findAll();
        model.addAttribute("products", products);

        return "redirect:/invoice";
    }

    @RequestMapping(path = "/generate-invoice", method = RequestMethod.GET)
    public String generate(Model model) {
        var products = productServices.findAll();
        var invoice = invoiceServices.returnInvoice();
        invoiceServices.setTotalSub(invoice);
        double subTotal = invoiceServices.getSubTotal(invoice);
        double total = invoiceServices.getTotalAmountDue(invoice);
        String invoiceNumber = invoice.getInvoiceNumber();
        model.addAttribute("products", products);
        model.addAttribute("invoiceNumber", invoiceNumber);
        model.addAttribute("subTotal", subTotal);
        model.addAttribute("total", total);
        return "generateInvoice";
    }
}
