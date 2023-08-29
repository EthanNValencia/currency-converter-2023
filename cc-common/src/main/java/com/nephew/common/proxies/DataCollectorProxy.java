package com.nephew.common.proxies;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nephew.common.entities.FxdsRoot;
import com.nephew.common.entities.XRatesUsdData;


/***
 * Version 0.0.2
 * 
 * @author Ethan
 */
@FeignClient(name = "cc-data-collector", url = "${DATA_VALIDATOR_URI:http://localhost}:8200/cc-data-collector")
public interface DataCollectorProxy {

	@GetMapping("/base={base}&quote={quote}&start_date={startDate}&end_date={endDate}")
	public FxdsRoot collectDataByDates(@PathVariable String base, @PathVariable String quote,
			@PathVariable LocalDate startDate, @PathVariable LocalDate endDate);

	@GetMapping("/todays-rates-base-usd")
	public HashSet<XRatesUsdData> getTodaysCurrencyDataBaseUsd();

	@GetMapping("/rates-base-usd/date={date}")
	public HashSet<XRatesUsdData> getCurrencyDataByDate(@PathVariable String date);

	@GetMapping("/rates-base-usd/start={start}&end={end}")
	public ArrayList<XRatesUsdData> getCurrencyDataBaseUsdByRange(@PathVariable String start,
			@PathVariable String end);

}
