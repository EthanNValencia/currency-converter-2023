package com.nephew.microservices.ccentryservice;

import java.time.LocalDate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/***
 * Version 0.0.2
 * 
 * @author Ethan
 */
@FeignClient(name = "cc-data-validator", url = "${DATA_VALIDATOR_URI:http://localhost}:8250/cc-data-validator")
public interface DataValidatorProxy {
	@GetMapping("contains-pair/base={base}&quote={quote}")
	public Boolean validateCurrencyPairByDateRange(@PathVariable String base, @PathVariable String quote);
	
	@GetMapping("contains-dates/begin={beginDate}&end={endDate}")
	public Boolean validateDates(@PathVariable LocalDate beginDate, @PathVariable LocalDate endDate);
	
	
}
