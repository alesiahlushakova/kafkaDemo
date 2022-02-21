package com.itechart.kafkademo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.kafkademo.exception.TicketNotExistsException;
import com.itechart.kafkademo.model.Ticket;
import com.itechart.kafkademo.repository.TicketRepository;
import com.itechart.kafkademo.service.TicketService;
import com.itechart.kafkademo.service.kafka.Streams;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alesia.Hlushakova
 * @since 10.02.2022
 */
@Slf4j
@AllArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository repository;
    private final Streams streams;
    private final ObjectMapper mapper;

    @Override
    public Ticket save(final Ticket ticket) {
        log.info("Ticket published to create_ticket topic {}", ticket);
        var message = MessageBuilder.withPayload(ticket).build();
        var channel = streams.createTicketChannel();
        channel.send(message);
        return ticket;
    }

    @Override
    public Ticket find(final String id) {
        log.info("Retrieved from ticket {} from DB", id);
        return repository.findById(id).orElseThrow(TicketNotExistsException::new);
    }

    @StreamListener(value = Streams.TICKET_CREATED_TOPIC)
    public void handleCreated(@Payload(required = false) JsonNode payload) throws JsonProcessingException {
        log.info("Received message from ticket_created, saved ticket {} to ticket DB", payload);
        final Ticket ticket = mapper.treeToValue(payload, Ticket.class);
        repository.save(ticket);
    }

    @StreamListener(value = Streams.GET_TICKET_RESPONSES_TOPIC)
    public void handleGet(@Payload(required = false) JsonNode payload) throws JsonProcessingException {
        log.info("Received message from get_ticket_responses, saved ticket {} to ticket DB", payload);
        List<Ticket> tickets = Arrays.asList(mapper.treeToValue(payload, Ticket[].class));
        repository.saveAll(tickets);
    }
}
