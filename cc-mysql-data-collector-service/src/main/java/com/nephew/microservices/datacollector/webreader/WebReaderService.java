package com.nephew.microservices.datacollector.webreader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.common.entities.XRatesUsdData;
import com.nephew.common.support.LocalDateComparator;
import com.nephew.microservices.datacollector.DataCollectorController;


@Service
public class WebReaderService {
	
	private Logger logger = LoggerFactory.getLogger(WebReaderService.class);
	
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
			sleepForASecond();
			ArrayList<XRatesUsdData> currencyArrayList = serverWebReader.getPageAsArrayList(WEBSITE_URL + localDate);
			if(currencyArrayList == null) {
				logger.warn("serverWebReader failed to return an array list. Method was called with: {}", WEBSITE_URL + localDate);
			}
			logger.info("serverWebReader returned an array list. Method was called with: {}", WEBSITE_URL + localDate);
			returnList.addAll(currencyArrayList);
		}
		return returnList;
	}
	
	public void sleepForASecond() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
