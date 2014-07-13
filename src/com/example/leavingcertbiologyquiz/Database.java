package com.example.leavingcertbiologyquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {
	// tasks Table Columns names
	public static final String KEY_ROWID = "_id";
	public static final String KEY_QUESTION = "ques";
	public static final String KEY_ANSWER = "ans";
	public static final String KEY_ANSWER1 = "ans1";
	public static final String KEY_ANSWER2 = "ans2";
	public static final String KEY_ANSWER3 = "ans3";

	
	private static final String DATABASE_NAME = "QnAdb"; //Database name
	private static final String DATABASE_TABLE = "QnA_table"; //Table holds 3 values above^
	private static final int DATABASE_VERSION = 1; //
	
	public boolean x = true;
	
	private DbHelper ourHelper; //
	private final Context ourContext; //
	private static SQLiteDatabase ourDatabase; //
	
	private static class DbHelper extends SQLiteOpenHelper{
		

		public boolean popDb = true ;
		
		public DbHelper(Context context){
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) { //Runs the first time we make a database
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
					KEY_ROWID +  " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
					KEY_QUESTION + " TEXT NOT NULL, " +	 
					KEY_ANSWER + " TEXT NOT NULL, " + 
					KEY_ANSWER1 + " TEXT NOT NULL, " + 
					KEY_ANSWER2 + " TEXT NOT NULL, " + 
					KEY_ANSWER3 + " TEXT NOT NULL  );" //Database set up (SQL Code that creates table)		
					);
		
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //Update Class
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		
		}
	
		
		
	}
	
	public Database(Context c){ //Constructor for Database class
		ourContext = c;
		
	}
	
	public Database open() throws SQLException{
		
		ourHelper = new DbHelper(ourContext); //New instance of ourHelper
		ourDatabase = ourHelper.getWritableDatabase(); //Open up our database through the helper
		return this;
	}
	
	public void close(){ //Closes Database
		
		ourHelper.close();
		
	}
	
	
	static void addQuestions()
	{
		
		createEntry("zzzzzz","Jalur Pesawat", "Jack sParrow", "Jasa Programmer", "Jasa Programmer");
		createEntry("zzzzzz is JP2?","Jalur Pesawat", "Jack sParrow", "Jasa Programmer", "Jasa Programmer");
		createEntry("zzzzzz is JP3?","Jalur Pesawat", "Jack sParrow", "Jasa Programmer", "Jasa Programmer");

		
	}

	public static long createEntry(String question, String answer, String answer1, String answer2, String answer3) { //Adds to Database
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues(); //Make a bundle to put into the table in the database
		cv.put(KEY_QUESTION, question);
		cv.put(KEY_ANSWER, answer);
		cv.put(KEY_ANSWER1, answer1);
		cv.put(KEY_ANSWER2, answer2);
		cv.put(KEY_ANSWER3, answer3);

		return ourDatabase.insert(DATABASE_TABLE, null, cv); //Inserts the 5 puts above
	}

	public String getData() {
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_QUESTION, KEY_ANSWER, KEY_ANSWER1, KEY_ANSWER2, KEY_ANSWER3};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iQuestion = c.getColumnIndex(KEY_QUESTION);
		int iAnswer = c.getColumnIndex(KEY_ANSWER);
		int iAnswer1 = c.getColumnIndex(KEY_ANSWER1);
		int iAnswer2 = c.getColumnIndex(KEY_ANSWER2);
		int iAnswer3 = c.getColumnIndex(KEY_ANSWER3);
		
		
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			
			
			result = result + c.getString(iRow) + " " + c.getString(iQuestion) + " " + c.getString(iAnswer) + " " + c.getString(iAnswer1) + " " + c.getString(iAnswer2) + " " + c.getString(iAnswer3) + "\n";
		
			
			
		}

		return result;
	}

	public String getQuestion(long l)  throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_QUESTION, KEY_ANSWER, KEY_ANSWER1, KEY_ANSWER2, KEY_ANSWER3};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			String question = c.getString(1);
			return question;
		}
		return null;
	}

	public String getAnswer(long l)  throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_QUESTION, KEY_ANSWER, KEY_ANSWER1, KEY_ANSWER2, KEY_ANSWER3};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			String answer = c.getString(2); //column 
			return answer;
		}
		return null;
	}
	
	public String getAnswer1(long l)  throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_QUESTION, KEY_ANSWER, KEY_ANSWER1, KEY_ANSWER2, KEY_ANSWER3};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			String answer = c.getString(3); //column 
			return answer;
		}
		return null;
	}
	
	public String getAnswer2(long l)  throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_QUESTION, KEY_ANSWER, KEY_ANSWER1, KEY_ANSWER2, KEY_ANSWER3};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			String answer = c.getString(4); //column 
			return answer;
		}
		return null;
	}
	
	public String getAnswer3(long l)  throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ KEY_ROWID, KEY_QUESTION, KEY_ANSWER, KEY_ANSWER1, KEY_ANSWER2, KEY_ANSWER3};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
		if(c!=null){
			c.moveToFirst();
			String answer = c.getString(4); //column 
			return answer;
		}
		return null;
	}
	
	
	public void deleteEntry(long lRow1)  throws SQLException{
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_TABLE, KEY_ROWID + "=" + lRow1, null);
	}
	
}
