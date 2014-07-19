package com.example.leavingcertbiologyquiz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends Activity{
	
	private TextView score_display;
	private int value = -1;
	private String value2;
	protected void onCreate(Bundle savedInstanceState){
		
		value = 0;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.results);
		score_display = (TextView)findViewById(R.id.tvscore);
		showScore();
		
	}

	public void showScore(){
		value = 0;
		Bundle score = getIntent().getExtras();

		if(score != null){
			
			value = score.getInt("Score");
			
		}
		
		value2 = Integer.toString(value);
		
		score_display.setText(value2);
		
	}
	
}
