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
		
	//Section (Number of questions)
		
	//1. Characteristics of Life/Food (30)
		
	createEntry("The 7 ‘characteristics of life’ are…", "Organisation Nutrition Excretion Response Movement Growth Reproduction", "Nutrition Excretion Response Movement Digestion Growth Reproduction", "Organisation Nutrition Excretion Response Movement Growth Sex", "Nutrition Excretion Response Movement Growth Reproduction Immune System");

	createEntry("The function of food is…", "To provide energy and materials for the growth and repair of cells", "To stave off hunger", "To wake the body up", "To taste nice");

	createEntry("The 6 elements in food are...", "Carbon hydrogen oxygen nitrogen sulphur phosphorus", "Carbon hydrogen oxygen nitrogen sulphur magnesium", "Carbon hydrogen oxygen nitrogen sulphur calcium", "Carbon hydrogen oxygen nitrogen sulphur sodium");

	createEntry("The 7 biomolecular components of food are….", "Carbohydrates proteins lipids vitamins minerals water", "Carbohydrates proteins lipids saturates minerals water", "Carbohydrates proteins fats vitamins minerals water", "Lignin proteins lipids vitamins minerals water" );

	createEntry("Carbohydrates contain….", "Carbon hydrogen oxygen", "Carbon hydrogen nitrogen", "Hydrogen nitrogen sulphur", "Carbon nitrogen sulphur");

	createEntry("Monosaccharides are...", "One sugar unit e.g. glucose", "Two sugar units e.g. sucrose", "Many sugar units e.g. starch", "Zero sugar units");

	createEntry("Disaccharides are…", "Two sugar units e.g. sucrose","One sugar unit e.g. glucose","Many sugar units e.g. starch","Zero sugar units");

	createEntry("Polysaccharides are…", "Many sugar units e.g. starch","One sugar unit e.g. glucose","Two sugar units e.g. starch","Zero sugar units");

	createEntry("Sources of Carbohydrates are….", "Meat fish eggs", "Fruits", "Water", "Vitamins");

	createEntry("The 4 primary elements of proteins are…", "Carbon hydrogen oxygen nitrogen", "Carbon hydrogen nitrogen sulphur", "Carbon nitrogen sulphur boron", "Carbon nitrogen sulphur lithium");

	createEntry("Sources of Protein are... ",  "Meat fish eggs", "Fruits", "Water", "Vitamins minerals");

	createEntry("Lipids Contain…", "Carbon hydrogen oxygen in the ratio 2H:10", "Carbon hydrogen oxygen in the ratio 1H:20", "Carbon hydrogen oxygen in the ratio 3H:10", "Carbon hydrogen oxygen in the ratio 1H:10"); 
	 
	createEntry("Fats are... ", "Solid at room temperature", "Liquid at room temperature", "Gas at room temperature", "Undefined at room temperature");

	createEntry("Oils are…", "Liquid at room temperature","Solid at room temperature", "Gas at room temperature", "Undefined at room temperature");

	createEntry("The basic of unit of a lipid is…", "Triglyceride", "Phospholipid", "Fat", "Oil");

	createEntry("Sources of lipids",  "Vegetables", "Fruits", "Butter, oil, meat, cheese", "Vitamins minerals");

	createEntry("The structural role of carbohydrates are…", "Cellulose in plant cell wall/ chitin in cell wall of fungi", "Collagen in skin/myosin in muscle", "Phospholipids in cell membranes", "Muscle tissue");

	createEntry("The structural role of protein is…", "Collagen in skin/myosin in muscle", "Cellulose in plant cell wall/ chitin in cell wall of fungi", "Phospholipids in cell membranes", "Muscle tissue");

	createEntry("The structural role of lipids are…", "Phospholipids in cell membranes", "Cellulose in plant cell wall/ chitin in cell wall of fungi", "Collagen in skin/myosin in muscle", "Muscle tissue");

	createEntry("The metabolic role of carbohydrates are…", "Release of energy (glucose)", "Storage of energy (starch in plants, glycogen in animals)", "Formation of enzymes and hormones", "Release and storage of energy");

	createEntry("The metabolic role of proteins are…","Storage of energy (starch in plants, glycogen in animals)",  "Release of energy (glucose)", "Formation of enzymes and hormones", "Release and storage of energy");

	createEntry("The metabolic role of lipids are…","Storage of energy (starch in plants, glycogen in animals)",  "Release of energy (glucose)", "Formation of enzymes and hormones", "Release and storage of energy");

	createEntry("The metabolic role of vitamin D is…","Absorption of calcium",  "Release of energy (glucose)", "Formation of enzymes and hormones", "Release and storage of energy");

	createEntry("The metabolic role of vitamin C is…","Formation of skin and blood vessels",  "Release of energy (glucose)", "Formation of enzymes and hormones", "Release and storage of energy");

	createEntry("What disease is caused by a Vitamin C deficiency?", "Scurvy", "Rickets in children", "Aids", "The flu");

	createEntry("What disease is caused by a Vitamin D deficiency?", "Rickets in children", "Scurvy", "Aids", "The flu");

	createEntry("Role of calcium in plants", "Formation of middle lamella between plant cell walls", "Formation of chlorophyll", "Formation of haemoglobin", "Formation of leafs and flower");

	createEntry("Role of magnesium in plants", "Formation of chlorophyll", "Formation of middle lamella between plant cell walls", "Formation of haemoglobin", "Formation of leafs and flower");

	createEntry("Role of calcium in animals", "Formation of bones and teeth", "Formation of skin and hair", "Formation of haemoglobin", "Formation of claws and nails");

	createEntry("Role of iron in animals", "Formation of haemoglobin", "Formation of skin and hair", "Formation of bones and teeth", "Formation of claws and nails");

	//2.Ecology (48)
	
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
	
	createEntry("Conservation is defined as...", "A series of activities designed to preserve or protect the enviornment","Any means that prevents pollution of the environment", "The upkeep or organisms and their environment", "The preservation of an organism's environment" );
	
	createEntry("Benefits of conservation include...","Maintains our food supply, biodiversity, and possible sources of drugs", "Promotes tourism and recreation", "Prevents extinction of endangered species", "Allows for scientific research to be conducted");
	
	createEntry("Problems of waste management include...", "Incinerators burn rubbish and harmful gases may be released", "Seaguls flock around landfill sites", "Landfill sites attract looters", "Hard to maintain");
	
	createEntry("Micro-organisms assist in waste management by...", "Decomposing waste in sewage plants (bacteria and fungi)", "Eliminating the foul odor from waste", "Purifying waste for humans to dispose of", "Turning waste into liquid and gas");
	
	createEntry("Factors affecting human population growth...", "Disease, food supply, war, contraception, birth rate, death rate, degree of medical care", "Disease, food supply, war, contraception", "Death rate, degree of medical care", "Contraception, birth rate, death rate");	
	
	createEntry("Which Animal Kingdom are bacteria a part of?", "Monera", "Fungi", "Protocitsta", "Animal");
	
	createEntry("Which Animal Kingdom are mushrooms a part of?", "", "Monera", "Fungi", "Protocitsta");

	createEntry("Which Animal Kingdom are amoebas a part of?", "Protocitsta", "Monera", "Fungi", "Plant");

	createEntry("Which Animal Kingdom are buttercups a part of?", "Plant", "Monera", "Fungi", "Protocitsta");

	createEntry("Which Animal Kingdom are rabbits a part of?", "Animal", "Monera", "Fungi", "Protocitsta");

	createEntry("A qualitative survey...", "Records all species present in an ecosystem", "Mesaures the population size or distribution of a sepceis", "Measures the size only of a species", "Records some species in an ecosystem");
	
	createEntry("A quantitative survey...","Mesaures the population size or distribution of a sepceis", "Measures the size only of a species", "Records some species in an ecosystem", "Records all species present in an ecosystem");
	
	createEntry("Which of these is not a valid error of a quantitative survey?", "Syntax error", "Human error", "Limitation of sample size", "Not enough quadrats sampled");
	
	createEntry("An adaptation is...","A feature of an organism that suits it to its environment", "A decision made by the orgainism to suit its environment", "An environemtal quirk tailored to a specific organism", "None of the aboe");
	
	createEntry("Which of the following is a valid example of an adaptation?", "Spider - uses its web to catch prey", "Snail - slimey for enhanced mobility", "Daisy - bright colour to absorb sunlight", "Rabbit - big feet to kick predators");
	
	createEntry("In a qualitative study, what is used in the identification of a species?", "A biological key", "Google", "The observer's knowledge", "DNA testing");
	
	//The Cell (17)
	
	createEntry("An animal cell is made up of...", "Cell membrane, cytoplasm, nucleus", "Cell membrane, nucleus", "Cell wall, cell membrane, nucleus", "Chloroplast, vacuole, cell wall, cell membrane, cytoplasm, nucleus");
	
	createEntry("A plant cell is made up of...", "Chloroplast, vacuole, cell wall, cell membrane, cytoplasm, nucleus","Cell membrane, cytoplasm, nucleus", "Cell membrane, nucleus", "Cell wall, cell membrane, nucleus");

	createEntry("The function(s) of the cell wall are...", "To support the cell and prevent bursting", "To store food, H2O, and chemicals for protection", "Aerobic respiration", "Protein synthesis");
	
	createEntry("The function(s) of the large vacuole are...", "To store food, H2O, and chemicals for protection","To support the cell and prevent bursting",  "Aerobic respiration", "Protein synthesis");

	createEntry("The function(s) of the chloroplast are...", "Photosynthesis","To support the cell and prevent bursting",  "Aerobic respiration", "Protein synthesis");
	
	createEntry("The function(s) of the cell membrane are...", "To regulate what enters and leaves the cell (Selectively permeable)","To support the cell and prevent bursting",  "Aerobic respiration", "Protein synthesis");

	createEntry("The function(s) of the cytoplasm are...", "To suspend the cell's organelles and to act as a medium for chemical reactions to occur","To support the cell and prevent bursting",  "Aerobic respiration", "Protein synthesis");

	createEntry("The function(s) of the ribosome are...", "Protein synthesis","To support the cell and prevent bursting",  "Aerobic respiration", "Photosynthesis");

	createEntry("The function(s) of the mitochondrion are...","Aerobic respiration", "Protein synthesis","To support the cell and prevent bursting",   "Photosynthesis");

	createEntry("The function(s) of the nucleus are...","Hold DNA and to control the cell's activites", "Protein synthesis","To support the cell and prevent bursting",   "Photosynthesis");

	createEntry("Prokaryotic cells...", "Do not have a membrane-bound nucleus and organelles such as mitochondria and choloplasts (Monera kingdom", "Have a nucleus bounded by a membrane and mitochondria and chloroplasts", "None of the above", "Have no nucleus present in the cytoplasm");
	
	createEntry("Eukaryotic cells...", "Have a nucleus bounded by a membrane and mitochondria and chloroplasts","Do not have a membrane-bound nucleus and organelles such as mitochondria and choloplasts (Monera kingdom",  "None of the above", "Have no nucleus present in the cytoplasm");

	createEntry("Tissue is defined as...", "A group of cells specialised for a particular function", "A group of different cells working together for a particular function(s)", "Part of an organ worjing together to carry out a particular function(s)","None of the above");
	
	createEntry("Organ is defined as...", "A group of different tissues working together for a particular function(s)","A group of cells specialised for a particular function",  "Part of an organ worjing together to carry out a particular function(s)","None of the above");

	createEntry("An organ system is defined as...", "A number of organs working together to carry out particular function(s)","A group of cells specialised for a particular function",  "A group of different tissues working together for a particular function(s)","None of the above");

	createEntry("Tissue culture is...", "The growth of cells in a sterile nutrient medium in the laboratory", "None of the above", "A method to identify different types of tissue", "The growth of cells on a preexisting set of cells");
	
	createEntry("Which of the following is tissue culture NOT used for?", "Tanning", "Mirco-propagation of plants", "Transplant surgery, e.g. skin grafting", "Cancer research");
	
	//Cell Continuity (15)
	
	createEntry("Cell continuity means...", "Existing cells divide and prodcue new cells", "Existing cells sustain themselves", "Existing cells move from place in an organism to another", "Existing cells reproduce with eachother to form new cells");
	
	createEntry("A haploid cell has...", "One set of chromosomes (n) e.g. egg cell, sperm", "Two sets of chromosomes (2n), e.g. bone cell, muscle cell", "Three sets of chromosomes (3n)", "Zero sets of chromosomes");
	
	createEntry("A diploid cell has...", "Two sets of chromosomes (2n), e.g. bone cell, muscle cell","One set of chromosomes (n) e.g. egg cell, sperm", "Three sets of chromosomes (3n)", "Zero sets of chromosomes");

	createEntry("During the cell cycle, interphase is when...", "DNA uncoils and replicates and the cell increases in size", "The nucleus divides (mitosis) and the cytoplasm divides (cell division)", "DNA coils and the cell decreases in size", "The nucleus and cytoplasm expand");
	
	createEntry("During the cell cycle, division is when...", "The nucleus divides (mitosis) and the cytoplasm divides (cell division)","DNA uncoils and replicates and the cell increases in size",  "DNA coils and the cell decreases in size", "The nucleus and cytoplasm expand");

	createEntry("The stages of mitosis are...", "Prophase, Metaphase, Anaphase, Telephase", "Metaphase, Anaphase, Telephase", "Prophase, Metaphase, Anaphase", "Prophase, Metaphase, Anaphase, Telephase, Ketaphase");
	
	createEntry("During cell division in animal cells...", "A cleavage furrow pinches the cell in two", "A cell plate and new cell walls divide the cell", "The cell cleanly splits down the middle", "Another cell moves through the middle of the dividing cell to divide it");
	
	createEntry("During cell division in plant cells...",  "A cell plate and new cell walls divide the cell","A cleavage furrow pinches the cell in two", "The cell cleanly splits down the middle", "Another cell moves through the middle of the dividing cell to divide it");
	
	createEntry("The result(s) of mitosis are...", "2 identical daughter cells + the chromosome number is kept constant", "2 identical daughter cells", "Chromosome number is kept constant","2 genetically different daughter cells");
	
	createEntry("The role of mitosis in unicellular organisms is...", "Asexual reproduction", "Growth", "Repair", "Sexual reproduction");
	
	createEntry("The role of mitosis in multicellular organisms is...","Growth and replacement of cells" ,"Asexual reproduction", "Restoration", "Sexual reproduction");

	createEntry("The result(s) of meiosis are...", "Chromosome number halved + daughter nuclei genetically different",  "2 identical daughter cells + the chromosome number is kept constant", "2 identical daughter cells", "Chromosome number is kept constant");
	
	createEntry("The role(s) of meiosis are...", "Production of haploid gametes for sexual reproduction + genetic variation", "Growth and replacement of cells" ,"Asexual reproduction", "Restoration");
	
	createEntry("In humans, meiosis occurs...", "In the testis and ovaries", "The brain", "The heart", "The testis only");
	
	createEntry("Which of the following is not a cause of cancer?", "Jogging", "Cigarette smoke", "Asbestos", "Ultra-violet light");
	
	//Cell Membranes (7)
	
	createEntry("Diffusion is defined as...", "The movement of molecules in a liquid or gas from a region of higher to lower concentration", "The movement of water molecules from a region of higher concentration to a region of lower concentration across a semi permeable membrance", "Shrinkage of plant cells due to loss of water by osmosis","The movement of molecules from an area of low concentration to an are of high concentration");

	createEntry("Osmosis is defined as...","The movement of water molecules from a region of higher concentration of water to a region of lower concentration across a semi permeable membrance", "The movement of molecules in a liquid or gas from a region of higher to lower concentration",  "Shrinkage of plant cells due to loss of water by osmosis","The movement of molecules from an area of low concentration to an are of high concentration");

	createEntry("Turgor is defined as...","A state in which a cell is fully stretched and rigid due to the cytoplasm pushing out agaisnt the restraining cell wall", "The movement of molecules in a liquid or gas from a region of higher to lower concentration",  "Shrinkage of plant cells due to loss of water by osmosis","The movement of molecules from an area of low concentration to an are of high concentration");

	createEntry("Plasmolysis is defined as...","Shrinkage of plant cells due to loss of water by osmosis","The movement of water molecules from a region of higher concentration of water to a region of lower concentration across a semi permeable membrance", "The movement of molecules in a liquid or gas from a region of higher to lower concentration",  "The movement of molecules from an area of low concentration to an are of high concentration");

	createEntry("Which of the following is NOT an example of diffusion?", "Absorption of H2O in the intestine", "Absorption of food in the intestine", "Absorption of minerals by root hairs and root epidermal cells", "O2 and CO2 moving in and out of leaves");
	
	createEntry("Which of the following is NOT an example of osmosis?", "Absorption of food in the intestine", "Absorption of H2O in the intestine", "The opening and closing of the stoma", "Re-absorbtion of H2O in the nephron");

	createEntry("How does osmosis help preserve food?", "By using a high concentration of salt or sugar in food, H2O will be drained from any bacterial cells present causing them to die", "", "", "");
	
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
