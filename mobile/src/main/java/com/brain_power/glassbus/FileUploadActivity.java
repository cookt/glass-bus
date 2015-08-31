package com.brain_power.glassbus;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.brain_power.glassbus.backend.glassBus.model.EndpointResponse;
import com.brain_power.glassbus.backend.glassBus.model.PostResponse;


public class FileUploadActivity extends Activity implements TaskListener, View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_upload);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_file_upload, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		switch(id){
			case(R.id.action_settings):
				return true;
			case(R.id.file_save):
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onClick(View v) {
		int id=v.getId();

		switch (id){
			case(R.id.generate_data_button):
				populateTextViewWithData();
				break;
			case(R.id.send_data_button):


				break;
			default:
				break;
		}

	}

	@Override
	public void onComplete(Object data) {
		PostResponse response=(PostResponse) data;
	}

	private void populateTextViewWithData(){

	}
}
