package com.nephew.microservices.mysqlcrud.controllers;

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

import com.nephew.microservices.mysqlcrud.entities.Pair;
import com.nephew.microservices.mysqlcrud.services.PairService;

@RestController
@RequestMapping("/cc-mysql-crud")
public class PairController {
	
	private Logger logger = LoggerFactory.getLogger(PairController.class);

	@Autowired
	private PairService pairService;
	
	@GetMapping("/find-pair/id={id}")
	public Pair findPairById(@PathVariable Long id) {
		return pairService.findById(id);
	}
	
	@GetMapping("/find-pair/base={base}&quote={quote}")
	public Pair findByBaseCurrencyAndQuoteCurrency(@PathVariable String base, @PathVariable String quote) {
		return pairService.findByBaseCurrencyAndQuoteCurrency(base, quote);
	}
	
	@PostMapping("/save-pair")
	public Pair savePair(@RequestBody Pair pair) {
		return pairService.savePair(pair);
	}
	
	@DeleteMapping("/delete-pair") 
	public void deletePair(@RequestBody Pair pair) {
		pairService.deletePair(pair);
	}
}
