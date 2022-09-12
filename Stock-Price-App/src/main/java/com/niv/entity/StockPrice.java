package com.niv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK_PRICE_DTLS")
public class StockPrice {
	
	@Id
	@Column(name = "STOCK_ID")
	private Integer stockId;
	
	private Integer portNo;
	

	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	@Column(name = "COMPANY_PRICE")
	private Double companyPrice;
	
	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Double getCompanyPrice() {
		return companyPrice;
	}

	public void setCompanyPrice(Double companyPrice) {
		this.companyPrice = companyPrice;
	}

	public Integer getPortNo() {
		return portNo;
	}

	public void setPortNo(Integer portNo) {
		this.portNo = portNo;
	}
	
}
