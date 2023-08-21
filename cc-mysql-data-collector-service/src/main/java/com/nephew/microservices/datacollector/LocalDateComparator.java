package com.nephew.microservices.datacollector;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateComparator {

	private long daysBetween;
	private boolean isValid;
	private boolean isMoreThanADay;

	public LocalDateComparator() {
		super();
	}

	public LocalDateComparator(LocalDate startDate, LocalDate endDate) {
		super();
		this.daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		this.isValid = this.daysBetween > 0l;
		this.isMoreThanADay = this.daysBetween > 1l;
	}

	public long getDaysBetween() {
		return daysBetween;
	}

	public void setDaysBetween(long daysBetween) {
		this.daysBetween = daysBetween;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public boolean isMoreThanADay() {
		return isMoreThanADay;
	}

	public void setMoreThanADay(boolean isMoreThanADay) {
		this.isMoreThanADay = isMoreThanADay;
	}

}
