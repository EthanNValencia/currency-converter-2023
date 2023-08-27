package com.nephew.common.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dates")
public class Date {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate date;

	@OneToMany(mappedBy = "date", cascade = CascadeType.ALL)
	private List<Rate> rate;

	public Date() {
		super();
	}

	public Date(LocalDate localDate) {
		super();
		this.date = localDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Rate> getRate() {
		return rate;
	}

	public void setRate(List<Rate> rate) {
		this.rate = rate;
	}

}
