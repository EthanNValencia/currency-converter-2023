package com.nephew.microservices.ccmysqlcrudservice.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySQLCRUDController {

	private Logger logger = LoggerFactory.getLogger(MySQLCRUDController.class);

	@Autowired
	private Environment environment;

	@GetMapping("/cc-mysql-crud/test")
	public String test() {
		logger.info("test enpoint reached");
		String port = environment.getProperty("local.server.port");
		String host = environment.getProperty("HOSTNAME");
		String version = "v1";
		String response = port + " " + version + " " + host;
		logger.info("test endpoint reached with a successful response.");
		return response;
	}

}
