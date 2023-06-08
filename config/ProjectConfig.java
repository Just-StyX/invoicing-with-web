package com.jbdev.orderapp.config;

import com.jbdev.orderapp.aspect.InvoiceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ProjectConfig {
    @Bean
    public InvoiceAspect invoiceAspect() {
        return new InvoiceAspect();
    }
}
