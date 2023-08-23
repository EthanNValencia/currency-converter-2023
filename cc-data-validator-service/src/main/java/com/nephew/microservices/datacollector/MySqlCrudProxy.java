package com.nephew.microservices.datacollector;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cc-mysql-crud-service", url = "${MY_SQL_CRUD_URI:http://localhost}:8110")
public interface MySqlCrudProxy {

	@GetMapping("/cc-mongo-crud/from/{from}/to/{to}/period/{period}")
	public List<FxdsRoot> retrieveChartData(@PathVariable String from, @PathVariable String to, @PathVariable String period);
	
	@GetMapping("/cc-mysql-crud/get-all-responses")
	public List<FxdsResponse> getAllResponses();
	
	@GetMapping("/cc-mysql-crud/get-max-date")
	public LocalDate getMaxCloseTime();
	
	@GetMapping("/cc-mysql-crud/get-min-date")
	public LocalDate getMinCloseTime();
	
	@GetMapping("/cc-mysql-crud/get-all-dates")
	public List<?> getAllCloseTimes();

}
