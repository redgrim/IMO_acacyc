package com.example.acacyc;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class saldo extends SherlockActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.saldo);
		setTitle("Saldo");
		
		listIN();
		
	}
	
	public void listIN(){		 
		
		ListView listView = (ListView) findViewById(R.id.list);
		listView.setAdapter(new ItemAdapterIN());	
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				startImageGalleryActivityIN(position);
			}
		});
	//	listView.setOnScrollListener(new PauseOnScrollListener(false, true));
	}
	
	private void startImageGalleryActivityIN(int position) {
		AlertDialog.Builder builder;
		final AlertDialog alertDialog;
		LayoutInflater inflater = (LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE);
		//Nos guardamos una referencia a nuestro layout	
		View layout = inflater.inflate(R.layout.detalles, (ViewGroup) this.findViewById(R.id.layout_root));	
		builder = new AlertDialog.Builder(this);	
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
		alertDialog.show();		
	}
	
	class ItemAdapterIN extends BaseAdapter {
		private class ViewHolder {
			public TextView  textT;
			public TextView	 textF;
			public ImageView image1;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 5;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = convertView;
			ViewHolder holder;
			if (convertView == null) {
				view = getLayoutInflater().inflate(R.layout.list_row, null);
				holder = new ViewHolder();
				holder.textT	 = (TextView)  view.findViewById(R.id.title);
				holder = new ViewHolder();
				view.setTag(holder);
				return view;
			}else{
				holder = (ViewHolder) view.getTag();
			}
			return convertView;
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
}
