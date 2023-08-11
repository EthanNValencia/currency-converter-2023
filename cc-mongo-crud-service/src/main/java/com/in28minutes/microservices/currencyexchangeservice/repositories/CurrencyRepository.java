package com.in28minutes.microservices.currencyexchangeservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.in28minutes.microservices.currencyexchangeservice.documents.Currency;
import com.in28minutes.microservices.currencyexchangeservice.documents.CurrencyConversion;

public interface CurrencyRepository extends MongoRepository<CurrencyConversion, String> {

	List<CurrencyConversion> findAllByNameIgnoreCase(String name);

}
