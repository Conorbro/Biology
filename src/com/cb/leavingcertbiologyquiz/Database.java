package com.cb.leavingcertbiologyquiz;

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

	
	public static final String DATABASE_NAME = "QnAdb"; //Database name
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
	
	ourDatabase.beginTransaction();	
		
	//Section (Number of questions)
		
	//1. Characteristics of Life/Food (30)
		
	createEntry("What are the 7 characteristics of life?", "Organisation Nutrition Excretion Response Movement Growth Reproduction", "Nutrition Excretion Response Movement Digestion Growth Reproduction", "Organisation Nutrition Excretion Response Movement Growth Sex", "Nutrition Excretion Response Movement Growth Reproduction Immune System");

	createEntry("What is the  function of food?", "To provide energy and materials for the growth and repair of cells", "To stave off hunger", "To wake the body up", "To taste nice");

	createEntry("What are the 6 elements in food?", "Carbon hydrogen oxygen nitrogen sulphur phosphorus", "Carbon hydrogen oxygen nitrogen sulphur magnesium", "Carbon hydrogen oxygen nitrogen sulphur calcium", "Carbon hydrogen oxygen nitrogen sulphur sodium");

	createEntry("What are the 7 biomolecular components of food?", "Carbohydrates proteins lipids vitamins minerals water", "Carbohydrates proteins lipids saturates minerals water", "Carbohydrates proteins fats vitamins minerals water", "Lignin proteins lipids vitamins minerals water" );

	createEntry("What do carbohydrates consist of?", "Carbon hydrogen oxygen", "Carbon hydrogen nitrogen", "Hydrogen nitrogen sulphur", "Carbon nitrogen sulphur");

	createEntry("What do monosaccharides consist of?", "One sugar unit e.g. glucose", "Two sugar units e.g. sucrose", "Many sugar units e.g. starch", "Zero sugar units");

	createEntry("What do disaccharides consist of?", "Two sugar units e.g. sucrose","One sugar unit e.g. glucose","Many sugar units e.g. starch","Zero sugar units");

	createEntry("What do polysaccharides consist of?", "Many sugar units e.g. starch","One sugar unit e.g. glucose","Two sugar units e.g. starch","Zero sugar units");

	createEntry("Select the correct source for carbohydrates", "Meat fish eggs", "Fruits", "Water", "Vitamins");

	createEntry("What are the 4 primary elements of proteins?", "Carbon hydrogen oxygen nitrogen", "Carbon hydrogen nitrogen sulphur", "Carbon nitrogen sulphur boron", "Carbon nitrogen sulphur lithium");

	createEntry("Select the correct source for proteins",  "Meat fish eggs", "Fruits", "Water", "Vitamins minerals");

	createEntry("What do lipids consist of?", "Carbon hydrogen oxygen in the ratio 2H:10", "Carbon hydrogen oxygen in the ratio 1H:20", "Carbon hydrogen oxygen in the ratio 3H:10", "Carbon hydrogen oxygen in the ratio 1H:10"); 
	 
	createEntry("Fats are...", "Solid at room temperature", "Liquid at room temperature", "Gas at room temperature", "Undefined at room temperature");

	createEntry("Oils are…", "Liquid at room temperature","Solid at room temperature", "Gas at room temperature", "Undefined at room temperature");

	createEntry("The basic of unit of a lipid is…", "Triglyceride", "Phospholipid", "Fat", "Oil");

	createEntry("Select the correct source for lipids",  "Vegetables", "Fruits", "Butter, oil, meat, cheese", "Vitamins minerals");

	createEntry("What are the structural roles of carbohydrates?", "Cellulose in plant cell wall/ chitin in cell wall of fungi", "Collagen in skin/myosin in muscle", "Phospholipids in cell membranes", "Muscle tissue");

	createEntry("What are the structural roles of protein?", "Collagen in skin/myosin in muscle", "Cellulose in plant cell wall/ chitin in cell wall of fungi", "Phospholipids in cell membranes", "Muscle tissue");

	createEntry("What are the structural roles of lipids?", "Phospholipids in cell membranes", "Cellulose in plant cell wall/ chitin in cell wall of fungi", "Collagen in skin/myosin in muscle", "Muscle tissue");

	createEntry("What are the metabolic roles of carbohydrates?", "Release of energy (glucose)", "Storage of energy (starch in plants, glycogen in animals)", "Formation of enzymes and hormones", "Release and storage of energy");

	createEntry("What are the metabolic roles of proteins?","Storage of energy (starch in plants, glycogen in animals)",  "Release of energy (glucose)", "Formation of enzymes and hormones", "Release and storage of energy");

	createEntry("What are the metabolic roles of lipids?","Storage of energy (starch in plants, glycogen in animals)",  "Release of energy (glucose)", "Formation of enzymes and hormones", "Release and storage of energy");

	createEntry("What are the metabolic roles of vitamin D?","Absorption of calcium",  "Release of energy (glucose)", "Formation of enzymes and hormones", "Release and storage of energy");

	createEntry("What are the metabolic roles of vitamin C?","Formation of skin and blood vessels",  "Release of energy (glucose)", "Formation of enzymes and hormones", "Release and storage of energy");

	createEntry("What disease is caused by a Vitamin C deficiency?", "Scurvy", "Rickets in children", "Aids", "The flu");

	createEntry("What disease is caused by a Vitamin D deficiency?", "Rickets in children", "Scurvy", "Aids", "The flu");

	createEntry("What is the role of calcium in plants?", "Formation of middle lamella between plant cell walls", "Formation of chlorophyll", "Formation of haemoglobin", "Formation of leafs and flower");

	createEntry("What is the role of magnesium in plants?", "Formation of chlorophyll", "Formation of middle lamella between plant cell walls", "Formation of haemoglobin", "Formation of leafs and flower");

	createEntry("What is the role of calcium in animals?", "Formation of bones and teeth", "Formation of skin and hair", "Formation of haemoglobin", "Formation of claws and nails");

	createEntry("What is the role of iron in animals?", "Formation of haemoglobin", "Formation of skin and hair", "Formation of bones and teeth", "Formation of claws and nails");

	//2.Ecology (48) (31)
	
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
	
	//The Heart and Circulatory system (245)
	
	createEntry("In blood, plasma is...", "The liquid part of blood", "Colourless, nucleus containing cell that defends against disease" , "No nucleus, cell fragments that clot the blood", "Bi-concave, haemoglobin containing, no nucleus or mitochondria cell that transports O2");
	
	createEntry("In blood, red blood cells are...", "Bi-concave, haemoglobin containing, no nucleus or mitochondria cell that transports O2", "The liquid part of blood", "Colourless, nucleus containing cell that defends against disease" , "No nucleus, cell fragments that clot the blood");

	createEntry("In blood, white blood cells are...", "Colourless, nucleus containing cell that defends against disease" ,"Bi-concave, haemoglobin containing, no nucleus or mitochondria cell that transports O2", "The liquid part of blood",  "No nucleus, cell fragments that clot the blood");

	createEntry("In blood, platelets are...",  "No nucleus, cell fragments that clot the blood", "Colourless, nucleus containing cell that defends against disease" ,"Bi-concave, haemoglobin containing, no nucleus or mitochondria cell that transports O2", "The liquid part of blood");

	createEntry("Which of the following are the correct blood groups?", "A B AB O", "A B" , "A B O C", "AB BA OA B");
	
	createEntry("Select the correct order in which blood flows around the body", "Heart - arteries - arterioles - capillaries - venules - veins - heart", "Heart - arterioles - arteries - veins - venules - capillaries - heart", "Heart - veins - venules - capillaries - arterioles - arteries - heart", "Heart - capillaries - venules - arteries - arterioles - veins - heart");
	
	createEntry("Where does blood flow in the pulmonary system?", "Heart - Lungs - Heart", "Heart - Liver - Heart", "Heart - Rest of body - Heart", "Heart - Heart");
	
	createEntry("Where does blood flow in the systemic system?", "Heart - Rest of body - Heart","Heart - Lungs - Heart", "Heart - Liver - Heart",  "Heart - Heart");

	createEntry("Which of the following statements is correct in regards to blood flow?", "Arteries carry blood away from the heart at high pressure", "Arteries carry blood to the heart at high pressure", "Arteries carry blood to the heart at low pressure", "Arteries carry blood away from the heart at low pressure");
	
	createEntry("Which of the following statements is correct in regards to blood flow?", "Veins carry blood to the heart at low pressure","Veins carry blood away from the heart at high pressure", "Veins carry blood to the heart at high pressure",  "Veins carry blood away from the heart at low pressure");
	
	createEntry("Do arteries and/or veins have valves?", "Only veins have valves present", "Bot arteries and veins have valves present", "Only arteries have valves present", "Neither contain valves");
	
	createEntry("Which of the following statements is correct?", "Arteries have a thick layer of muscle and a small lumen while veins have a thin layer of muscle and a large lumen", "Arteries have a thin layer of muscle and a small lumen while veins have a thick layer of muscle and a large lumen", "Arteries have a thick layer of muscle and a large lumen while veins have a thin layer of muscle and a small lumen", "Arteries have a thick layer of muscle and no lumen while veins have a thin layer of muscle and a large lumen");
	
	createEntry("What are capillaries?", "Tiny tubes that link arterioles to venules and allow exchange between blood and tissues", "Large tubes that link veins to arteries", "Small tubes that link arteries to arterioles and allow exchange between blood and tissues", "None of the above");
	
	createEntry("Capillaries are consist of...", "Thin, porous walls to allow materials in and out", "Thick impermeable walls", "Thick, porous walls that do not allow materials in and out", "Thin impermeable walls");
	
	createEntry("During the cardiac cycle, diastole is when the heart muscle is...", "Relaxed" , "Contracted", "Taught", "Open");
	
	createEntry("During the cardiac cycle, systole is when the heart muscle is...", "Contracted","Relaxed" , "Taught", "Open");

	createEntry("Where is the sinoatrial node located in the heart?", "In the wall of the right atrium", "In the wall of the left atrium", "In the vena cava", "In the septum");
	
	createEntry("What controls the controls heartbeat?", "The sinoatrial node", "Septum", "Tricuspid valve", "Chordae tendinae");
	
	createEntry("Which of the following factors does NOT affect heart rate?", "All answers are valid", "Exercise", "Fear", "Sleep");
	
	createEntry("What is blood pressure?", "The force of blood pushing against the wall of a blood vessel", "The wave of vibrations in arteries due to blood pbeing forced out of the ventricles", "The oxygen in moving around in blood", "None of the above");
	
	createEntry("What is pulse?","The wave of vibrations in arteries due to blood pbeing forced out of the ventricles", "The force of blood pushing against the wall of a blood vessel",  "The oxygen in moving around in blood", "None of the above");
	
	createEntry("What do the coronary arteries do?", "Supply blood to cardiac muscle", "Move blood from atriums to ventricles in the heart", "Supply blood to the brain", "Supply blood to the liver");
	
	createEntry("What is lymph?", "A colourless fluid formed from tissue fluid consisting of plasma and lymphocytes", "The force of blood pushing against the wall of a blood vessel", "The wave of vibrations in arteries due to blood pbeing forced out of the ventricles", "The oxygen in moving around in blood");
	
	createEntry("What is the lymphatic system?", "A one-way system that consists of lymph vessels and lymph nodes containing valves to prevent backflow of lymph", "None of the above", "A two-way system that consists of lymph vessels and lymph nodes containing valves to prevent backflow of lymph", "A three-way system that consists of lymph vessels and lymph nodes containing valves to prevent backflow of lymph");
	
	createEntry("What are the functions of the lymphatic system?", "Transport of tissue fluid to return it to the blood and defence against disease", "To regulate body temperature", "To optimise enzyme action", "To assist in digestion");
	
	//Human Nutrition and Human Excretion (270)
	
	createEntry("Select the correct order of stages of human nutrition", "Ingestion, Digestion, Absorption, Egestion", "Egestion, Absorption, Digestion, Ingestion", "Absorption, Digestion, Egestion, Ingestion", "Egestion, Absorption, Ingestion, Digestion");
	
	createEntry("What carries out mechanical digestion in humans?", "Teeth and stomach", "Enzymes", "Liver", "Throat");
	
	createEntry("What carries out chemical digestion in humans?", "Enzymes", "Teeth and stomach", "Throat", "Liver");
	
	createEntry("What is the function of the epiglottis in digestive system?", "Prevents food from entering the trachea", "Churns food", "Cuts, chews, and grinds food up into smaller pieces", "Storage of bile");
	
	createEntry("What is the function of the teeth in digestive system?", "Cuts, chews, and grinds food up into smaller pieces","Prevents food from entering the trachea", "Churns food",  "Storage of bile");

	createEntry("What is the function of the liver in digestive system?", "Produces bile which emulsifies lipid and neutralises acid","Prevents food from entering the trachea", "Churns food",  "Storage of bile");

	createEntry("What is the function of the gall bladder in digestive system?","Storage of bile", "Cuts, chews, and grinds food up into smaller pieces","Prevents food from entering the trachea", "Churns food");

	createEntry("What is the function of the illeum in the small intestine in digestive system?","Abosrbs nutrients from food", "Cuts, chews, and grinds food up into smaller pieces","Prevents food from entering the trachea", "Churns food");

	createEntry("What is the function of the anus in digestive system?", "Egestion", "Digestion","Prevents food from entering the trachea", "Churns food");

	createEntry("What is the function of the rectum in digestive system?", "Stores faeces", "Egestion", "Digestion","Prevents food from entering the trachea");

	createEntry("What is the function of the colon in digestive system?","Absorbs H2O, symbiotic bacteria produce vitamins and kill pathogenic bacteria also" ,"Stores faeces", "Egestion", "Digestion");

	createEntry("What is the function of the pancreas in digestive system?", "Neutralises acidic food", "Egestion", "Churns food", "Digestion");
	
	createEntry("What is the function of the oesophagus in digestive system?", "Moves food down into the stomach","Prevents food from entering the trachea", "Churns food",  "Storage of bile");

	createEntry("What is the function of the stomach in digestive system?","Churns food, mucus lining protects stomach, pepsin turns proteins into peptides", "Cuts, chews, and grinds food up into smaller pieces","Prevents food from entering the trachea",   "Storage of bile");

	createEntry("What is the role of fibre in the diet?", "Stiumates peristalsis", "Produces bile and heat", "Produces urea from the breakdown of excess amino acids", "Breaks down red blood cells and toxic chemicals taken from the blood");
	
	createEntry("Which of the following is NOT a function of the liver?", "Stiumates peristalsis", "Produces bile and heat", "Produces urea from the breakdown of excess amino acids", "Breaks down red blood cells and toxic chemicals taken from the blood");
	
	createEntry("Where does the hepatic artery carry blood to and from?", "From the aorta to the liver", "From the liver to the vena cava", "From the gut to the liver", "None of the above");
	
	createEntry("Where does the hepatic vein carry blood to and from?","From the liver to the vena cava", "From the aorta to the liver",  "From the gut to the liver", "None of the above");

	createEntry("Where does the hepatic portal vein carry blood to and from?", "From the gut to the liver",  "From the aorta to the liver", "From the liver to the vena cava","None of the above");
	
	createEntry("Which of the following is an adaptation of the ileum for the absorption of food?", "All answers are valid", "Long tube with villi gives large surface area for absorption", "Villus walls are very thin and lymph lacteals", "Large network of blood capillaries");
	
	createEntry("What is the human dental formula?", "I 2/2, C 1/1, PM 2/2, M 3/3", "I 1/1, C 1/1, PM 3/3, M 2/2", "I 2/2, C 2/2, PM 3/3, M 2/2 ", "I 3/3, C 2/2, PM 1/1, M 1/1");
	
	createEntry("Excretion is defined as...", "The removal of waste products of metabolism from the body", "The process of treating a substance with heat, enzymes, or a solvent to promote decomposition or extract essential components", "A process in living organisms involving the production of energy, typically with the intake of oxygen and the release of carbon dioxide from the oxidation of complex organic substances", "None of the above");
	
	createEntry("What are the organs of excretion?", "Lungs, kidneys, skin", "Skin, bladder, kidneys", "Bladder, Lungs, Skin", "Lungs and Kidneys");
	
	createEntry("What are/is the major function(s) of the kidneys?", "Exrection and Osmoregualtion", "Excretion only", "Digestion", "Respiration and Osmoregulation");
	
	createEntry("What is osmoregulation?", "The maintenance of water balance and salt balance in body fluids", "The removal of urea, excess salts and salt balance in body fluids", "The production of urea", "Regulation of water pH in the body");
	
	createEntry("What does ADH stand for?", "Anti-diuretic hormone", "Anti-diarrhoea hormone", "Anti-deflamatory hormone", "Anti-death horomone");
	
	createEntry("Where is urine stored?", "The bladder", "Kidneys", "Gall bladder", "Liver");
	
	createEntry("Where is urine formed", "In nephron of the kidneys", "Bladder", "Urethra", "Rectum");
	
	createEntry("What is the function of the larynx?", "Prodcues sound", "Carries air to lungs", "Gas exchange", "Contains mucus which traps dirt and bacteria, cilia that moves mucus up to the mouth and cartilage rings keep air tubes open");
	
	createEntry("What is the function of the larynx?", "Prodcues sound", "Carries air to lungs", "Gas exchange", "Contains mucus which traps dirt and bacteria, cilia that moves mucus up to the mouth and cartilage rings keep air tubes open");

	createEntry("What is the function of the trachea?","Contains mucus which traps dirt and bacteria, cilia that moves mucus up to the mouth and cartilage rings keep air tubes open", "Prodcues sound", "Carries air to lungs", "Gas exchange" );

	createEntry("What is the function of bronchus?","Carries air into the lungs","Contains mucus which traps dirt and bacteria, cilia that moves mucus up to the mouth and cartilage rings keep air tubes open", "Prodcues sound",  "Gas exchange" );

	createEntry("What is the function of the bronchioles?","Carres air to and from the alveoli", "Prodcues sound", "Carries air to lungs", "Gas exchange" );

	createEntry("What is the function of the alveoli?", "Gas exchange","Carres air to and from the alveoli", "Prodcues sound", "Carries air to lungs" );

	createEntry("Which of the following is NOT an adaptation of the alveoli for gas exchange?", "Thick walls", "Large surface area", "Thin walls", "Moist surface");
	
	createEntry("Select the correct order of stages for inhalation in the mechanism of breathing ", "Intercostal muscles contract, rib-cage moves up and out, diaphram contracts + flattens, volume of thorax increases, lung air pressure decreases, air flows into lungs", "Rib-cage moves up and out, diaphram contracts + flattens, volume of thorax increases, lung air pressure decreases, air flows into lungs", "Diaphram contracts + flattens, intercostal muscles contract, rib-cage moves up and out,  volume of thorax increases, lung air pressure decreases, air flows into lungs", "Rib-cage moves up and out, intercostal muscles contract, diaphram contracts + flattens, volume of thorax increases, lung air pressure decreases, air flows into lungs");
	
	createEntry("Select the correct order of stages for exhalation in the mechanism of breathing", "Intercostal muscles relax, rib-cage goes down and in, diaphram relaxes, thorax volum decreases, lung air pressure increases, air is forced out of lungs", "Rib-cage goes down and in, intercostal muscles relax,  diaphram relaxes, thorax volum decreases, lung air pressure increases, air is forced out of lungs", "Intercostal muscles relax, rib-cage goes down and in, diaphram relaxes, lung air pressure increases, thorax volum decreases,  air is forced out of lungs", "Rib-cage goes down and in, diaphram relaxes, thorax volum decreases, lung air pressure increases, air is forced out of lungs, intercostal muscles relax");
	
	createEntry("Which of the following controls the rate of breathing?", "The level of CO2 in the blood", "The level of O2 in the blood", "The level of O2 in the lungs", "The medulla oblongata in the brain");
	
	createEntry("Which of the following controls the centre of breathing?", "The medulla oblongata in the brain", "The level of CO2 in the blood", "The level of O2 in the blood", "The level of O2 in the lungs");
	
	createEntry("What are the symptoms of asthma?", "Shortness of breath, wheezy breathing, coughing", "Smooth, easy breathing", "Sore feet and tennis elbow", "Bad breath");
	
	createEntry("What are the causes of asthma?", "Allergens such as pollen and dust", "Acids", "Drugs", "Breathing in through your mouth rather than your nose");
	
	createEntry("How can asthma be treated?", "Inhaling drugs to dilate the bronchioles", "Inhaling drugs to contract the bronchioles", "Asthma cannot be treated", "Widening the rib-cage");
	
	createEntry("Name the major organs of homeostasis", "Kidney, lungs, liver, skin", "Liver, pancreas, stomach, heart", "Heart, pancreas, liver, brain", "Brain and lungs");
	
	createEntry("What is homeostasis?", "Keeping a constant internal environment in the body to allow cells to carry out normal metabolic activities", "", "", "");
	
	//Human musculoskeletal system + Human nervous system (314)
	
	createEntry("What are the functions of the skeleton?", "Support, protection, movement", "Movement, growth, protection", "Support and protection", "Growth and Support");
	
	createEntry("What does the axial skeleton consist of?", "Skull, vertebrae(33), ribs(12), sternum", "Pectoral and pelvic girdles, arms and legs", "Cervical(7), thoraic(12), lumbar(5), sacrum(5), coccyx(4)", "None of the above");
	
	createEntry("What does the appendicular skeleton consist of?","Pectoral and pelvic girdles, arms and legs", "Cervical(7), thoraic(12), lumbar(5), sacrum(5), coccyx(4)", "Skull, vertebrae(33), ribs(12), sternum",  "None of the above");

	createEntry("What do the vertebrae consist of?","Cervical(7), thoraic(12), lumbar(5), sacrum(5), coccyx(4)", "Skull, vertebrae(33), ribs(12), sternum", "Pectoral and pelvic girdles, arms and legs",  "None of the above");

	createEntry("What is the function of compact bone?", "Strength and rigidity", "Stores fat", "Produces blood cells", "Absorbs shock and reduces friction");
	
	createEntry("What is the function of the medullary cavity?","Stores fat", "Strength and rigidity",  "Produces blood cells", "Absorbs shock and reduces friction");

	createEntry("What is the function of spongy bone?", "Produces blood cells + provides strength and rigidity","Strength and rigidity", "Stores fat",  "Absorbs shock and reduces friction");

	createEntry("What is the function of articular cartilage?", "Absorbs shock and reduces friction", "Strength and rigidity", "Stores fat", "Produces blood cells");

	createEntry("What is the difference between osteoblasts and osteoclasts?", "Osteoblasts help make bone, osteoclasts help break down bone", "Osteblasts help break down bone, osteoclasts help make bone", "There is no difference", "Osteoblasts are only found in human bone unlike osteclasts which are found in all mammals");
	
	createEntry("Give an example of an immovable joint in the human skeletal system", "The skull and the pelvic girdle", "Between the vertebrae", "Hip, shoulder", "Elbow, knee");
	
	createEntry("Give an example of a slightly movable joint in the human skeletal system","Between the vertebrae", "The skull and the pelvic girdle",  "Hip, shoulder", "Elbow, knee");

	createEntry("Give an example of a free moving or synovial joint joint in the human skeletal system", "Hip, shoulder", "The skull", "Between the vertebrae", "Pelvic girdle");
	
	createEntry("Ligaments connect...", "Bone to bone", "Muscle to bone", "Vessels to bone", "Vessels to arteries");
	
	createEntry("Tendons connect...", "Muscle to bone","Bone to bone",  "Vessels to bone", "Vessels to arteries");

	createEntry("What are an antagonistic pair of muscles?", "A pair of muscles that have opposite effects", "A pair of muscles that have the same effects", "A pair of muscles that can't move without the other moving", "None of the above");
	
	createEntry("Give an example of a pair of antagonistic muscles", "Biceps and triceps", "Triceps and glutes", "Glutes and calves", "Calves and biceps");
	
	createEntry("Which of the following is a disorder of the musculoskeletal system?", "Osteoporosis", "Asthma", "AIDS", "Ebola");
	
	createEntry("What causes osteoporosis?", "All answers are valid","Lack of calcium", "Lack of exercise", "Aging");
	
	createEntry("How could one prevent getting osteoporosis?", "By having a calcium rich diet and exercising", "Avoiding calcium in their diet", "Sitting down all day watching tv", "Eating carrots");
	
	createEntry("How can osteoporosis be treated?", "With a calcium rich diet, vitamin D and medication", "Avoiding exercise", "Avoiding calcium and vitamin D", "It cannot be treated");
	
	createEntry("What does CNS stand for?", "Central Nervous System", "Control Nervous System", "Canal Nervous System", "Cerebellum Nervous System");
	
	createEntry("What does PNS stand for?", "Peripheral Nervous System", "Primary Nervous System", "Positional Nervous System", "Passive Nervous System");
	
	createEntry("What does the central nervous system consist of?", "The brain and spinal cord", "Cranianl nerves and spinal nerves", "Brain only", "Spinal cord only");
	
	createEntry("What does the peripheral nervous system consist of?", "Cranianl nerves and spinal nerves", "The brain and spinal cord",  "Brain only", "Spinal cord only");

	createEntry("What is the function of dendrites in a nerve cell?", "To carry impulses to the body", "Produces neurotransmitter", "Carries impulses from cell body", "Protects axon and accelerates impulse transmission");
	
	createEntry("What is the function of the cell body in a nerve cell?",  "Produces neurotransmitter","To carry impulses to the body", "Carries impulses from cell body", "Protects axon and accelerates impulse transmission");

	createEntry("What is the function of axons in a nerve cell?","Carries impulses from cell body", "To carry impulses to the body", "Produces neurotransmitter",  "Protects axon and accelerates impulse transmission");

	createEntry("What is the function of schwann cells in a nerve cell?", "Produces myelin sheath", "Produces neurotransmitter", "Carries impulses from cell body", "Protects axon and accelerates impulse transmission");

	createEntry("What is the function the myelin sheath in a nerve cell?", "Protects axon and accelerates impulse transmission", "To carry impulses to the body", "Produces neurotransmitter", "Carries impulses from cell body");

	createEntry("What does a motor neuron do?", "Carries impulses from the central nervous system to the muscles and glands", "Carries impulses to the central nervous system from the sensory cells", "Links two neurons within the central system", "Nothing");
	
	createEntry("What does a sensory neuron do?", "Carries impulses to the central nervous system from the sensory cells","Carries impulses from the central nervous system to the muscles and glands",  "Links two neurons within the central system", "Nothing");

	createEntry("What does a interneuron do?",  "Links two neurons within the central system", "Carries impulses from the central nervous system to the muscles and glands", "Carries impulses to the central nervous system from the sensory cells","Nothing");

	createEntry("What is meant by a 'threshold' in regards to the human nervous system?", "The minimum strength of stimulus needed to generate an impulse", "The maximum strength of stimulus that can generate an impulse", "The distance between two neurons", "None of the above");
	
	createEntry("Name a disorder of the nervous system", "Parkinson's Disease", "AIDS", "Asthma", "Scurvy");
	
	createEntry("How can Parkinson's disease be treated?", "Drugs", "Prayer", "It cannot be treated", "Avoiding salty foods");
	
	createEntry("What causes Parkinson's disease?", "Lack of dopamine", "Lack of salt in the diet", "Poor diet and exercise", "Abstaining from sex");
	
	createEntry("What is the function of the meninges in the brain?", "Protection", "Vision, hearing, intelligence", "Secretes hormones", "Balance");

	createEntry("What is the function of the cerebrum in the brain?", "Vision, hearing, intelligence","Protection",  "Secretes hormones", "Balance");

	createEntry("What is the function of the cerebellum in the brain?", "Balance", "Protection", "Vision, hearing, intelligence", "Secretes hormones");

	createEntry("What is the function of the hypothalamus in the brain?", "Osmoregulation", "Vision, hearing, intelligence", "Secretes hormones", "Breathing rate");

	createEntry("What is the function of the medulla oblongata in the brain?", "Breathing rate", "Vision, hearing, intelligence", "Secretes hormones", "Balance");

	createEntry("What is the function of the pituitary gland in the brain?", "Secretes hormones", "Protection", "Vision, hearing, intelligence", "Balance");

	createEntry("What is a reflex action?", "An automatic response to a stimulus", "A concious response to a stimulus", "A random response from the body to no stimulus", "A random response from the body to a stimulus");
	
	createEntry("What is the purpose of reflex actions?", "Protection", "Reflex actions have no purpose", "To ease blood flow", "Digestion");
	
	createEntry("What is a synapse?", "The junction between neurons", "Part of a neuron responsible for transmission of dopamine", "Unused part of a neuron", "None of the above");
	
	createEntry("Select the correct order of stages from the synapse mechanism of action", "Impulse arrives at synaptic knob, vesicles release neurotransmitter, neurotransmitter diffuses across the cleft, impulse generated in the next neuron, neurotransmitter broken down by and enzyme", "Impulse arrives at synaptic knob, vesicles release neurotransmitter, impulse generated in the next neuron, neurotransmitter diffuses across the cleft, neurotransmitter broken down by and enzyme", "Vesicles release neurotransmitter, impulse generated in the next neuron, impulse arrives at synaptic knob, neurotransmitter diffuses across the cleft, neurotransmitter broken down by and enzyme", "Impulse arrives at synaptic knob, vesicles release neurotransmitter, neurotransmitter broken down by and enzyme, impulse generated in the next neuron, neurotransmitter diffuses across the cleft");
	
	//Human Senses & Endocrine System (360)
	
	createEntry("What is the function of the iris in the eye?", "Controls the amount of light entering the eye", "Focuses light on the retina", "Holds lens in position", "Prevents reflection of light within the eye");
	
	createEntry("What is the function of the cornea in the eye?", "Focuses light", "Focuses light on the retina", "Holds lens in position", "Prevents reflection of light within the eye");

	createEntry("What is the function of the sclera in the eye?", "Protection", "Focuses light on the retina", "Holds lens in position", "Prevents reflection of light within the eye");

	createEntry("What is the function of the pupil in the eye?", "Lets light into the eye", "Focuses light on the retina", "Holds lens in position", "Prevents reflection of light within the eye");

	createEntry("What is the function of the lens in the eye?", "Focuses light on the retina","Controls the amount of light entering the eye",  "Holds lens in position", "Prevents reflection of light within the eye");

	createEntry("What is the function of the suspensory ligament in the eye?", "Holds lens in position","Controls the amount of light entering the eye", "Focuses light on the retina",  "Prevents reflection of light within the eye");

	createEntry("What is the fovea in the eye?", "The point of sharpest vision", "Part that focuses light on the retina", "Part that holds lens in position", "Part that prevents reflection of light within the eye");

	createEntry("What is the function of the choroid in the eye?", "Prevents reflection of light within the eye", "Controls the amount of light entering the eye", "Focuses light on the retina", "Holds lens in position");

	createEntry("What is the function of the ear drum in the ear?", "Transfers sound vibrations to bones", "Links middle ear to throat and keeps air pressure equal on both sides of the ear drum", "Transfers vibrations to the inner ear", "Hearing");
	
	createEntry("What is the function of the eustachian tube in the ear?", "Links middle ear to throat and keeps air pressure equal on both sides of the ear drum","Transfers sound vibrations to bones",  "Transfers vibrations to the inner ear", "Hearing");

	createEntry("What is the function of the cochela in the ear?", "Hearing", "Transfers sound vibrations to bones", "Links middle ear to throat and keeps air pressure equal on both sides of the ear drum", "Transfers vibrations to the inner ear");

	createEntry("What is the function of the oval window in the ear?","Transfers vibrations to the inner ear", "Transfers sound vibrations to bones", "Links middle ear to throat and keeps air pressure equal on both sides of the ear drum",  "Hearing");

	createEntry("What are the functions of the skin?", "Protection, sensory organ, excretion, temperature regulation", "Protection, excretion", "Excretion, temperature regulation, digestion", "Sensory organ, protection, excretion");
	
	createEntry("What hormones does the pituitary gland produce?", "TSH/ADH/FSH/LH", "Thyroxine", "Insulin", "Adrenaline");
	
	createEntry("What hormones does the thyroid produce?","Thyroxine", "TSH/ADH/FSH/LH",  "Insulin", "Adrenaline");

	createEntry("What hormones does the pancreas produce?","Insulin", "TSH/ADH/FSH/LH", "Thyroxine",  "Adrenaline");

	createEntry("What hormones does the adrenal gland produce?", "Adrenaline", "TSH/ADH/FSH/LH", "Thyroxine", "Insulin");

	createEntry("What hormones do the ovaries produce?", "Oestrogen/Progesterone", "Thyroxine", "Insulin", "Adrenaline");

	createEntry("What hormones do the testis gland produce?", "Testosterone", "Thyroxine", "Insulin", "Adrenaline");

	createEntry("What is the endocrine gland and what does it do?", "A ductless gland that secretes hormones into the blood", "A gland that secretes hormones into the blood", "A part of the skin responsible for temperature regulation", "Ducted gland the secretes saliva");
	
	createEntry("What is a hormne?", "Chemical messenger secreted by the endocrine gland that causes a response in a target area", "Chemical messenger secreted by the exocrine gland that causes a response in a target area", "Chemical messenger secreted by the exocrine gland that regulates temperature", "None of the above");
	
	createEntry("What is the exocrine gland and what does it do?", "A ducted gland that carries secretions out, e.g. salivary gland, pancreas", "A gland that secretes hormones into the blood", "A part of the skin responsible for temperature regulation", "Ductless gland the secretes saliva");

	createEntry("What is the function of thyroxine?", "Controls the rate of metabolism, growth and development", "Temperature regulation", "Immunity and protection", "Excretion and digestion");
	
	createEntry("What are the symptoms of thyroxine deficiency?", "Poor growth in children/Mental retardation in adults/Reduced resistance to disease", "Inability to regulate body temperature", "Mental retardation", "Swollen glands");
	
	createEntry("How can thyroxine deficiency be treated?", "Thyroxine tables", "Exercise", "Dieting", "It cannot be treated");
	
	createEntry("What are the symptoms of excess thyroxine?", "Swollen neck/Weight Loss/Restlessness", "Poor growth in children/Mental retardation in adults/Reduced resistance to disease", "Inability to regulate body temperature", "Mental retardation");
	
	createEntry("How can excessive thyroxine be treated?", "Remove the thyroid gland/Kill some cells" ,"Thyroxine tables",  "Dieting", "It cannot be treated");

	//Human Defence System (387)
	
	createEntry("What is the function of the general defence system?", "Protects against all pathogens", "Protection against particular pathogens", "Egestion", "Excretion");
	
	createEntry("What is the role of the skin in the human defence system?", "The epidermis acts as barrier preventing entry of pathogens/Acid in sweat and sebum kills bacteria", "Mucus traps pathogens/Cilia moves mucus up and out", "HCl kills bacteria", "No role in the human defence system");

	createEntry("What is the role of the mucus membrane lining in the human defence system?","Mucus traps pathogens/Cilia moves mucus up and out and HCl in the stomach kills bacteria", "The epidermis acts as barrier preventing entry of pathogens/Acid in sweat and sebum kills bacteria", "No role in the human defence system", "None of the above");
	
	createEntry("What are phagocytes?", "White blood cells", "Red blood cells", "Platelets", "Water");
	
	createEntry("What are the role of white blood cells", "To engulf and destroy pathogens in the body", "To carry oxygen around the body", "To clot the blood", "None of the above");
	
	createEntry("What is the function of the specific defence system?", "Immune system that protects against particular pathogens","Protects against all pathogens",  "Egestion", "Excretion");

	createEntry("What are the organs of the immune system?", "Spleen, thymus, lymph nodes", "Live, spleen, lymph nodes", "Lymph nodes", "Spleen, thymus");
	
	createEntry("What is an antigen?", "A specific molecule that stiumlates the formation of antibodies", "A defence protein produced by lymphocytes in response to recognising an antigen", "A small quantity of a dead pathogen that is stimulates the formation of antibodes and memory cells", "None of the above");
	
	createEntry("What is an antibody?", "A defence protein produced by lymphocytes in response to recognising an antigen","A specific molecule that stiumlates the formation of antibodies",  "A small quantity of a dead pathogen that is stimulates the formation of antibodes and memory cells", "None of the above");

	createEntry("What is a vaccine?", "A small quantity of a dead pathogen that is stimulates the formation of antibodes and memory cells","A defence protein produced by lymphocytes in response to recognising an antigen","A specific molecule that stiumlates the formation of antibodies",   "None of the above");

	createEntry("What is induced immunity?", "The ability to resist disease caused by pathogens by the production of specific antibodies", "The ability to resist disease caused by pathogens by the production of specific vaccines", "The ability to resist disease caused by pathogens by the production of specific antigens", "None of the above");
	
	createEntry("What is active immunity?", "When a person makes antibodies in response to getting an infection or a vaccine - long lasting", "When antibodies are given to a person by injection or from mother to child via the placenta - short lasting", "None of the above", "When a person makes antibodies in response to getting an infection or a vaccine - short lasting");
	
	createEntry("What are lymphocytes (B and T cells) produced by?", "Lymph nodes", "Liver", "Pancreas", "Brain");
	
	createEntry("What do B cells do?", "Produce antibodies and memory cells", "Produce memory cells only", "Directly destroy infected cells", "Recognise antigens and release chemicals");
	
	createEntry("What are the different types of T cells?", "Helper T cells, Killer T cells, Supressor T cells, Memory T cells", "Helper T cells, Killer T cells, Supressor T cells", "Helper T cells, Killer T cells", "Helper T cells, Killer T cells, Supressor T cells, Memory T cells, Sleeper T cells");

	createEntry("What is the function helper T cells?", "To recognise antigens and release chemicals that stimulate the production of B cells and killer T cells", "To destroy infected cells directly", "To stop the activity of B cells and T cells (stop the immune resposne)", "To remember antigen and give future resistance");
	
	createEntry("What is the function killer T cells?", "To destroy infected cells directly","To recognise antigens and release chemicals that stimulate the production of B cells and killer T cells",  "To stop the activity of B cells and T cells (stop the immune resposne)", "To remember antigen and give future resistance");

	createEntry("What is the function suppressor T cells?", "To stop the activity of B cells and T cells (stop the immune resposne)","To recognise antigens and release chemicals that stimulate the production of B cells and killer T cells", "To destroy infected cells directly",  "To remember antigen and give future resistance");

	createEntry("What is the function memory T cells?", "To remember antigen and give future resistance", "To recognise antigens and release chemicals that stimulate the production of B cells and killer T cells", "To destroy infected cells directly", "To stop the activity of B cells and T cells (stop the immune resposne)");

	//Growth response in flowering plants (406)
	
	createEntry("What are the external factors relating to growth regulation in flowering plants?", "Light intensity, day length, gravity, temperature", "Light intensity, day length, gravity", "Day length, gravity", "Light intensity, day length, gravity, temperature, production of growth regulators");
	
	createEntry("What are the internal factors relating to growth regulation in flowering plants", "Production of growth regulators", "Light intensity", "Gravity", "Day length");
	
	createEntry("Where in the plant are growth regualtors produced?", "The meristematic system", "Roots", "Flower", "Leaves");
	
	createEntry("What growth regulators promote growth in flowering plants?", "Auxin", "Ethene", "Abscisic acid", "Ketamine");
	
	createEntry("Which of the following is NOT an effect of auxin?", "All answers are valid", "Stimulation of shoot and root growth", "Stimulates development of flowers and fruits", "Active in response to external stimuli");
	
	createEntry("Give an example of a commercial use of plant growing regulators", "Ethene in the banana ripening", "Auxin in pear ripening", "Abscisic acid in decontamination", "There are no commercial uses");
	
	createEntry("What is a tropism?", "A growth response of a plant to an external stimulus", "A growth response of a plant to an internal stimulus", "Any kind of a stimulus to a plant", "Any kind of a growth a plant incurs");
	
	createEntry("Why are tropisms important?", "They allow plants to have favourable conditions for growth", "They serve no purpose to plants", "They assist in reproduction", "They kill of old plants to make room for the new ones");
	
	createEntry("Which of the following is the tropism related to light?", "Phototropism", "Geotropism", "Thigmotropism", "Hydrotropism");
	
	createEntry("Which of the following is the tropism related to gravity?","Geotropism", "Phototropism",  "Thigmotropism", "Hydrotropism");

	createEntry("Which of the following is the tropism related to touch?", "Thigmotropism","Phototropism", "Geotropism",  "Hydrotropism");

	createEntry("Which of the following is the tropism related to water?", "Hydrotropism", "Phototropism", "Geotropism", "Thigmotropism");

	createEntry("Which of the following is the tropism related to chemicals?", "Chemotropism", "Geotropism", "Thigmotropism", "Hydrotropism");

	createEntry("Which of the following is a chemical adaptation of plants for protection?", "Production of toxic chemicals and heat-shock proteins", "Thick cuticle on stem and leaf", "Dormancy", "Stinging cells");
	
	createEntry("Which of the following is a structural adaptation of plants for protection?", "All answers are valid", "Thick cuticle on stem and leaf", "Dormancy", "Stinging cells");
	
	createEntry("Where is auxin produced?", "The shoot tip", "The roots", "Leaves", "Flower");
	
	//Sexual Reproduction in Humans (422)
	
	createEntry("What is the role of the Cowper's gland in the male reproductive system?", "Secretes seminal fluid", "Stores sperm", "Produces sperm and secretes testosterone", "Carries urine and semens");
	
	createEntry("What is the role of the epididymis in the male reproductive system?", "Stores sperm","Secretes seminal fluid",  "Produces sperm and secretes testosterone", "Carries urine and semens");

	createEntry("What is the role of the testis in the male reproductive system?","Produces sperm and secretes testosterone", "Secretes seminal fluid", "Stores sperm",  "Carries urine and semens");

	createEntry("What is the role of the Cowper's Gland in the male reproductive system?", "Carries urine and semens", "Secretes seminal fluid", "Stores sperm", "Produces sperm and secretes testosterone");

	createEntry("what is the role of the uterus in the female reproductive system?", "Encloses the developing embryo", "Receieves semen", "Produces eggs by meiosis and secretes oestrogen and progesterone", "None of the above");

	createEntry("what is the role of the vagina in the female reproductive system?", "Receieves semen","Encloses the developing embryo",  "Produces eggs by meiosis and secretes oestrogen and progesterone", "None of the above");

	createEntry("what is the role of the ovaries in the female reproductive system?","Produces eggs by meiosis and secretes oestrogen and progesterone", "Encloses the developing embryo", "Receieves semen",  "None of the above");

	createEntry("Which of the following is a secondary sexual characteristic in males?", "Deeping of voice", "Development of breasts", "Widening of the hips", "Production of breast milk");
	
	createEntry("Which of the following is a secondary sexual characteristic in females?","Widening of the hips", "Growth of facial hair", "Balls dropping", "Deeping of voice");

	createEntry("Select the correct order of stages of the menstural cycle", "Graafian follicle develops in the ovary, Endometrium develops in the uterus, Ovulation occurs, Endometrium thickens, Corpus luteum breaks down in the ovary", "Endometrium develops in the uterus, Ovulation occurs, Graafian follicle develops in the ovary, Endometrium thickens, Corpus luteum breaks down in the ovary", "Graafian follicle develops in the ovary, Endometrium develops in the uterus, Endometrium thickens, Ovulation occurs, Corpus luteum breaks down in the ovary", "Graafian follicle develops in the ovary, Endometrium develops in the uterus, Corpus luteum breaks down in the ovary, Ovulation occurs, Endometrium thickens");
	
	createEntry("How many days does the menstural cycle typically take place over?", "28 days", "10 days", "7 days", "42 days");
	
	createEntry("Which of the following is NOT true about FSH?", "Stimulates the lining of the uterus to become thick and vascular", "Secreted by the pituitary gland", "Stimulates the development of the Graafian follicle", "Stimulates secretion of oestrogen by the follicle cells");
	
	createEntry("Which of the following is NOT a function of oestrogen?", "Stimulates the development of the Graafian follicle", "Stimulates the lining of the uterus to become thick and vascular", "Inhibits secretion of FSH", "Stimulates secretion of luteinising hormone (LH) by the pituitary gland");
	
	createEntry("Which of the following is NOT a function of progesterone? ?", "Stimulates the development of the Graafian follicle", "Maintains the thickening of the endometrium", "Inhibits secretion of FSH and LH", "All answers are valid");
	
	createEntry("Which of the following is NOT a function of luteinising hormone (LH)?", "Maintains the thickening of the endometrium", "Stimulates ovulation", "Stimulates development of he corpus luteum from the Graafian follicle", "Stiumlates the corpus luteum to secrete progesterone and oestrogen");
	
	createEntry("What happens hormonally if implantation does not occur?", "Levels of progesterone and oestrogen fall, pituitary gland secrets FSH - new cycle begins", "Levels of progesterone and oestrogen rise - new cycle begins", "Levels of progesterone rise, oestrogen levels fall - new cycle begins", "Levels of progesterone rise, oestrogen levels fall, FSH secreted from pituitary gland - new cycle begins");
	
	createEntry("How long can a sperm survive in the female?", "Up to 7 days", "24 hours", "30 minutes", "Up to 30 days");
	
	createEntry("How long can an egg survive after ovulation?", "Up to 24 hours","Up to 7 days", "Up to 30 minutes", "Up to 30 days");
	
	createEntry("What is copulation?", "Sexual intercourse", "Fertilisation", "Germination", "Implantation");
	
	createEntry("What is fertilisation?", "Fusion of haploid nuclei of sperm and egg to form a diploid zygote in the fallopian tube", "Fusion of haploid nuclei of sperm and egg to form a haploid zygote in the uterus", "Fusion of diploid nuclei of sperm and egg to form a diploid zygote in the ovaries", "Fusion of diploid nuclei of sperm and egg to form a diploid zygote in the fallopian tube");
	
	createEntry("How does pregnancy affect the menstural cycle?", "It stops the menstural cycle", "It accelerates the menstural cycle", "It has no effect on the menstural cycle", "It slows down the menstural cycle");
	
	createEntry("What is implantation?", "The embedding of the blastocyst in the endometrium 7 days after fertilisation", "Fusion of haploid nuclei of sperm and egg to form a diploid zygote in the fallopian tube", "The movement of the female egg from ovary to uterus", "None of the above");
	
	createEntry("Which of the following primary germ layers gives rise to the skin and nervous system?", "Ectoderm", "Mesoderm", "Endoderm", "None of the above");
	
	createEntry("Which of the following primary germ layers gives rise to the muscle, skeletal and reproductive sysem?","Mesoderm", "Ectoderm",  "Endoderm", "None of the above");

	createEntry("Which of the following primary germ layers gives rise to the gut linig and liver?","Endoderm", "Ectoderm", "Mesoderm",  "None of the above");

	createEntry("What is the amnion?", "A fluid-filled sac or membrane that encloses and protects the embryo", "Connects the placenta to the embryo", "Part of the ovaries responsible for hormone secretion", "None of the above");
	
	createEntry("What forms the placenta?", "Tissues in the embryo and uterus", "Tissues from the ovaries and vagina", "Tissues from the fallopian tubes", "Hormonal residue");
	
	createEntry("What does the umbilical cord do?", "Connects the placenta to the embryo", "Nothing", "Secretes hormones", "Forms the placenta");
	
	createEntry("Which of the following is a function of the placenta?", "All answers are valid", "Transfer of food, gases, excretory products between embryo and mother", "Prevents transfer of pathogens, blood cells and hormones", "Secretes the hormones progesterone and oestrogen");
	
	createEntry("What hormone induces labour?", "Oxytocin", "Oestrogen", "LH", "FSH");
	
	createEntry("What does oxytocin do?", "Stimulates contractions of the muscles of the uterus, cervix dialtes and amnion bursts", "Causes ovulation and implantation to occur", "Stimulates fertilisation, causes amnion to burst", "Infertility in males");
	
	createEntry("Which hormone stimulates lactation?", "Prolactin", "Oxytocin", "LH", "FSH");
	
	createEntry("Which of the following is a benefit of breast-feeding?", "All answers are valid", "Provides baby with the correct nutrients", "Contains antibodies", "Helps the uterus to contrac");
	
	createEntry("Name a cause of male infertility", "Low sperm count", "High sperm count", "High libido", "Low libido");
	
	createEntry("Name a cause of female infertility", "Failure to ovulate", "High egg count", "Drinking too much milk", "None of the above");
	
	createEntry("How can infertility be treated in both males and females?", "In-vitro fertilisation", "It cannot be treated", "Drugs", "Hormone treatment");
	
	createEntry("Name a disorder of the menstural cycle", "Fibrosis", "Erectile disfunction", "AIDS", "Asthma");
	
	createEntry("How can fibrosis be treated?", "Hormones and/or surgery", "Dieting", "Exercise", "It cannot be treated");
	
	createEntry("What causes fibrosis?", "Unkown cause - may be hormonal", "Poor diet", "Lack of exercise", "Uterus infections");
	
	
	
	//Sexual Reproduction in Flowering Plants (461)

	createEntry("What is pollination?", "The transfer of pollen from anther to stigma", "The transfer of pollen from stigma to anther", "Mitosis occuring in a plant", "Fertilisation");
	
	createEntry("What is self-polination?", "When pollen grains are transferred onto the stigma of the same flower or onto another flower on the same plant", "When pollen grains are transferred onto the stigma of a flower on another plant of the same species", "Fertilisation", "None of the above");
	
	createEntry("What is cross-polination?", "When pollen grains are transferred onto the stigma of a flower on another plant of the same species","When pollen grains are transferred onto the stigma of the same flower or onto another flower on the same plant",  "Fertilisation", "None of the above");

	createEntry("What carries out cross-pollination?", "Insects and the wind", "Rocks and stones", "Clouds and rain water", "Lava and magma");
	
	createEntry("Select the correct order of stages for seed formation", "Post fertilisation, zygote forms seed embryo, edosperm nucleus forms endosperm, ovule develops into a seed/integuments form the testa, seed dries out, becomes dormant","Post fertilisation, edosperm nucleus forms endosperm, zygote forms seed embryo, ovule develops into a seed/integuments form the testa, seed dries out, becomes dormant","Post fertilisation, zygote forms seed embryo, ovule develops into a seed/integuments form the testa, edosperm nucleus forms endosperm, seed dries out, becomes dormant","Post fertilisation, zygote forms seed embryo, edosperm nucleus forms endosperm, seed dries out, becomes dormant, ovule develops into a seed/integuments form the testa");
	
	createEntry("What is the difference between edospermic seeds and non-endospermic seeds?", "Food is stored in the endosperm in endospermic seeds and is stored in the cotyledons in non-endospermic seeds", "Food is stored in the non-endosperm in endospermic seeds and is stored in the cotyledons in endospermic seeds", "There is no difference", "Endospermic seeds have no cotyledon where as non-endospermic seeds do");
	
	createEntry("What is fruit?", "A mature ovary containing seeds", "Part of the roots responsible for water absorbtion", "Part of the leaves responsible for transpiration", "None of the above");
	
	createEntry("What are the functions of fruit?", "Seed protection and to disperse seeds away from the parent plant", "Water absorbtion and transport", "Transpiration", "Gas exchange");
	
	createEntry("Why is seed dispersal important for a plant?", "Reduce competition space and increase survival of the species", "To see if the species can survive in different locations", "Evolution", "Seed dispersal is not important to most plants");
	
	createEntry("What method of seed dispersal does a pea use?", "Mechanical/Self-dispersal", "Wind dispersal", "Animal dispersal", "Water dispersal");
	
	createEntry("What method of seed dispersal does a dandelion use?","Wind dispersal", "Mechanical/Self-dispersal",  "Animal dispersal", "Water dispersal");

	createEntry("What method of seed dispersal does a raspberry use?", "Animal dispersal","Mechanical/Self-dispersal", "Wind dispersal",  "Water dispersal");

	createEntry("What method of seed dispersal does a water-lilly use?", "Water dispersal", "Mechanical/Self-dispersal", "Wind dispersal", "Animal dispersal");

	createEntry("What is dormancy in relation to seeds?", "Germination will not occur even if conditions are suitable", "Germination will only occur if conditions are suitable", "Germination will only occur if conditions are unsuitable", "Germination will occur regardless of conditions");
	
	createEntry("What are the advantages of dormancy?", "To prevent germination at the wrong time of year and to allow time for greater dispersal", "There is no advantages to dormancy", "Dormancy forces the seed to only germinate once conditions are suitable", "None of the above");
	
	createEntry("What is germination?", "When the embryo of a seed begins to grow again", "When an ovary matures and contains seeds", "Fertilisation", "None of the above");
	
	createEntry("What conditions are required for germination to occur?", "All answers are valid", "Water", "Oxygen", "Suitable temperature");
	
	//(477) total questions
	
	ourDatabase.endTransaction();
	
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
