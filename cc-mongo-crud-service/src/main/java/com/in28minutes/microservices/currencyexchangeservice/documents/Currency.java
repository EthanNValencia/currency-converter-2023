package com.in28minutes.microservices.currencyexchangeservice.documents;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Currency {

	@Id
	private String id;
	private String fromName;
	private String toName;
	private Integer fromRate;
	private Integer toRate;
	private LocalDate date;
	private String description;
	private Integer exchangeRate;

	public Currency(String fromName, String toName, Integer fromRate, Integer toRate, LocalDate date,
			String description, Integer exchangeRate) {
		super();
		this.fromName = fromName;
		this.toName = toName;
		this.fromRate = fromRate;
		this.toRate = toRate;
		this.date = date;
		this.description = description;
		this.exchangeRate = exchangeRate;
	}

	public Currency() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public Integer getFromRate() {
		return fromRate;
	}

	public void setFromRate(Integer fromRate) {
		this.fromRate = fromRate;
	}

	public Integer getToRate() {
		return toRate;
	}

	public void setToRate(Integer toRate) {
		this.toRate = toRate;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Integer exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

}
