package com.nephew.microservices.mysqlcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nephew.microservices.mysqlcrud.repositories.PairRepository;
import com.nephew.microservices.mysqlcrud.entities.Pair;

@SpringBootApplication
public class MySqlCrudMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlCrudMicroserviceApplication.class, args);
	}
	
	@Autowired
	private PairRepository pairRepo;
	
	// @Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Pair pair = new Pair();
			pair.setBaseCurrency("USD");
			pair.setQuoteCurrency("EUR");
			pairRepo.save(pair);
		};
	}
	

/*

The bean 'dateRepository', defined in com.nephew.microservices.mysqlcrud.repositories.DateRepository defined in 
@EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration, could not be registered. 
A bean with that name has already been defined in com.nephew.microservices.mysqlcrud.repositories.DateRepository defined in 
@EnableJdbcRepositories declared on JdbcRepositoriesRegistrar.EnableJdbcRepositoriesConfiguration and overriding is disabled.


 */
	
	
	
	
}