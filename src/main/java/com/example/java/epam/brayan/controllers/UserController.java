package com.example.java.epam.brayan.controllers;

import com.example.java.epam.brayan.controllers.requests.CreateUserRequest;
import com.example.java.epam.brayan.data.entities.User;
import com.example.java.epam.brayan.services.CreateUserService;
import com.example.java.epam.brayan.services.PDFGenerationService;
import com.example.java.epam.brayan.services.TicketUserService;
import com.example.java.epam.brayan.services.data.NewUser;
import com.example.java.epam.brayan.services.data.TicketUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UserController {
    private final CreateUserService createUserService;
    private final TicketUserService ticketUserService;
    private final PDFGenerationService pdfGenerationService;

    @PostMapping
    public User createUser(@RequestBody CreateUserRequest createUserRequest) {
        log.debug("Creating a new user {}", createUserRequest);

        return createUserService.createUser(
                NewUser.builder()
                        .name(createUserRequest.getName())
                        .email(createUserRequest.getEmail())
                        .build()
        );
    }

    @GetMapping("/{id}/tickets")
    public Iterable<TicketUser> getBookedTicketsForUser(
            @PathVariable Long id,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "1") int pageNum
    ) {
        log.debug("Get booked tickets by user {}", id);

        return ticketUserService.getBookedTickets(id, pageSize, pageNum);
    }

    @GetMapping(value = "/{id}/tickets", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody byte[] getBookedTicketsForUserPDF(
            @PathVariable Long id,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "1") int pageNum
    ) {
        log.debug("[PDF] Get booked tickets by user {}", id);

        Iterable<TicketUser> tickets = ticketUserService.getBookedTickets(id, pageSize, pageNum);

        return pdfGenerationService.generatePDFForTickets(tickets);
    }
}
