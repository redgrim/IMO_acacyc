package com.example.acacyc;

import java.text.DecimalFormat;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
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
	Button aplicar;
	EditText monto;
	RadioGroup rg1;
	RadioButton rb1,rb2,rb3,rb4,rb5,rb6;
	double mont = 0;
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
		
		
		rb1 = (RadioButton) findViewById(R.id.rb12);
		rb2 = (RadioButton) findViewById(R.id.rb24);
		rb3 = (RadioButton) findViewById(R.id.rb36);
		rb4 = (RadioButton) findViewById(R.id.rb48);
		rb5 = (RadioButton) findViewById(R.id.rb60);
		rb6 = (RadioButton) findViewById(R.id.rb72);
		rg1 = (RadioGroup) findViewById(R.id.radiogroup);
		credito = (TextView)findViewById(R.id.credito);		
		credito.setText(flag);
		
		monto = (EditText) findViewById(R.id.monto);		
           
		aplicar = (Button)findViewById(R.id.btnaplicar);
		aplicar.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View view) {
				// Launching News Feed Screen
				
				try {
					mont = Double.parseDouble(monto.getText().toString());
				}catch(NumberFormatException nfe){
					
				}
				
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
				} 
				
				if(tipo.equals("pe")){
					
					if(mont >= 1000){
					double interes = 0.139;
					
					 double a =  ( ( mont/( (1- (Math.pow( (1+(interes/12)), -plazo) ) )/(interes/12) ) )+1.14 );
					 double b = mont * (0.061/100);
					 double c = a+b;
					
					 DecimalFormat df = new DecimalFormat("#.##");
					Toast.makeText(Tipo.this, "CUOTA = $"+ df.format(a) , 10000).show();
					Toast.makeText(Tipo.this, "SEG DEUDA = $"+ df.format(b) , 10000).show();
					Toast.makeText(Tipo.this, "CUOTA TOTAL = $"+ df.format(c) , 10000).show();
					
					AlertDialog.Builder builder;
					final AlertDialog alertDialog;
					LayoutInflater inflater = (LayoutInflater) Tipo.this.getSystemService(Tipo.this.LAYOUT_INFLATER_SERVICE);
					//Nos guardamos una referencia a nuestro layout	
					View layout = inflater.inflate(R.layout.aplica, (ViewGroup) Tipo.this.findViewById(R.id.layout_root1));
					
		          
					builder = new AlertDialog.Builder(Tipo.this);	
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
					
					}else if (mont == 0.0 || mont <1000){
						Toast.makeText(Tipo.this, "INGRESE UN MONTO MAYOR DE $1000" , 10000).show();
					}
					
				}else if(tipo.equals("ge")){
					if(mont >= 1000){
						double interes = 0.100;
						
						 double a =  ( ( mont/( (1- (Math.pow( (1+(interes/12)), -plazo) ) )/(interes/12) ) )+1.14 );
						 double b = mont * (0.061/100);
						 double c = a+b;
						
						 DecimalFormat df = new DecimalFormat("#.##");
						Toast.makeText(Tipo.this, "CUOTA = $"+ df.format(a) , 10000).show();
						Toast.makeText(Tipo.this, "SEG DEUDA = $"+ df.format(b) , 10000).show();
						Toast.makeText(Tipo.this, "CUOTA TOTAL = $"+ df.format(c) , 10000).show();
						
						AlertDialog.Builder builder;
						final AlertDialog alertDialog;
						LayoutInflater inflater = (LayoutInflater) Tipo.this.getSystemService(Tipo.this.LAYOUT_INFLATER_SERVICE);
						//Nos guardamos una referencia a nuestro layout	
						View layout = inflater.inflate(R.layout.aplica, (ViewGroup) Tipo.this.findViewById(R.id.layout_root1));
						
			          
						builder = new AlertDialog.Builder(Tipo.this);	
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
						
						}else if (mont == 0.0 || mont <1000){
							Toast.makeText(Tipo.this, "INGRESE UN MONTO MAYOR DE $1000" , 10000).show();
						}
				}else if(tipo.equals("de")){
					if(mont >= 1000){
						double interes = 0.240;
						
						 double a =  Math.ceil(( ( mont/( (1- (Math.pow( (1+(interes/12)), -plazo) ) )/(interes/12) ) )+1.14 ));
						 double b = 3.00;
						 double c = a+b;
						
						 DecimalFormat df = new DecimalFormat("#.##");
						Toast.makeText(Tipo.this, "CUOTA = $"+ df.format(a) , 10000).show();
						Toast.makeText(Tipo.this, "SEG DEUDA = $"+ df.format(b) , 10000).show();
						Toast.makeText(Tipo.this, "CUOTA TOTAL = $"+ df.format(c) , 10000).show();
						
						AlertDialog.Builder builder;
						final AlertDialog alertDialog;
						LayoutInflater inflater = (LayoutInflater) Tipo.this.getSystemService(Tipo.this.LAYOUT_INFLATER_SERVICE);
						//Nos guardamos una referencia a nuestro layout	
						View layout = inflater.inflate(R.layout.aplica, (ViewGroup) Tipo.this.findViewById(R.id.layout_root1));
						
			          
						builder = new AlertDialog.Builder(Tipo.this);	
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
						
						}else if (mont == 0.0 || mont <1000){
							Toast.makeText(Tipo.this, "INGRESE UN MONTO MAYOR DE $1000" , 10000).show();
						}
				}else if(tipo.equals("em")){
					if(mont >= 500){
						double interes = 0.240;
						
						 double a =  ( ( mont/( (1- (Math.pow( (1+(interes/12)), -plazo) ) )/(interes/12) ) )+1.14 );
						 double b = mont * (0.061/100);
						 double c = a+b;
						
						 DecimalFormat df = new DecimalFormat("#.##");
						Toast.makeText(Tipo.this, "CUOTA = $"+ df.format(a) , 10000).show();
						
						
						AlertDialog.Builder builder;
						final AlertDialog alertDialog;
						LayoutInflater inflater = (LayoutInflater) Tipo.this.getSystemService(Tipo.this.LAYOUT_INFLATER_SERVICE);
						//Nos guardamos una referencia a nuestro layout	
						View layout = inflater.inflate(R.layout.aplica, (ViewGroup) Tipo.this.findViewById(R.id.layout_root1));
						
			          
						builder = new AlertDialog.Builder(Tipo.this);	
						//Asignamos la vista del AlertDialog a nuestro propio layout
						builder.setView(layout);
						
						alertDialog = builder.create();
						//Asignamos el evento click a nuestro botón de aceptar (en este caso cierra el alertdialog)
						final TextView title = (TextView) layout.findViewById(R.id.title);
						final TextView tx = (TextView) layout.findViewById(R.id.mo);
						final TextView tx1 = (TextView) layout.findViewById(R.id.pl);
						final TextView tx2 = (TextView) layout.findViewById(R.id.in);
						final TextView tx3 = (TextView) layout.findViewById(R.id.cu);
						//final TextView tx4 = (TextView) layout.findViewById(R.id.seg);
					//	final TextView tx5 = (TextView) layout.findViewById(R.id.cuto);
						title.setText("Linea de "+flag);
			            tx.setText("" + mont);
			            tx1.setText(""+plazo);
			            tx2.setText(""+interes);
			            tx3.setText(df.format(a));
			           // tx4.setText(df.format(b));
			           // tx5.setText(df.format(c));
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
						
						}else if (mont == 0.0 || mont <500){
							Toast.makeText(Tipo.this, "INGRESE UN MONTO MAYOR DE $1000" , 10000).show();
						}
				}
				
				
				
				/*AlertDialog.Builder builder;
				final AlertDialog alertDialog;
				LayoutInflater inflater = (LayoutInflater) Tipo.this.getSystemService(Tipo.this.LAYOUT_INFLATER_SERVICE);
				//Nos guardamos una referencia a nuestro layout	
				View layout = inflater.inflate(R.layout.aplica, (ViewGroup) Tipo.this.findViewById(R.id.layout_root));	
				builder = new AlertDialog.Builder(Tipo.this);	
				//Asignamos la vista del AlertDialog a nuestro propio layout
				builder.setView(layout);	
				alertDialog = builder.create();
				//Asignamos el evento click a nuestro botón de aceptar (en este caso cierra el alertdialog)
				Button aceptarBtn = (Button) layout.findViewById(R.id.btnaceptar);
				aceptarBtn.setOnClickListener(new OnClickListener(){
					@Override	
					public void onClick(View v) {	
						alertDialog.dismiss();	
					}
				});
				//Mostramos el alertdialog	
				alertDialog.show();		*/
			}
		});
		
	}
	public double personal(double mont2 , int plazo){
		double mon = mont2;
		int pla = plazo;
		double interes = 0.139;
		double resultado;
	resultado = (mon/((1-(1+Math.pow((interes/12), pla)))/(interes/12)))+1.14;
	
	return resultado;
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
}
