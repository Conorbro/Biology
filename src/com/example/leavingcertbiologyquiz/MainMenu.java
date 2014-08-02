package com.example.leavingcertbiologyquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity {

	
	private Button startQuiz;
	private Button database;
	private Button sectionQuiz;
	public int x;
	
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_menu);
		init();
	}
	
	public void init(){
		
		x=0;
		startQuiz = (Button)findViewById(R.id.bbegin);
		
		startQuiz.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				newQuiz();
			
	
		}});
		
		database = (Button)findViewById(R.id.bdatabase);
		
		database.setOnClickListener(new OnClickListener(){
			
			
			public void onClick(View v){
			
				openDatabase();
				
		}});
		
		sectionQuiz = (Button)findViewById(R.id.bsection);
		
		sectionQuiz.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				x=1;
				Intent i = new Intent("android.intent.action.SECTIONS");
				startActivity(i);
							
			
		}});
		
	}
	
	public void newQuiz(){
		
		Intent i = new Intent("android.intent.action.QUIZ");
		startActivity(i);
		
	}
	
	public void openDatabase(){
		
		Intent i = new Intent("android.intent.action.SQLITE");
		startActivity(i);
	
	}
	
}
