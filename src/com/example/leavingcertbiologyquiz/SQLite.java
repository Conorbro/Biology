package com.example.leavingcertbiologyquiz;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLite extends Activity implements OnClickListener{

	Button sqlUpdate, sqlView, sqlModify, sqlGetInfo, sqlDelete;
	EditText sqlQuestion, sqlAnswer, sqlRow;
	public boolean x = true;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite);
		sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlQuestion = (EditText) findViewById(R.id.etSQLName);
		sqlAnswer = (EditText) findViewById(R.id.etSQLSurname);
		sqlRow = (EditText) findViewById(R.id.etIndex);
		sqlGetInfo = (Button) findViewById(R.id.bgetInfo);
		sqlDelete = (Button) findViewById(R.id.bSQLdelete);
		//sqlModify = (Button) findViewById(R.id.bSQLmodify);
		sqlView = (Button) findViewById(R.id.bSQLopenView);
		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);		
		sqlGetInfo.setOnClickListener(this);
		sqlDelete.setOnClickListener(this);
	}
	
	
	@SuppressWarnings("static-access")
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	
		switch (arg0.getId()){
		
		case R.id.bSQLUpdate:	//Update database with new table entry
		
			boolean working = true;
			try{
			String question = sqlQuestion.getText().toString();
			String answer = sqlAnswer.getText().toString();
			String answer1 = "aad";
			String answer2 = "aac";
			String answer3 = "aab";
			
			Database entry = new Database(SQLite.this);
			entry.open();
			Database.createEntry(question, answer, answer1, answer2, answer3);
			entry.close();
			}catch(Exception e){
				
				working = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle(":(");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				
				
			}finally{
				if(working){
					Dialog d = new Dialog(this);
					d.setTitle("Obviously");
					TextView tv = new TextView(this);
					tv.setText("Success");
					d.setContentView(tv);
					d.show();
				}
				
				
			}
			break;
			
		case R.id.bSQLopenView: //View database (new activity)
		
	
			Intent i = new Intent("android.intent.action.SQLVIEW");
			startActivity(i);
			break;
			
		case R.id.bgetInfo:		//Get info from database for a specific question via index number
		 try{
			String s = sqlRow.getText().toString();
			long l = Long.parseLong(s); //Converts string to long
			
			Database Db = new Database(this);
			Db.open();
			String returnedQuestion = Db.getQuestion(l);
			String returnedAnswer = Db.getAnswer(l);
			if(x==true){
				x = false;
				Db.addQuestions();
			}
			Db.close();
		
			sqlQuestion.setText(returnedQuestion);
			sqlAnswer.setText(returnedAnswer);
			
		
			
		 }catch(Exception e){
				
				working = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle(":(");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				
				
			}
			break;
			
		
		case R.id.bSQLdelete:	//Delete an entry from the database via index number
		 try{
			String sRow1 = sqlRow.getText().toString();
			long lRow1 = Long.parseLong(sRow1);
			Database ex1 = new Database(this);
			ex1.open();
			ex1.deleteEntry(lRow1);
			ex1.close();
		 }catch(Exception e){
				
				working = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle(":(");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();
				
				
			}
			break;
			
//		case R.id.bSQLmodify:
//			
//			break;
		
		}
		
	}

}
