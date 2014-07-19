package com.example.leavingcertbiologyquiz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends Activity{
	
	private TextView score_display = (TextView)findViewById(R.id.tvscore);
	
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.results);
		showScore();
	}

	public void showScore(){
		
		score_display.setText("XXX");
		
	}
	
}
