package com.example.acacyc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class credito extends SherlockActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.credito);
		setTitle("Creditos");
		
		//Button btn_hipo = (Button) findViewById(R.id.btn_hipo);		
		Button btn_pers = (Button) findViewById(R.id.btn_pers);	        
		Button btn_gere = (Button) findViewById(R.id.btn_gere);	        	   
		Button btn_decr = (Button) findViewById(R.id.btn_decre);
		Button btn_emer	= (Button) findViewById(R.id.btn_emer);		
		Button atras	= (Button) findViewById(R.id.atras);	
		//Button btn_bill	= (Button) findViewById(R.id.btn_bille);
		
		/*btn_hipo.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), Tipo.class);
				i.putExtra("flag", "Credito Hipotecario");
				startActivity(i);
			
			}
		});*/
		btn_pers.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), Tipo.class);
				i.putExtra("flag", "Credito Personal");
				i.putExtra("tipo", "pe");
				startActivity(i);
			
			}
		});
		btn_gere.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), Tipo.class);
				i.putExtra("flag", "Credito Gerencial");
				i.putExtra("tipo", "ge");
				startActivity(i);
				
			}
		});
		btn_decr.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), Tipo.class);
				i.putExtra("flag", "Credito Decreciente");
				i.putExtra("tipo", "de");
				startActivity(i);
		
			}
		});
		btn_emer.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), Tipo.class);
				i.putExtra("flag", "Credito de Emergencia");
				i.putExtra("tipo", "em");
				startActivity(i);
		
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
		/*btn_bill.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), Tipo.class);
				i.putExtra("flag", "Billetin");
				startActivity(i);
		
			}
		});*/
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
