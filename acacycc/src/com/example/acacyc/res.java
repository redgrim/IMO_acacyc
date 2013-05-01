package com.example.acacyc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;

public class res extends SherlockActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.res);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		
		Button btn_preg 	= (Button) findViewById(R.id.preg);
		
		btn_preg.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), video.class);

				startActivity(i);

			}
		});
	}
}
