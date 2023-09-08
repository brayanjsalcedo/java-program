package com.example.java.epam.brayan.jms.producers;

import com.example.java.epam.brayan.controllers.requests.CreateTicketRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TicketBookingPublisher {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    @Value("${activemq.topic}")
    private String topic;

    public void sendTicketRequest(CreateTicketRequest createTicketRequest) {
        try {
            String payload = objectMapper.writeValueAsString(createTicketRequest);
            jmsTemplate.convertAndSend(topic, payload);
        } catch (Exception e) {
            log.error("Error occurred while sending ticket request to the JMS queue", e);

            throw new RuntimeException("Unable to send ticket request to the JMS queue.", e);
        }
    }
}
