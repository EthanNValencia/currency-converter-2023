package com.nephew.microservices.validator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nephew.common.entities.FxdsRoot;

@FeignClient(name="data-collector", url = "${DATA_COLLECTOR_URI:http://localhost}:8200")
public interface DataCollectorProxy {

	@GetMapping("/data-collector/base={base}&quote={quote}&start_date={startDate}&end_date={endDate}")
	public FxdsRoot retrieveFxdsData(@PathVariable String base, @PathVariable String quote, @PathVariable String startDate, @PathVariable String endDate);

}

// https://fxds-public-exchange-rates-api.oanda.com/cc-api/currencies?base=USD&quote=EUR&data_type=general_currency_pair&start_date=2023-08-13&end_date=2023-08-14

// https://fxds-public-exchange-rates-api.oanda.com
// /cc-api/currencies?base=USD&quote=EUR&data_type=general_currency_pair&start_date=2023-08-13&end_date=2023-08-14