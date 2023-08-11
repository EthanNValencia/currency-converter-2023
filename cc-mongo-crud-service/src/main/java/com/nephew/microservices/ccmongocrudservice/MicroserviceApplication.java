package com.nephew.microservices.ccmongocrudservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nephew.microservices.ccmongocrudservice.constants.Constants;
import com.nephew.microservices.ccmongocrudservice.constants.Constants.CALENDRICAL_PERIOD;
import com.nephew.microservices.ccmongocrudservice.documents.CurrencyPeriod;
import com.nephew.microservices.ccmongocrudservice.documents.CurrencyConversion;
import com.nephew.microservices.ccmongocrudservice.repositories.CurrencyRepository;

@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

	// TODO - generate some test data for the database
	@Bean
	public CommandLineRunner commandLineRunner(CurrencyRepository currencyRepository) {
		return args -> {
			generateTestData(currencyRepository);
		};
	}

	public void generateTestData(CurrencyRepository currencyRepository) {
		Currency usdCurrency = Currency.getInstance("USD");
		currencyRepository.deleteAll();
		String to = "EUR";
		String from = "USD";
		// String name = "USDtoEUR";
		CurrencyConversion usdToEurDays = new CurrencyConversion(from, to,
				Constants.CALENDRICAL_PERIOD.DAYS.toString(),
				generateHistoricalList(CALENDRICAL_PERIOD.DAYS, to, from, 900));
		CurrencyConversion usdToEurWeeks = new CurrencyConversion(from, to,
				Constants.CALENDRICAL_PERIOD.WEEKS.toString(),
				generateHistoricalList(CALENDRICAL_PERIOD.WEEKS, to, from, 500));
		CurrencyConversion usdToEurMonths = new CurrencyConversion(from, to,
				Constants.CALENDRICAL_PERIOD.MONTHS.toString(),
				generateHistoricalList(CALENDRICAL_PERIOD.MONTHS, to, from, 300));
		CurrencyConversion usdToEurYears = new CurrencyConversion(from, to,
				Constants.CALENDRICAL_PERIOD.YEARS.toString(),
				generateHistoricalList(CALENDRICAL_PERIOD.YEARS, to, from, 30));
		System.out.println("Inserting test data...");
		currencyRepository.insert(usdToEurDays);
		currencyRepository.insert(usdToEurWeeks);
		currencyRepository.insert(usdToEurMonths);
		currencyRepository.insert(usdToEurYears);
		System.out.println("Inserted test data.");
	}

	public List<CurrencyPeriod> generateHistoricalList(CALENDRICAL_PERIOD period, String to, String from, int size) {
		List<CurrencyPeriod> currencyList = new ArrayList<CurrencyPeriod>();
		for (int i = 0; i < size; i++) {
			CurrencyPeriod c = new CurrencyPeriod();
			// c.setId("" + i);
			c.setDate(generateDate(period, i));
			c.setFromRate(1.0);
			c.setToRate(toValGenerator(0.5, 1.3));
			currencyList.add(c);
		}
		return currencyList;
	}

	public LocalDate generateDate(CALENDRICAL_PERIOD period, int i) {
		switch (period) {
		case DAYS:
			return LocalDate.now().minusDays(i);
		case WEEKS:
			return LocalDate.now().minusWeeks(i);
		case MONTHS:
			return LocalDate.now().minusMonths(i);
		case YEARS:
			return LocalDate.now().minusYears(i);
		}
		return null;
	}

	public double toValGenerator(double min, double max) {
		Random r = new Random();
		return (r.nextInt((int) ((max - min) * 10 + 1)) + min * 10) / 10.0;
	}

}