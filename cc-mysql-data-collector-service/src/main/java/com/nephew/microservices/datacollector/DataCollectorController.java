package com.nephew.microservices.datacollector;

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
	
	@GetMapping("/test")
	public String testing() {
		return "Test was successful";
	}
	
	@GetMapping("/data-collector/base={base}&quote={quote}&start_date={startDate}&end_date={endDate}")
	public FxdsRoot testingApiEndpoint(@PathVariable String base, @PathVariable String quote, @PathVariable String startDate, @PathVariable String endDate) {
		logger.info("testingApiEndpoint called with {} to {} period {}-{}.", base, quote, startDate, endDate);
		String jsonResponse = fxdsProxy.retrieveFxdsData(base, quote, startDate, endDate);
		try {
            ObjectMapper objectMapper = new ObjectMapper();
            FxdsRoot root = objectMapper.readValue(jsonResponse, FxdsRoot.class);
            logger.info("testingApiEndpoint called with {} to {} period {}-{} request fulfilled.", base, quote, startDate, endDate);
            return root;
        } catch (Exception e) {
            e.printStackTrace();
        }
		logger.info("testingApiEndpoint called with {} to {} period {}-{} request not fullfilled. Something went wrong.", base, quote, startDate, endDate);
		return null;
	}

}
