package com.niv.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.niv.entity.StockPrice;

public interface StockPriceRepo extends JpaRepository<StockPrice, Integer>{

	public StockPrice findByCompanyName(String companyName);
	 
}
