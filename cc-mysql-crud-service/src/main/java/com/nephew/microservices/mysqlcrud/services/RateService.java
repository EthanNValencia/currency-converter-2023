package com.nephew.microservices.mysqlcrud.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.common.entities.Rate;
import com.nephew.microservices.mysqlcrud.repositories.RateRepository;

@Service
public class RateService {
	@Autowired
	private RateRepository repo;

	public List<Rate> findByBaseQuoteAndRange(String base, String quote, LocalDate startDate, LocalDate endDate) {
		
		return null;
	}
}
