package com.example.leavingcertbiologyquiz;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity {

	
	private Button startQuiz;
	private Button database;
	private Button sectionQuiz;
	
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_menu);
		init();
	}
	
	public void init(){
		
		startQuiz = (Button)findViewById(R.id.bbegin);
		database = (Button)findViewById(R.id.bdatabase);
		sectionQuiz = (Button)findViewById(R.id.bsection);

		
		
		startQuiz.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				newQuiz();
			
	
		}});
		
		
		database.setOnClickListener(new OnClickListener(){
			
			
			public void onClick(View v){
			
				openDatabase();
				
		}});
		
		
		sectionQuiz.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
			
				openSections();
							
			
		}});
		
	}
	
	public void newQuiz(){
		
		Intent i = new Intent("android.intent.action.QUIZ");
		Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
		startActivity(i, bndlanimation);		
	}
	
	public void openDatabase(){
		
		Intent i = new Intent("android.intent.action.SQLITE");
		Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
		startActivity(i, bndlanimation);	
	}
	
	public void openSections(){
		
		Intent i = new Intent("android.intent.action.SECTIONS");
		Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
		startActivity(i, bndlanimation);
	}
	
}
