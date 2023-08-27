package com.nephew.microservices.ccentryservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nephew.common.entities.Pair;

@RestController
public class EntryController {

	// private Logger logger = LoggerFactory.getLogger(EntryController.class);

	@Autowired
	private MySqlCrudProxy mySqlProxy;

	@GetMapping("/test")
	public Pair test() {
		Pair pair = mySqlProxy.findByBaseCurrencyAndQuoteCurrency("USD", "EUR");
		return pair;
	}
	

}
