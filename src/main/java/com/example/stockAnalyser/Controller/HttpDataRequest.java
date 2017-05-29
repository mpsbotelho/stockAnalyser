package com.example.stockAnalyser.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;

public class HttpDataRequest implements Runnable {

	final String googleFinanceURL = "http://finance.google.com/finance/info?client=ig&q=BVSP:";
	private String endPoint;

	public HttpDataRequest(String stockName) {
		this.endPoint = this.googleFinanceURL + stockName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		URL url = null;
		try {
			url = new URL(this.endPoint);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
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
		String v = "";
		 try {
			v = new JSONArray(s).getJSONObject(0).getString("l");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Value: " + v);
		// values.add (Double.parseDouble(v));
	}

}
