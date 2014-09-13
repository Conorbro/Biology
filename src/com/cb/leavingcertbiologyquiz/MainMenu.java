package com.cb.leavingcertbiologyquiz;

import com.cb.leavingcertbiologyquiz.R;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity {

	
	private Button sectionQuiz;

	SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

	
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main_menu);
		init();
	}
	
	public void init(){
		final int soundId = sp.load(this, R.raw.click, 1); 
		sectionQuiz = (Button)findViewById(R.id.bsection);


		
		sectionQuiz.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				sp.play(soundId, 1, 1, 0, 0, 1);
				openSections();
							
			
		}});
		
	}
	

	
	public void openSections(){
		
		Intent i = new Intent("android.intent.action.SECTIONS");
		Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
		startActivity(i, bndlanimation);
//		startActivity(i);
	}
	

}
