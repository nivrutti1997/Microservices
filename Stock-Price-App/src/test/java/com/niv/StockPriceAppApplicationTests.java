package com.niv;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.niv.controller.StockPriceRestController;
import com.niv.entity.StockPrice;

@SpringBootTest
class StockPriceAppApplicationTests {

	@Autowired
	StockPriceRestController rest;
	
	@ParameterizedTest
	@CsvSource(value = {"SBI:450.0","HCL:500.0","HDFC:6000.0","AXIS:4500.0","TCS:3000.0"},delimiter = ':')
	void testGetStockPrice(String companyName, Double expectedCmpPrice) {
		ResponseEntity<StockPrice> stockPrice = rest.getStockPrice(companyName);
		StockPrice stock = stockPrice.getBody();
		Double actualPrice = stock.getCompanyPrice();
		assertEquals(expectedCmpPrice, actualPrice);;
	}
	
	@Test
	void testSaveStockInfo() {
		StockPrice stockPrice = new StockPrice();
		stockPrice.setStockId(109);
		stockPrice.setCompanyName("Tata Motors");
		stockPrice.setCompanyPrice(510.0);
		ResponseEntity<String> saveStockInfo = rest.saveStockInfo(stockPrice);
		String msg = saveStockInfo.getBody();
		assertEquals("Stock added successfully...!!", msg);
	
	}
	

}
