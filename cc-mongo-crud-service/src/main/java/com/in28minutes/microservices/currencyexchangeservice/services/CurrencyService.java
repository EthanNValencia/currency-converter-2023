package com.in28minutes.microservices.currencyexchangeservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.in28minutes.microservices.currencyexchangeservice.documents.Currency;
import com.in28minutes.microservices.currencyexchangeservice.repositories.CurrencyRepository;

@Service
public class CurrencyService {

	private final CurrencyRepository currencyRepository;

	public CurrencyService(CurrencyRepository currencyRepository) {
		super();
		this.currencyRepository = currencyRepository;
	}

	public List<Currency> searchByName(String to, String from) {
		return currencyRepository.findAllByNameIgnoreCase(from.concat("to" + to));
	}

}
