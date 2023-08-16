package com.nephew.microservices.datacollector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="fxds-public-exchange-rates", url = "https://fxds-public-exchange-rates-api.oanda.com")
public interface FxdsProxy {

	@GetMapping("/cc-api/currencies?base={base}&quote={quote}&data_type=general_currency_pair&start_date={startDate}&end_date={endDate}")
	public String retrieveFxdsData(@PathVariable String base, @PathVariable String quote, @PathVariable String startDate, @PathVariable String endDate);

}


// https://fxds-public-exchange-rates-api.oanda.com/cc-api/currencies?base=USD&quote=EUR&data_type=general_currency_pair&start_date=2023-08-13&end_date=2023-08-14

// https://fxds-public-exchange-rates-api.oanda.com
// /cc-api/currencies?base=USD&quote=EUR&data_type=general_currency_pair&start_date=2023-08-13&end_date=2023-08-14