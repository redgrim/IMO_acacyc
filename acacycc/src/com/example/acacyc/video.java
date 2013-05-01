package com.example.acacyc;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.actionbarsherlock.app.SherlockActivity;

public class video extends SherlockActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		
		 VideoView videoView = (VideoView) findViewById(R.id.videoView_video);
		  
		         Uri path = Uri.parse("android.resource://com.example.acacyc/"
		                 + R.raw.song2);
		          
		         MediaController mc = new MediaController(this);    
		                 videoView.setMediaController(mc);
		                 videoView.setVideoURI(path);
		                 videoView.start();		                 		           
	}
}
