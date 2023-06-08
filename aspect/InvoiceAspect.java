package com.jbdev.orderapp.aspect;

import com.jbdev.orderapp.models.Invoice;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Random;

@Aspect
public class InvoiceAspect {
    public String invoiceNumber() {
        Random random = new Random();
        char[] digits = new char[12];
        digits[0] = (char) (random.nextInt(9) + '1');
        for (int i = 1; i < 12; i++) {
            digits[i] = (char) (random.nextInt(10) + '0');
        }
        return new String(digits);
    }

    @Around("execution(* com.jbdev.orderapp.services.InvoiceServices.returnInvoice(..))")
    public Invoice log(ProceedingJoinPoint joinPoint) throws Throwable {
        Invoice invoice = (Invoice) joinPoint.proceed();
        invoice.setInvoiceNumber(invoiceNumber());
        return invoice;
    }
}
