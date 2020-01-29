package com.cognizant.BDS;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//@EnableEurekaClient
@SpringBootApplication
public class BloodBankApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BloodBankApplication.class);
	
	public static void main(String[]args)  throws ParseException {
		ApplicationContext applicationContext = SpringApplication.run(BloodBankApplication.class, args);
	}
}
