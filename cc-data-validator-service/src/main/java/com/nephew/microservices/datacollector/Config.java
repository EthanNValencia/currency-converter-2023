package com.nephew.microservices.datacollector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nephew.common.support.LocalDateComparator;

@Configuration
public class Config {

	@Bean
	LocalDateComparator localDateComparator() {
		return new LocalDateComparator();
	}
	
}
