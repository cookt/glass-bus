package com.brain_power.glassbus.models;


import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;



/**
 * Created by Thomas on 7/27/2015.
 */
public class UserAccount {

	private User user;

	private GlassState userGlassState;

	public String getDatastoreKey() {
		return DatastoreKey;
	}

	public void setDatastoreKey(String datastoreKey) {
		DatastoreKey = datastoreKey;
	}

	public String getDatastoreKind() {
		return DatastoreKind;
	}

	public void setDatastoreKind(String datastoreKind) {
		DatastoreKind = datastoreKind;
	}

	private String DatastoreKey;

	private String DatastoreKind;

	public UserAccount(){

	}

	public GlassState getUserGlassState() {
		return userGlassState;
	}

	public void setUserGlassState(GlassState userGlassState) {
		this.userGlassState = userGlassState;
	}

	public Entity userToEntity(){

		Entity user= new Entity(DatastoreKind, DatastoreKey);
		user.setProperty("googleUserAccount",this.user);

		return user;
	}
}
