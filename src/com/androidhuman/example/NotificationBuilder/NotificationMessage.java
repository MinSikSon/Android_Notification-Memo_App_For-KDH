package com.androidhuman.example.NotificationBuilder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class NotificationMessage extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    //TextView tv = new TextView(this);
	    //tv.setText(NotificationBuilder.text);
	    //setContentView(tv);
	    Intent i = new Intent(NotificationMessage.this, NotificationBuilder.class);
	    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
		finish();
	    
	    // Cancel Notification
	    // NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
	    // nm.cancel(1234);
	}

}
