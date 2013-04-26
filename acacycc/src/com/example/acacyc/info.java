package com.example.acacyc;

import com.actionbarsherlock.app.SherlockActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class info extends SherlockActivity{

	String flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		Bundle extra = this.getIntent().getExtras();
		
			
		flag = (String) extra.get("flag");
		 if(flag.equals("1")){
			 setContentView(R.layout.info);
		 }else if(flag.equals("2")){
			 setContentView(R.layout.info1);
		 }else if(flag.equals("3")){
			 setContentView(R.layout.info2);
		 }else if(flag.equals("4")){
			 setContentView(R.layout.info3);
		 }else if(flag.equals("5")){
			 setContentView(R.layout.info4);
		 }else if(flag.equals("6")){
			 setContentView(R.layout.info5);
		 }else if(flag.equals("7")){
			 setContentView(R.layout.info6);
		 }else if(flag.equals("8")){
			 setContentView(R.layout.info7);
		 }
		 Button atras	= (Button) findViewById(R.id.atras);
		 atras.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View view) {
					// Launching News Feed Screen
					Intent i = new Intent(getApplicationContext(), informacion.class);				
					startActivity(i);
					finish();
				}
			});
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK) {
	        return true;
		}
	    return super.onKeyDown(keyCode, event);
	}
}
