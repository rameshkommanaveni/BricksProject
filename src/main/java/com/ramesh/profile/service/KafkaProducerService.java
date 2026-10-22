package com.ramesh.profile.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ramesh.profile.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);
    private static final String TOPIC = "test-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendEmployeeEvent(String eventType, Employee employee) {
        final String message;
        try {
            ObjectNode event = objectMapper.createObjectNode();
            event.put("eventType", eventType);
            event.set("employee", objectMapper.valueToTree(employee));
            message = objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException exception) {
            throw new IllegalStateException("Failed to serialize employee event", exception);
        }

        kafkaTemplate.send(TOPIC, String.valueOf(employee.getId()), message)
                .whenComplete((result, exception) -> {

                    if (exception == null) {

                        LOGGER.info(
                                "Sent {} event for employee {} to Kafka topic {}",
                                eventType,
                                employee.getId(),
                                TOPIC
                        );

                    } else {

                        LOGGER.error(
                                "Failed to send {} event for employee {} to Kafka topic {}",
                                eventType,
                                employee.getId(),
                                TOPIC,
                                exception
                        );
                    }
                });
    }
}
