package com.nephew.microservices.mysqlcrud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FxdsResponseRepository extends JpaRepository<FxdsResponse, Long> {
	
}
