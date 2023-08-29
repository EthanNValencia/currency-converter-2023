package com.nephew.microservices.datacollector.webreader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.common.entities.XRatesUsdData;
import com.nephew.common.support.LocalDateComparator;


@Service
public class WebReaderService {
	
	private LocalDate DATE_TODAY = LocalDate.now();
    private String WEBSITE_URL = "https://www.x-rates.com/historical/?from=USD&amount=1&date=";
    
    @Autowired
    private LocalDateComparator localDateComparator;

	public HashSet<XRatesUsdData> collectTodaysCurrencyDataBaseUsd() {
		WebReader serverWebReader = new WebReader();
        HashSet<XRatesUsdData> currencyHashSet = serverWebReader.getPage(WEBSITE_URL + DATE_TODAY);
        return currencyHashSet;
	}
	
	public HashSet<XRatesUsdData> collectCurrencyDataBaseUsdByLocalDate(LocalDate localDate) {
		WebReader serverWebReader = new WebReader();
        HashSet<XRatesUsdData> currencyHashSet = serverWebReader.getPage(WEBSITE_URL + localDate);
        return currencyHashSet;
	}

	public ArrayList<XRatesUsdData> collectCurrencyDataBaseUsdByLocalDateRange(LocalDate start, LocalDate end) {
		ArrayList<XRatesUsdData> returnList = new ArrayList<XRatesUsdData>();
		WebReader serverWebReader = new WebReader();
		localDateComparator = new LocalDateComparator(start, end);
		for (LocalDate localDate : localDateComparator.getRangeArrayList()) {
			ArrayList<XRatesUsdData> currencyArrayList = serverWebReader.getPageAsArrayList(WEBSITE_URL + localDate);
			returnList.addAll(currencyArrayList);
		}
		return returnList;
	}
	
}
