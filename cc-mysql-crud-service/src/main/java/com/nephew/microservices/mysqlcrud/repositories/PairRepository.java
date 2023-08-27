package com.nephew.microservices.mysqlcrud.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nephew.common.entities.Pair;

@Repository
public interface PairRepository extends JpaRepository<Pair, Long> {
	// TODO Need to test this.
	Optional<Pair> findByBaseCurrencyAndQuoteCurrency(String base, String quote);
	//     @Query(value = "SELECT * FROM products WHERE category = :category", nativeQuery = true)

	@Query(value = "SELECT EXISTS (SELECT * FROM pairs WHERE base_currency = :base AND quote_currency = :quote) as result", nativeQuery = true)
	int databaseContainsBaseAndQuote(String base, String quote);

	// SELECT EXISTS (SELECT * FROM pairs WHERE base_currency = :base AND quote_currency = :quote) as result;
}
