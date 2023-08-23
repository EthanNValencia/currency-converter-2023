package com.nephew.microservices.mysqlcrud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nephew.microservices.mysqlcrud.entities.Rate;
import com.nephew.microservices.mysqlcrud.fxds.FxdsResponse;
import com.nephew.microservices.mysqlcrud.fxds.FxdsRoot;
import com.nephew.microservices.mysqlcrud.fxds.FxdsService;
import com.nephew.microservices.mysqlcrud.services.RateService;

@RestController
@RequestMapping("/cc-mysql-crud")
public class MySqlCrudController {

	private Logger logger = LoggerFactory.getLogger(MySqlCrudController.class);
	
	// @Autowired
	// private Environment environment;

	@Autowired
	private FxdsService fxdsService;

	@Autowired
	private RateService rateService;
	
	/*
	 * @GetMapping("/cc-mysql-crud/test") public String test() {
	 * logger.info("test endpoint reached"); String port =
	 * environment.getProperty("local.server.port"); String host =
	 * environment.getProperty("HOSTNAME"); String version = "v1"; String response =
	 * port + " " + version + " " + host;
	 * logger.info("test endpoint reached with a successful response."); return
	 * response; }
	 */

	@PostMapping("/save-root")
	public void saveAllCurrencyData(@RequestBody FxdsRoot root) {
		logger.info("saveAllCurrencyData called with {} items in the response arraylist.", root.getResponse().size());
		fxdsService.saveAllFxdsResponse(root);
		logger.info("SUCCESS saveAllCurrencyData called with {} items in the response arraylist was successful.",
				root.getResponse().size());
	}

	@GetMapping("/get-all-responses")
	public List<FxdsResponse> getAllResponses() {
		logger.info("All currency data was requested.");
		return fxdsService.getAllResponses();
	}
	
	@GetMapping("/get-max-date")
	public LocalDate getMaxCloseTime() {
		logger.info("The max currency date was requested.");
		return fxdsService.getMaxCloseTime();
	}
	
	@GetMapping("/get-min-date")
	public LocalDate getMinCloseTime() {
		logger.info("The min currency date was requested.");
		return fxdsService.getMinCloseTime();
	}
	
	@GetMapping("/get-all-dates")
	public List<?> getAllCloseTimes() {
		logger.info("The min currency date was requested.");
		return fxdsService.getAllCloseTimes();
	}
	
	@GetMapping("/base={base}&quote={quote}&start_date={startDate}&end_date={endDate}")
	public List<Rate> getRatesByBaseQuoteAndRange(@PathVariable String base, @PathVariable String quote,
			@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
		List<Rate> rates = rateService.findByBaseQuoteAndRange(base, quote, startDate, endDate);
		
		return rates;
		
	}

}
