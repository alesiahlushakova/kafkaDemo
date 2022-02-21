package com.itechart.servicenow.repository;

import com.itechart.servicenow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alesia.Hlushakova
 * @since 10.02.2022
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
}
