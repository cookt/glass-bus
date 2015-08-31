package com.brain_power.glassbus;

import com.brain_power.glassbus.backend.glassBus.model.EndpointResponse;

/**
 * Created by Thomas on 7/13/2015.
 */
public interface TaskListener {

	public void onComplete(Object data);
}
