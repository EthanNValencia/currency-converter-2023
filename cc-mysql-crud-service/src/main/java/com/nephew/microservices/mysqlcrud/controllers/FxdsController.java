package com.nephew.microservices.mysqlcrud.controllers;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nephew.microservices.mysqlcrud.entities.FxdsResponse;
import com.nephew.microservices.mysqlcrud.entities.FxdsRoot;
import com.nephew.microservices.mysqlcrud.services.FxdsService;

@RestController
@RequestMapping("/cc-mysql-crud")
public class FxdsController {

	private Logger logger = LoggerFactory.getLogger(FxdsController.class);

	@Autowired
	private FxdsService fxdsService;

	@PostMapping("/save-root")
	public void saveAllCurrencyData(@RequestBody FxdsRoot root) {
		logger.info("saveAllCurrencyData called with {} items in the response arraylist.", root.getResponse().size());
		fxdsService.saveAllFxdsResponse(root);
		logger.info("SUCCESS saveAllCurrencyData called with {} items in the response arraylist was successful.",
				root.getResponse().size());
	}

	@GetMapping("/get-all-responses")
	public List<FxdsResponse> getAllResponses() {
		logger.info("All currency data was requested.");
		return fxdsService.getAllResponses();
	}
	
	@GetMapping("/get-max-date")
	public LocalDate getMaxCloseTime() {
		logger.info("The max currency date was requested.");
		return fxdsService.getMaxCloseTime();
	}
	
	@GetMapping("/get-min-date")
	public LocalDate getMinCloseTime() {
		logger.info("The min currency date was requested.");
		return fxdsService.getMinCloseTime();
	}
	
	@GetMapping("/get-all-dates")
	public List<?> getAllCloseTimes() {
		logger.info("The min currency date was requested.");
		return fxdsService.getAllCloseTimes();
	}
	
	
	

}
