package com.example.acacyc;

import java.text.DecimalFormat;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;


public class Tipo extends SherlockActivity{

	String flag,tipo;
	TextView credito;
	Button aplicar, _b0,_b1,_b2,_b3,_b4,_b5,_b6,_b7,_b8,_b9,_bC;
	EditText monto;
	RadioGroup rg1;
	RadioButton rb1,rb2,rb3,rb4,rb5,rb6;
	double mont = 0;
	private boolean _nuevoValor = true;
	int plazo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.tipo);
		
		Bundle extra = this.getIntent().getExtras();
		flag = (String) extra.get("flag");
		tipo = (String) extra.get("tipo");
		setTitle(flag);
		
		_b0 = (Button)findViewById(R.id.button0);
        _b1 = (Button)findViewById(R.id.button1);
        _b2 = (Button)findViewById(R.id.button2);
        _b3 = (Button)findViewById(R.id.button3);
        _b4 = (Button)findViewById(R.id.button4);
        _b5 = (Button)findViewById(R.id.button5);
        _b6 = (Button)findViewById(R.id.button6);
        _b7 = (Button)findViewById(R.id.button7);
        _b8 = (Button)findViewById(R.id.button8);
        _b9 = (Button)findViewById(R.id.button9);
        _bC = (Button)findViewById(R.id.buttonC);
        aplicar = (Button)findViewById(R.id.btnaplicar);
        Button atras	= (Button) findViewById(R.id.atras1);	
		credito = (TextView)findViewById(R.id.credito);		
		credito.setText(flag);
		
		monto = (EditText) findViewById(R.id.monto);				
		monto.setText("0");
		
		View.OnClickListener lsBoton = new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				monto.setTextColor(Color.BLACK);
				cambiaValor();
				monto.setText(monto.getText()+((Button)arg0).getText().toString());
			}
		};
			
		_b1.setOnClickListener(lsBoton);        
		_b2.setOnClickListener(lsBoton);
		_b3.setOnClickListener(lsBoton);
		_b4.setOnClickListener(lsBoton);
		_b5.setOnClickListener(lsBoton);
		_b6.setOnClickListener(lsBoton);        
		_b7.setOnClickListener(lsBoton);
		_b8.setOnClickListener(lsBoton);
		_b9.setOnClickListener(lsBoton);
		_b0.setOnClickListener(lsBoton);
		_bC.setOnClickListener(lsBoton);
		
		_bC.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View arg0) {
        		monto.setText("0");
				_nuevoValor = true;
			}
		});
		
		aplicar.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				
				mont = Double.parseDouble(monto.getText().toString());

				if(tipo.equals("pe")){	
					if(mont >= 1000 && mont <=20000){
						String a = monto.getText().toString();
						Intent i = new Intent(getApplicationContext(), Tipo2.class);	
						i.putExtra("flag", flag);
						i.putExtra("tipo", tipo);
						i.putExtra("monto", a);
						startActivity(i);
					}else if (mont == 0.0 || mont <1000){
						Toast.makeText(Tipo.this, "INGRESE UN MONTO MAYOR DE $1000" , 10000).show();
					}else if (mont >20000){
						Toast.makeText(Tipo.this, "INGRESE UN MONTO MENOR DE $20000" , 10000).show();
					}
				}else if(tipo.equals("ge")){
					if(mont >= 1000 && mont <=5000){
						String a = monto.getText().toString();
						Intent i = new Intent(getApplicationContext(), Tipo2.class);	
						i.putExtra("flag", flag);
						i.putExtra("tipo", tipo);
						i.putExtra("monto", a);
						startActivity(i);
					}else if (mont == 0.0 || mont <1000){
						Toast.makeText(Tipo.this, "INGRESE UN MONTO MAYOR DE $1000" , 10000).show();
					}else if (mont >5000){
						Toast.makeText(Tipo.this, "INGRESE UN MONTO MENOR DE $5000" , 10000).show();
					}
				}else if(tipo.equals("de")){
					if(mont >= 1000 && mont <=2000){
						String a = monto.getText().toString();
						Intent i = new Intent(getApplicationContext(), Tipo2.class);	
						i.putExtra("flag", flag);
						i.putExtra("tipo", tipo);
						i.putExtra("monto", a);
						startActivity(i);
					}else if (mont == 0.0 || mont <1000){
						Toast.makeText(Tipo.this, "INGRESE UN MONTO MAYOR DE $1000" , 10000).show();
					}else if (mont >2000){
						Toast.makeText(Tipo.this, "INGRESE UN MONTO MENOR DE $2000" , 10000).show();
					}
				}else if(tipo.equals("em")){
					if(mont >= 100 && mont <=500){
						String a = monto.getText().toString();
						Intent i = new Intent(getApplicationContext(), Tipo2.class);	
						i.putExtra("flag", flag);
						i.putExtra("tipo", tipo);
						i.putExtra("monto", a);
						startActivity(i);
					}else if (mont == 0.0 || mont <100){
						Toast.makeText(Tipo.this, "INGRESE UN MONTO MAYOR DE $100" , 10000).show();
					}else if (mont >500){
						Toast.makeText(Tipo.this, "INGRESE UN MONTO MENOR DE $500" , 10000).show();
					}
				}
			}
		});
		atras.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), credito.class);				
				startActivity(i);
				finish();
			}
		});
	}
	private void cambiaValor()
    {
    	if (_nuevoValor == true)
    	{
    		monto.setText("");
    		_nuevoValor = false;
    	}
    }
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	      case android.R.id.home:
	    	  Intent intent = new Intent(this, credito.class);
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
	        return true;
		}
	    return super.onKeyDown(keyCode, event);
	}
}
