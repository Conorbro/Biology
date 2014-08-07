package com.example.leavingcertbiologyquiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private int currentQuestion; //Keeps track of question in index

	
	private Button questionButton; //Next Question Button
	private TextView questionView; //Show Question Text
	private TextView answerView; //Show Answer Text
	private TextView questionNumberView; //Displays Question number
	private RadioButton answer;	
	public int max, min, value;
	public int questionNum;
	public int score;
	public String returnedAnswer;
	SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		
		
		setContentView(R.layout.activity_main);
		
		init();
	}
	public void init()
	{

		final int soundId = sp.load(this, R.raw.click, 1);
		score = 0;
		questionNum = 0;
		currentQuestion = 0;
		questionButton = (Button)findViewById(R.id.button1);
		questionView = (TextView)findViewById(R.id.QuestionTextView);
		answerView = (TextView)findViewById(R.id.AnswerDisplay);
		questionNumberView = (TextView)findViewById(R.id.QuestionNumberView);
		
		
		Intent mIntent = getIntent();
		max = mIntent.getIntExtra("max", 0);
		min = mIntent.getIntExtra("min", 0);

		
		questionButton.setOnClickListener(new OnClickListener(){ //Generate next question to answer
			
			public void onClick(View v) {
				 	sp.play(soundId, 1, 1, 0, 0, 1);
					showQuestion();	
					showQuestionNumber();
				}});
		
		
		questionView();	
		showQuestionNumber();
		
		}
	
	public void showQuestionNumber()
	{
		questionNumberView.setText("Question " + String.valueOf(currentQuestion));
	}
	
	public void showQuestion() //Checks answer of previously answered question
	{
			
	
	RadioGroup group=(RadioGroup)findViewById(R.id.radioGroup1);
	answer=(RadioButton)findViewById(group.getCheckedRadioButtonId());

		
		if(questionNum==0){
			
			answerView.setText(" ");
			
		}
	
		if(answer.getText().toString()==returnedAnswer){
			
			score++;
			answerView.setText("The last question was answered Correctly :)");
			
		}
		
		else{
			
			answerView.setText("The last question was answered incorrectly :(" + "\n" + "Correct answer was: " +  returnedAnswer);
			
		}
	

	if(group.getCheckedRadioButtonId() == -1){
		
		Toast.makeText(getApplicationContext(), "You didn't select an answer ya bleedin muppawn!",
		Toast.LENGTH_LONG).show();
	}
	
	else{
		questionView();
		}
	}
	
	
	public void questionView(){ //Loads up next question
		
		questionNum++;
		
		if(questionNum>5){		//When questions answered, show results
						
			questionNum = 0;
			Intent i = new Intent(getApplicationContext(), Results.class);
			i.putExtra("Score", score);
			startActivity(i);
			finish();
		}
		
		List<Button> buttons = new ArrayList<Button>();
		
		buttons.add((Button)findViewById(R.id.radioButton1));
	    buttons.add((Button)findViewById(R.id.radioButton2));
	    buttons.add((Button)findViewById(R.id.radioButton3));
	    buttons.add((Button)findViewById(R.id.radioButton4));
		
		Random rand = new Random();
		
		int x = 0;
		
	if(max!=0){
		 x = rand.nextInt(max - min) + min;
	}
	
	else {	 x = rand.nextInt(120) + 1;
	
	}
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
		
        RadioButton rbu1 =(RadioButton)findViewById(R.id.radioButton4);
        rbu1.setChecked(true);
		
		questionView.setText(returnedQuestion);


		for (int i = 0; i < objects.size(); i++) {
		     buttons.get(i).setText(objects.get(i).toString());
		   }
		
		Dbb.close();

	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	protected void onResume()
	{
	   super.onResume();

	   
	}

	
}
