package com.brain_power.glassbus;

import com.brain_power.glassbus.models.UserAccount;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Objectify service wrapper so we can statically register our persistence
 * classes.
 * More on Objectify here : https://code.google.com/p/objectify-appengine/
 */
/**
 * Created by Thomas on 7/29/2015.
 */
public final class OfyService {

	private OfyService(){}

	static{
		factory().register(UserAccount.class);
	}
	/**
	 * Returns the Objectify service wrapper.
	 * @return The Objectify service wrapper.
	 */
	public static Objectify ofy() {
		return ObjectifyService.ofy();
	}

	/**
	 * Returns the Objectify factory service.
	 * @return The factory service.
	 */
	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}


}
