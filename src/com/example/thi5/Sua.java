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

public class Sua extends Activity {
	EditText id, name;
	Button btnSua, btnXoa;
	SQLiteDatabase database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sua);
		database = openOrCreateDatabase("QLSV.db", MODE_PRIVATE, null);
		id = (EditText)findViewById(R.id.edt_id2);
		name = (EditText)findViewById(R.id.edt_name2);
		btnSua = (Button)findViewById(R.id.btn_sua);
		btnXoa = (Button)findViewById(R.id.btn_xoa);
		Bundle bundle = getIntent().getExtras();
		String id1 = bundle.getString("idSV");
		String name1 = bundle.getString("name");
		id.setText(id1);
		name.setText(name1);
	}
	public void suaSV(View v){
		if (TextUtils.isEmpty(name.getText().toString())) {
			new AlertDialog.Builder(getBaseContext()).setMessage("Ban khong duoc de trong").setPositiveButton("OK", null);
		}else{
			ContentValues values = new ContentValues();
			values.put("idSV", id.getText().toString());
			values.put("name", name.getText().toString());
			if (database.update("bangdl", values, "idSV=?", new String[]{id.getText().toString()})>0) {
				Toast.makeText(getBaseContext(), "Sua thanh cong", Toast.LENGTH_LONG).show();
				finish();
			}else{
				Toast.makeText(getBaseContext(), "Sua that bai", Toast.LENGTH_LONG).show();
				
			}
		}
	}
	public void xoaSV(View v){
		if (database.delete("bangdl", "idSV=?", new String[]{id.getText().toString()})> 0) {
			Toast.makeText(getBaseContext(), "xoa thanh cong", Toast.LENGTH_LONG).show();
			finish();
		}else{
			Toast.makeText(getBaseContext(), "xoa that bai", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sua, menu);
		return true;
	}

}
