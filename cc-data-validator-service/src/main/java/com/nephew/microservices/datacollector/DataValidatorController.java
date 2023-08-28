package com.nephew.microservices.datacollector;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cc-data-validator")
public class DataValidatorController {

	private Logger logger = LoggerFactory.getLogger(DataValidatorController.class);

	@Autowired
	private DataValidatorService service;
	
	@GetMapping("/test")
	public String testing() {
		logger.info("Test endpoint has been reached.");
		return "Test was successful";
	}
	
	// validate currency conversion with a range. 
	@GetMapping("contains/base={base}&quote={quote}&begin={beginDate}&end={endDate}")
	public Boolean validateCurrencyPairByDateRange(@PathVariable String base, @PathVariable String quote, @PathVariable LocalDate beginDate, @PathVariable LocalDate endDate) {
		Boolean pairIsValid = service.validateCurrencyPair(base, quote);
		Boolean rangeIsValid = service.validateDateRange(beginDate, endDate);
		
		if(pairIsValid && rangeIsValid) {
			return true;
		}
		
		return false;
	}
	

}

