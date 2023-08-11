package com.nephew.microservices.ccmongocrudservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nephew.microservices.ccmongocrudservice.documents.CurrencyConversion;
import com.nephew.microservices.ccmongocrudservice.services.CurrencyService;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private CurrencyService currencyService;

	@Autowired
	private Environment environment;

	@GetMapping("/cc-mongo-crud/from/{from}/to/{to}/period/{period}")
	public CurrencyConversion retrieveChartData(@PathVariable String from, @PathVariable String to, @PathVariable String period) {
		logger.info("retrieveChartData called with {} to {}", from, to);
		List<CurrencyConversion> currencyExchange = currencyService.searchByNameAndPeriod(to, from, period);
		if (currencyExchange.isEmpty()) {
			throw new RuntimeException("Unable to Find data for " + from + " to " + to);
		}
		String port = environment.getProperty("local.server.port");
		// CHANGE-KUBERNETES
		String host = environment.getProperty("HOSTNAME");
		String version = "v1";
		// currencyExchange.setEnvironment(port + " " + version + " " + host);
		currencyExchange.get(0).setEnvironment(port + " " + version + " " + host);
		logger.info("retrieveChartData called with {} to {} with a successful response.", from, to);
		return currencyExchange.get(0);
	}

}
