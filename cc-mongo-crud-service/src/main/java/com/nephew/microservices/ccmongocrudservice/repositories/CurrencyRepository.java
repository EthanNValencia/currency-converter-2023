package com.nephew.microservices.ccmongocrudservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nephew.microservices.ccmongocrudservice.documents.Currency;
import com.nephew.microservices.ccmongocrudservice.documents.CurrencyConversion;

public interface CurrencyRepository extends MongoRepository<CurrencyConversion, String> {

	List<CurrencyConversion> findAllByNameIgnoreCase(String name);

}
