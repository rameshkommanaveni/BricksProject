package com.ramesh.kafka;

import org.springdoc.core.configuration.SpringDocDataRestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = {SpringDocDataRestConfiguration.class})
public class KafkaAppInit {

	public static void main(String[] args) {
		SpringApplication.run(KafkaAppInit.class, args);
	}
}
