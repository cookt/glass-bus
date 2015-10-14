package com.brain_power.glassbus.backend;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * The object model for the data we are sending through endpoints
 */
public class DataBean {

	private String stringData;

	private List<Double> doubles;

	private Date date;

	public String getStringData() {
		return stringData;
	}

	public void setStringData(String data) {
		stringData = data;
	}

	public List<Double> getDoubles(){
		return  doubles;
	}

	public void setDoubles(List<Double> doubles){
		this.doubles=doubles;
	}

	public Date getDate(){
		return date;
	}

	public void setDate(Date timeStamp){
		this.date=timeStamp;
	}

	public String toString(){
		String s= "String data: "+this.getStringData()+"\n";
		s+="Doubles: "+ Arrays.toString(doubles.toArray())+"\n";
		s+="Date: "+this.getDate();
		return s;
	}
}