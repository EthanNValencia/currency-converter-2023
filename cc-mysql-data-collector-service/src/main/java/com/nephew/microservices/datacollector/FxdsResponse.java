package com.nephew.microservices.datacollector;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FxdsResponse {
	@JsonProperty("base_currency")
	public String baseCurrency;
	@JsonProperty("quote_currency")
	public String quoteCurrency;
	@JsonProperty("close_time")
	public Date closeTime;
	@JsonProperty("average_bid")
	public String averageBid;
	@JsonProperty("average_ask")
	public String averageAsk;
	@JsonProperty("high_bid")
	public String highBid;
	@JsonProperty("high_ask")
	public String highAsk;
	@JsonProperty("low_bid")
	public String lowBid;
	@JsonProperty("low_ask")
	public String lowAsk;

	public FxdsResponse() {
		super();
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

	public String getAverageBid() {
		return averageBid;
	}

	public void setAverageBid(String averageBid) {
		this.averageBid = averageBid;
	}

	public String getAverageAsk() {
		return averageAsk;
	}

	public void setAverageAsk(String averageAsk) {
		this.averageAsk = averageAsk;
	}

	public String getHighBid() {
		return highBid;
	}

	public void setHighBid(String highBid) {
		this.highBid = highBid;
	}

	public String getHighAsk() {
		return highAsk;
	}

	public void setHighAsk(String highAsk) {
		this.highAsk = highAsk;
	}

	public String getLowBid() {
		return lowBid;
	}

	public void setLowBid(String lowBid) {
		this.lowBid = lowBid;
	}

	public String getLowAsk() {
		return lowAsk;
	}

	public void setLowAsk(String lowAsk) {
		this.lowAsk = lowAsk;
	}

	@Override
	public String toString() {
		return "FxdsCurrencyData [baseCurrency=" + baseCurrency + ", quoteCurrency=" + quoteCurrency + ", closeTime="
				+ closeTime + ", averageBid=" + averageBid + ", averageAsk=" + averageAsk + ", highBid=" + highBid
				+ ", highAsk=" + highAsk + ", lowBid=" + lowBid + ", lowAsk=" + lowAsk + "]";
	}

}
