package com.hcl.airport_management_system_server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirportManagementSystemServerApplication 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AirportManagementSystemServerApplication.class);
	
	public static void main(String[] args) {
		
		LOGGER.info("Application Started");
		SpringApplication.run(AirportManagementSystemServerApplication.class, args);
	}

}
