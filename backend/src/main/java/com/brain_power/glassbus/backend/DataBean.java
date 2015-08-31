package com.brain_power.glassbus.backend;

import com.google.api.server.spi.types.DateAndTime;

import java.util.List;

/**
 * The object model for the data we are sending through endpoints
 */
public class DataBean {

	private String stringData;

	private List<Double> doubles;

	private DateAndTime dateAndTime;



	public String getData() {
		return stringData;
	}

	public void setData(String data) {
		stringData = data;
	}
}