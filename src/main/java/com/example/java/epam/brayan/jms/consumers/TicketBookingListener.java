package com.example.java.epam.brayan.jms.consumers;

import com.example.java.epam.brayan.controllers.requests.CreateTicketRequest;
import com.example.java.epam.brayan.services.CreateTicketService;
import com.example.java.epam.brayan.services.data.NewTicket;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TicketBookingListener {

    private final CreateTicketService createTicketService;
    private final ObjectMapper objectMapper;
    @JmsListener(destination = "${activemq.topic}")
    public void receiveMessage(String payload) {

        try {
            log.info("Received a ticket booking request from the queue: {}", payload);
            CreateTicketRequest createTicketRequest = objectMapper.readValue(payload, CreateTicketRequest.class);

            createTicketService.createTicket(
                    NewTicket.builder()
                            .category(createTicketRequest.getCategory())
                            .place(createTicketRequest.getPlace())
                            .eventId(createTicketRequest.getEventId())
                            .userId(createTicketRequest.getUserId())
                            .build()
            );

            log.info("Ticket saved to database successfully.");

        } catch (Exception e) {
            log.error("Error processing the ticket booking request", e);
        }
    }
}
