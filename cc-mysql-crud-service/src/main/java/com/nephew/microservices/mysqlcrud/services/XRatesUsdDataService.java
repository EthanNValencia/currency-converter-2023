package com.nephew.microservices.mysqlcrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.common.entities.XRatesUsdData;
import com.nephew.microservices.mysqlcrud.repositories.XRatesUsdDataRepository;

@Service
public class XRatesUsdDataService {
	
	@Autowired
	private XRatesUsdDataRepository repo;
	

	public void saveAll(List<XRatesUsdData> data) {
		repo.saveAll(data);
	}

	public List<XRatesUsdData> getAll() {
		return repo.findAll();
	}
	
}
