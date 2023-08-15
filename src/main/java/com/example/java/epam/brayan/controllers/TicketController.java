package com.example.java.epam.brayan.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @GetMapping("/tickets")
    public String tickets() {
        return "Hello World";
    }
}
