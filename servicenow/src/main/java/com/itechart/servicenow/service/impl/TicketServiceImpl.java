package com.itechart.servicenow.service.impl;

import com.itechart.servicenow.model.Ticket;
import com.itechart.servicenow.repository.TicketRepository;
import com.itechart.servicenow.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public Ticket save(final Ticket ticket) {
        log.info("Ticket saved {}", ticket);
        return repository.save(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        return repository.findAll();
    }
}
