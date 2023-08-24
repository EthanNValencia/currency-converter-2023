package com.nephew.microservices.mysqlcrud.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "currency_conversion")
// @Table(name="currency_conversion", schema = "currency_db")
public class FxdsResponse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("base_currency")
	private String baseCurrency;
	@JsonProperty("quote_currency")
	private String quoteCurrency;
	@JsonProperty("close_time")
	private Date closeTime;
	@JsonProperty("average_bid")
	private Double averageBid;
	@JsonProperty("average_ask")
	private Double averageAsk;
	@JsonProperty("high_bid")
	private Double highBid;
	@JsonProperty("high_ask")
	private Double highAsk;
	@JsonProperty("low_bid")
	private Double lowBid;
	@JsonProperty("low_ask")
	private Double lowAsk;

	public FxdsResponse() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getQuoteCurrency() {
		return quoteCurrency;
	}

	public void setQuoteCurrency(String quoteCurrency) {
		this.quoteCurrency = quoteCurrency;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public Double getAverageBid() {
		return averageBid;
	}

	public void setAverageBid(Double averageBid) {
		this.averageBid = averageBid;
	}

	public Double getAverageAsk() {
		return averageAsk;
	}

	public void setAverageAsk(Double averageAsk) {
		this.averageAsk = averageAsk;
	}

	public Double getHighBid() {
		return highBid;
	}

	public void setHighBid(Double highBid) {
		this.highBid = highBid;
	}

	public Double getHighAsk() {
		return highAsk;
	}

	public void setHighAsk(Double highAsk) {
		this.highAsk = highAsk;
	}

	public Double getLowBid() {
		return lowBid;
	}

	public void setLowBid(Double lowBid) {
		this.lowBid = lowBid;
	}

	public Double getLowAsk() {
		return lowAsk;
	}

	public void setLowAsk(Double lowAsk) {
		this.lowAsk = lowAsk;
	}

	@Override
	public String toString() {
		return "FxdsCurrencyData [baseCurrency=" + baseCurrency + ", quoteCurrency=" + quoteCurrency + ", closeTime="
				+ closeTime + ", averageBid=" + averageBid + ", averageAsk=" + averageAsk + ", highBid=" + highBid
				+ ", highAsk=" + highAsk + ", lowBid=" + lowBid + ", lowAsk=" + lowAsk + "]";
	}

}
