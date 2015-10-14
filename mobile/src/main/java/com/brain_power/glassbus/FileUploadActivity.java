package com.brain_power.glassbus;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.brain_power.glassbus.backend.glassBus.model.DataBean;
import com.brain_power.glassbus.backend.glassBus.model.PostResponse;
import com.google.api.client.util.DateTime;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class FileUploadActivity extends Activity implements TaskListener, View.OnClickListener{
	private DataBean sample=null;

	private TextView dataView;
	private Button genData;
	private Button sendData;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_upload);
		dataView=(TextView) findViewById(R.id.data_text);
		genData=(Button) findViewById(R.id.generate_data_button);
		sendData=(Button) findViewById(R.id.send_data_button);

		genData.setOnClickListener(this);
		sendData.setOnClickListener(this);

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
				if (sample!=null){
					new DataUploadTask().execute(new Pair<Context, DataBean>(this, sample));
				} else{
					Toast.makeText(this, "Generate some data",Toast.LENGTH_SHORT).show();
				}
				break;
			default:
				break;
		}

	}

	@Override
	public void onComplete(Object data) {
		PostResponse response=(PostResponse) data;
	}

	public void populateTextViewWithData(){
		sample=new DataBean();
		sample.setStringData("Test data");
		List<Double> doubleData=Arrays.asList(1.,3.,.4,9.);
		sample.setDoubles(doubleData);
		sample.setDate(new DateTime(new Date()));
		dataView.setText(sample.toString());
;	}
}
