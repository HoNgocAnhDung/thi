package com.example.thi5;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Tab1 extends Activity {
	
	SQLiteDatabase database;
	ListView listSV;
	ArrayAdapter<data> adapter;
	ArrayList<data> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab1);
		database = openOrCreateDatabase("QLSV.db", MODE_PRIVATE, null);
		listSV = (ListView)findViewById(R.id.list_sv);
		list = new ArrayList<data>();
		adapter = new ArrayAdapter<data>(getBaseContext(), android.R.layout.simple_list_item_1, list);
		listSV.setAdapter(adapter);
		readData();
		
		listSV.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(), Sua.class);
				intent.putExtra("idSV", list.get(arg2).getId().toString());
				intent.putExtra("name", list.get(arg2).getName().toString());
				startActivity(intent);
			}
		});
	}

	protected void onResume() {
		readData();
		listSV.setAdapter(adapter);
		super.onResume();
	}
	public void readData(){
		list.clear();
		Cursor c = database.query("bangdl", null, null, null, null, null, null);
		c.moveToFirst();
		while (c.isAfterLast()== false) {
			data da = new data();
			da.setId(c.getString(0));
			da.setName(c.getString(1));
			list.add(da);
			c.moveToNext();
		}c.close();
		adapter.notifyDataSetChanged();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab1, menu);
		return true;
	}

}
