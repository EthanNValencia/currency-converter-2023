package com.nephew.microservices.mysqlcrud.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.common.entities.FxdsResponse;
import com.nephew.common.entities.FxdsRoot;
import com.nephew.microservices.mysqlcrud.repositories.FxdsResponseRepository;

@Service
public class FxdsService {

	@Autowired
	private FxdsResponseRepository repo;

	public void saveFxdsResponse(FxdsRoot root) {
		for (FxdsResponse response : root.getResponse()) {
			repo.save(response);
		}
	}

	public void saveAllFxdsResponse(FxdsRoot root) {
		if (root.getResponse() != null) {
			repo.saveAll(root.getResponse());
		} else {
			// throw exception? 
		}
	}

	public List<FxdsResponse> getAllResponses() {
		return repo.findAll();
	}
	
	public LocalDate getMaxCloseTime() {
		LocalDate maxLocalDate = repo.getTheMaxCloseTime();
		return maxLocalDate;
	}
	
	public LocalDate getMinCloseTime() {
		LocalDate maxLocalDate = repo.getTheMinCloseTime();
		return maxLocalDate;
	}
	
	public List<?> getAllCloseTimes() {
		List<?> closeTimes = repo.getAllCloseTimes();
		return closeTimes;
	}
	
	private LocalDate convertDateToLocalDate(Date date) {
		Instant instant = date.toInstant();
		LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate;
	}

}
