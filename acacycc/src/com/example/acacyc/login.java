package com.example.acacyc;

import com.actionbarsherlock.app.SherlockActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends SherlockActivity {

	EditText usua;
	Button login;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		setContentView(R.layout.login);

		usua = (EditText)findViewById(R.id.usu);
	//	pass = (EditText)findViewById(R.id.pass);
		login =(Button)findViewById(R.id.btnLogin);		
		login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	String usuario = usua.getText().toString();
            	//String password = pass.getText().toString();
            	if(usua.length() < 9){
            		errorlogin1();
            	}else{
            		new MyAsyncTask().execute();
           		 usua.setText("");
            		
            	}
            }
        });
	}	
	private class MyAsyncTask extends AsyncTask<Void, Void, Void>{		
		ProgressDialog mProgressDialog;
        @Override
        protected void onPostExecute(Void result) {
            mProgressDialog.dismiss();        
            Intent i = new Intent(login.this, MainActivity.class);
            startActivity(i);	            	          
        }
        @Override
        protected void onPreExecute() {
            mProgressDialog = ProgressDialog.show(login.this, "Loading...", "Data is Loading...");
        }		
		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			return null;
		}	
	}	
	public void errorlogin(){
		Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(200);
		Toast toast = Toast.makeText(getApplicationContext(), "Error: Ingrese usuario", Toast.LENGTH_SHORT);
		toast.show();
	}
	public void errorlogin1(){
		Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		vibrator.vibrate(200);
		Toast toast = Toast.makeText(getApplicationContext(), "Error: Ingrese los nueve digitos del usuario", Toast.LENGTH_SHORT);
		toast.show();
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK) {
	        return true;
		}
	    return super.onKeyDown(keyCode, event);
	}
	/*@Override
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
	}*/
}