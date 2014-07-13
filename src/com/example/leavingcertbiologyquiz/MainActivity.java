package com.example.leavingcertbiologyquiz;

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

	
//	private Button answerButton; //Check Answer Button
	private Button questionButton; //Next Question Button
	private TextView questionView; //Show Question Text
	private TextView answerView; //Show Answer Text
//	private EditText answerText; //Where user enters text for answer
	private TextView questionNumberView; //Displays Question number
	
	private RadioButton a, b ,c, d ;
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
	//	answerButton = (Button)findViewById(R.id.AnswerButton);
		questionButton = (Button)findViewById(R.id.button1);
		questionView = (TextView)findViewById(R.id.QuestionTextView);
		answerView = (TextView)findViewById(R.id.AnswerDisplay);
	//	answerText = (EditText) findViewById(R.id.AnswerTextView);
		questionNumberView = (TextView)findViewById(R.id.QuestionNumberView);
		
		a = (RadioButton)findViewById(R.id.radioButton1);
		b = (RadioButton)findViewById(R.id.radioButton2);
		c = (RadioButton)findViewById(R.id.radioButton3);
		d = (RadioButton)findViewById(R.id.radioButton4);

		test = (Button)findViewById(R.id.button2);
		test2 = (Button)findViewById(R.id.button3);
		
//		answerButton.setOnClickListener(new OnClickListener(){ //Check if answer is correct
//			
//				public void onClick(View v){
//						checkAnswer();
//				}});
		
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

		Dbb.close();
//		if(currentQuestion == questions.length)
//				currentQuestion = 0;
		
		questionView.setText(returnedQuestion);
		answerView.setText("");
		a.setText(returnedAnswer);
		b.setText(answer1);
		c.setText(answer2);
		d.setText(answer3);

//		answerText.setText("");		
		
		checkAnswer();
		
	}
	
	public boolean isCorrect(String answer)
	{
		return(answer.equalsIgnoreCase(returnedAnswer));
	}
	
	
	public void checkAnswer()
	{
		
//		String answer =answerText.getText().toString();
//		if(isCorrect(answer))
//			answerView.setText("You're Right!");
//		else
//			answerView.setText("You're Wrong! Answer is: " + returnedAnswer);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
}
