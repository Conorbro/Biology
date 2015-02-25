package com.cb.leavingcertbiologyquiz;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLite extends Activity implements OnClickListener{

	Button sqlUpdate, sqlView, sqlModify, sqlGetInfo, sqlDelete, newQuiz;
	EditText sqlQuestion, sqlAnswer1, sqlAnswer2, sqlAnswer3, sqlAnswer4, sqlRow;
    TextView et1, et2, et3, et4, qt;
//    SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
//    final int soundId = sp.load(this, R.raw.click, 1);


    protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite);

		sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlQuestion = (EditText) findViewById(R.id.etAddQuestion);
		sqlAnswer1 = (EditText) findViewById(R.id.etAddAnswer);
        sqlAnswer2 = (EditText) findViewById(R.id.etAddFAnswer1);
        sqlAnswer3 = (EditText) findViewById(R.id.etAddFAnswer2);
        sqlAnswer4 = (EditText) findViewById(R.id.etAddFAnswer3);
        newQuiz = (Button) findViewById(R.id.bNewQuiz);
        et1 = (TextView)findViewById(R.id.etAddAnswer);
        et2 = (TextView)findViewById(R.id.etAddFAnswer1);
        et3 = (TextView)findViewById(R.id.etAddFAnswer2);
        et4 = (TextView)findViewById(R.id.etAddFAnswer3);
        qt = (TextView)findViewById(R.id.etAddQuestion);

//      sqlRow = (EditText) findViewById(R.id.etIndex);
//		sqlGetInfo = (Button) findViewById(R.id.bgetInfo);
//		sqlDelete = (Button) findViewById(R.id.bSQLdelete);
//		//sqlModify = (Button) findViewById(R.id.bSQLmodify);
//		sqlView = (Button) findViewById(R.id.bSQLopenView);
//		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);
        newQuiz.setOnClickListener(this);
//		sqlGetInfo.setOnClickListener(this);
//		sqlDelete.setOnClickListener(this);
	}
	
	
	@SuppressWarnings("static-access")
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

        boolean working;

        switch (arg0.getId()){

		case R.id.bSQLUpdate:	//Update database with new table entry

//            sp.play(soundId, 1, 1, 0, 0, 1);

            String question = sqlQuestion.getText().toString();
            String answer  = sqlAnswer1.getText().toString();
            String answer1 = sqlAnswer2.getText().toString();
            String answer2 = sqlAnswer3.getText().toString();
            String answer3 = sqlAnswer4.getText().toString();

            if(question.matches("") || answer.matches("") || answer1.matches("") || answer2.matches("") || answer3.matches("")){
                Dialog d = new Dialog(this);
                d.setTitle("Please Enter Text For Each Box!");
                TextView tv = new TextView(this);
                d.setContentView(tv);
                d.show();
                break;
            }

            else {
                working = true;

                try {

                    Database entry = new Database(SQLite.this);
                    entry.open();
                    Database.createEntry(question, answer, answer1, answer2, answer3);
                    entry.close();

                } catch (Exception e) {

                    working = false;
                    String error = e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle(":(");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();


                } finally {
                    if (working) {
                        Dialog d = new Dialog(this);
                        d.setTitle("New Question Added");
                        TextView tv = new TextView(this);
                        d.setContentView(tv);
                        d.show();
                        et1.setText("");
                        et2.setText("");
                        et3.setText("");
                        et4.setText("");
                        qt.setText("");

                    }
                }
            }
			break;

        case R.id.bNewQuiz:
//            sp.play(soundId, 1, 1, 0, 0, 1);
            Intent i = new Intent("android.intent.action.SECTIONS");
            Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
            startActivity(i, bndlanimation);

//		case R.id.bSQLopenView: //View database (new activity)
//
//
//			Intent i = new Intent("android.intent.action.SQLVIEW");
//			startActivity(i);
//			break;
			
//		case R.id.bgetInfo:		//Get info from database for a specific question via index number
//		 try{
//			String s = sqlRow.getText().toString();
//			long l = Long.parseLong(s); //Converts string to long
//
//			Database Db = new Database(this);
//			Db.open();
//			String returnedQuestion = Db.getQuestion(l);
//			String returnedAnswer = Db.getAnswer(l);
//			if(x==true){
//				x = false;
//				Db.addQuestions();
//			}
//			Db.close();
//
//			sqlQuestion.setText(returnedQuestion);
//			sqlAnswer1.setText(returnedAnswer);
//
//
//
//		 }catch(Exception e){
//
//				String error = e.toString();
//				Dialog d = new Dialog(this);
//				d.setTitle(":(");
//				TextView tv = new TextView(this);
//				tv.setText(error);
//				d.setContentView(tv);
//				d.show();
//
//
//			}
//			break;
			
//
//		case R.id.bSQLdelete:	//Delete an entry from the database via index number
//		 try{
//			String sRow1 = sqlRow.getText().toString();
//			long lRow1 = Long.parseLong(sRow1);
//			Database ex1 = new Database(this);
//			ex1.open();
//			ex1.deleteEntry(lRow1);
//			ex1.close();
//		 }catch(Exception e){
//
//				working = false;
//				String error = e.toString();
//				Dialog d = new Dialog(this);
//				d.setTitle(":(");
//				TextView tv = new TextView(this);
//				tv.setText(error);
//				d.setContentView(tv);
//				d.show();
//
//
//			}
//			break;
//
//		case R.id.bSQLmodify:
//
//			break;
		
		}
		
	}

}
