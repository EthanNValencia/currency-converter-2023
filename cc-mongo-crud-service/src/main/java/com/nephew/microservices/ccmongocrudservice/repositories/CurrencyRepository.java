package com.nephew.microservices.ccmongocrudservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nephew.microservices.ccmongocrudservice.documents.CurrencyPeriod;
import com.nephew.microservices.ccmongocrudservice.documents.CurrencyConversion;

public interface CurrencyRepository extends MongoRepository<CurrencyConversion, String> {

	// List<CurrencyConversion> findAllByToNameIgnoreCase(String name);

	List<CurrencyConversion> findByToNameIgnoreCaseAndFromNameIgnoreCaseAndCalendricalPeriodIgnoreCase(String toName, String fromName, String period);

}
