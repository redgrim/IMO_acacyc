package com.example.acacyc;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class conocenos extends SherlockActivity{

	 private WebView web;
	 ProgressBar progressBar;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	
		setContentView(R.layout.conocenos);
		setTitle("Conocenos");
		 web = (WebView) findViewById(R.id.WebView);
	     progressBar = (ProgressBar) findViewById(R.id.progressBar1);

	     web.setWebViewClient(new myWebClient());
	     web.getSettings().setJavaScriptEnabled(true);
	     web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
	     web.loadUrl("http://www.acacycpnc.com.sv/");
	     Button atras	= (Button) findViewById(R.id.atras1);	
	     
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
	public class myWebClient extends WebViewClient
	{
	    @Override
	    public void onPageStarted(WebView view, String url, Bitmap favicon) {
	        // TODO Auto-generated method stub
	        super.onPageStarted(view, url, favicon);
	    }

	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        // TODO Auto-generated method stub

	        view.loadUrl(url);
	        return true;

	    }

	    @Override
	    public void onPageFinished(WebView view, String url) {
	        // TODO Auto-generated method stub
	        super.onPageFinished(view, url);

	        progressBar.setVisibility(View.GONE);
	    }
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
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
	        return true;
		}
	    return super.onKeyDown(keyCode, event);
	}
}
