package com.example.leavingcertbiologyquiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int currentQuestion; //Keeps track of question in index

	
	private Button questionButton; //Next Question Button
	private TextView questionView; //Show Question Text
	private TextView answerView; //Show Answer Text
	private TextView questionNumberView; //Displays Question number
	
	private Button test;
	private Button test2;
	
	public String returnedAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	public void init()
	{
			
		currentQuestion = 0;
		questionButton = (Button)findViewById(R.id.button1);
		questionView = (TextView)findViewById(R.id.QuestionTextView);
		answerView = (TextView)findViewById(R.id.AnswerDisplay);
		questionNumberView = (TextView)findViewById(R.id.QuestionNumberView);

		test = (Button)findViewById(R.id.button2);
		test2 = (Button)findViewById(R.id.button3);
		
		
		showQuestion();	
		showQuestionNumber();
		
		questionButton.setOnClickListener(new OnClickListener(){ //Generate next question to answer
			
				public void onClick(View v) {
					showQuestion();	
					showQuestionNumber();
				}});
		
		test.setOnClickListener(new OnClickListener(){ //Debugging
			
			
			public void onClick(View v){
				Intent i = new Intent("android.intent.action.SQLVIEW");
				startActivity(i);
				
			
			}});
		
		
		test2.setOnClickListener(new OnClickListener(){ //Debugging
			
			public void onClick(View v){
				Intent j = new Intent("android.intent.action.SQLITE");
				startActivity(j);
			
		}});
			
		}
	
	
	

	public void showQuestionNumber()
	{
		questionNumberView.setText("Question " +String.valueOf(currentQuestion));
	}
	
	public void showQuestion()
	{
		
		
	
		
		List<Button> buttons = new ArrayList<Button>();
		
		buttons.add((Button)findViewById(R.id.radioButton1));
	    buttons.add((Button)findViewById(R.id.radioButton2));
	    buttons.add((Button)findViewById(R.id.radioButton3));
	    buttons.add((Button)findViewById(R.id.radioButton4));
		
		Random rand = new Random();
		int x = rand.nextInt(3) + 1;
		currentQuestion++;
		Database Dbb = new Database(this);
		Dbb.open();
		String returnedQuestion = Dbb.getQuestion(x);
		returnedAnswer = Dbb.getAnswer(x);
		String answer1 = Dbb.getAnswer1(x);
		String answer2 = Dbb.getAnswer2(x);
		String answer3 = Dbb.getAnswer3(x);

		List<String> objects = new ArrayList<String>();
		objects.add(returnedAnswer);
		objects.add(answer1);
		objects.add(answer2);
		objects.add(answer3);
		
		Collections.shuffle(objects);
		
		Dbb.close();
		
		questionView.setText(returnedQuestion);
		answerView.setText("");
	
		
		checkAnswer();
		
		for (int i = 0; i < objects.size(); i++) {
		     buttons.get(i).setText(objects.get(i).toString());
		   }
		
	}
	
	public boolean isCorrect(String answer)
	{
		return(answer.equalsIgnoreCase(returnedAnswer));
	}
	
	
	public void checkAnswer()
	{
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
}
