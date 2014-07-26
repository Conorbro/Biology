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
		

	//1. Characteristics of Life/Food (30)
		
	createEntry("The 7 ‘characteristics of life’ are…", "Organisation Nutrition Excretion Response Movement Growth Reproduction", "Nutrition Excretion Response Movement Digestion Growth Reproduction", "Organisation Nutrition Excretion Response Movement Growth Sex", "Nutrition Excretion Response Movement Growth Reproduction Immune System");

	createEntry("The function of food is…", "to provide energy and materials for growth and repair of cells", "to provide energy for the repair and growth of cells in the body", "to fuel the body in its day to day needs", "to repair muscle tissue and maintain healthy bones in the body");

	createEntry("The 6 elements in food are...", "carbon hydrogen oxygen nitrogen sulphur phosphorus", "carbon hydrogen oxygen nitrogen sulphur magnesium", "carbon hydrogen oxygen nitrogen sulphur calcium", "carbon hydrogen oxygen nitrogen sulphur sodium");

	createEntry("The 7 biomolecular components of food are….", "carbohydrates proteins lipids vitamins minerals water", "carbohydrates proteins lipids saturates minerals water", "carbohydrates proteins fats vitamins minerals water", "lignin proteins lipids vitamins minerals water" );

	createEntry("Carbohydrates contain….", "carbon hydrogen oxygen", "carbon hydrogen nitrogen", "hydrogen nitrogen sulphur", "carbon nitrogen sulphur");

	createEntry("Monosaccharides are...", "one sugar unit e.g. glucose", "two sugar units e.g. sucrose", "many sugar units e.g. starch", "zero sugar units");

	createEntry("Disaccharides are…", "two sugar units e.g. sucrose","one sugar unit e.g. glucose","many sugar units e.g. starch","zero sugar units");

	createEntry("Polysaccharides are…", "many sugar units e.g. starch","one sugar unit e.g. glucose","two sugar units e.g. starch","zero sugar units");

	createEntry("Sources of Carbohydrates are….", "meat fish eggs", "fruits", "water", "vitamins");

	createEntry("The 4 primary elements of proteins are…", "carbon hydrogen oxygen nitrogen", "carbon hydrogen nitrogen", "carbon nitrogen sulphur", "carbon nitrogen sulphur lithium");

	createEntry("Sources of Protein are... ",  "meat fish eggs", "fruits", "water", "vitamins minerals");

	createEntry("Lipids Contain…", "carbon hydrogen oxygen in the ratio 2H:10", "carbon hydrogen oxygen in the ratio 1H:20", "carbon hydrogen oxygen in the ratio 3H:10", "carbon hydrogen oxygen in the ratio 1H:10"); 
	 
	createEntry("fats are... ", "solid at room temperature", "liquid at room temperature", "gas at room temperature", "undefined at room temperature");

	createEntry("oils are…", "liquid at room temperature","solid at room temperature", "gas at room temperature", "undefined at room temperature");

	createEntry("The basic of unit of a lipid is…", "triglyceride", "phospholipid", "fat", "oil");

	createEntry("Sources of lipids",  "vegetables", "fruits", "butter, oil, meat, cheese", "vitamins minerals");

	createEntry("The structural role of carbohydrates are…", "cellulose in plant cell wall/ chitin in cell wall of fungi", "collagen in skin/myosin in muscle", "phospholipids in cell membranes", "muscle tissue");

	createEntry("The structural role of protein is…", "collagen in skin/myosin in muscle", "cellulose in plant cell wall/ chitin in cell wall of fungi", "phospholipids in cell membranes", "muscle tissue");

	createEntry("The structural role of lipids are…", "phospholipids in cell membranes", "cellulose in plant cell wall/ chitin in cell wall of fungi", "collagen in skin/myosin in muscle", "muscle tissue");

	createEntry("The metabolic role of carbohydrates are…", "release of energy (glucose)", "storage of energy (starch in plants, glycogen in animals)", "formation of enzymes and hormones", "release and storage of energy");

	createEntry("The metabolic role of proteins are…","storage of energy (starch in plants, glycogen in animals)",  "release of energy (glucose)", "formation of enzymes and hormones", "release and storage of energy");

	createEntry("The metabolic role of lipids are…","storage of energy (starch in plants, glycogen in animals)",  "release of energy (glucose)", "formation of enzymes and hormones", "release and storage of energy");

	createEntry("The metabolic role of vitamin D is…","absorption of calcium",  "release of energy (glucose)", "formation of enzymes and hormones", "release and storage of energy");

	createEntry("The metabolic role of vitamin C is…","formation of skin and blood vessels",  "release of energy (glucose)", "formation of enzymes and hormones", "release and storage of energy");

	createEntry("What disease is caused by a Vitamin C deficiency?", "scurvy", "rickets in children", "aids", "the flu");

	createEntry("What disease is caused by a Vitamin D deficiency?", "rickets in children", "scurvy", "aids", "the flu");

	createEntry("Role of calcium in plants", "formation of middle lamella between plant cell walls", "formation of chlorophyll", "formation of haemoglobin", "formation of leafs and flower");

	createEntry("Role of magnesium in plants", "formation of chlorophyll", "formation of middle lamella between plant cell walls", "formation of haemoglobin", "formation of leafs and flower");

	createEntry("Role of calcium in animals", "formation of bones and teeth", "formation of skin and hair", "formation of haemoglobin", "formation of claws and nails");

	createEntry("Role of iron in animals", "formation of haemoglobin", "formation of skin and hair", "formation of bones and teeth", "formation of claws and nails");

	//2.Ecology (20)
	
	createEntry("Ecology is defined as…", "The study of the relationships of living organisms with each other and with their abiotic environment", "The place where an organism lives", "A group of different species sharing the same resources", "The part of the earth where organisms can live");

	createEntry("A habitat is defined as…", "The place where an organism lives", "The study of the relationships of living organisms with each other and with their abiotic environment", "A group of different species sharing the same resources", "The part of the earth where organisms can live");

	createEntry("A community is defined as…", "A group of different species sharing the same resources", "The study of the relationships of living organisms with each other and with their abiotic environment","The place where an organism lives", "The part of the earth where organisms can live");

	createEntry("A population is defined as…", "The members of the same species living in an ecosystem", "The study of the relationships of living organisms with each other and with their abiotic environment","The place where an organism lives", "The part of the earth where organisms can live");

	createEntry("An ecosystem is defined as…", "Living organisms and their abiotic environment e.g. woodland", "The study of the relationships of living organisms with each other and with their abiotic environment","The place where an organism lives", "The part of the earth where organisms can live");

	createEntry("A biosphere is defined as…", "The part of the earth where organisms can live", "The study of the relationships of living organisms with each other and with their abiotic environment","The place where an organism lives", "The part of the earth where organisms can live");

	createEntry("A niche is defined as…", "The role of an organism in an ecosystem", "The study of the relationships of living organisms with each other and with their abiotic environment","The place where an organism lives", "The part of the earth where organisms can live");

	createEntry("Abiotic factors (edaphic+climate) are…", "Non-living features of the environment that affect a community", "factors relating to soil e.g. moisture, temperature, pH", "Light intensity, rainfall , wind, temperature, humidity", "Influences of living organisms on each other");

	createEntry("Edaphic factors (competition, predation, symbiosis) are…",  "Factors relating to soil e.g. moisture", "Non-living features of the environment that affect a community", "temperature, pH, light intensity, rainfall , wind, temperature, humidity", "Influences of living organisms on each other");

	createEntry("Climatic factors are…","Light intensity, rainfall , wind, temperature, humidity", "Factors relating to soil e.g. moisture", "Non-living features of the environment that affect a community", "Influences of living organisms on each other");

	createEntry("Biotic factors are…",  "Influences of living organisms on each other", "Factors relating to soil e.g. moisture", "Non-living features of the environment that affect a community", "Temperature, pH, Light intensity, rainfall , wind, temperature, humidity");

	createEntry("Producers are…", "Autotrophs: organisms that make their own food", "Heterotrophs: organisms that cannot make their own food", "Herbivores: animals that eat plants only", "Carnivores: animals that eat other animals");

	createEntry("Consumers are…","Heterotrophs: organisms that cannot make their own food",  "Autotrophs: organisms that make their own food", "Herbivores: animals that eat plants only", "Carnivores: animals that eat other animals");

	createEntry("Primary Consumers are…","Herbivores: animals that eat plants only", "Heterotrophs: organisms that cannot make their own food",  "Autotrophs: organisms that make their own food", "Carnivores: animals that eat other animals");

	createEntry("Secondary Consumers are…","Carnivores/Omnivores", "Herbivores: animals that eat plants only", "Heterotrophs: organisms that cannot make their own food",  "Autotrophs: organisms that make their own food");

	createEntry("A food chain is defined as…", "A pathway along which food (energy) is passed from one species to another", "Feeding stage of a species in a food chain", "An illustration of the interconnections between two or more food structures in an ecosystem", "A chain of animals were the previous animal eats the preceding one");

	createEntry("A trophic level is defined as…", "Feeding stage of a species in a food chain","A pathway along which food (energy) is passed from one species to another", "An illustration of the interconnections between two or more food structures in an ecosystem", "A chain of animals were the previous animal eats the preceding one");

	createEntry("A food web shows…", "The interconnections between two or more food chains in an ecosystem","A pathway along which food (energy) is passed from one species to another", "An illustration of the interconnections between two or more food structures in an ecosystem", "A chain of animals were the previous animal eats the preceding one");

	createEntry("The pyramid of numbers is…", "A diagram showing the number of organisms at each trophic level in a food chain", "An illustration of the interconnections between two or more food structures in an ecosystem", "A chain of animals were the previous animal eats the preceding one", "A pathway along which food (energy) is passed from one species to another");

	createEntry("What is the main limitation of the pyramid of numbers?", "It does not take into account the size of the animals or plants", "It does not take into account the number of animals or plants", "It does not take into account the age of the animals or plants", "It does not take into account the sexual orientation of the animals or plants");

	//30
	
	createEntry("Biotic Factors are defined as...", "The influences of living organisms on each other", "The influence of the environment on organisms,", "The influence of organisms on the environment", "The influence of the environement on itself");
	
	createEntry("Competition is defined as...", "The struggle between two or more organisms for a resource that is in short supply, e.g. food", "When an animal hunts and kills another animal for food", "The influence of the environment on organisms,", "The influence of organisms on the environment");
	
	createEntry("Predation is defined as...", "When an animal hunts and kills another animal for food", "The struggle between two or more organisms for a resource that is in short supply, e.g. food", "The relationship between the predator and its prey", "A relationship between different species that involves benefit");
	
	createEntry("Symbiosis is defined as...", "A close relationship between different species that involve benefit, e.g. mutualism, parasitism, commensalism","When an animal hunts and kills another animal for food", "The struggle between two or more organisms for a resource that is in short supply, e.g. food", "The relationship between the predator and its prey" );
	
	createEntry("Mutalism is defined as...", "Two different organisms living together where both benefit", "Two different organisms living together where one (the parasite) benefits and causes the other (host) harm", "Two different orgaisms living together where one benefits and the other other is unharmed/harmed", "Relationship between two organisms where neither benefit");
	
	createEntry("Parasitism is defined as...","Two different organisms living together where one (the parasite) benefits and causes the other (host) harm", "Two different organisms living together where both benefit",  "Two different orgaisms living together where one benefits and the other other is unharmed/harmed", "Relationship between two organisms where neither benefit");

	createEntry("Commensalism is defined as...", "Two different orgaisms living together where one benefits and the other other is unharmed/harmed","Two different organisms living together where both benefit", "Two different organisms living together where one (the parasite) benefits and causes the other (host) harm",  "Relationship between two organisms where neither benefit");

	createEntry("Pollution is defined as...", "Any harmful addition to the environment", "Destruction of the environment by humans", "Phenomenom such as acid rain caused by humans", "Littering");
	
	createEntry("A Pollutant is...", "A substance that causes harm to the environment, e.g. Sulphur Dioxide SO2","Any harmful addition to the environment", "Destruction of the environment by humans", "Phenomenom such as acid rain caused by humans" );
	
	createEntry("Sulphur Dioxide pollution causes....", "Acid rain", "Smog", "Globar warming", "Smoke Particles");
	
	createEntry("Sulphur Dioxide pollution is caused by...", "The burning of fossil fuels, e.g. oil, natural gas, coal", "Littering", "Methane emitted from animal dung", "Overfishing");
	
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
			String answer = c.getString(5); //column 
			return answer;
		}
		return null;
	}
	
	
	public void deleteEntry(long lRow1)  throws SQLException{
		// TODO Auto-generated method stub
		ourDatabase.delete(DATABASE_TABLE, KEY_ROWID + "=" + lRow1, null);
	}
	
}
