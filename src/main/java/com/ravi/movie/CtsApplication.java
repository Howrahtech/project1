package com.ravi.movie;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ravi.movie.MovieCru.FileStorageProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class CtsApplication {

	
	
	private static final Logger logger = LogManager.getLogger(CtsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CtsApplication.class, args);
	}

	 public void run(ApplicationArguments applicationArguments) throws Exception {
	        logger.debug("Debugging log");
	        logger.info("Info log");
	        logger.warn("Hey, This is a warning!");
	        logger.error("Oops! We have an Error. OK");
	        logger.fatal("Damn! Fatal error. Please fix me.");
	    }
}
