package com.nephew.microservices.mysqlcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nephew.microservices.mysqlcrud.entities.Pair;

@Repository
public interface PairRepository extends JpaRepository<Pair, Long> {

	Pair findByBaseCurrencyAndQuoteCurrency(String base, String quote);

}
