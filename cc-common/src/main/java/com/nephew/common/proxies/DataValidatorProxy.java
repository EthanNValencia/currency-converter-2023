package com.nephew.common.proxies;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "cc-data-validator", url = "${DATA_VALIDATOR_URI:http://localhost}:8200/cc-data-validator")
public class DataValidatorProxy {

}
