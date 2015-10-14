package com.brain_power.glassbus;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.brain_power.glassbus.backend.glassBus.model.GetResponse;


public class MainActivity extends Activity implements TaskListener, View.OnClickListener {

	private static final String OPERATION_SUCCESS="SUCCESS";
	private Button demo;
	private Button submit;
	private EditText fileNameTextField;
	private TextView statusText;
	private ImageView mImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		demo=(Button) findViewById(R.id.sample);
		submit=(Button) findViewById(R.id.submit);
		demo.setOnClickListener(this);
		submit.setOnClickListener(this);

		fileNameTextField=(EditText) findViewById(R.id.fileName);
		statusText=(TextView) findViewById(R.id.statusText);
		mImageView=(ImageView) findViewById(R.id.imageView);

//		AccountManager accountManager = AccountManager.get(this);
//		Account gmail=accountManager.getAccountsByType("com.gmail")[0];
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		switch(id) {
			case (R.id.action_settings):
				return true;
			case (R.id.file_save):
				Intent i=new Intent(this, FileUploadActivity.class);
				startActivity(i);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onComplete(Object response) {
		GetResponse data=(GetResponse) response;
		String status=data.getMessageHeader();
		if (status.equals(OPERATION_SUCCESS)){
			String imageString = data.getEncodedImageString();

			byte[] imageData = Base64.decode(imageString, Base64.DEFAULT);
			Bitmap bitmap= BitmapFactory.decodeByteArray(imageData, 0, imageData.length);

			statusText.setText(status);
			mImageView.setImageBitmap(bitmap);
		} else{
			Toast.makeText(this, "Media fetch status: "+status,Toast.LENGTH_SHORT).show();
		}
	}


	@Override
	public void onClick(View v) {
		int id=v.getId();
		String msg;
		switch(id){
			case(R.id.submit):
				String fileName=fileNameTextField.getText().toString();
				new MediaFetchTask(this).execute(new Pair<Context, String>(this,fileName));
				msg="Fetch for "+fileName+" initiated";
				Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
				break;
			case(R.id.sample):
				msg="Fetch for sample image initiated";
				new MediaFetchTask(this).execute(new Pair<Context, String>(this, "pickachu.png"));
				Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
				break;
			default:
				break;

		}
	}
}
