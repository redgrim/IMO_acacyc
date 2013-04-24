package com.example.acacyc;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard_layout);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		//Button btn_saldo 		= (Button) findViewById(R.id.btn_news_feed);		
		Button btn_credito 		= (Button) findViewById(R.id.btn_friends);	        
		Button btn_conocenos 	= (Button) findViewById(R.id.btn_messages);	        	   
		Button btn_informacion 	= (Button) findViewById(R.id.btn_events);
		//Button salir 	= (Button) findViewById(R.id.btnsalir);
	
		/*btn_saldo.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), saldo.class);
		
				startActivity(i);
			
			}
		});*/
		btn_credito.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), credito.class);

				startActivity(i);

			}
		});
		btn_conocenos.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), conocenos.class);
				//i.putExtra(Extra.IMAGES, IMAGES);
				startActivity(i);
			}
		});
		btn_informacion.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
			//	Intent i = new Intent(getApplicationContext(), Mapa2.class);
				Intent i = new Intent(getApplicationContext(), informacion.class);

				startActivity(i);
			}
		});
			
		/*salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	Intent intent = new Intent(MainActivity.this, login.class);          
            	startActivity(intent);
            	finish();
            }
        });*/
	}
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	      case android.R.id.home:
	    	  Intent intent = new Intent(this, login.class);
	          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	          startActivity(intent);
	          finish();
	        return(true);

	    // more code here for other cases
	  }
	    return super.onOptionsItemSelected(item);    
	}
}
