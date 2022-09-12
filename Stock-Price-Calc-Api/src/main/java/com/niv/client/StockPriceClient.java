package com.niv.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.niv.model.StockPrice;

@FeignClient(name = "STOCK-PRICE-APP")
public interface StockPriceClient {
	
	@GetMapping("/price/{cName}")
	public StockPrice getStockPrice(@PathVariable String cName);

}
