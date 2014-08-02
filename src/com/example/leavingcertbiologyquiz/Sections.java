package com.example.leavingcertbiologyquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Sections extends Activity {

	private Button ecology;
	private Button food;
	private Button cell;
	private Button cell_continuity;
	private Button enzymes;
	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sections);
		init();
		
	}
	
	public void init(){
		
		food = (Button)findViewById(R.id.bfood);
		enzymes = (Button)findViewById(R.id.benzymes);
		ecology = (Button)findViewById(R.id.becology);
		cell = (Button)findViewById(R.id.bcell);
		cell_continuity = (Button)findViewById(R.id.bcellcontinuity);

		
		food.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startQuiz(30, 0);
			}});
		
		
		
		ecology.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startQuiz(78, 30);
			}});
		
	
			
		
		cell.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startQuiz(95, 79);
			}});
		
		
		cell_continuity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				startQuiz(117,95);
			}});
		
		
		enzymes.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				startQuiz(123, 117);
			
			}});
		
		
		
	}
	
	public void startQuiz(int max, int min){
		
		Intent i = new Intent(Sections.this, MainActivity.class);
		i.putExtra("max", max);
		i.putExtra("min", min);
		startActivity(i);
		
		
	}
	
	
}
