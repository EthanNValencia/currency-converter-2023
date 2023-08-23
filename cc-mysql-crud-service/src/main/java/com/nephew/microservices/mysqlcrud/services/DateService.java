package com.nephew.microservices.mysqlcrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.microservices.mysqlcrud.repositories.DateRepository;

@Service
public class DateService {
	
	@Autowired
	private DateRepository repo;

}
