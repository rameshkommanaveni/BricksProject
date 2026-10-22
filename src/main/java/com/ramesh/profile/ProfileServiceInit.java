package com.ramesh.profile;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


import lombok.extern.slf4j.Slf4j;



@Slf4j
@SpringBootApplication
public class ProfileServiceInit extends SpringBootServletInitializer {


	public static void main(String[] args) {

		final Logger log = LoggerFactory.getLogger(ProfileServiceInit.class);
		if (StringUtils.isBlank(System.getProperty("spring.profiles.active"))) {

			log.info("Missing spring.profiles.active setup, init with DEV config");
			System.setProperty("spring.profiles.active", "local");
		}
		SpringApplication.run(ProfileServiceInit.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(ProfileServiceInit.class);
	}


}
