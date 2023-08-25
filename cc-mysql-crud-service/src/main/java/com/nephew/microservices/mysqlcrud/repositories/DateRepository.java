package com.nephew.microservices.mysqlcrud.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nephew.common.entities.Date;


@Repository
public interface DateRepository extends JpaRepository<Date, Long> {

	Optional<Date> findDistinctByDate(LocalDate date);
	
	Optional<Date> findByDate(LocalDate date);

}
