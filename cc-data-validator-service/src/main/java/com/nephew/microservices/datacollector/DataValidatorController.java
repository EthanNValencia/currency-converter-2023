package com.nephew.microservices.datacollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data-validator")
public class DataValidatorController {

	private Logger logger = LoggerFactory.getLogger(DataValidatorController.class);

	@GetMapping("/test")
	public String testing() {
		logger.info("Test endpoint has been reached.");
		return "Test was successful";
	}
	
	// validate currency conversion with a range. 
	@GetMapping("")
	public String validateByDateRange() {
		
		return "validated";
	}
	

}

