package com.nephew.microservices.mysqlcrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.microservices.mysqlcrud.repositories.PairRepository;

@Service
public class PairService {
	@Autowired
	private PairRepository repo;
}
