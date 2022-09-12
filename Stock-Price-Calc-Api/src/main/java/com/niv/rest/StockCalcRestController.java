package com.niv.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.niv.client.StockPriceClient;
import com.niv.model.StockPrice;

@RestController
public class StockCalcRestController {
	
	@Autowired
	StockPriceClient client;

	@GetMapping("/calc/{companyName}/{qnty}")
	public ResponseEntity<String> calculatePrice(@PathVariable String companyName,@PathVariable Integer qnty){
		String msg = "";
		/*
		 * String url = "http://localhost:1111/price/{companyName}"; RestTemplate rt =
		 * new RestTemplate(); ResponseEntity<StockPrice> entity = rt.getForEntity(url,
		 * StockPrice.class, companyName); StockPrice stockPrice = entity.getBody();
		 * Double companyPrice = stockPrice.getCompanyPrice();
		 */
		
		StockPrice stockPrice = client.getStockPrice(companyName);
		Double companyPrice = stockPrice.getCompanyPrice();
		Double totalCost = companyPrice*qnty;
		msg = "Total Cost : "+totalCost + " (Price API Server Port :: "+ stockPrice.getPortNo() + " )";
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}