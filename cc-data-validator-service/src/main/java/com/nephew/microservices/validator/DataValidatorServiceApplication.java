package com.nephew.microservices.validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/***
 * The point of this microservice is to validate the MySQL database.  
 * @author Ethan 
 */
@SpringBootApplication
@EnableFeignClients
public class DataValidatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataValidatorServiceApplication.class, args);
	}

}
