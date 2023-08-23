package com.nephew.microservices.mysqlcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nephew.microservices.mysqlcrud.entities.Date;

@Repository
public interface DateRepository extends JpaRepository<Date, Long> {

}
