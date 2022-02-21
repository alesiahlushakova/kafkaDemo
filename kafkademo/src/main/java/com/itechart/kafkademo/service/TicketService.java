package com.itechart.kafkademo.service;


import com.itechart.kafkademo.model.Ticket;

/**
 * @author Alesia.Hlushakova
 * @since 10.02.2022
 */
public interface TicketService {
    Ticket save(final Ticket ticket);

    Ticket find(final String id);
}
