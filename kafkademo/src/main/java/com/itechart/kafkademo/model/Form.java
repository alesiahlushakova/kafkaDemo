package com.itechart.kafkademo.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Alesia.Hlushakova
 * @since 18.02.2022
 */
@Entity
@Data
public class Form {
    @Id
    private String id;
    private String form;
}
