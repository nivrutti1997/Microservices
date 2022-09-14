package com.niv.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.niv.entity.StockPrice;

public interface StockPriceRepo extends MongoRepository<StockPrice, Integer>{

	public StockPrice findByCompanyName(String companyName);
	 
}
