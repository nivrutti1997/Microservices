package com.niv.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
//@Entity
//@Table(name = "STOCK_PRICE_DTLS")
@Document
public class StockPrice {
	
	@Id
	private Integer stockId;
	private Integer portNo;
	private String companyName;
	private Double companyPrice;
	
	
	
}
