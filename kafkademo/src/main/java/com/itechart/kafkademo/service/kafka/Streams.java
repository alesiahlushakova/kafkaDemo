package com.itechart.kafkademo.service.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Alesia.Hlushakova
 * @since 10.02.2022
 */

public interface Streams {
    String CREATE_TICKET_TOPIC = "create_ticket";
    String TICKET_CREATED_TOPIC = "ticket_created";
    String GET_TICKET_REQUESTS_TOPIC = "get_ticket_requests";
    String GET_TICKET_RESPONSES_TOPIC = "get_ticket_responses";

    //write
    @Output(CREATE_TICKET_TOPIC)
    MessageChannel createTicketChannel();

    //read
    @Input(TICKET_CREATED_TOPIC)
    SubscribableChannel ticketCreatedChannel();

    //write
    @Output(GET_TICKET_REQUESTS_TOPIC)
    SubscribableChannel getTicketRequestsChannel();

    //read
    @Input(GET_TICKET_RESPONSES_TOPIC)
    SubscribableChannel getTicketResponsesChannel();

}
