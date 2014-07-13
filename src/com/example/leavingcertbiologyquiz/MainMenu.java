package com.example.leavingcertbiologyquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity {

	
	private Button startQuiz;

	
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_menu);
		init();
	}
	
	public void init(){
		
		startQuiz = (Button)findViewById(R.id.bbegin);
		
		startQuiz.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				newQuiz();
			
	
		}});
		
	}
	
	public void newQuiz(){
		
		Intent i = new Intent("android.intent.action.QUIZ");
		startActivity(i);
		
	}
	
}
