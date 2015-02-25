package com.cb.leavingcertbiologyquiz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SQLView extends Activity {

	
	protected void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);
		TextView tv = (TextView) findViewById(R.id.tvSQLinfo);
		Database info = new Database(this);
		info.open();
		String data = info.getData();
		info.close();
		tv.setText(data);
	}
}
