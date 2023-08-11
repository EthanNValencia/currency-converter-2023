package com.in28minutes.microservices.currencyexchangeservice;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.in28minutes.microservices.currencyexchangeservice.documents.Currency;
import com.in28minutes.microservices.currencyexchangeservice.documents.CurrencyConversion;
import com.in28minutes.microservices.currencyexchangeservice.repositories.CurrencyRepository;

@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}
	
	
	// TODO - generate some test data for the database
	@Bean
	public CommandLineRunner commandLineRunner(CurrencyRepository productRepository) {
		return args -> {
			productRepository.deleteAll();
			String to = "EUR";
			String from = "USD";
			String name = "USDtoEUR";
			CurrencyConversion usdToEur = new CurrencyConversion(name, generateHistoricalList(to, from));
		};
	}
	
	public List<Currency> generateHistoricalList(String to, String from) {
		
		return null;
	}
	

}
