package com.brain_power.glassbus.backend;

import com.brain_power.glassbus.models.UserAccount;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.User;

/**
 * Created by Thomas on 8/15/2015.
 */
public class DatastoreDB {

	/**
	 *
	 * @param user
	 */
	public static void putUser(UserAccount user){
		if (user==null){
			return;
		}
		Entity userEntity=user.userToEntity();
		DatastoreService datastore= DatastoreServiceFactory.getDatastoreService();
		datastore.put(userEntity);
	}

	/**
	 *
	 * @param user
	 * @return
	 */
	public static boolean hasUser(User user){


		return false;
	}

	public static UserAccount getUser(User user){


		return null;
	}


	public static void deleteUser(UserAccount user){
		
	}

	private UserAccount entityToUser(Entity userEntity){
		if (userEntity==null){
			return new UserAccount();
		}

		UserAccount user=new UserAccount();

		user.set

		return user;
	}
}
