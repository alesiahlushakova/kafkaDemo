package com.itechart.servicenow.service;


import com.itechart.servicenow.model.Ticket;

import java.util.List;

/**
 * @author Alesia.Hlushakova
 * @since 10.02.2022
 */
public interface TicketService {
    Ticket save(Ticket ticket);
    List<Ticket> findAll();
}
