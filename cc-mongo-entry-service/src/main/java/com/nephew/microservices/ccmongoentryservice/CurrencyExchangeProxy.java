package com.nephew.microservices.ccmongoentryservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_URI:http://localhost}:8000")
public interface CurrencyExchangeProxy {

	@GetMapping("/cc-mongo-crud/from/{from}/to/{to}")
	public CurrencyConversion retrieveChartData(@PathVariable String from, @PathVariable String to);

}
