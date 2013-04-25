package com.example.acacyc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class informacion extends SherlockActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.informa);
		
		setTitle("Informacion");
		Button btn1 		= (Button) findViewById(R.id.btn1);	        
		Button btn2 		= (Button) findViewById(R.id.btn2);	        	   
		Button btn3 		= (Button) findViewById(R.id.btn3);
		Button btn4 		= (Button) findViewById(R.id.btn4);	        
		Button btn5 		= (Button) findViewById(R.id.btn5);	        	   
		Button btn6 		= (Button) findViewById(R.id.btn6);
		Button btn7 		= (Button) findViewById(R.id.btn7);	        	   
		Button btn8 		= (Button) findViewById(R.id.btn8);		
		Button atras	= (Button) findViewById(R.id.atras);	
		
		btn1.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), info.class);		
				i.putExtra("flag", "1");
				startActivity(i);
				finish();
			}
		});
		btn2.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), info.class);	
				i.putExtra("flag", "2");
				startActivity(i);
				finish();
			}
		});
		btn3.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), info.class);
				i.putExtra("flag", "3");
				startActivity(i);
				finish();
			}
		});
		btn4.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), info.class);
				i.putExtra("flag", "4");
				startActivity(i);
				finish();
			}
		});
		btn5.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), info.class);
				i.putExtra("flag", "5");
				startActivity(i);
				finish();
			}
		});
		btn6.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), info.class);
				i.putExtra("flag", "6");
				startActivity(i);
				finish();
			}
		});
		btn7.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), info.class);
				i.putExtra("flag", "7");
				startActivity(i);
				finish();
			}
		});
		btn8.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), info.class);
				i.putExtra("flag", "8");
				startActivity(i);
				finish();
			}
		});
		
		atras.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), MainActivity.class);				
				startActivity(i);
				finish();
			}
		});
	}
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	      case android.R.id.home:
	    	  Intent intent = new Intent(this, MainActivity.class);
	          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	          startActivity(intent);
	          finish();
	        return(true);

	    // more code here for other cases
	  }
	    return super.onOptionsItemSelected(item);    
	}
}
