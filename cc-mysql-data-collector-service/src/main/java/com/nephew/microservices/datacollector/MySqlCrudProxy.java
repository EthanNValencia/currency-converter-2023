package com.nephew.microservices.datacollector;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "currency-exchange", url = "${MY_SQL_CRUD_URI:http://localhost}:8110")
public interface MySqlCrudProxy {

	@GetMapping("/cc-mongo-crud/from/{from}/to/{to}/period/{period}")
	public List<FxdsRoot> retrieveChartData(@PathVariable String from, @PathVariable String to, @PathVariable String period);
	
	@PostMapping("/cc-mysql-crud/save-root")
	public void saveCurrencyData(@RequestBody FxdsRoot root);

}
