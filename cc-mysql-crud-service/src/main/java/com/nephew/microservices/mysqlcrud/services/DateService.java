package com.nephew.microservices.mysqlcrud.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.common.entities.Date;
import com.nephew.microservices.mysqlcrud.repositories.DateRepository;

@Service
public class DateService {
	
	@Autowired
	private DateRepository repo;
	
	public Date findById(Long id) {
		return repo.findById(id).get();
	}
	
	public Date findByDate(LocalDate date) {
		return repo.findByDate(date).get();
	}

	public Boolean doesDatabaseContainDate(LocalDate date) {
		Optional<Date> localDate = repo.findDistinctByDate(date);
		if(localDate.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public Date saveDate(Date date) {
		return repo.save(date);
	}
	
	public void deleteDate(Date date) {
		repo.delete(date);
	}

}
