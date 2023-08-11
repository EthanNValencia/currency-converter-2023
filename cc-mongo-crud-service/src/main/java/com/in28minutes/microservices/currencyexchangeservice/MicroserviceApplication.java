package com.in28minutes.microservices.currencyexchangeservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	public CommandLineRunner commandLineRunner(CurrencyRepository currencyRepository) {
		return args -> {
			currencyRepository.deleteAll();
			String to = "EUR";
			String from = "USD";
			// String name = "USDtoEUR";
			CurrencyConversion usdToEur = new CurrencyConversion(from + "to" + to, generateHistoricalList(to, from));
			System.out.println("Inserting test data...");
			currencyRepository.insert(usdToEur);
			System.out.println("Inserted test data.");
		};
	}
	
	public List<Currency> generateHistoricalList(String to, String from) {
		List<Currency> currencyList = new ArrayList<Currency>();
		for(int i = 0; i < 90; i++) {
			Currency c = new Currency();
			c.setToName(to); // EUR
			c.setFromName(from); // USD
			c.setDate(LocalDate.now().minusDays(i));
			c.setFromRate(1.0);
			c.setToRate(toValGenerator(0.5, 1.3));
			c.setDescription();
			currencyList.add(c);
		}
		return currencyList;
	}
	
	public double toValGenerator(double min, double max) {
	    Random r = new Random();
	    return (r.nextInt((int)((max-min)*10+1))+min*10) / 10.0;
	}
	
}