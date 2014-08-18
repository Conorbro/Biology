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
	
	createEntry("Which Animal Kingdom are mushrooms a part of?", "Fungi", "Monera", "Animal", "Protocitsta");

	createEntry("Which Animal Kingdom are amoebas a part of?", "Protocitsta", "Monera", "Fungi", "Plant");

	createEntry("Which Animal Kingdom are buttercups a part of?", "Plant", "Monera", "Fungi", "Protocitsta");

	createEntry("Which Animal Kingdom are rabbits a part of?", "Animal", "Monera", "Fungi", "Protocitsta");

	createEntry("A qualitative survey...", "Records all species present in an ecosystem", "Mesaures the population size or distribution of a sepceis", "Measures the size only of a species", "Records some species in an ecosystem");
	
	createEntry("A quantitative survey...","Mesaures the population size or distribution of a sepceis", "Measures the size only of a species", "Records some species in an ecosystem", "Records all species present in an ecosystem");
	
	createEntry("Which of these is not a valid error of a quantitative survey?", "Syntax error", "Human error", "Limitation of sample size", "Not enough quadrats sampled");
	
	createEntry("An adaptation is...","A feature of an organism that suits it to its environment", "A decision made by the orgainism to suit its environment", "An environemtal quirk tailored to a specific organism", "None of the aboe");
	
	createEntry("Which of the following is a valid example of an adaptation?", "Spider - uses its web to catch prey", "Snail - slimey for enhanced mobility", "Daisy - bright colour to absorb sunlight", "Rabbit - big feet to kick predators");
	
	createEntry("In a qualitative study, what is used in the identification of a species?", "A biological key", "Google", "The observer's knowledge", "DNA testing");
	
	//3. The Cell (17) (78)
	
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

	createEntry("Prokaryotic cells...", "Do not have a membrane-bound nucleus and organelles such as mitochondria and choloplasts (Monera kingdom)", "Have a nucleus bounded by a membrane and mitochondria and chloroplasts", "None of the above", "Have no nucleus present in the cytoplasm");
	
	createEntry("Eukaryotic cells...", "Have a nucleus bounded by a membrane and mitochondria and chloroplasts","Do not have a membrane-bound nucleus and organelles such as mitochondria and choloplasts (Monera kingdom",  "None of the above", "Have no nucleus present in the cytoplasm");

	createEntry("Tissue is defined as...", "A group of cells specialised for a particular function", "A group of different cells working together for a particular function(s)", "Part of an organ worjing together to carry out a particular function(s)","None of the above");
	
	createEntry("Organ is defined as...", "A group of different tissues working together for a particular function(s)","A group of cells specialised for a particular function",  "Part of an organ worjing together to carry out a particular function(s)","None of the above");

	createEntry("An organ system is defined as...", "A number of organs working together to carry out particular function(s)","A group of cells specialised for a particular function",  "A group of different tissues working together for a particular function(s)","None of the above");

	createEntry("Tissue culture is...", "The growth of cells in a sterile nutrient medium in the laboratory", "None of the above", "A method to identify different types of tissue", "The growth of cells on a preexisting set of cells");
	
	createEntry("Which of the following is tissue culture NOT used for?", "Tanning", "Mirco-propagation of plants", "Transplant surgery, e.g. skin grafting", "Cancer research");
	
	//4. Cell Continuity (15) (22) (95)
	
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
	
	//Cell Membranes (7) (110)
	
	createEntry("Diffusion is defined as...", "The movement of molecules in a liquid or gas from a region of higher to lower concentration", "The movement of water molecules from a region of higher concentration to a region of lower concentration across a semi permeable membrance", "Shrinkage of plant cells due to loss of water by osmosis","The movement of molecules from an area of low concentration to an are of high concentration");

	createEntry("Osmosis is defined as...","The movement of water molecules from a region of higher concentration of water to a region of lower concentration across a semi permeable membrance", "The movement of molecules in a liquid or gas from a region of higher to lower concentration",  "Shrinkage of plant cells due to loss of water by osmosis","The movement of molecules from an area of low concentration to an are of high concentration");

	createEntry("Turgor is defined as...","A state in which a cell is fully stretched and rigid due to the cytoplasm pushing out agaisnt the restraining cell wall", "The movement of molecules in a liquid or gas from a region of higher to lower concentration",  "Shrinkage of plant cells due to loss of water by osmosis","The movement of molecules from an area of low concentration to an are of high concentration");

	createEntry("Plasmolysis is defined as...","Shrinkage of plant cells due to loss of water by osmosis","The movement of water molecules from a region of higher concentration of water to a region of lower concentration across a semi permeable membrance", "The movement of molecules in a liquid or gas from a region of higher to lower concentration",  "The movement of molecules from an area of low concentration to an are of high concentration");

	createEntry("Which of the following is NOT an example of diffusion?", "Absorption of H2O in the intestine", "Absorption of food in the intestine", "Absorption of minerals by root hairs and root epidermal cells", "O2 and CO2 moving in and out of leaves");
	
	createEntry("Which of the following is NOT an example of osmosis?", "Absorption of food in the intestine", "Absorption of H2O in the intestine", "The opening and closing of the stoma", "Re-absorbtion of H2O in the nephron");

	createEntry("How does osmosis help preserve food?", "By using a high concentration of salt or sugar in food, H2O will be drained from any bacterial cells present causing them to die", "By using a low concentration of salt or sugar in food, H2O will be drained from any bacterial cells present causing them to die", "By using a high concentration of sulphur or magnesium in food, H2O will be drained from any bacterial cells present causing them to die", "None of the above");
	
	//Enzymes (20) (117)
	
	createEntry("Metabolism is defined as...", "All the chemical reactions in living cells or organisms", "The breaking down reactions where energy is released e.g. respiration", "The building up reactions where energy is used, e.g. photosynthesis", "None of the above");
	
	createEntry("Catabolism is defined as...", "The breaking down reactions where energy is released e.g. respiration","All the chemical reactions in living cells or organisms",  "The building up reactions where energy is used, e.g. photosynthesis", "None of the above");

	createEntry("Anabolism is defined as...","The building up reactions where energy is used, e.g. photosynthesis", "All the chemical reactions in living cells or organisms", "The breaking down reactions where energy is released e.g. respiration",  "None of the above");

	createEntry("Enzymes are defined as...", "Biological catalyts produced by living cells (on the ribosomes)", "Cells for growing muscle tissue", "A type of lipid used by the body", "The byproducts of digestion");
	
	createEntry("What are enzymes made of?", "Protein", "Fats", "Phospholipids", "Carbohydrates");
	
	createEntry("What type of enzyme acts on starch?", "Amylase", "Lactase", "Maltase", "Diastase");
	
	createEntry("What factors affect enzyme action?", "pH and temperature", "Day of the week", "Humidity", "Gender");
	
	createEntry("An enzyme whose structure is permantly damaged and can no longer function is known as...", "A denatured enzyme", "A broken enzyme", "An enzyme", "None of the above");
	
	createEntry("Bioprecoessing is defined as...", "The use of living organisms or their enzymes to produce useful substances", "The use of dead organisms to produce useful substances", "The use of denatured enzymes to produce useful substances", "The use of living organisms to produce denatured enzymes");
	
	createEntry("Immobilised enzymes are ...", "Fixed in a gel or attached to an inert material so that they are not free in the solution","Not fixed in a gel or attached to an inert material so that they are free in the solution ","Denatured enzymes attached to an inert material so that they are fixed in the solution", "None of the above");
	
	createEntry("What is the method to immobilize enzymes?", "Gel beads containing enzymes are prepared using sodium alginate and calcium chloride solutions", "Hollow beads containing enzymes are prepared using sodium chloried solutions", "Empty gel beads are used to capture the enzymes floating free in the solution", "None of the above");
	
	createEntry("When using immobilized enzymes...", "The temperature and pH are kept at optimal levels", "The temperature and pH do not affect the enzyme action", "Only the pH is kept at an optimal level", "Only the temperature is kept at an optimal level");
	
	createEntry("Imobilised enzymes are usually placed in a...","Bioreactor", "Tube", "Recycable container", "Cardboard box");
	
	createEntry("Which of the following is an application of immobilised enzymes?", "Conversion of glucose to fructiose using glucose isomerase", "None of the above", "Electrolysis", "Respiration and Photosynthesis");
	
	createEntry("Which of the following is NOT an advantage of immobilized enzymes?", "Enzymes can alter the thermodynamics of a reaction", "Immboilised enzymes are easily recovered", "They can be re-used and are therefor economical", "The product is easily separated and purified");
	
	createEntry("What does 'ATP' stand for?", "Adenosine Triphosphate", "Adenosine Teraphosphate", "Alternative Triphospgate", "None of the above");
	
	createEntry("What is the role of ATP?", "ATP is the immediate supplier of energy in the cell, e.g. muscle contraction", "To form ADP", "TO break down ADP", "None of the above");
	
	createEntry("What is the role of ADP?", "ADP uses energy and combines with phosphate to form ATP", "ADP is the immediate supplier of energy in the cell, e.g. muscle contraction", "To break down ATP", "None of the above");
	
	createEntry("What does ADP stand for?", "Adenosine diphosphate", "Adenosine Triphosphate", "None of the above", "Adenosine delphosphate");
	
	createEntry("Which of the following is the correct formula for the formation of ATP?", "ADP + P + energy -> ATP", "ADP + P -> ATP", "ADP + D + P -> ATP", "ADP -> ATP");
	
	//Evolution/DNA () (137) (53)
	
	createEntry("DNA consists of...", "Two parallel strands of nucleotides coiled in a double helix", "Three parallel strands of nucleotides coiled in a double helix", "Two perpendicular strands of nucleotides coiled in a double helix", "One strand of nucleotides coiled in a double helix");
	
	createEntry("A nucleotide in DNA is made up of...", "Posphate (P) + Deoxyribose (S) + Nitrogen base", "Phosphate (P) + Deoxyribose (S)", "Deoxyribose (S) + Nitrogen base", "Phosphate (S) + Nitrogen base");
	
	createEntry("In DNA the nucleotide strands are held together by...", "Weak hydrogen bonds", "Strong hydrogen bonds", "Weak protein bonds", "Strong protein bonds");
	
	createEntry("In the complimentary bases of DNA adenine is bonded to...","Thymine" , "Guanine", "Cystosine", "Adenine");
	
	createEntry("In the complimentary bases of DNA guanine is bonded to..." , "Cystosine","Adenine","Thymine" , "Guanine" );  

	createEntry("In the complimentary bases of DNA cystosine is bonded to..." , "Guanine", "Cystosine","Adenine","Thymine"  );

	createEntry("A gene is defined as...", "A unit of jereditary information located on a chromosome and made of DNA", "A sequence of triplets that codes for the formation of protein", "Three bases in sequence in a DNA strand that codes for particular amino acid", "None of the above");
	
	createEntry("Genetic code is defined as...", "A sequence of triplets that codes for the formation of protein", "A unit of jereditary information located on a chromosome and made of DNA", "Three bases in sequence in a DNA strand that codes for particular amino acid", "None of the above");
	
	createEntry("A triplet code or codon is defined as...", "Three bases in sequence in a DNA strand that codes for particular amino acid","A sequence of triplets that codes for the formation of protein", "A unit of jereditary information located on a chromosome and made of DNA", "None of the above");
	
	createEntry("Coding DNA is defined as...", "DNA in genes that controls protein synthesis", "A sequence of triplets that codes for the formation of protein", "Three bases in sequence in a DNA strand that codes for particular amino acid", "None of the above");

	createEntry("RNA consists of...","A single strand of nucleotides", "A double strand of nucleotides" , "A triple strand of nucleotides", "None of the above");
	
	createEntry("What sugar does RNA consist of?", "Ribose", "Glucose", "Fructose", "Galactose");
	
	createEntry("What bases does RNA consist of?","Adenine, uracil, guanine, cystosine", "Adenine","Adenine, guanine, cystosine, thymine", "Thymine, uracil, cystosine");
	
	createEntry("Which of the following is NOT a difference between DNA and RNA?", "RNA is double-stranded while DNA is single-stranded", "RNA has the sugar ribose and the base uracil", "RNA is single-stranded while DNA is double-stranded", "DNA has deoxyribose and thymine");
	
	createEntry("What are the three types of RNA?", "Messenger mRNA, Ribosomal rRNA, Transfer tRNA", "Ribosomal rRNA, Transfer tRNA" , "Messenger mRNA, Ribosomal rRNA",  "Messenger mRNA, Ribosomal rRNA, Transfer tRNA, Synthesis sRNA");
	
	createEntry("At what stage of the cell cycle does DNA replication take place?", "Interphase", "Prophase", "Anaphase", "Telephase");
	
	createEntry("Which of the following is not a stage in DNA replication?", "All answers are valid stages of DNA replication", "Double helix unwinds and strands separate", "Free nucleotides link up with the matching exposed bases on each strand", "New complementary strands are formed alongside the old strands");
	
	createEntry("DNA profiling is defined as...", "The making of a patern of fragments of DNA for comparison", "Categorising nucleotides in a subject's DNA", "A stage of DNA replication", "The conversion of DNA to RNA");
	
	createEntry("Genetic screening is...", "The testing for the presence or absence of a particular gene(s)", "The making of a patern of fragments of DNA for comparison", "Manipulation and alteration of genes or genotype", "A stage of DNA replication");
	
	createEntry("In DNA profiling, what is used to extract DNA from the cell?", "Restriction enzymes", "Bacteria", "RNA", "Phospholipids");
	
	createEntry("In DNA profiling, how are the extraced fragments separated?", "By size", "By colour", "By scent", "None of the above");
	
	createEntry("Which of the following is not an application of genetic engineering?", "All given answers are valid", "Production of weed killer resistant crop plants", "Human blood-clotting factor VIII produced in sheep's milk", "Human insulin produced by bacteria");
	
	createEntry("Which of the following is the correct order of steps taken in the process of genetic engineering?", "Isolation, Cutting, Insertion, Transformation, Expression", " Cutting, Isolation, Insertion, Transformation, Expression", "Isolation, Cutting, Transformation, Insertion, Expression", "Insertion, Expression, Isolation, Cutting, Transformation");
	
	createEntry("Which of the following is a cause of genetic variation?", "Sexual reproduction/Mutation", "Contraception", "Respiration", "DNA Profiling");
	
	createEntry("A mutation is...", "A change in genetic material", "DNA replication", "A part of DNA profiling", "The breaking down of DNA");
	
	createEntry("Which of the following may cause a mutation to occur?", "All answers may cause a mutation to occur", "Cigarette Smoke", "Viruses", "Radiation, e.g. x-rays");
	
	createEntry("Evolution is defined as...", "The change in species or organisms over long periods of time", "The controlled alteration of a particular organism's DNA", "The sexual reproduction of organisms and plants", "None of the above");
	
	createEntry("What causes evolution to occur?", "Natural selection in response to a change in the environment", "Genetic engineering", "Protein synthesis", "None of the above");
	
	createEntry("Name the two scientists who are associated with the theory of of evolution and natural selection", "Charles Darwin and Alfred Russel Walace", "Albert Einstein and Isaac Newton", "Marie Curie and Gregor Mendel", "Max Born and Galileo Galilei");
	
	createEntry("In the theory of evolution, it is observed that...", "Species have a high reproductive rate, population numbers remain more or less the same, and there is a high death rate among offspring", "Species have a low reproductive rate, population numbers tend to increase continuously, and there is a low death rate among offspring", "Species have a high reproductive rate, population numbers remain more or less the same, and there is a high death rate among offspring", "None of the above");
	
	createEntry("In the thoery of evolution, the struggle for existence is caused by competition for...", "Food, shelter, and a mate", "Food", "Food and shelter", "Shelter and a mate");
	
	createEntry("Fill in the blank: ____ occur within a species so that some individuals are better suited to the conditions that others", "Variations", "Deaths", "Reproductions", "Wars");
	
	createEntry("The individuals with the more favourable variations....", "Live longer and have more offspring than those less adapted", "Live shorter and have more offspring than those less adapted", "Live longer and have less offspring than those less adapted", "The favourable variations have no effect");
	
	createEntry("Which of the following is valid evidence for evolution?", "All answers provide valid evidence for evolution" ,"Comparative anatomy", "Fossils, e.g. the horse", "Comparative embryology");
	
	createEntry("Genetics is defined as...", "The study of heredity and variation", "The passing on of characteristics from parents to offspring", "The differences between members of a species", "A unit of heredity, composed of DNA");
	
	createEntry("Heredity is defined as...","The passing on of characteristics from parents to offspring", "The study of heredity and variation", "The differences between members of a species", "A unit of heredity, composed of DNA");

	createEntry("Variation is defined as...","The differences between members of a species","The passing on of characteristics from parents to offspring", "The study of heredity and variation",  "A unit of heredity, composed of DNA");

	createEntry("Species is defined as...","Organisms capable of interbreeding and producing fertile offspring","The passing on of characteristics from parents to offspring", "The study of heredity and variation",  "A unit of heredity, composed of DNA");

	createEntry("A gene is defined as...", "A unit of heredity, composed of DNA", "The differences between members of a species","The passing on of characteristics from parents to offspring", "The study of heredity and variation");

	createEntry("A locus is defined as...", "The position of a gene on a chromosome", "The differences between members of a species","The passing on of characteristics from parents to offspring", "The study of heredity and variation");

	createEntry("Alleles is defined as...", "Alternative forms of the same gene", "The differences between members of a species","The passing on of characteristics from parents to offspring", "The study of heredity and variation");

	createEntry("A genotype is defined as...", "The genetic make-up of an organism", "The differences between members of a species","The passing on of characteristics from parents to offspring", "The study of heredity and variation");

	createEntry("A phenotype is defined as...", "The visible expression of the genotype", "The differences between members of a species","The passing on of characteristics from parents to offspring", "The study of heredity and variation");

	createEntry("A dominant gene is defined as...", "An allele that is expressed when it is homozygous and heterozygous", "An allele that is only expressed when it is homozygous","The passing on of characteristics from parents to offspring", "The study of heredity and variation");

	createEntry("A recessive gene is defined as...", "An allele that is only expressed when it is homozygous", "An allele that is expressed when it is homozygous and heterozygous","The passing on of characteristics from parents to offspring", "The study of heredity and variation");

	createEntry("Homozygous is defined as...", "A pair of identical alleles (genes) for a characteristic", "A pair of different alleles (genes) for a characteristic","The passing on of characteristics from parents to offspring", "The study of heredity and variation");

	createEntry("Heterozygous is defined as...", "A pair of different alleles (genes) for a characteristic","A pair of identical alleles (genes) for a characteristic", "The passing on of characteristics from parents to offspring", "The study of heredity and variation");

	createEntry("Gametes are defined as...", "Haploid sex cells (male & female) that fuse during sexual reproduction to form a diploid zygote ","A pair of identical alleles (genes) for a characteristic", "The passing on of characteristics from parents to offspring", "The study of heredity and variation");

	createEntry("The 1st law of segregation states that...", "Characteristics are controlled by a pair of genes that separate during gamete formation - only one factor of each pair is present in a gamete", "During gamete formation, either one of a pair of allesls may enter a gamete with either one of another pair of alleles", "Characteristics are controlled one factor only", "None of the above");
	
	createEntry("Linked genes are...", "Genes on the same chromosome that are inherited together", "Genes on different chromosomes that are inherited separately", "Genes on the same chromosome that are inherited separately", "Genes ones on the same chromosome that are inherited together");
	
	createEntry("Do linked genes obey Mendel's 2nd law?", "No", "Yes", "Sometimes", "");
	
	createEntry("Sex-linked genes are...", "Genes carried on the sex chromosomes, usually on the X chromosome, e.g. Colour vision", "Genes carried on normal chromosomes, usually on the X chromosome, e.g. Colour vision", "Genes on the same chromosome that are inherited separately", "Genes ones on the same chromosome that are inherited together");
	
	createEntry("Non-nuclear DNA is...", "DNA found in the mitochondria and chloroplasts", "DNA found in the nucleus", "DNA found in the nucleus and ribosomes", "None of the above");
	
	//Classification or organisms/Viruses/Bacteria/Fungi (190)
	
	createEntry("What part of the animal kingdom are unicellular bacteria apart of?", "Monera", "Animal", "Protoctista", "Fungi");
	
	createEntry("What part of the animal kingdom are amoeba apart of?", "Protoctista", "Monera", "Animal",  "Fungi");

	createEntry("What part of the animal kingdom are mushrooms and yeast apart of?", "Fungi", "Monera", "Animal", "Protoctista");

	createEntry("What part of the animal kingdom are humans apart of?","Animal", "Monera",  "Protoctista", "Fungi");

	createEntry("What part of the animal kingdom are flowering plants apart of?", "Plant", "Animal", "Protoctista", "Fungi");

	createEntry("Which of the following is NOT a feature of monocotyledons?", "Two cotyledons", "One cotyledon", "Parallel venation in leaves", "Herbaceous");
	
	createEntry("Which of the following is NOT a feature of Dicotyledons?", "Parallel venation in leaves", "Ring of vascular bundles", "Two cotyledons", "Reticulate venation in leaves");
	
	createEntry("Which of the following is NOT a valid shape for a virus?", "All answers are valid", "Rod", "Spherical", "Complex");
	
	createEntry("Which of the following is NOT a non-living feature of a virus", "All answers are valid", "Non-cellular", "No cell organelles", "Consist of only one nucleic acid (DNA or RNA) inside a protein coat");
	
	createEntry("Select the correct order of steps for viral replication", "Virus attaches to host, injects nucleic acid, protein coat formed, nucleic acid replicates, new viruses formed, host cell bursts releasing the new viruses", "Virus attaches to host, injects nucleic acid, nucleic acid replicates, protein coat formed,  new viruses formed, host cell bursts releasing the new viruses", "Virus attaches to host,  nucleic acid replicates, protein coat formed, injects nucleic acid, new viruses formed, host cell bursts releasing the new viruses", "Virus attaches to host, injects nucleic acid, protein coat formed, host cell bursts releasing the new viruses nucleic acid replicates, new viruses formed");

	createEntry("Name a beneficial effect of viruses", "Formation of vaccines", "Polio and Aids", "Foot and mout", "Tomao mosaic disease");
	
	createEntry("Which of the following is NOT a valid shape for bacteria?", "All answers are valid", "Round (coccus)", "Rod", "Spiral");

	createEntry("How do bacteria reproduce?", "Asexually by binary fission", "Sexually", "Sexually and asexually", "Bacteria do not reproduce, they grow from dead matter");
	
	createEntry("Endospores are...", "Resistant, thick-walled spores formed within the cell under adverse conditions", "Fragile, think-walled spores formed withing the cell under favourable conditions", "Fragile, thick-walled spores formed within the cell under adverse conditions", "None of the above");
	
	createEntry("How do autotrophic bacteria obtain their nutrition?", "They make their own food (photosynthetic/chemosynthetic", "Via parasitic/saprophytic means", "Bacteria do not require any nutrition", "None of the above");
	
	createEntry("How do heterotrophic bacteria obtain their nutrition?", "Via parasitic/saprophytic means", "They make their own food (photosynthetic/chemosynthetic", "Bacteria do not require any nutrition", "None of the above");
	
	createEntry("Select the correct order of the growth curve of bacteria in culture", "Lag, Log, Stationary, Decline, Survival", "Log, Lag, Stationary, Decline, Survival", "Log, Survival, Decline, Lag, Stationary", "Stationary, Log, Decline, Survival, Lag");

	createEntry("Which of the following is a factor affecting the growth of cultured bacteria?", "All answers are valid", "Temperature and pH", "Oxygen concentration", "External solute concentration and pressure");
	
	createEntry("What is the difference between batch and continuous flow processing?", "Fixed amount of nutrient in batch processing - Nutrient constantly added in continuous flow", "Fixed amount of nutrient in continuous flow processing - Nutrient constantly added in batch processing", "There is no difference between either method", "None of the above");
	
	createEntry("What are antibiotics?", "Chemicals produced by fungi and bacteria that inhibit or kill other bacteria", "Chemicals produced by viruses that kill fungi and bacteria", "Chemicals produced by fungi and bacteria that inhibit or kill viruses", "Chemicals produced by fungi and bacteria that promote the growth of bacteria");
	
	createEntry("Which of the following is a benefit of bacteria", "Production of antibiotics", "Tetanus", "Food decay", "Tonsillitis");
	
	createEntry("Which of the following is a harmful effect of bacteria", "Human disease", "Food", "Vitamins in the human large intestine", "Production of antibiotics");
	
	createEntry("How do antibiotic resistant pathogenic bacteria come about?", "Over-exposure to to an antibiotic, mutant antibiotic strains prosper", "Under-exposure to to an antibiotic, mutant antibiotic strains prosper", "None of the above", "They don't");
	
	createEntry("Rhizopus is...", "A saprophytic fungus found on bread and other starchy foods", "A type of bacteria found in decaying organic matter", "A type of virus transfered via sexual intercourse", "None of the above");
	
	createEntry("Select the correct order of steps that occurs in the asexual reproduction of Rhizopus", "Sporangiophores grow upwards - sporangia form - spores formed by mitosis are released and dispered - spores germinate forming new mycelia", "Sporangia form - spores formed by mitosis are released and dispered - sporangiophores grow upwards - spores germinate forming new mycelia", "Spores germinate forming new mycelia - spores formed by mitosis are released and dispered - sporangiophores grow upwards - sporangiophores grow upwards", "Spores formed by mitosis are released and dispered - sporangiophores grow upwards - sporangiophores grow upwards");
	
	createEntry("Yeast is a...", "A unicellular saprophytic fungus", "A multicellular bacteria" , "A unicellular saprophytic virus", "A multicellular virus");
	
	createEntry("Yeast reproduces...", "Asexually by budding", "Sexually", "Sexually by budding", "Asexually");
	
	createEntry("Select the correct series of steps for the reproduction of yeast", "Nucleus divides by mitosis - One nucleus moves into the bud - Bud is cut off forming a new cell", "One nucleus moves into the bud - Bud is cut off forming a new cell", "Nucleus divides by mitosis -One nucleus moves into the bud - Bud is cut off forming a new cell", "Bud is cut off forming a new cell - Nucleus divides by mitosis - One nucleus moves into the bud");
	
	createEntry("Which of the following is an economic importance of fungi?", "Production of antibiotics, e.g. penicillin", "Ringworm", "Thrush", "Athletes foot");
	
	createEntry("Which of the following is a harmful effect of fungi?", "Diseases in humans",  "Production of antibiotics", "Production of alcohol by yeast", "Bread making");
	
	createEntry("What is osmoregulation in amoeba?", "The maintanence of the H2O balance in the cytoplasm of the amoeba", "The maintance of the O2 levels in the cytoplasm of the amoeba", "None of the above", "The consumption of H2O by an amoeba");
	
	//Flowering Plant Structure (221)
	
	createEntry("What are the functions of the roots?", "Anchor plant, absorb H2O & minearals, food storage", "Photosynthesis, transpiration, food storage", "Support leaves + flowers, transport of minears/food/H2O", "Sexual reproduction");
	
	createEntry("What are the functions of the stems?","Support leaves + flowers, transport of minears/food/H2O", "Anchor plant, absorb H2O & minearals, food storage", "Photosynthesis, transpiration, food storage",  "Sexual reproduction");

	createEntry("What are the functions of the leaves?", "Photosynthesis, transpiration, food storage", "Support leaves + flowers, transport of minears/food/H2O","Anchor plant, absorb H2O & minearals, food storage",  "Sexual reproduction");

	createEntry("What are the functions of the buds?", "Growth of main stem + side branches, formation of flowers, food storage", "Photosynthesis, transpiration, food storage", "Support leaves + flowers, transport of minears/food/H2O", "Sexual reproduction");

	createEntry("What are the functions of the flowers?", "Sexual reproduction", "Anchor plant, absorb H2O & minearals, food storage", "Photosynthesis, transpiration, food storage", "Support leaves + flowers, transport of minears/food/H2O");

	createEntry("What is a meristem?", "A region of mitotic division in plants found in the shoot tip and root tip", "A region of mitotic division in plants found in the roots and stem", "A region of mitotic division in plants found in the flower petals", "A region of mitotic division in plants found only in the shoot tip");
	
	createEntry("Dermal tissue...", "Forms the outer epidermis for protection", "Lies between the dermis and vascular bundles for storage and packing", "Consists of xylem and phloem in vascular bundles for transport", "None of the above");
	
	createEntry("Ground tissue...", "Lies between the dermis and vascular bundles for storage and packing","Forms the outer epidermis for protection",  "Consists of xylem and phloem in vascular bundles for transport", "None of the above");

	createEntry("Vascular tissue...", "Consists of xylem and phloem in vascular bundles for transport", "Forms the outer epidermis for protection", "Lies between the dermis and vascular bundles for storage and packing", "None of the above");

	createEntry("What are the function(s) of xylem?", "Transport of water + minerals and mechanical support", "The transport of food from leaves to the rest of the plant (translocation)", "Transport of water only", "Mechanical support only");
	
	createEntry("What does phloem consist of?", "Sieve tubes and companion cells", "Epidermus", "Vascular tissue", "Xylem");
	
	createEntry("What is the difference between xylem vessels and xylem tracheids?", "Xylem vessel has no end wall, tracheids do", "Vessels have a thick lignified wall, tracheids don't", "Tracheid have pits, vessels do not", "There is no difference");
	
	createEntry("What adaption do root hairs have to increase water absorbtion?", "Large surface area", "Small surface area", "Root hairs do not absorb water", "Short root hairs");
	
	createEntry("What helps in the upward movement of H2O in xylem of plants?", "Root pressure and transpiration", "Transpiration only", "Root pressure only", "Phloem");
	
	createEntry("Transpiration is defined as...", "The loss of H2O vapour from a plant", "The force due to the intake of H2O that pushes H2O up the xylem", "The transport of water and minerals", "The conversion of CO2 to O2 by plants");
	
	createEntry("Root pressure is...", "The force due to the intake of H2O that pushes H2O up the xylem", "The loss of H2O vapour from a plant", "The transport of water and minerals", "The conversion of CO2 to O2 by plants");
	
	createEntry("In plants, carbohydrate is stored as...", "Starch", "Amylose", "Glycogen", "Plants do not store carbohydrates");

	createEntry("In plants oxygen is either...", "Used in plant respiration or it may diffuse out via the stomata", "Used in plant photosynthesis or it may diffuse out via the stomata", "Used in photosynthesis only", "It only diffuses out via the stomata");
	
	createEntry("Give an example of a modified root that stores food in plants", "Tap root in carrots", "Stem tuber in potatos", "Bulb in onions", "Chestnut in oak tree");
	
	createEntry("Give an example of a modified stem that stores food in plants", "Stem tuber in potatos","Tap root in carrots",  "Bulb in onions", "Chestnut in oak tree");

	createEntry("Give an example of a modified leaf that stores food in plants", "Bulb in onions","Stem tuber in potatos", "Tap root in carrots",   "Chestnut in oak tree");

	createEntry("Which of the following is an adaptation in leaves for gas exchange?", "All answers are valid", "Large number of stomata", "Large surface area", "Thin leaves");
	
	createEntry("What are lenticels?", "The openings in bark of woody stems for the exchange of gases", "The openings in the epidermis of leaves for gas exchange", "A type of food produced by plants", "None of the above");
	
	createEntry("What do guard cells do?", "They control the opening and closing of the stomata in leaves", "They regulate the entry of water through the root hairs", "They prevent the leakage of H2O and minerals from the xylem and phloem in the stem", "All answers are valid");
	
	//(247)
	
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
