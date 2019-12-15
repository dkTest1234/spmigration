package com.wns.sp.migration.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SPMigrationApplication class is the starting point of the application
 * @author Dilip
 *
 */
@SpringBootApplication
public class SPMigrationApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SPMigrationApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(SPMigrationApplication.class, args);
		LOGGER.info(" SPMigrationApplication started.");
		
	}
}
