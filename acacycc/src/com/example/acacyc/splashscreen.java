package com.example.acacyc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class splashscreen extends Activity {
	
	public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
	//int inicio	=	0; 
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		//StartAnimations();

		// create a File object for the parent directory
	/*	File imoves 	= new File("/sdcard/IMOVES");
		// have the object build the directory structure, if needed.
		imoves.mkdirs();
		File imovesP 	= new File("/sdcard/IMOVES/Ofertas");
		// have the object build the directory structure, if needed.
		imovesP.mkdirs();
		File imovesO 	= new File("/sdcard/IMOVES/Galeria");
		// have the object build the directory structure, if needed.
		imovesO.mkdirs();
		File imoveN 	= new File("/sdcard/IMOVES/Noticias");*/
		// have the object build the directory structure, if needed.
		//imoveN.mkdirs();

		Thread splashThread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while (waited < 5000) {
						sleep(100);
						waited += 100;
					}
				}catch (InterruptedException e) {
					// do nothing
	            }finally {
	            	finish();
	            	//if (inicio==0){
	            		Intent i = new Intent();
	            		i.setClassName("com.example.acacyc", "com.example.acacyc.MainActivity");
	            		startActivity(i);
	            /*	}else{
	            		Intent i2 = new Intent();
	            		i2.setClassName("com.example.mydemo", "com.example.mydemo.Categoria");
	            		startActivity(i2);
	            	}*/
	            }
			}
		};
		splashThread.start();
	}
	/*private void StartAnimations() {
		// TODO Auto-generated method stub
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
		anim.reset();
		LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
		l.clearAnimation();
		l.startAnimation(anim);	
		anim = AnimationUtils.loadAnimation(this, R.anim.translate);
		anim.reset();
		ImageView iv = (ImageView) findViewById(R.id.primera);
		iv.clearAnimation();
		iv.startAnimation(anim);	
	}*/
}