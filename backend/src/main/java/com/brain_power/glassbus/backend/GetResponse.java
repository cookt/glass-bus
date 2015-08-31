package com.brain_power.glassbus.backend;

import com.brain_power.glassbus.models.UserAccount;

import java.util.List;

/**
 * Created by Thomas on 7/14/2015.
 */
public class GetResponse {

	private String encodedImageString;

	public String getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	private UserAccount user;

	private String messageStatus;

	public GetResponse(){

	}

	public void setEncodedImageString(String encodedImageString){
		this.encodedImageString=encodedImageString;
	}

	public String getEncodedImageString(){
		return this.encodedImageString;
	}

	public void setMessageHeader(String msg){
		this.messageStatus=msg;
	}

	public String getMessageHeader(){
		return this.messageStatus;
	}

}
