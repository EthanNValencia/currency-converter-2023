package com.nephew.microservices.mysqlcrud.controllers;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nephew.common.entities.Date;
import com.nephew.microservices.mysqlcrud.services.DateService;

@RestController
@RequestMapping("/cc-mysql-crud")
public class DateController {

	private Logger logger = LoggerFactory.getLogger(DateController.class);

	@Autowired
	private DateService dateService;

	@GetMapping("/find-date/id={id}")
	public Date findDateById(@PathVariable Long id) {
		return dateService.findById(id);
	}

	@GetMapping("/find-date/date={date}")
	public Date findByLocalDate(@PathVariable LocalDate date) {
		return dateService.findByDate(date);
	}
	
	@GetMapping("/contains-date/localdate={localDate}")
	public Boolean doesDatabaseContainLocalDate(@PathVariable LocalDate localDate) {
		Boolean containsDate = dateService.doesDatabaseContainDate(localDate);
		return containsDate;
	}

	@PostMapping("/save-date")
	public Date saveDate(@RequestBody Date date) {
		return dateService.saveDate(date);
	}

	@DeleteMapping("/delete-date")
	public void deleteDate(@RequestBody Date date) {
		dateService.deleteDate(date);
	}
	
	
	@PostMapping("/create-date/date={date}")
	public Date createDate(@PathVariable LocalDate date) {
		Date savedDate = dateService.saveLocalDate(date);
		return savedDate;
	}
}
