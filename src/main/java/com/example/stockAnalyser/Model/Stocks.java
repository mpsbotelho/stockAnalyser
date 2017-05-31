package com.example.stockAnalyser.Model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Stocks {
	@JsonProperty
	private String name;
	@JsonProperty
	private String bvmf;
	
	
	private Double currentPrice;
	private Double percentageVariance;
	private String queryDate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBvmf() {
		return bvmf;
	}
	public void setBvmf(String bvmf) {
		this.bvmf = bvmf;
	}
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Double getPercentageVariance() {
		return percentageVariance;
	}
	public void setPercentageVariance(Double percentageVariance) {
		this.percentageVariance = percentageVariance;
	}
	public String getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}
	
	@Override
	public String toString() {
		return "Stocks [name=" + name + ", bvmf=" + bvmf + "]";
	}
	
}
