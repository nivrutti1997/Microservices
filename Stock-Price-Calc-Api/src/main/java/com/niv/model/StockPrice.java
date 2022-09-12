package com.niv.model;

public class StockPrice {
	
	private Integer stockId;
	private String companyName;
	private Double companyPrice;
	private Integer portNo;
	public Integer getPortNo() {
		return portNo;
	}
	public void setPortNo(Integer portNo) {
		this.portNo = portNo;
	}
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
	
	
}
