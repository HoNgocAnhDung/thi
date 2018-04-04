package com.example.thi5;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tab2 extends Activity {
	EditText id, name;
	Button btnThem;
	SQLiteDatabase database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab2);
		database = openOrCreateDatabase("QLSV.db", MODE_PRIVATE, null);
		id = (EditText)findViewById(R.id.edt_id);
		name = (EditText)findViewById(R.id.edt_name);
	}
	public void themSV(View v){
		if (TextUtils.isEmpty(id.getText().toString())||TextUtils.isEmpty(name.getText().toString())) {
			new AlertDialog.Builder(getBaseContext()).setMessage("Ban ko duoc de trong").setPositiveButton("Ok", null).show();
		}else{
			ContentValues values = new ContentValues();
			values.put("idSV", id.getText().toString());
			values.put("name", name.getText().toString());
			if (database.insert("bangdl", null, values) != -1) {
				Toast.makeText(getBaseContext(), "Them thanh cong", Toast.LENGTH_LONG).show();
			}else{
				Toast.makeText(getBaseContext(), "Them that bai", Toast.LENGTH_LONG).show();
			}
		}
		id.setText("");
		name.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab2, menu);
		return true;
	}

}
