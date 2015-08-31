package com.brain_power.glassbus;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.brain_power.glassbus.backend.glassBus.GlassBus;
import com.brain_power.glassbus.backend.glassBus.model.DataBean;
import com.brain_power.glassbus.backend.glassBus.model.EndpointResponse;
import com.brain_power.glassbus.backend.glassBus.model.PostResponse;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by Thomas on 7/13/2015.
 */
public class DataUploadTask extends AsyncTask<Pair<Context,DataBean>, Void, PostResponse> {
	private Context context;
	private GlassBus endpoint;
	private TaskListener listener;

	@Override
	protected void onPostExecute(PostResponse response) {
		listener.onComplete(response);
	}

	@Override
	protected PostResponse doInBackground(Pair<Context, DataBean>... params) {

		if (endpoint==null){
			GlassBus.Builder builder = new GlassBus.Builder(AndroidHttp.newCompatibleTransport(),
					new AndroidJsonFactory(), null)
					.setRootUrl("https://glass-bus.appspot.com/_ah/api/");

			endpoint= builder.build();
		}

		context = params[0].first;
		DataBean fileName = params[0].second;





		try{
			return endpoint.sendData(fileName).execute();
		} catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
}
