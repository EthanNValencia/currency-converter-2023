package com.nephew.microservices.mysqlcrud.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nephew.microservices.mysqlcrud.entities.Rate;
import com.nephew.microservices.mysqlcrud.services.RateService;

@RestController
@RequestMapping("/cc-mysql-crud")
public class RateController {

	@Autowired
	private RateService rateService;
	
	@GetMapping("/find-rate/base={base}&quote={quote}&start_date={startDate}&end_date={endDate}")
	public List<Rate> getRatesByBaseQuoteAndRange(@PathVariable String base, @PathVariable String quote,
			@PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
		List<Rate> rates = rateService.findByBaseQuoteAndRange(base, quote, startDate, endDate);
		return rates;
	}
	
}
