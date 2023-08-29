package com.nephew.microservices.ccentryservice;

import java.time.LocalDate;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nephew.common.entities.Pair;
import com.nephew.common.entities.XRatesUsdData;

@RestController
public class EntryController {

	private Logger logger = LoggerFactory.getLogger(EntryController.class);

	@Autowired
	private MySqlCrudProxy mySqlProxy;
	
	@Autowired
	private DataValidatorProxy dataValidatorProxy;
	
	@Autowired
	private DataCollectorProxy dataCollectorProxy;

	@GetMapping("/test/get-pair")
	public Pair testGetPair() {
		Pair pair = mySqlProxy.findByBaseCurrencyAndQuoteCurrency("USD", "EUR");
		return pair;
	}
	
	@GetMapping("/validate/base={base}&quote={quote}&begin={beginDate}&end={endDate}")
	public void validate(@PathVariable String base, @PathVariable String quote, @PathVariable LocalDate beginDate, @PathVariable LocalDate endDate) {
		
		Boolean pairIsValid = dataValidatorProxy.validateCurrencyPairByDateRange(base, quote);
		if(!pairIsValid) {
			logger.warn("The currency pair was not validated: {} {}", base, quote);
		} else if(pairIsValid) {
			logger.info("The currency pair was validated: {} {}", base, quote);
		}
		
		Boolean dateRangeIsValid = dataValidatorProxy.validateDates(beginDate, endDate);
		if(!dateRangeIsValid) {
			logger.warn("The date range was not validated: {} {}", beginDate, endDate);
		} else if(dateRangeIsValid) {
			logger.info("The date range was validated: {} {}", beginDate, endDate);
		}
	}
	
	@GetMapping("/save-x-rates-3-years")
	public ArrayList<XRatesUsdData> collectAndSaveXRatesUsdBase() {
		ArrayList<XRatesUsdData> xRatesList = dataCollectorProxy.getCurrencyDataBaseUsdByRange(LocalDate.now().toString(), LocalDate.of(2021, 1, 1).toString());
		mySqlProxy.saveAllXRates(xRatesList);
		return xRatesList;
	}

}
