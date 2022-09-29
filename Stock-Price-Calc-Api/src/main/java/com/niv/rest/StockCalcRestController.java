package com.niv.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.niv.client.StockPriceClient;
import com.niv.model.StockPrice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class StockCalcRestController {
	
	Logger logger = LoggerFactory.getLogger(StockCalcRestController.class);
	
	@Autowired
	StockPriceClient client;
	
	private static final String STOCK_PRICE_API = "stock-price-service";

	@GetMapping("/calc/{companyName}/{qnty}")
	@CircuitBreaker(name = STOCK_PRICE_API, fallbackMethod = "calculatePriceFallbackMethode")
	public ResponseEntity<String> calculatePrice(@PathVariable String companyName,@PathVariable Integer qnty){
		logger.info("inside [calculate Price]");
		String msg = "";
		/*
		 * String url = "http://localhost:1111/price/{companyName}"; RestTemplate rt =
		 * new RestTemplate(); ResponseEntity<StockPrice> entity = rt.getForEntity(url,
		 * StockPrice.class, companyName); StockPrice stockPrice = entity.getBody();
		 * Double companyPrice = stockPrice.getCompanyPrice();
		 */
		logger.info("Call to getStockPrice()");
		StockPrice stockPrice = client.getStockPrice(companyName);
		if (stockPrice != null) {
			logger.info("Stock Price : "+stockPrice);
		}else {
			logger.warn("StockPrice Object is null...");
		}
		Double companyPrice = stockPrice.getCompanyPrice();
		Double totalCost = companyPrice*qnty;
		msg = "Total Cost : "+totalCost + " (Price API Server Port :: "+ stockPrice.getPortNo() + " )";
		logger.info("Total price of the stocks : "+msg);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	public ResponseEntity<String> calculatePriceFallbackMethode(Exception e) {
		return new ResponseEntity<String>("This is a fallback method for calc api",HttpStatus.OK);
	}
}
