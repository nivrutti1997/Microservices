package com.niv;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.niv.rest.StockCalcRestController;

@SpringBootTest
class StockPriceCalcApiApplicationTests {

	@Autowired
	StockCalcRestController rest;
	
	@ParameterizedTest
	@CsvSource(value = {"SBI,10,4500.0","TCS,10,30000.0","HCL,10,5000.0","AXIS,10,45000.0"})
	void testCalculatePrice(String companyName, Integer stockCnt,CharSequence expectedPrice) {
		ResponseEntity<String> calculatePrice = rest.calculatePrice(companyName, stockCnt);
		String body = calculatePrice.getBody();
		assertTrue(body.contains(expectedPrice));
	}

}
