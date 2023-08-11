package com.nephew.microservices.ccmongoentryservice;

import java.util.List;

public class CurrencyConversion {

	private String id;
	private String name; // ex USDtoEUR
	private String environment;
	private List<Currency> currency;

	public CurrencyConversion(String name, List<Currency> currency) {
		super();
		this.name = name;
		this.currency = currency;
	}

	public CurrencyConversion() {
		super();
	}
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Currency> getCurrency() {
		return currency;
	}

	public void setCurrency(List<Currency> currency) {
		this.currency = currency;
	}

	public void appendEnvironment(String environment) {
		this.environment = this.environment + " -> " + environment;
	}

}
