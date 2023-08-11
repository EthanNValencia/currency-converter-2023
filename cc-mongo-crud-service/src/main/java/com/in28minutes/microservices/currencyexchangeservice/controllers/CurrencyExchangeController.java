package com.in28minutes.microservices.currencyexchangeservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.documents.Currency;
import com.in28minutes.microservices.currencyexchangeservice.services.CurrencyService;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private CurrencyService currencyService;

	@Autowired
	private Environment environment;

	@GetMapping("/currency-crud-mongo/from/{from}/to/{to}")
	public Currency retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		logger.info("retrieveExchangeValue called with {} to {}", from, to);

		List<Currency> currencyExchange = currencyService.searchByName(from, to);

		if (currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for " + from + " to " + to);
		}

		String port = environment.getProperty("local.server.port");

		// CHANGE-KUBERNETES
		String host = environment.getProperty("HOSTNAME");
		String version = "v1";
		// currencyExchange.setEnvironment(port + " " + version + " " + host);

		return currencyExchange.get(0);

	}

}
