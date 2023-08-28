package com.nephew.common.support;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class LocalDateComparator {

	private long daysBetween;
	private boolean isValid;
	private boolean isMoreThanADay;
	private LocalDate startDate;
	private LocalDate endDate;

	public LocalDateComparator() {
		super();
	}

	public LocalDateComparator(LocalDate startDate, LocalDate endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
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
	
	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public ArrayList<LocalDate> getRangeArrayList() {
		ArrayList<LocalDate> list = new ArrayList<LocalDate>();
		Boolean firstDateIsBeforeSecondDate = firstDateIsBeforeSecondDate(startDate, endDate);
		if (firstDateIsBeforeSecondDate) { // date1 is before date2
			generateList(startDate, endDate, list);
		} else if (!firstDateIsBeforeSecondDate) { // date1 is after date2
			generateList(endDate, startDate, list);
		} else {
			list.add(startDate);
		}
		return list;
	}

	private ArrayList<LocalDate> generateList(LocalDate startDate, LocalDate endDate, ArrayList<LocalDate> list) {
		list.add(startDate);
		LocalDate start = startDate;
		LocalDate end = endDate;
		while (start.compareTo(end) != 0) {
			start = start.plusDays(1);
			list.add(start);
		}
		return list;
	}

	private Boolean firstDateIsBeforeSecondDate(LocalDate startDate, LocalDate endDate) {
		int comparisonResult = startDate.compareTo(endDate);
		if (comparisonResult < 0) { // date1 is before date2
			return true;
		} else if (comparisonResult > 0) { // date1 is after date2
			return false;
		} else {
			return null;
		}
	}

}
