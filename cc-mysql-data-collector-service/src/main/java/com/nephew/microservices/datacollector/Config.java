package com.nephew.microservices.datacollector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	LocalDateComparator localDateComparator() {
		return new LocalDateComparator();
	}
	
	@Bean
	FxdsRootMapper fxdsRootMapper() {
		return new FxdsRootMapper();
	}
	
	
}
