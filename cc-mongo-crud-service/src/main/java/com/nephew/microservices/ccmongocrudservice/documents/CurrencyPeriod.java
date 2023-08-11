package com.nephew.microservices.ccmongocrudservice.documents;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Can represent a day, week, month, or a year.
@Document
public class CurrencyPeriod {

	private Double fromRate;
	private Double toRate;
	private LocalDate date;

	public CurrencyPeriod() {
		super();
	}

	public Double getFromRate() {
		return fromRate;
	}

	public void setFromRate(Double fromRate) {
		this.fromRate = fromRate;
	}

	public Double getToRate() {
		return toRate;
	}

	public void setToRate(Double toRate) {
		this.toRate = toRate;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


}
