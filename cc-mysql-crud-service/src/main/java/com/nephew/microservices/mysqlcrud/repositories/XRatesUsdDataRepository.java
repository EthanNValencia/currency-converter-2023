package com.nephew.microservices.mysqlcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nephew.common.entities.XRatesUsdData;

@Repository
public interface XRatesUsdDataRepository extends JpaRepository<XRatesUsdData, Long> {

}
