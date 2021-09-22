package com.example.springexercise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class PaymentConfiguration {
        @Bean
    public ClassLoaderTemplateResolver templateResolver (){

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
         templateResolver.setPrefix("templates/");
         templateResolver.setSuffix(".html");
         templateResolver.setTemplateMode("HTML5");
         templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
}
