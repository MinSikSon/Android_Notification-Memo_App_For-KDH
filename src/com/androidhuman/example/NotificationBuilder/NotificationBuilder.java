package com.androidhuman.example.NotificationBuilder;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotificationBuilder extends Activity implements OnClickListener{
	private EditText contentTitle;
	private EditText contentText;
	private Button registerButton;
	private NotificationManager nm;
	
	static String titles="";
	static String texts="";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        SharedPreferences contentTitleSpf1 = getSharedPreferences("contentTitle1", MODE_PRIVATE);
     	SharedPreferences.Editor contentTitleSpfEditor1 = contentTitleSpf1.edit();
        
        contentTitleSpfEditor1.putString("test1", "");
        contentTitleSpfEditor1.commit();
        
        
        contentTitle = (EditText)findViewById(R.id.contentTitle);
        contentText = (EditText)findViewById(R.id.contentText);
        registerButton = (Button)findViewById(R.id.registerNotification);
        
        registerButton.setOnClickListener(this);
        contentTitle.setText(titles);
        contentTitle.setText(getPreferences());
		contentText.setText(texts);
		contentText.setText(getPreferences2());
    }

	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.registerNotification:
			// Get Notification Service
			nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
			
			PendingIntent intent = PendingIntent.getActivity(
					NotificationBuilder.this, 0, 
					new Intent(NotificationBuilder.this, NotificationMessage.class), 0);
			
			//tickers = tickerText.getText().toString();
			titles = contentTitle.getText().toString();
			savePreferences(titles);
			texts = contentText.getText().toString();
			savePreferences2(texts);
										
			// Create Notification Object
//			Notification notification =	new Notification(android.R.drawable.ic_input_add, tickers, System.currentTimeMillis());
			Notification notification =	new Notification(android.R.drawable.ic_input_add, titles, System.currentTimeMillis());
			
			notification.setLatestEventInfo(NotificationBuilder.this, titles, texts, intent);
			
			nm.notify(1234, notification);
			Toast.makeText(NotificationBuilder.this, "Notification Registered.", 
					Toast.LENGTH_SHORT).show();
		break;
		}
		
	}
	
	
	
	public String getPreferences() {
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		return pref.getString("hi", "");
	}

	// 값 저장하기
	public void savePreferences(String value) {
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.putString("hi", value);
		editor.commit();
	}
	
	public String getPreferences2() {
		SharedPreferences pref2 = getSharedPreferences("pref", MODE_PRIVATE);
		return pref2.getString("hi2", "");
	}

	// 값 저장하기
	public void savePreferences2(String value) {
		SharedPreferences pref2 = getSharedPreferences("pref", MODE_PRIVATE);
		SharedPreferences.Editor editor2 = pref2.edit();
		editor2.putString("hi2", value);
		editor2.commit();
	}
	


	/*
	// 값(Key Data) 삭제하기
	public void removePreferences() {
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.remove("hi");
		editor.commit();
	}

	// 값(ALL Data) 삭제하기
	public void removeAllPreferences() {
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.clear();
		editor.commit();
	}
	*/
}