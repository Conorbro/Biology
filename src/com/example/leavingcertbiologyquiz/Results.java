package com.example.leavingcertbiologyquiz;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Results extends Activity{
	
	private TextView score_display;
	private int value = -1;
	private int percentage;
	private int total;
	private String value2;
	private ImageView faceView;
	private Drawable face;
	private Button new_quiz;
	public SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

	private int images[] = {			
			R.drawable.face_shocked,
			R.drawable.face_sad,
			R.drawable.face_neutral,
			R.drawable.face_wink,
			R.drawable.face_love		
	};
	
	protected void onCreate(Bundle savedInstanceState){
		
		
		
		
//		total = 5;
		value = 0;
		new_quiz = (Button)findViewById(R.id.bnewquiz2);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.results);
		score_display = (TextView)findViewById(R.id.tvscore);
		faceView = (ImageView)findViewById(R.id.ivface2);		
		
		Intent nIntent = getIntent();
		total = nIntent.getIntExtra("total", 1);

		showScore();
		//	init();
	}
	
	
	public void init(){
		
		final int soundId = sp.load(this, R.raw.click, 1); 

		new_quiz.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sp.play(soundId, 1, 1, 0, 0, 1);
			//	openSections();
				
			}});
		

	}

	public void showScore(){
		value = 0;
		Bundle score = getIntent().getExtras();

		if(score != null){
			
			value = score.getInt("Score");
			
		}
		
		value2 = Integer.toString(value);
		
		percentage = ((((value)*(100)/total)));
		System.out.println("Percentage = " + percentage);
		System.out.println("Value = " + value);
		System.out.println("Total = " + total);
		
		if(value<5){
		score_display.setText(value2 + "/" + total);
		}
		
		else{
		score_display.setText(value2 + "/" + total + "Perfect!");	
		}
		
		if(percentage<20){
			face = getResources().getDrawable(images[0]);
		}
		
		else if(percentage<40){
			face = getResources().getDrawable(images[1]);
		}
		
		else if(percentage<60){
			face = getResources().getDrawable(images[2]);
		}
		
		else if(percentage<80){
			face = getResources().getDrawable(images[3]);
		}
		
		else if(percentage<100 || percentage==100){
			face = getResources().getDrawable(images[4]);
		}
		
		faceView.setImageDrawable(face);
		
		
	}
	
//	public void openSections(){
//		
//		Intent i = new Intent("android.intent.action.SECTIONS");
//		Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
//		startActivity(i, bndlanimation);
//	}
	
	
}
