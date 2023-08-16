package com.nephew.microservices.datacollector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_URI:http://localhost}:8000")
public interface MySqlCrudProxy {

	@GetMapping("/cc-mongo-crud/from/{from}/to/{to}/period/{period}")
	public void retrieveChartData(@PathVariable String from, @PathVariable String to, @PathVariable String period);

}
