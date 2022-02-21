package com.itechart.servicenow.web;

import com.itechart.servicenow.model.Ticket;
import com.itechart.servicenow.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("/all")
    public List<Ticket> findAll(@RequestBody final String msg) {
        log.info("Received Ticket message {}", msg);
        return ticketService.findAll();
    }

}
