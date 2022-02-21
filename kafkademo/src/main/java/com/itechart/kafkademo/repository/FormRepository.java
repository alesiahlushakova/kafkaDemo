package com.itechart.kafkademo.repository;

import com.itechart.kafkademo.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alesia.Hlushakova
 * @since 10.02.2022
 */
@Repository
public interface FormRepository extends JpaRepository<Form, String> {
}
