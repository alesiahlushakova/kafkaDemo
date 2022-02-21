package com.itechart.kafkademo.service;


import com.itechart.kafkademo.model.Form;

/**
 * @author Alesia.Hlushakova
 * @since 10.02.2022
 */
public interface FormService {
    Form save(final Form form);

    Form find(final String id);
}
