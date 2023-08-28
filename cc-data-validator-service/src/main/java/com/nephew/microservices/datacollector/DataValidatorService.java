package com.nephew.microservices.datacollector;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.common.entities.Date;
import com.nephew.common.support.LocalDateComparator;

@Service
public class DataValidatorService {

	@Autowired
	private LocalDateComparator localDateComparator;

	@Autowired
	private MySqlCrudProxy mySqlProxy;

	public Boolean validateCurrencyPair(String base, String quote) {
		Boolean containsBaseAndQuote = mySqlProxy.databaseContainsBaseAndQuote(base, quote);
		if (!containsBaseAndQuote) {
			return false;
		}
		return true;
	}

	public Boolean validateDateRange(LocalDate beginDate, LocalDate endDate) {
		localDateComparator = new LocalDateComparator(beginDate, endDate);
		try {
			for (LocalDate localDate : localDateComparator.getRangeArrayList()) {
				System.out.println("doesDatabaseContainLocalDate? " + localDate);
				Boolean dbContainsDate = mySqlProxy.doesDatabaseContainLocalDate(localDate.toString());
				if (!dbContainsDate) {
					mySqlProxy.saveDate(new Date(localDate));
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
