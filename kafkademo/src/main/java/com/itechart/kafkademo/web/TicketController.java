package com.itechart.kafkademo.web;

import com.itechart.kafkademo.model.Ticket;
import com.itechart.kafkademo.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alesia.Hlushakova
 * @since 10.02.2022
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    public Ticket save(@RequestBody final Ticket ticket) {
        log.info("Received Ticket {}", ticket);
        return ticketService.save(ticket);
    }

    @GetMapping("/{id}")
    public Ticket find(@PathVariable final String id) {
        log.info("Received Ticket ID {}", id);
        return ticketService.find(id);
    }
}
