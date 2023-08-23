package com.nephew.microservices.mysqlcrud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double averageBid;
	private Double averageAsk;
	private Double highBid;
	private Double highAsk;
	private Double lowBid;
	private Double lowAsk;

	@ManyToOne
	@JoinColumn(name = "pair_id")
	private Pair pair;

	@ManyToOne
	@JoinColumn(name = "date_id")
	private Date date;

	public Rate() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Pair getPair() {
		return pair;
	}

	public void setPair(Pair pair) {
		this.pair = pair;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
