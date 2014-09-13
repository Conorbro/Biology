package com.cb.leavingcertbiologyquiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import com.cb.leavingcertbiologyquiz.R;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
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
	public int max, min, value, x, numberQuestions;
	public int questionNum;
	public int score;
	public String returnedAnswer;
	public SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
	public ImageView imageView, faceView;
	public Drawable image, faceImage;
	public int[] questions;
	
	
	public int images[] = {			
		R.drawable.ecology,
		R.drawable.food,
		R.drawable.ic_launcher
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		
		
		setContentView(R.layout.activity_main);
		
		init();
	}
	public void init()
	{

		final int soundId = sp.load(this, R.raw.click, 1);
		questions = new int[16];
		score = 0;
		x = 0;
		questionNum = 0;
		currentQuestion = 0;
		questionButton = (Button)findViewById(R.id.bheart);
		questionView = (TextView)findViewById(R.id.QuestionTextView);
		answerView = (TextView)findViewById(R.id.AnswerDisplay);
		questionNumberView = (TextView)findViewById(R.id.QuestionNumberView);
		imageView = (ImageView)findViewById(R.id.ivface2);
		faceView = (ImageView)findViewById(R.id.ivface);
		image = getResources().getDrawable(images[1]);		//Setting the image view
		imageView.setImageDrawable(image);

		Intent mIntent = getIntent();
		max = mIntent.getIntExtra("max", 0);
		min = mIntent.getIntExtra("min", 0);
		numberQuestions = mIntent.getIntExtra("numberQuestions", 0);

		answerView.setText(" ");

		faceImage = getResources().getDrawable(R.drawable.face2);
		faceView.setImageDrawable(faceImage);
		
		questionButton.setOnClickListener(new OnClickListener(){ //Generate next question to answer
			
			public void onClick(View v) {
				 	sp.play(soundId, 1, 1, 0, 0, 1);
					showQuestion();	
					showQuestionNumber();
				
					questionNum++;
			
			}});
		
		questionView();	
		showQuestionNumber();	

		}
	
	public void showQuestionNumber()		//Displays current question number 
	{
		questionNumberView.setText("Question " + String.valueOf(currentQuestion) + "/" + numberQuestions);
		
		if(currentQuestion==numberQuestions){
			
			questionButton.setText("Finish");
			
		}
		
	}
	
	public void showQuestion() //Checks answer of previously answered question
	{
			
	
	RadioGroup group=(RadioGroup)findViewById(R.id.radioGroup1);
	answer=(RadioButton)findViewById(group.getCheckedRadioButtonId());
	
		if(answer.getText().toString()==returnedAnswer){	//Check if given answer is correct 
			
			score++;
			answerView.setText("The last question was answered Correctly"); //returns feedback of correctly answered question
			faceImage = getResources().getDrawable(R.drawable.face1);		//Setting the image view
			faceView.setImageDrawable(faceImage);		}
		
		else{	//returns feedback on wrongly answered question
			
			answerView.setText("The last question was answered incorrectly " + "\n" + "Correct answer was: " +  returnedAnswer);
			faceImage = getResources().getDrawable(R.drawable.face3);
			faceView.setImageDrawable(faceImage);
		}
	

	if(group.getCheckedRadioButtonId() == -1){		//Returns an error if no radio button selected and answer is submitted
		
		Toast.makeText(getApplicationContext(), "You didn't select an answer ya bleedin muppawn!",
		Toast.LENGTH_LONG).show();
	}
	
	
	else if(questionNum==(numberQuestions-1)){
		
		getResults();
		
	}
	
	else{ //Loads up next question
		questionView();
		}
	}
	
	
	public void questionView(){ //Loads up next question
		
		
		List<Button> buttons = new ArrayList<Button>();
		
		buttons.add((Button)findViewById(R.id.radioButton1));
	    buttons.add((Button)findViewById(R.id.radioButton2));
	    buttons.add((Button)findViewById(R.id.radioButton3));
	    buttons.add((Button)findViewById(R.id.radioButton4));
		
	    currentQuestion++;
	    
	    //Generate random value of x
	    x = rand(max, min);
		boolean duplicate = false, added = false;
	    int j = 0;
		
	    for(j=0; j<currentQuestion; j++){
	    	
	    	if(questions[j]==x){ //If duplicate found, generate new x, leave for loop, start over
	    		duplicate = true;
	    		x = rand(max, min);
	    		j=-1;
	    	}
	    	
	    }
		
	    	
	    	added = addToArray(x,currentQuestion-1);
	    	


		
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

		if(x>50){
			
			image = getResources().getDrawable(images[2]);		//Setting the image view
			imageView.setImageDrawable(image);
			
		}
		
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

	public int rand(int max, int min){
		
		Random rand = new Random();
		
		int a = rand.nextInt(max - min) + min;;
				
		return a;
	}
	
	public void getResults(){
		
		questionNum = 0;
		Intent i = new Intent(getApplicationContext(), Results.class);
		i.putExtra("Score", score);
		i.putExtra("total", numberQuestions);
		Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
		startActivity(i, bndlanimation);
//		startActivity(i);
		finish();
		
	}
	
	public boolean addToArray(int x, int space){
		
		questions[space] = x;
		return true;
	}
	
}
