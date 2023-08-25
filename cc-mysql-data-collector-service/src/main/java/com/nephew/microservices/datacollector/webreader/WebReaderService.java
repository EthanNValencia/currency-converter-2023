package com.nephew.microservices.datacollector.webreader;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.stereotype.Service;

import com.nephew.common.entities.XRatesUsdData;


@Service
public class WebReaderService {
	
	private LocalDate DATE_TODAY = LocalDate.now();
    private String WEBSITE_URL = "https://www.x-rates.com/historical/?from=USD&amount=1&date=";

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
	
}
