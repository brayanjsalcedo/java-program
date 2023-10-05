package com.example.java.epam.brayan.services;

import com.example.java.epam.brayan.services.data.TicketUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PDFGenerationServiceTest {

    private PDFGenerationService pdfGenerationService;

    @BeforeEach
    void setUp() {
        pdfGenerationService = new PDFGenerationService();
    }

    @Test
    void testGeneratePDFForTickets() {
        // Mocking the input
        TicketUser ticket1 = TicketUser.builder()
                .id(1L)
                .category("CategoryA")
                .userId(101L)
                .place(1001L)
                .build();

        TicketUser ticket2 = TicketUser.builder()
                .id(2L)
                .category("CategoryB")
                .userId(102L)
                .place(1002L)
                .build();

        Iterable<TicketUser> tickets = Arrays.asList(ticket1, ticket2);

        byte[] result = pdfGenerationService.generatePDFForTickets(tickets);

        // Verify that the byte array is not empty (i.e., some PDF content was generated)
        assertTrue(result.length > 0);
    }
}