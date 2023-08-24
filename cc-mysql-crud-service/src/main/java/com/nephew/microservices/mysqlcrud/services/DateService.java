package com.nephew.microservices.mysqlcrud.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.microservices.mysqlcrud.repositories.DateRepository;

@Service
public class DateService {
	
	@Autowired
	private DateRepository repo;
	
	public LocalDate findByDate(LocalDate date) {
		// return repo.findByDate(date).get();
		return null;
	}

	public Boolean doesDatabaseContainDate(LocalDate date) {
		Optional<LocalDate> localDate = repo.findDistinctByDate(date);
		if(localDate.isEmpty()) {
			return false;
		}
		return true;
	}

}
