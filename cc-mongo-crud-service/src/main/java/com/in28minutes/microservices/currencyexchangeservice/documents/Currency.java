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
	private Double fromRate;
	private Double toRate;
	private LocalDate date;
	private String description;

	public Currency(String fromName, String toName, Double fromRate, Double toRate, LocalDate date,
			String description) {
		super();
		this.fromName = fromName;
		this.toName = toName;
		this.fromRate = fromRate;
		this.toRate = toRate;
		this.date = date;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription() {
		this.description = "Exchange from USD " + this.fromName + " to " + this.toName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
