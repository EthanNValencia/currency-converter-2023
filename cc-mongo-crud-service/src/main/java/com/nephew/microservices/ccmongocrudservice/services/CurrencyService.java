package com.nephew.microservices.ccmongocrudservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nephew.microservices.ccmongocrudservice.documents.Currency;
import com.nephew.microservices.ccmongocrudservice.documents.CurrencyConversion;
import com.nephew.microservices.ccmongocrudservice.repositories.CurrencyRepository;

@Service
public class CurrencyService {

	private final CurrencyRepository currencyRepository;

	public CurrencyService(CurrencyRepository currencyRepository) {
		super();
		this.currencyRepository = currencyRepository;
	}

	public List<CurrencyConversion> searchByName(String from, String to) {
		String searchString = from + "to" + to;
		System.out.println("Searching for " + searchString);
		return currencyRepository.findAllByNameIgnoreCase(searchString);
	}

}
