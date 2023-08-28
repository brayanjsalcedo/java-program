package com.example.java.epam.brayan.config;

import com.example.java.epam.brayan.exception.CustomHandlerExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Configuration
public class WebConfig {

    @Bean
    public HandlerExceptionResolver customExceptionResolver() {
        return new CustomHandlerExceptionResolver();
    }
}
