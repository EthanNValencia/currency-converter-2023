package com.nephew.microservices.datacollector;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nephew.common.entities.*;

/***
 * Version 0.0.1
 * 
 * @author Ethan
 */
@FeignClient(name = "cc-mysql-crud-service", url = "${MY_SQL_CRUD_URI:http://localhost}:8110/cc-mysql-crud")
public interface MySqlCrudProxy {

	// Begin Date
	@GetMapping("/find-date/id={id}")
	public Date findDateById(@PathVariable Long id);

	@GetMapping("/find-date/date={date}")
	public Date findByLocalDate(@PathVariable LocalDate date);

	@GetMapping("/contains-date/date={date}")
	public Boolean doesDatabaseContainLocalDate(@PathVariable LocalDate date);

	@PostMapping("/save-date")
	public Date saveDate(@RequestBody Date date);

	@DeleteMapping("/delete-date")
	public void deleteDate(@RequestBody Date date);
	
	@PostMapping("/create-date/date={date}")
	public Date createDate(@PathVariable LocalDate date);
	// End Date

	// Begin Fxds
	@PostMapping("/save-root")
	public void saveAllCurrencyData(@RequestBody FxdsRoot root);

	@GetMapping("/get-all-responses")
	public List<FxdsResponse> getAllResponses();

	@GetMapping("/get-max-date")
	public LocalDate getMaxCloseTime();

	@GetMapping("/get-min-date")
	public LocalDate getMinCloseTime();

	@GetMapping("/get-all-dates")
	public List<?> getAllCloseTimes();
	// End Fxds

	// Begin Pair
	@GetMapping("/find-pair/id={id}")
	public Pair findPairById(@PathVariable Long id);

	@GetMapping("/find-pair/base={base}&quote={quote}")
	public Pair findByBaseCurrencyAndQuoteCurrency(@PathVariable String base, @PathVariable String quote);

	@GetMapping("/contains/base={base}&quote={quote}&begin={beginDate}&end={endDate}")
	public Boolean doesDatabaseContainCurrencyPairAndDateRange(@PathVariable String base, @PathVariable String quote, @PathVariable LocalDate beginDate, @PathVariable LocalDate startDate);
	
	@PostMapping("/save-pair")
	public Pair savePair(@RequestBody Pair pair);

	@DeleteMapping("/delete-pair")
	public void deletePair(@RequestBody Pair pair);
	
	@GetMapping("/contains-pair/base={base}&quote={quote}")
	public Boolean databaseContainsBaseAndQuote(@PathVariable String base, @PathVariable String quote);
	// End Pair

	// Begin Rate
	@GetMapping("/find-rate/base={base}&quote={quote}&start_date={startDate}&end_date={endDate}")
	public List<Rate> getRatesByBaseQuoteAndRange(@PathVariable String base, @PathVariable String quote,
			@PathVariable LocalDate startDate, @PathVariable LocalDate endDate);
	// End Rate
}
