package com.itechart.kafkademo.service.impl;

import com.itechart.kafkademo.exception.FormNotExistsException;
import com.itechart.kafkademo.model.Form;
import com.itechart.kafkademo.repository.FormRepository;
import com.itechart.kafkademo.service.FormService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Alesia.Hlushakova
 * @since 10.02.2022
 */
@Slf4j
@AllArgsConstructor
@Service
public class FormServiceImpl implements FormService {
    private final FormRepository repository;

    @Override
    public Form save(final Form form) {
        return repository.save(form);
    }

    @Override
    public Form find(final String id) {
        return repository.findById(id).orElseThrow(FormNotExistsException::new);
    }

}
