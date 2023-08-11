package com.nephew.microservices.ccmongocrudservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nephew.microservices.ccmongocrudservice.documents.CurrencyPeriod;
import com.nephew.microservices.ccmongocrudservice.documents.CurrencyConversion;
import com.nephew.microservices.ccmongocrudservice.repositories.CurrencyRepository;

@Service
public class CurrencyService {

	private final CurrencyRepository currencyRepository;

	public CurrencyService(CurrencyRepository currencyRepository) {
		super();
		this.currencyRepository = currencyRepository;
	}

	public List<CurrencyConversion> searchByNameAndPeriod(String toName, String fromName, String period) {
		return currencyRepository.findByToNameIgnoreCaseAndFromNameIgnoreCaseAndCalendricalPeriodIgnoreCase(toName, fromName, period);
	}

}
