package com.nephew.microservices.mysqlcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySqlCrudMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlCrudMicroserviceApplication.class, args);
	}
	
	@Autowired
	private CurrencyConversionRepository repo;
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			FxdsResponse response = new FxdsResponse();
			response.setBaseCurrency("USD");
			response.setQuoteCurrency("EUR");
			// response.setId(1l);
			repo.save(response);
		};
	}

}