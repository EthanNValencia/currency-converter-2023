package com.nephew.microservices.mysqlcrud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySqlCrudController {

	private Logger logger = LoggerFactory.getLogger(MySqlCrudController.class);

	@Autowired
	private Environment environment;

	/*
	@GetMapping("/cc-mysql-crud/test")
	public String test() {
		logger.info("test endpoint reached");
		String port = environment.getProperty("local.server.port");
		String host = environment.getProperty("HOSTNAME");
		String version = "v1";
		String response = port + " " + version + " " + host;
		logger.info("test endpoint reached with a successful response.");
		return response;
	}
	*/
	
	@PutMapping("/put-data")
	public void saveCurrencyData(@RequestBody FxdsResponse response) {
		
	}
	

}
