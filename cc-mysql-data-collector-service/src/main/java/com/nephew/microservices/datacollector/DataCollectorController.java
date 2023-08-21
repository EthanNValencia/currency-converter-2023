package com.nephew.microservices.datacollector;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DataCollectorController {

	private Logger logger = LoggerFactory.getLogger(DataCollectorController.class);

	@Autowired
	private FxdsProxy fxdsProxy;
	
	@Autowired
	private MySqlCrudProxy mySqlCrudProxy;
	
	@Autowired
	private FxdsRootMapper mapper;
	
	@GetMapping("/test")
	public String testing() {
		return "Test was successful";
	}
	
	// TODO Finish this, you need to fix the logic here. 
	@GetMapping("/data-collector/base={base}&quote={quote}&start_date={startDate}&end_date={endDate}")
	public FxdsRoot collectDataByDates(@PathVariable String base, @PathVariable String quote, @PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
		logger.info("collectDataByDates called with {} to {} period {}-{}.", base, quote, startDate, endDate);
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate); // TODO check scratch pad to see how to use this. Should simplify the logic a lot. 
		
		int dateCompare = startDate.compareTo(endDate);
		String jsonResponse = null;
		if (dateCompare < 0) { // startDate is before endDate (valid case)
		    dateCompare = startDate.compareTo(endDate.minusDays(1)); // Check if provided dates are exactly one day apart. 
			if(dateCompare == 0) { // If they are one day apart
				jsonResponse = fxdsProxy.retrieveFxdsData(base, quote, startDate.toString(), endDate.toString());
				mapper.readJson(jsonResponse);
			} else { // else multiple api calls are required. 
		    	
		    }
			
		} else if (dateCompare > 0) { // startDate is after endDate (invalid case)
			// TODO throw invalid date exception? 
		} else { // startDate is equal to endDate (invalid case)
			// TODO throw invalid date exception? 
		}
		
		
		// String jsonResponse = fxdsProxy.retrieveFxdsData(base, quote, startDate.toString(), endDate.toString());
		logger.info("collectDataByDates called with {} to {} period {}-{} request not fullfilled. Something went wrong.", base, quote, startDate, endDate);
		return mapper.getResponseRoot();
	}

}
