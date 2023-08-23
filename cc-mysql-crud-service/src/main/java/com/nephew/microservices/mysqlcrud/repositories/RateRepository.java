package com.nephew.microservices.mysqlcrud.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nephew.microservices.mysqlcrud.entities.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
	
	// TODO Write this query
	@Query()
	List<Rate> findByBaseAndQuoteAndDateBetween(String base, String quote, LocalDate startDate, LocalDate endDate);

}


// @Query("SELECT r FROM Recipient r WHERE r.recipientPhone=?1 AND r.recipientId=?2")