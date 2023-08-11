package com.nephew.microservices.ccmongoentryservice;

import java.util.List;

public class CurrencyConversion {

	private String id;
	private String fromName;
	private String toName;
	private String calendricalPeriod;
	private String description;
	private String environment;
	// @DBRef
	private List<CurrencyPeriod> currency;

	public CurrencyConversion(String fromName, String toName, String calendricalPeriod, List<CurrencyPeriod> currency) {
		super();
		this.fromName = fromName;
		this.toName = toName;
		this.calendricalPeriod = calendricalPeriod;
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

	public String getCalendricalPeriod() {
		return calendricalPeriod;
	}

	public void setCalendricalPeriod(String calendricalPeriod) {
		this.calendricalPeriod = calendricalPeriod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public List<CurrencyPeriod> getCurrency() {
		return currency;
	}

	public void setCurrency(List<CurrencyPeriod> currency) {
		this.currency = currency;
	}

	public void setDescription() {
		this.description = "Exchange from " + this.fromName + " to " + this.toName;
	}

	public void appendEnvironment(String string) {
		this.environment = this.environment + string;
	}

}
