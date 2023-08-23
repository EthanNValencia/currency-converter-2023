package com.nephew.microservices.mysqlcrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.microservices.mysqlcrud.repositories.RateRepository;

@Service
public class RateService {
	@Autowired
	private RateRepository repo;
}
