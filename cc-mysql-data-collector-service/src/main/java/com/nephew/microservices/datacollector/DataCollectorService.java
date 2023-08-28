package com.nephew.microservices.datacollector;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.common.support.LocalDateComparator;

@Service
public class DataCollectorService {
	
	private Logger logger = LoggerFactory.getLogger(DataCollectorService.class);

	@Autowired
	private FxdsProxy fxdsProxy;

	@Autowired
	private MySqlCrudProxy mySqlCrudProxy; 

	@Autowired
	private FxdsRootMapper fxdsRootMapper;

	@Autowired
	private LocalDateComparator localDateComparator;

	public FxdsRoot processRequest(String base, String quote, LocalDate startDate, LocalDate endDate) throws InvalidDatesException {
		localDateComparator = new LocalDateComparator(startDate, endDate);
		if (localDateComparator.isValid()) { // startDate is before endDate (valid case)
			handleValidDateRange(base, quote, startDate, endDate);
		} else { // startDate is not before endDate (invalid case)
			logger.warn("FAILURE processRequest called with {} to {} period {}-{} request was unfulfilled. The provided date range was invalid.",
					base, quote, startDate, endDate);
			throw new InvalidDatesException("The dates provided have an invalid range.");
		}
		logger.warn("SUCCESS processRequest called with {} to {} period {}-{} request was fulfilled.",
				base, quote, startDate, endDate);
		// mySqlCrudProxy.saveCurrencyData(fxdsRootMapper.getResponseRoot());
		return fxdsRootMapper.getResponseRoot();
	}
	
	public void handleValidDateRange(String base, String quote, LocalDate startDate, LocalDate endDate) {
		if (localDateComparator.isMoreThanADay()) { // If they are more than one day apart
			getMultipleJsonResponses(base, quote, startDate, endDate);
		} else {
			getSingleJsonResponse(base, quote, startDate, endDate);
		}
	}

	public void getSingleJsonResponse(String base, String quote, LocalDate startDate, LocalDate endDate) {
		String jsonResponse = fxdsProxy.retrieveFxdsData(base, quote, startDate.toString(), endDate.toString());
		fxdsRootMapper.readJson(jsonResponse);
	}
	
	public void getMultipleJsonResponses(String base, String quote, LocalDate startDate, LocalDate endDate) {
		for (int i = 0; i < (int) localDateComparator.getDaysBetween(); i++) {
			String jsonResponse = fxdsProxy.retrieveFxdsData(base, quote, endDate.minusDays(i + 1).toString(),
					endDate.minusDays(i).toString());
			fxdsRootMapper.readJson(jsonResponse);
		}
	}

}
