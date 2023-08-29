package com.nephew.microservices.validator;

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
	
	@GetMapping("contains-pair/base={base}&quote={quote}")
	public Boolean validateCurrencyPairByDateRange(@PathVariable String base, @PathVariable String quote) {
		Boolean pairIsValid = service.validateCurrencyPair(base, quote);
		if(pairIsValid) {
			return true;
		}
		return false;
	}
	
	@GetMapping("contains-dates/begin={beginDate}&end={endDate}")
	public Boolean validateDates(@PathVariable LocalDate beginDate, @PathVariable LocalDate endDate) {
		Boolean rangeIsValid = service.validateDateRange(beginDate, endDate);
		if(rangeIsValid) {
			return true;
		}
		return false;
	}
	

}

