package com.nephew.microservices.datacollector;

import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataCollectorController {

	private Logger logger = LoggerFactory.getLogger(DataCollectorController.class);

	@Autowired
	private FxdsProxy fxdsProxy;
	
	@Autowired
	private MySqlCrudProxy mySqlCrudProxy;
	
	@Autowired
	private FxdsRootMapper fxdsRootMapper;
	
	@Autowired
	private LocalDateComparator localDateComparator;
	
	@GetMapping("/test")
	public String testing() {
		return "Test was successful";
	}
	
	// TODO This is working. Consider breaking this logic out of the controller? 
	@GetMapping("/data-collector/base={base}&quote={quote}&start_date={startDate}&end_date={endDate}")
	public FxdsRoot collectDataByDates(@PathVariable String base, @PathVariable String quote, @PathVariable LocalDate startDate, @PathVariable LocalDate endDate) {
		logger.info("collectDataByDates called with {} to {} period {}-{}.", base, quote, startDate, endDate);
		localDateComparator = new LocalDateComparator(startDate, endDate); 
		if (localDateComparator.isValid()) { // startDate is before endDate (valid case)
			String jsonResponse = null;
			if(localDateComparator.isMoreThanADay()) { // If they are more than one day apart
				for(int i = 0; i < (int) localDateComparator.getDaysBetween(); i++) {
					jsonResponse = fxdsProxy.retrieveFxdsData(base, quote, endDate.minusDays(i+1).toString(), endDate.minusDays(i).toString());
					fxdsRootMapper.readJson(jsonResponse);
				}
			} else {
				jsonResponse = fxdsProxy.retrieveFxdsData(base, quote, startDate.toString(), endDate.toString());
				fxdsRootMapper.readJson(jsonResponse);
		    }
		} else { // startDate is equal to endDate (invalid case)
			// TODO throw invalid date exception? 
		}	
		logger.info("collectDataByDates called with {} to {} period {}-{} request not fullfilled. Something went wrong.", base, quote, startDate, endDate);
		return fxdsRootMapper.getResponseRoot();
	}

}
