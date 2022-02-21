package com.itechart.kafkademo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Alesia.Hlushakova
 * @since 10.02.2022
 */
@Entity
@Data
public class Ticket {
    @Id
    private String id;
    private String name;
    private String description;
    private String severity;
}
