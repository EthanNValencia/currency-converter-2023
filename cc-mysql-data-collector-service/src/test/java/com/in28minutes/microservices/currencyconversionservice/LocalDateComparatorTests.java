package com.in28minutes.microservices.currencyconversionservice;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nephew.microservices.datacollector.Config;
import com.nephew.microservices.datacollector.FxdsRootMapper;
import com.nephew.microservices.datacollector.LocalDateComparator;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {Config.class})
class LocalDateComparatorTests {
	
	@Autowired
	LocalDateComparator comp;
	
	@Autowired
	FxdsRootMapper mapper;
	
	@Test
	void test_LocalDateComparator_isValid_shouldBeTrue() {
		LocalDate d1 = LocalDate.of(2023, 8, 13);
		LocalDate d2 = LocalDate.of(2023, 8, 14);
		comp = new LocalDateComparator(d1, d2);
		assertTrue(comp.isValid());
	}
	
	@Test
	void test_LocalDateComparator_isValid_shouldBeFalse() {
		LocalDate d1 = LocalDate.of(2023, 8, 20); // first date must be less than second date
		LocalDate d2 = LocalDate.of(2023, 8, 14);
		comp = new LocalDateComparator(d1, d2);
		assertFalse(comp.isValid());
	}
	
	@Test
	void test_LocalDateComparator_isValid_shouldEqualOne() {
		LocalDate d1 = LocalDate.of(2023, 8, 13); 
		LocalDate d2 = LocalDate.of(2023, 8, 14);
		comp = new LocalDateComparator(d1, d2);
		assertEquals(1, comp.getDaysBetween());
	}
	
	@Test
	void test_LocalDateComparator_isMoreThanADay_shouldBeTrue() {
		LocalDate d1 = LocalDate.of(2023, 8, 10); 
		LocalDate d2 = LocalDate.of(2023, 8, 14);
		comp = new LocalDateComparator(d1, d2);
		assertTrue(comp.isMoreThanADay());
	}
	
	@Test
	void test_LocalDateComparator_isMoreThanADay_shouldBeFalse() {
		LocalDate d1 = LocalDate.of(2023, 8, 13); 
		LocalDate d2 = LocalDate.of(2023, 8, 14);
		comp = new LocalDateComparator(d1, d2);
		assertFalse(comp.isMoreThanADay());
	}
	
	@Test
	void test_FxdsRootMapper_rootResponseIsNotNull() {
		assertNotNull(mapper.getResponseRoot().getResponse());
	}
	
	

}
