package com.brain_power.glassbus;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.brain_power.glassbus.backend.glassBus.GlassBus;
import com.brain_power.glassbus.backend.glassBus.model.GetResponse;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Thomas on 7/13/2015.
 */
public class MediaFetchTask extends AsyncTask<Pair<Context,String>,Void,GetResponse> {
	private Context context;
	private GlassBus myApiService;
	private TaskListener listener;

	public MediaFetchTask(TaskListener listener){
		this.listener=listener;
	}
	@Override
	protected GetResponse doInBackground(Pair<Context, String>... params)
	{
		if (myApiService == null) {  // Only do this once
			GlassBus.Builder builder = new GlassBus.Builder(AndroidHttp.newCompatibleTransport(),
					new AndroidJsonFactory(), null)
					.setRootUrl("https://glass-bus.appspot.com/_ah/api/");

			myApiService = builder.build();
		}

		context = params[0].first;
		String fileName = params[0].second;

		try {
			return myApiService.getImage(fileName).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(GetResponse response)
	{
		if (response!=null) {
			listener.onComplete(response);
		}
	}
}
