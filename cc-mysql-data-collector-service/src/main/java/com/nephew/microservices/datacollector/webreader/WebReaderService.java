package com.nephew.microservices.datacollector.webreader;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.stereotype.Service;

@Service
public class WebReaderService {
	
	private LocalDate DATE_TODAY = LocalDate.now();
    private String WEBSITE_URL = "https://www.x-rates.com/historical/?from=USD&amount=1&date=";

	public HashSet<CurrencyData> collectTodaysCurrencyDataBaseUsd() {
		WebReader serverWebReader = new WebReader();
        HashSet<CurrencyData> currencyHashSet = serverWebReader.getPage(WEBSITE_URL + DATE_TODAY);
        return currencyHashSet;
	}
	
	public HashSet<CurrencyData> collectCurrencyDataBaseUsdByLocalDate(LocalDate localDate) {
		WebReader serverWebReader = new WebReader();
        HashSet<CurrencyData> currencyHashSet = serverWebReader.getPage(WEBSITE_URL + localDate);
        return currencyHashSet;
	}
	
}
