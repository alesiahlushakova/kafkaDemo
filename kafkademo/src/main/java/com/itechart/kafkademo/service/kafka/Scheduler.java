package com.itechart.kafkademo.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Alesia.Hlushakova
 * @since 20.02.2022
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class Scheduler {
    private final Streams streams;

    @Scheduled(cron = "0 */1 * * * *")
    public void cronJobSch() {
        var message = MessageBuilder.withPayload("GET Tickets").build();
        var channel = streams.getTicketRequestsChannel();
        channel.send(message);
        log.info("Cron job executed, {} sent", message);
    }
}
