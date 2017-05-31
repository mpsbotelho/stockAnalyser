package com.example.stockAnalyser.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Market {
	
	@JsonProperty
	private List<Stocks> lstocks;
	
	@JsonProperty
	private String name;

	public List<Stocks> getLstocks() {
		return lstocks;
	}

	public void setLstocks(List<Stocks> lstocks) {
		this.lstocks = lstocks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Market [lstocks=" + lstocks + ", name=" + name + "]";
	}
	

}
