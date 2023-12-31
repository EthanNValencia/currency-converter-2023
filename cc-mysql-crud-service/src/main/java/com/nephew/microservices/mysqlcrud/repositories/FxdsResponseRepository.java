package com.nephew.microservices.mysqlcrud.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nephew.common.entities.FxdsResponse;

@Repository
public interface FxdsResponseRepository extends JpaRepository<FxdsResponse, Long> {
	@Query(value = "SELECT MAX(DATE(close_time)) FROM currency_db.currency_conversion", nativeQuery = true)
	LocalDate getTheMaxCloseTime();

	@Query(value = "SELECT MIN(DATE(close_time)) FROM currency_db.currency_conversion", nativeQuery = true)
	LocalDate getTheMinCloseTime();

	// SELECT DISTINCT DATE(close_time) AS unique_dates FROM
	// currency_db.currency_conversion;
	@Query(value = "SELECT DISTINCT DATE(close_time) FROM currency_db.currency_conversion", nativeQuery = true)
	List<?> getAllCloseTimes();
}
