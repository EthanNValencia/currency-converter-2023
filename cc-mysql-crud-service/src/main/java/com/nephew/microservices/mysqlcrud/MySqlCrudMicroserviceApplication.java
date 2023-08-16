package com.nephew.microservices.mysqlcrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySqlCrudMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySqlCrudMicroserviceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			// Nothing to run yet.
		};
	}

}