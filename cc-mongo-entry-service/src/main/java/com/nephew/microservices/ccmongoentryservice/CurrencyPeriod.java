package com.nephew.microservices.ccmongoentryservice;

import java.time.LocalDate;

// Can represent a day, week, month, or a year.
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
