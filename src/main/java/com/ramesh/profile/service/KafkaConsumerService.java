package com.ramesh.profile.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;
    @Service
    public class KafkaConsumerService {

        private static final Logger LOGGER =
                LoggerFactory.getLogger(com.ramesh.profile.service.KafkaConsumerService.class);

        @KafkaListener(
                topics = "test-topic",
                groupId = "group-id"
        )
        public void consume(String message) {

            LOGGER.info("Message received from Kafka: {}", message);

            System.out.println("Consumed message: " + message);
        }
    }

