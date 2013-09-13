package com.example.temp1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

	public class MainActivity extends FragmentActivity implements DatePickerDialog.OnDateSetListener 
	{
	
	    @Override
	    public void onDateSet(DatePicker view, int year, int month, int day) 
	    {
	        //do some stuff for example write on log and update TextField on activity
	        ((EditText) findViewById(R.id.edit_message2)).setText(day + "." + (month+1) + "." + year);
	    }
	
	
		public final static String EXTRA_MESSAGE_FROAM_EDITMESSAGE = "com.example.temp1.MESSAGE";
		public final static String EXTRA_MESSAGE_FROAM_EDITMESSAGE2 = "com.example.temp1.MESSAGE2";
		public final static String EXTRA_MESSAGE_FROAM_EDITMESSAGE3 = "com.example.temp1.MESSAGE3";
		public final static String EXTRA_MESSAGE_FROAM_EDITMESSAGE4 = "com.example.temp1.MESSAGE4";
		public final static String EXTRA_MESSAGE_FROAM_EDITMESSAGE5 = "com.example.temp1.MESSAGE5";
		public final static String EXTRA_MESSAGE_FROAM_EDITMESSAGE6 = "com.example.temp1.MESSAGE6";
		public final static String EXTRA_MESSAGE_FROAM_EDITMESSAGE7 = "com.example.temp1.MESSAGE7";
		public final static String EXTRA_MESSAGE_RESPONSE_FROM_SECOND_ACTIVITY = "com.example.temp1.RESPONSE";
	
	
		@Override
	    public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
			
	        ((Button) findViewById(R.id.btnSpinnerSex)).setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                final String[] items = view.getResources().getStringArray(R.array.sex);
	                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, items);
	                new AlertDialog.Builder(MainActivity.this).setTitle("Выберете пол").setAdapter(adapter, new DialogInterface.OnClickListener() {
	                    @Override
	                    public void onClick(DialogInterface dialog, int which) {
	                        ((Button) findViewById(R.id.btnSpinnerSex)).setText(items[which]);
	                        dialog.dismiss();
	                    }
	                }).create().show();
	            }
	        });     
	
	    }	

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) 
	    {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	    
	  // Date picker
	    public void showDatePickerDialog(View view) 
	    {
	        // Do something in response to button
	        DatePickerFragment newFragment = new DatePickerFragment();
	        newFragment.show(getSupportFragmentManager(), "datePicker");
	    }
	  // END Date picker
    
    
	    /** Called when the user clicks the Send button */
	    public void sendMessage(View view) 
	    {
	        // Do something in response to button
	    	
	    	Intent intent = new Intent(this, DisplayMessageActivity.class);
	    	
	    	
	    	EditText editText = (EditText) findViewById(R.id.edit_message);
	    	String message = editText.getText().toString();
	    	intent.putExtra(EXTRA_MESSAGE_FROAM_EDITMESSAGE, message);
	    	
	    	editText = (EditText) findViewById(R.id.edit_message2);
	    	message = editText.getText().toString();
	    	intent.putExtra(EXTRA_MESSAGE_FROAM_EDITMESSAGE2, message);
	    	
	    	message = ((Button) findViewById(R.id.btnSpinnerSex)).getText().toString();
	    	intent.putExtra(EXTRA_MESSAGE_FROAM_EDITMESSAGE3, message);
	    	
	    	editText = (EditText) findViewById(R.id.edit_message4);
	    	message = editText.getText().toString();
	    	intent.putExtra(EXTRA_MESSAGE_FROAM_EDITMESSAGE4, message);
	    	
	    	editText = (EditText) findViewById(R.id.edit_message5);
	    	message = editText.getText().toString();
	    	intent.putExtra(EXTRA_MESSAGE_FROAM_EDITMESSAGE5, message);
	    	
	    	editText = (EditText) findViewById(R.id.edit_message6);
	    	message = editText.getText().toString();
	    	intent.putExtra(EXTRA_MESSAGE_FROAM_EDITMESSAGE6, message);
	    	
	    	editText = (EditText) findViewById(R.id.edit_message7);
	    	message = editText.getText().toString();
	    	intent.putExtra(EXTRA_MESSAGE_FROAM_EDITMESSAGE7, message);
	    	
	    	//startActivity(intent);
	    	startActivityForResult(intent, 777);
	    }
	    @Override
	    public void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	
	        if (requestCode == 777) {
	            if (resultCode == Activity.RESULT_OK) {                
	            	
	        	    // Get the message from the intent
	        	    Intent intent = data;
	        	    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_RESPONSE_FROM_SECOND_ACTIVITY);
	        	    
	            	
	            	AlertDialog.Builder ad;
	                final Context context;
	                
	                context = MainActivity.this;
	                String title = "Письмо от работодателя";
	                String button1String = "Закрыть";
	                final String button2String = "Спасибо за участие!";
	                
	                ad = new AlertDialog.Builder(context);
	                ad.setTitle(title);  // заголовок
	                ad.setMessage(message); // сообщение
	                ad.setPositiveButton(button1String, new OnClickListener() {
	                    public void onClick(DialogInterface dialog, int arg1) {
	                        Toast.makeText(context, button2String,
	                                Toast.LENGTH_LONG).show();
	                    }
	                });
	                ad.setCancelable(true);
	                ad.setOnCancelListener(new OnCancelListener() {
	                    public void onCancel(DialogInterface dialog) {
	                        Toast.makeText(context, "Вы ничего не выбрали",
	                                Toast.LENGTH_LONG).show();
	                    }
	                });
	                ad.show();
	            }
	        }


   }
}
