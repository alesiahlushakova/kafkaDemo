package com.itechart.kafkademo.web;

import com.itechart.kafkademo.model.Form;
import com.itechart.kafkademo.service.FormService;
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
@RequestMapping("/api/forms")
public class FormController {
    private final FormService formService;

    @PostMapping
    public Form save(@RequestBody final Form form) {
        log.info("Received Form {}", form);
        return formService.save(form);
    }

    @GetMapping("/{id}")
    public Form find(@PathVariable final String id) {
        log.info("Received Form ID {}", id);
        final Form form = formService.find(id);
        return form;
    }
}
