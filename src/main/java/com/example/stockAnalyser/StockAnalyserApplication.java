package com.example.stockAnalyser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.stockAnalyser.Controller.HttpDataRequest;
import com.example.stockAnalyser.Controller.YamlToPojo;
import com.example.stockAnalyser.Model.Market;
import com.example.stockAnalyser.Model.Stocks;

@SpringBootApplication
public class StockAnalyserApplication {

	private static List<Double> values = new ArrayList<Double>();
	
	public static void main(String[] args) throws UnsupportedEncodingException,
			IOException, JSONException, InterruptedException {
		final String fileName = "src/main/resources/static/stocks.yaml";
		
		
		Market bv = YamlToPojo.parseYamlToPojo(fileName, Market.class);

		while(true){
			values.clear();
			for (Stocks st : bv.getLstocks()) {
				System.out.println("Requesting: " + st.getName());
				new HttpDataRequest(st.getBvmf()).run();
			}
			Thread.sleep(1000);
		}
	}
}
