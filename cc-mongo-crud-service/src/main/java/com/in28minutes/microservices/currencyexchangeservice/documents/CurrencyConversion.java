package com.in28minutes.microservices.currencyexchangeservice.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CurrencyConversion {

	@Id
	private String id;
	private String name; // ex USDtoEUR
	// @DBRef
	private List<Currency> currency;

	public CurrencyConversion(String name, List<Currency> currency) {
		super();
		this.name = name;
		this.currency = currency;
	}

	public CurrencyConversion() {
		super();
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

}
