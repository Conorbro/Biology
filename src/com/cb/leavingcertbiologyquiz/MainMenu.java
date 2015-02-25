package com.cb.leavingcertbiologyquiz;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ContextWrapper;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.File;

public class MainMenu extends Activity {

    private Button sectionQuiz;
    private Button createQuestions;
    SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_menu);

        if(doesDatabaseExist(this, Database.DATABASE_NAME)==false){
            Database Db = new Database(this);
            Db.open();
            Db.addQuestions();
            Db.close();
        }

        init();
    }

    public void init(){
        final int soundId = sp.load(this, R.raw.click, 1);
        sectionQuiz = (Button)findViewById(R.id.bsection);
        createQuestions = (Button)findViewById(R.id.baddquestions);

        sectionQuiz.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                sp.play(soundId, 1, 1, 0, 0, 1);
                openSections();
            }});

        createQuestions.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.play(soundId, 1, 1, 0, 0, 1);
                openCreateQuestions();
            }
        });
    }

    public void openSections() {

        Intent i = new Intent("android.intent.action.SECTIONS");
		Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
		startActivity(i, bndlanimation);
    }

    public void openCreateQuestions() {
        Intent i = new Intent("android.intent.action.SQLITE");
        Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
        startActivity(i, bndlanimation);
    }

    private static boolean doesDatabaseExist(ContextWrapper context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }
}
