package com.itechart.kafkademo.config;

import com.itechart.kafkademo.service.kafka.Streams;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alesia.Hlushakova
 * @since 12.02.2022
 */
@Configuration
@EnableBinding(Streams.class)
public class KafkaConfig {
}
