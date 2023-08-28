package com.in28minutes.microservices.currencyconversionservice;

import java.text.ParseException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nephew.common.support.LocalDateComparator;
import com.nephew.microservices.datacollector.Config;
import com.nephew.microservices.datacollector.FxdsRootMapper;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {Config.class})
class DataCollectorTests {
	
	@Autowired
	LocalDateComparator comp;
	
	@Autowired
	FxdsRootMapper mapper;
	
	private String jsonResponse = "{\"response\": [{\"base_currency\": \"USD\",\"quote_currency\": \"EUR\",\"close_time\": \"2023-08-13T23:59:59Z\",\"average_bid\": \"0.913281\",\"average_ask\": \"0.913739\",\"high_bid\": \"0.914002\",\"high_ask\": \"0.914127\",\"low_bid\":\"0.912517\",\"low_ask\": \"0.913167\"}]}";
	
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
	
	@Test
	void test_FxdsRootMapper_rootResponseIsCorrect() throws ParseException {
		String dateString = "Sun Aug 13 19:59:59 EDT 2023";
        // String pattern = "E MMM dd HH:mm:ss z yyyy"; // Pattern matching the input format
        // SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        // Date date = dateFormat.parse(dateString);
		mapper.readJson(jsonResponse);
		assertEquals("USD", mapper.getResponseRoot().getResponse().get(0).getBaseCurrency());
		assertEquals("EUR", mapper.getResponseRoot().getResponse().get(0).getQuoteCurrency());
		assertEquals(dateString, mapper.getResponseRoot().getResponse().get(0).getCloseTime().toString());
		assertEquals("0.913281", mapper.getResponseRoot().getResponse().get(0).getAverageBid());
		assertEquals("0.913739", mapper.getResponseRoot().getResponse().get(0).getAverageAsk());
		assertEquals("0.914002", mapper.getResponseRoot().getResponse().get(0).getHighBid());
		assertEquals("0.914127", mapper.getResponseRoot().getResponse().get(0).getHighAsk());
		assertEquals("0.912517", mapper.getResponseRoot().getResponse().get(0).getLowBid());
		assertEquals("0.913167", mapper.getResponseRoot().getResponse().get(0).getLowAsk());
	}
	
	// closeTime=Sun Aug 13 19:59:59 EDT 2023,

}
