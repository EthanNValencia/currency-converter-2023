package com.nephew.microservices.datacollector;

import java.time.LocalDate;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nephew.common.entities.XRatesUsdData;
import com.nephew.microservices.datacollector.webreader.WebReaderService;

/***
 * Rest Controller for the data collector. The data collector is meant to collect data that will be 
 * stored in the database and eventually used in the front-end. 
 * @author Ethan
 */
@RestController
@RequestMapping("/data-collector")
public class DataCollectorController {

	private Logger logger = LoggerFactory.getLogger(DataCollectorController.class);

	@Autowired
	private DataCollectorService service;
	
	@Autowired
	private WebReaderService wrService;

	@GetMapping("/test")
	public String testing() {
		return "Test was successful";
	}

	// TODO This is working. Consider breaking this logic out of the controller?
	@GetMapping("/base={base}&quote={quote}&start_date={startDate}&end_date={endDate}")
	public FxdsRoot collectDataByDates(@PathVariable String base, @PathVariable String quote,
			@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
		logger.info("collectDataByDates called with {} to {} period {}-{}.", base, quote, startDate, endDate);
		FxdsRoot root;
		try {
			root = service.processRequest(base, quote, startDate, endDate);
			logger.info(
					"SUCCESS collectDataByDates called with {} to {} period {}-{} request was fullfilled.",
					base, quote, startDate, endDate);
			return root;
		} catch (InvalidDatesException e) {
			e.printStackTrace();
		}
		logger.warn("FAILURE collectDataByDates called with {} to {} period {}-{} request not fullfilled. Something went wrong.",base, quote, startDate, endDate);
		return null;
	}
	
	@GetMapping("/todays-rates-base-usd")
	public HashSet<XRatesUsdData> getTodaysCurrencyDataBaseUsd() {
		return wrService.collectTodaysCurrencyDataBaseUsd();
	}
	
	@GetMapping("/rates-base-usd/date/{date}")
	public HashSet<XRatesUsdData> getTodaysCurrencyDataBaseUsd(@PathVariable LocalDate date) {
		return wrService.collectCurrencyDataBaseUsdByLocalDate(date);
	}

}
