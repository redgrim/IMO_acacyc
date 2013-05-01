package com.example.acacyc;

import java.text.DecimalFormat;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

public class Tipo2 extends SherlockActivity{
	
	String flag,monto,tipo;
	RadioGroup rg1;
	RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10,rb11;
	Button aplicar;
	double mont = 0;
	TextView credito;
	int plazo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		Bundle extra = this.getIntent().getExtras();
		flag = (String) extra.get("flag");
		tipo = (String) extra.get("tipo");
		monto = (String) extra.get("monto");
		setTitle(flag);
		if(tipo.equals("pe")){
			setContentView(R.layout.tipo2);
		}else if(tipo.equals("ge")){
			setContentView(R.layout.tipo3);
		}else if(tipo.equals("de")){
			setContentView(R.layout.tipo4);
		}else if(tipo.equals("em")){
			setContentView(R.layout.tipo5);
		}
		rb1 = (RadioButton) findViewById(R.id.rb12);
		rb2 = (RadioButton) findViewById(R.id.rb24);
		rb3 = (RadioButton) findViewById(R.id.rb36);
		rb4 = (RadioButton) findViewById(R.id.rb48);
		rb5 = (RadioButton) findViewById(R.id.rb60);
		rb6 = (RadioButton) findViewById(R.id.rb72);
		rb7 = (RadioButton) findViewById(R.id.rb96);	
		rb8 = (RadioButton) findViewById(R.id.rb1);
		rb9 = (RadioButton) findViewById(R.id.rb2);
		rb10 = (RadioButton) findViewById(R.id.rb3);
		rb11 = (RadioButton) findViewById(R.id.rb4);
		
		rg1 = (RadioGroup) findViewById(R.id.radiogroup);
		aplicar = (Button)findViewById(R.id.btnaplicar);
		Button atras1	= (Button) findViewById(R.id.atras1);
		Button atras2	= (Button) findViewById(R.id.atras2);
		credito = (TextView)findViewById(R.id.credito);		
		credito.setText(flag);
		aplicar = (Button)findViewById(R.id.btnaplicar);
		aplicar.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				
				try {
					mont = Double.parseDouble(monto);
				}catch(NumberFormatException nfe){
					
				}

				if(tipo.equals("pe")){
					if (rb1.isChecked()== true) {
						plazo = 12;
					}else if (rb2.isChecked() == true) {
						plazo = 24;
					}else if (rb3.isChecked() == true) {
						plazo = 36;
					}else if (rb4.isChecked() == true) {
						plazo = 48;
					}else if (rb5.isChecked() == true) {
						plazo = 60;
					}else if (rb6.isChecked() == true) {
						plazo = 72;
					}else if (rb7.isChecked() == true) {
						plazo = 96;
					}
					if(mont >= 1000){
					double interes = 0.139;
					
					 double a =  ( ( mont/( (1- (Math.pow( (1+(interes/12)), -plazo) ) )/(interes/12) ) )+1.14 );
					 double b = mont * (0.061/100);
					 double c = a+b;
					
					 DecimalFormat df = new DecimalFormat("#.##");
	
					AlertDialog.Builder builder;
					final AlertDialog alertDialog;
					LayoutInflater inflater = (LayoutInflater) Tipo2.this.getSystemService(Tipo2.this.LAYOUT_INFLATER_SERVICE);
					//Nos guardamos una referencia a nuestro layout	
					View layout = inflater.inflate(R.layout.aplica, (ViewGroup) Tipo2.this.findViewById(R.id.layout_root1));
					
		          
					builder = new AlertDialog.Builder(Tipo2.this);	
					//Asignamos la vista del AlertDialog a nuestro propio layout
					builder.setView(layout);
					
					alertDialog = builder.create();
					//Asignamos el evento click a nuestro botón de aceptar (en este caso cierra el alertdialog)
					final TextView title = (TextView) layout.findViewById(R.id.title);
					final TextView tx = (TextView) layout.findViewById(R.id.mo);
					final TextView tx1 = (TextView) layout.findViewById(R.id.pl);
					final TextView tx2 = (TextView) layout.findViewById(R.id.in);
					final TextView tx3 = (TextView) layout.findViewById(R.id.cu);
					final TextView tx4 = (TextView) layout.findViewById(R.id.seg);
					final TextView tx5 = (TextView) layout.findViewById(R.id.cuto);
					title.setText("Linea de "+flag);
		            tx.setText("" + mont);
		            tx1.setText(""+plazo);
		            tx2.setText(""+interes);
		            tx3.setText(df.format(a));
		            tx4.setText(df.format(b));
		            tx5.setText(df.format(c));
					Button aceptarBtn = (Button) layout.findViewById(R.id.btnaceptar);
					aceptarBtn.setOnClickListener(new OnClickListener(){
						@Override	
						public void onClick(View v) {			
							alertDialog.dismiss();	
						}
					});
					//Mostramos el alertdialog	
					alertDialog.show();	
					
					a=0;
					b=0;
					c=0;
					
					}/*else if (mont == 0.0 || mont <1000){
						Toast.makeText(Tipo2.this, "INGRESE UN MONTO MAYOR DE $ 1000" , 10000).show();
					}else if (mont >20000){
						Toast.makeText(Tipo2.this, "INGRESE UN MONTO MENOR DE $ 20000" , 10000).show();
					}*/
					
				}else if(tipo.equals("ge")){
					
					if (rb1.isChecked()== true) {
						plazo = 12;
					}else if (rb2.isChecked() == true) {
						plazo = 24;
					}else if (rb3.isChecked() == true) {
						plazo = 36;
					}else if (rb4.isChecked() == true) {
						plazo = 48;
					}else if (rb5.isChecked() == true) {
						plazo = 60;
					}
					
					if(mont >= 1000){
						double interes = 0.100;
						
						 double a =  ( ( mont/( (1- (Math.pow( (1+(interes/12)), -plazo) ) )/(interes/12) ) )+1.14 );
						 double b = mont * (0.061/100);
						 double c = a+b;
						
						 DecimalFormat df = new DecimalFormat("#.##");
						
						AlertDialog.Builder builder;
						final AlertDialog alertDialog;
						LayoutInflater inflater = (LayoutInflater) Tipo2.this.getSystemService(Tipo2.this.LAYOUT_INFLATER_SERVICE);
						//Nos guardamos una referencia a nuestro layout	
						View layout = inflater.inflate(R.layout.aplica, (ViewGroup) Tipo2.this.findViewById(R.id.layout_root1));
						
			          
						builder = new AlertDialog.Builder(Tipo2.this);	
						//Asignamos la vista del AlertDialog a nuestro propio layout
						builder.setView(layout);
						
						alertDialog = builder.create();
						//Asignamos el evento click a nuestro botón de aceptar (en este caso cierra el alertdialog)
						final TextView title = (TextView) layout.findViewById(R.id.title);
						final TextView tx = (TextView) layout.findViewById(R.id.mo);
						final TextView tx1 = (TextView) layout.findViewById(R.id.pl);
						final TextView tx2 = (TextView) layout.findViewById(R.id.in);
						final TextView tx3 = (TextView) layout.findViewById(R.id.cu);
						final TextView tx4 = (TextView) layout.findViewById(R.id.seg);
						final TextView tx5 = (TextView) layout.findViewById(R.id.cuto);
						title.setText("Linea de "+flag);
			            tx.setText("" + mont);
			            tx1.setText(""+plazo);
			            tx2.setText(""+interes);
			            tx3.setText(df.format(a));
			            tx4.setText(df.format(b));
			            tx5.setText(df.format(c));
						Button aceptarBtn = (Button) layout.findViewById(R.id.btnaceptar);
						aceptarBtn.setOnClickListener(new OnClickListener(){
							@Override	
							public void onClick(View v) {			
								alertDialog.dismiss();	
							}
						});
						//Mostramos el alertdialog	
						alertDialog.show();	
						
						a=0;
						b=0;
						c=0;
						
						}/*else if (mont == 0.0 || mont <1000){
							Toast.makeText(Tipo2.this, "INGRESE UN MONTO MAYOR DE $1000" , 10000).show();
						}else if ( mont >5000){
							Toast.makeText(Tipo2.this, "INGRESE UN MONTO MENOR DE $5000" , 10000).show();
						}*/
				}else if(tipo.equals("de")){
					if (rb1.isChecked()== true) {
						plazo = 12;
					}else if (rb2.isChecked() == true) {
						plazo = 24;
					}else if (rb3.isChecked() == true) {
						plazo = 36;
					}
					if(mont >= 1000){
						double interes = 0.240;
						
						 double a =  Math.ceil(( ( mont/( (1- (Math.pow( (1+(interes/12)), -plazo) ) )/(interes/12) ) )+1.14 ));
						 double b = 3.00;
						 double c = a+b;
						
						 DecimalFormat df = new DecimalFormat("#.##");
						
						AlertDialog.Builder builder;
						final AlertDialog alertDialog;
						LayoutInflater inflater = (LayoutInflater) Tipo2.this.getSystemService(Tipo2.this.LAYOUT_INFLATER_SERVICE);
						//Nos guardamos una referencia a nuestro layout	
						View layout = inflater.inflate(R.layout.aplica, (ViewGroup) Tipo2.this.findViewById(R.id.layout_root1));
						
			          
						builder = new AlertDialog.Builder(Tipo2.this);	
						//Asignamos la vista del AlertDialog a nuestro propio layout
						builder.setView(layout);
						
						alertDialog = builder.create();
						//Asignamos el evento click a nuestro botón de aceptar (en este caso cierra el alertdialog)
						final TextView title = (TextView) layout.findViewById(R.id.title);
						final TextView tx = (TextView) layout.findViewById(R.id.mo);
						final TextView tx1 = (TextView) layout.findViewById(R.id.pl);
						final TextView tx2 = (TextView) layout.findViewById(R.id.in);
						final TextView tx3 = (TextView) layout.findViewById(R.id.cu);
						final TextView tx4 = (TextView) layout.findViewById(R.id.seg);
						final TextView tx5 = (TextView) layout.findViewById(R.id.cuto);
						title.setText("Linea de "+flag);
			            tx.setText("" + mont);
			            tx1.setText(""+plazo);
			            tx2.setText(""+interes);
			            tx3.setText(df.format(a));
			            tx4.setText(df.format(b));
			            tx5.setText(df.format(c));
						Button aceptarBtn = (Button) layout.findViewById(R.id.btnaceptar);
						aceptarBtn.setOnClickListener(new OnClickListener(){
							@Override	
							public void onClick(View v) {			
								alertDialog.dismiss();	
							}
						});
						//Mostramos el alertdialog	
						alertDialog.show();	
						
						a=0;
						b=0;
						c=0;
						
						}/*else if (mont == 0.0 || mont <500){
							Toast.makeText(Tipo2.this, "INGRESE UN MONTO MAYOR DE $500" , 10000).show();
						}else if (mont >2000){
							Toast.makeText(Tipo2.this, "INGRESE UN MONTO MENOR DE $2000" , 10000).show();
						}*/
				}else if(tipo.equals("em")){
					if (rb8.isChecked() == true) {
						plazo = 1;
					}else if (rb9.isChecked() == true) {
						plazo = 2;
					}else if (rb10.isChecked() == true) {
						plazo = 3;
					} else if (rb11.isChecked() == true) {
						plazo = 4;
					}  
					if(mont > 100){
						double interes = 0.240;
						
						 double a =  ( ( mont/( (1- (Math.pow( (1+(interes/12)), -plazo) ) )/(interes/12) ) )+1.14 );
						 double b = mont * (0.061/100);
						 double c = a+b;
						
						 DecimalFormat df = new DecimalFormat("#.##");
						
						AlertDialog.Builder builder;
						final AlertDialog alertDialog;
						LayoutInflater inflater = (LayoutInflater) Tipo2.this.getSystemService(Tipo2.this.LAYOUT_INFLATER_SERVICE);
						//Nos guardamos una referencia a nuestro layout	
						View layout = inflater.inflate(R.layout.aplica, (ViewGroup) Tipo2.this.findViewById(R.id.layout_root1));
						
			          
						builder = new AlertDialog.Builder(Tipo2.this);	
						//Asignamos la vista del AlertDialog a nuestro propio layout
						builder.setView(layout);
						
						alertDialog = builder.create();
						//Asignamos el evento click a nuestro botón de aceptar (en este caso cierra el alertdialog)
						final TextView title = (TextView) layout.findViewById(R.id.title);
						final TextView tx = (TextView) layout.findViewById(R.id.mo);
						final TextView tx1 = (TextView) layout.findViewById(R.id.pl);
						final TextView tx2 = (TextView) layout.findViewById(R.id.in);
						final TextView tx3 = (TextView) layout.findViewById(R.id.cu);
						final TextView tx4 = (TextView) layout.findViewById(R.id.seg);
						final TextView tx5 = (TextView) layout.findViewById(R.id.cuto);
						title.setText("Linea de "+flag);
			            tx.setText("" + mont);
			            tx1.setText(""+plazo);
			            tx2.setText(""+interes);
			            tx3.setText(df.format(a));
			            tx4.setText("-");
			            tx5.setText(df.format(a));
						Button aceptarBtn = (Button) layout.findViewById(R.id.btnaceptar);
						aceptarBtn.setOnClickListener(new OnClickListener(){
							@Override	
							public void onClick(View v) {			
								alertDialog.dismiss();	
							}
						});
						//Mostramos el alertdialog	
						alertDialog.show();	
						
						a=0;
						b=0;
						c=0;
						
						}/*else if (mont == 0.0 || mont <100){
							Toast.makeText(Tipo2.this, "INGRESE UN MONTO MAYOR DE $100" , 10000).show();
						}
						else if ( mont >500){
							Toast.makeText(Tipo2.this, "INGRESE UN MONTO MENOR DE $500" , 10000).show();
						}*/
				}
			}
		});
		atras1.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), Tipo.class);		
				i.putExtra("flag", flag);
				i.putExtra("tipo", tipo);
				startActivity(i);
				finish();
			}
		});
		atras2.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(), credito.class);				
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
