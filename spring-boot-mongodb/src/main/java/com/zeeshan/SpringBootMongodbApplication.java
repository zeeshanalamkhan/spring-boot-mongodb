package com.zeeshan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMongodbApplication {

	private static final Logger logger = LogManager.getLogger(SpringBootMongodbApplication.class);

	public static void main(String[] args) {

		logger.info("SpringBootMongodbApplication class execution started");

		SpringApplication.run(SpringBootMongodbApplication.class, args);

		logger.info("SpringBootMongodbApplication execution finished");
		
	}

}
