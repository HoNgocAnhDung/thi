package com.example.thi5;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
	SQLiteDatabase database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		taoData();
		taoBang();
		TabHost tabHost = getTabHost();
		
		TabSpec tabSpec1 = getTabHost().newTabSpec("Tab1");
		tabSpec1.setIndicator("Tab1");
		Intent intent1 = new Intent(getBaseContext(),Tab1.class);
		tabSpec1.setContent(intent1);
		
		TabSpec tabSpec2 = getTabHost().newTabSpec("Tab2");
		tabSpec2.setIndicator("Tab2");
		Intent intent2 = new Intent(getBaseContext(), Tab2.class);
		tabSpec2.setContent(intent2);
		tabHost.addTab(tabSpec1);
		tabHost.addTab(tabSpec2);
	}

	public void taoData(){
		database = openOrCreateDatabase("QLSV.db", MODE_PRIVATE, null);
	}
	public void taoBang(){
		String bang = "create table if not exists bangdl(idSV text primary key, name text)";
		database.execSQL(bang);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
