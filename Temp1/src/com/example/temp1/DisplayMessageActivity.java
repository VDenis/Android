package com.example.temp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
			
	    // Get the message from the intent
	    Intent intent = getIntent();
	    TextView textView;
	    
	    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_FROAM_EDITMESSAGE);
	    if(!message.isEmpty())
	    {
		    textView = (TextView) findViewById(R.id.text_message);
		    textView.setText( getResources().getString(R.string.DMActivity_additionalfor_text_message) + " " +  message);
	    }
	    
	    message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_FROAM_EDITMESSAGE2);
	    if(!message.isEmpty())
	    {
		    textView = (TextView) findViewById(R.id.text_message2);
		    textView.setText( getResources().getString(R.string.DMActivity_additionalfor_text_message2) + " " +  message);
	    }
	    
	    message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_FROAM_EDITMESSAGE3);
	    if(!message.isEmpty())
	    {
		    textView = (TextView) findViewById(R.id.text_message3);
		    textView.setText( getResources().getString(R.string.DMActivity_additionalfor_text_message3) + " " +  message);
	    }
	    
	    message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_FROAM_EDITMESSAGE4);
	    if(!message.isEmpty())
	    {
		    textView = (TextView) findViewById(R.id.text_message4);
		    textView.setText( getResources().getString(R.string.DMActivity_additionalfor_text_message4) + " " +  message);
	    }
	    
	    message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_FROAM_EDITMESSAGE5);
	    if(!message.isEmpty())
	    {
		    textView = (TextView) findViewById(R.id.text_message5);
		    textView.setText( getResources().getString(R.string.DMActivity_additionalfor_text_message5) + " " +  message);
	    }
	    
	    message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_FROAM_EDITMESSAGE6);
	    if(!message.isEmpty())
	    {
		    textView = (TextView) findViewById(R.id.text_message6);
		    textView.setText( getResources().getString(R.string.DMActivity_additionalfor_text_message6) + " " +  message);
	    }
	    
	    message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_FROAM_EDITMESSAGE7);
	    if(!message.isEmpty())
	    {
	    	textView = (TextView) findViewById(R.id.text_message7);
	    	textView.setText( getResources().getString(R.string.DMActivity_additionalfor_text_message7) + " " +  message);
	    }	    	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

	/** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
    	Intent resultIntent = new Intent();
    	
    	EditText editText = (EditText) findViewById(R.id.edit_message8);
    	String message = editText.getText().toString();
    	
    	if(message.isEmpty())
    	{
    		message = getResources().getString(R.string.DMActivity_dismiss_text_message8);
    	}
    	resultIntent.putExtra(MainActivity.EXTRA_MESSAGE_RESPONSE_FROM_SECOND_ACTIVITY, message);
    	
    	setResult(Activity.RESULT_OK, resultIntent);
    	finish();
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
