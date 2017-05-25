package com.example.stockAnalyser.Model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Stocks {
	@JsonProperty
	private String name;
	@JsonProperty
	private String bvmf;
	
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
	
}
