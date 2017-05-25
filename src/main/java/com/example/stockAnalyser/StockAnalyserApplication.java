package com.example.stockAnalyser;

import java.io.BufferedReader;
import java.io.File;
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


import com.example.stockAnalyser.Model.Market;
import com.example.stockAnalyser.Model.Stocks;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

@SpringBootApplication
public class StockAnalyserApplication {

	private static List<Double> values = new ArrayList<Double>();
	
	public static void main(String[] args) throws UnsupportedEncodingException,
			IOException, JSONException {
		// SpringApplication.run(StockAnalyserApplication.class, args);
		// The path of your YAML file.
		final String fileName = "/home/mpsbotelho/workspace/stockAnalyser/src/main/resources/static/stocks.yaml";
		final String googleFinanceURL = "http://finance.google.com/finance/info?client=ig&q=BVSP:";
		Market bv = null;
		try {
			// TODO binding yaml file to pojo
			File ios = new File(fileName);
			final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
			bv = mapper.readValue(ios, Market.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("hey " + bv.getName());

		while(true){
			values.clear();
			for (Stocks st : bv.getLstocks()) {
				System.out.println("Requesting: " + st.getName());
				requestStockData(googleFinanceURL.concat(st.getBvmf()));
			}
			Collections.sort(values);
			for(int i = 0; i < 5; ++i){
				System.out.println("As mais baratas: " + values.get(i));
			}
			
		}
	}

	private static void requestStockData(String endPoint)
			throws UnsupportedEncodingException, IOException, JSONException {
		URL url = new URL(endPoint);

		StringBuilder sb = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				url.openStream(), "UTF-8"))) {
			for (String line; (line = reader.readLine()) != null;) {
				sb.append(line);
			}
		} catch (Exception e) {
			return;
		}
		System.out.println(sb.toString());
		String s = sb.toString().replace("// ", "");
		String v = new JSONArray(s).getJSONObject(0).getString("l");
		System.out.println("Value: " + v);
		values.add (Double.parseDouble(v));
	}
}
