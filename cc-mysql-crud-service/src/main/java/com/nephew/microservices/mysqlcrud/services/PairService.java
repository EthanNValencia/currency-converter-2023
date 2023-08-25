package com.nephew.microservices.mysqlcrud.services;
// 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.common.entities.Pair;
import com.nephew.microservices.mysqlcrud.repositories.PairRepository;

@Service
public class PairService {
	
	@Autowired
	private PairRepository repo;
	
	public Pair findById(Long id) {
		return repo.findById(id).get();
	}
	
	public Pair findByBaseCurrencyAndQuoteCurrency(String base, String quote) {
		return repo.findByBaseCurrencyAndQuoteCurrency(base, quote).get();
	}
	
	public Pair savePair(Pair pair) {
		return repo.save(pair);
	}
	
	public void deletePair(Pair pair) {
		repo.delete(pair);
	}
	
}
