package com.example.leavingcertbiologyquiz;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
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
	private Button dna;
	public SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sections);
		init();
		
	}
	
	public void init(){
		final int soundId = sp.load(this, R.raw.click, 1); 
		food = (Button)findViewById(R.id.bfood);
		enzymes = (Button)findViewById(R.id.benzymes);
		ecology = (Button)findViewById(R.id.becology);
		cell = (Button)findViewById(R.id.bcell);
		cell_continuity = (Button)findViewById(R.id.bcellcontinuity);
		dna = (Button)findViewById(R.id.bdna);
		
		food.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sp.play(soundId, 1, 1, 0, 0, 1);
				startQuiz(30, 0);
			}});
				
		ecology.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sp.play(soundId, 1, 1, 0, 0, 1);
				startQuiz(78, 30);
			}});
		

		cell.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sp.play(soundId, 1, 1, 0, 0, 1);
				startQuiz(95, 79);
			}});
			
		cell_continuity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sp.play(soundId, 1, 1, 0, 0, 1);
				startQuiz(117,95);
			}});
		
		enzymes.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sp.play(soundId, 1, 1, 0, 0, 1);
				startQuiz(123, 117);
			
			}});
		
		dna.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sp.play(soundId, 1, 1, 0, 0, 1);
				startQuiz(137, 123);
			
			}});
		
	}
	
	public void startQuiz(int max, int min){
		
		Intent i = new Intent(Sections.this, MainActivity.class);
		i.putExtra("max", max);
		i.putExtra("min", min);
		Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
		startActivity(i, bndlanimation);
		
		
	}
	
	public void OnBackPressed() {	
		super.onBackPressed();
		overridePendingTransition(R.anim.animation, R.anim.animation2);
	}
	
	
}
