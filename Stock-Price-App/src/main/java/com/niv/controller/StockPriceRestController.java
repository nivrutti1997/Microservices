package com.niv.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niv.entity.StockPrice;
import com.niv.repo.StockPriceRepo;

@RestController
public class StockPriceRestController {
	
	@Autowired
	private StockPriceRepo stockPriceRepo;
	
	@Autowired
	private Environment env;
	
	@GetMapping("price/{companyName}")
	public ResponseEntity<StockPrice> getStockPrice(@PathVariable String companyName){
		StockPrice stockPriceObj = stockPriceRepo.findByCompanyName(companyName);
		Integer portNo = Integer.valueOf(env.getProperty("server.port"));
		stockPriceObj.setPortNo(portNo);
		return new ResponseEntity<StockPrice>(stockPriceObj, HttpStatus.OK);
		
	}
	
	@PostMapping("/addStock")
	public ResponseEntity<String> saveStockInfo(@RequestBody StockPrice stockPrice){
		stockPriceRepo.save(stockPrice);		
		String msg = "Stock added successfully...!!";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
}
