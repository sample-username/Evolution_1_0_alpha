import java.util.Random;
class Animal {
	int ox, size, legs, randname;
	String lastname = "?";
	void ChangeAnimal(int ox_, int size_, int legs_) {
		int k; //var for decide which way to change 		
		int l; //var for decide what will change
		ox = ox_;
		size = size_;
		legs = legs_;
		Random rndk = new Random();
		k = rndk.nextInt(100); //0-23 for decrease, 75-100 for increase
		Random rndl = new Random();
		l = rndl.nextInt(4); //1 for ox, 2 for size, 3 for legs
		if (k < 20) {
			if (l == 1 & ox != 0) ox--;
			else if (l == 2 & size != 0) size--;
			else if (l == 3 & legs != 0) legs--;
		}
		if (k > 80) {
			if (l == 1) ox++;
			else if (l == 2) size++;
			else if (l == 3) legs++;
		}
		//System.out.print("Animal.ox = " + ox + ", Animal.size = " + size + ", Animal.legs = " + legs + "; "); //for test only

	}
	void CreateLastname() {
		
		Random rndk = new Random();
		randname = rndk.nextInt(31);
		if (randname==0) lastname = "Darwin";
		if (randname==1) lastname = "Feynman";
		if (randname==2) lastname = "Einstein";
		if (randname==3) lastname = "Newtone";
		if (randname==4) lastname = "Green";
		if (randname==5) lastname = "Bourne";
		if (randname==6) lastname = "Bond";
		if (randname==7) lastname = "Gilmour";
		if (randname==8) lastname = "Waters";
		if (randname==9) lastname = "Mason";
		if (randname==10) lastname = "Wright";
		if (randname==11) lastname = "Barrett";
		if (randname==12) lastname = "Olsen";
		if (randname==13) lastname = "Johansson";
		if (randname==14) lastname = "Smith";
		if (randname==15) lastname = "Charley";
		if (randname==16) lastname = "Stone";
		if (randname==17) lastname = "Watson";
		if (randname==18) lastname = "Holmes";
		if (randname==19) lastname = "Lyu";
		if (randname==20) lastname = "Christ";
		if (randname==21) lastname = "Hutt";
		if (randname==22) lastname = "Kovalsky";
		if (randname==23) lastname = "Palpatine";
		if (randname==24) lastname = "Skywalker";
		if (randname==25) lastname = "Kenobi";
		if (randname==26) lastname = "Amidala";
		if (randname==27) lastname = "Simpson";
		if (randname==28) lastname = "Baggins";
		if (randname==29) lastname = "Wayne";
		if (randname==30) lastname = "Potter";
	}

		
	
}
class Environment {
	int ox_level = 0; // oxygen level
	int food_level = 0; //food level
	int landscape_compl = 0; //at first landscape complexity, but now it's WATER LEVEL
	int population; //survived animals
	int k = 0; //var for decide which way to change 		
	int l = 0; //var for decide what will change
	String message = ""; //message to show
	String food_message = "";

	void Change(int ox_level_, int food_level_, int landscape_compl_, int population_) {


		ox_level = ox_level_;
		food_level = food_level_;
		landscape_compl = landscape_compl_;
		population = population_;
		Random rnd_k = new Random();
		k = rnd_k.nextInt(90); //decrease or increase
		Random rnd_l = new Random();
		l = rnd_l.nextInt(90); //ox, size, or legs

		if (k < 40) {
			if (l < 30) {
				if (ox_level > 0) ox_level--;
				if (ox_level==0) {
					message = "\nToo much CO2! Almost no oxygen!";
				}
				else message = "\nVolcanos are active. Oxygen gets low!";
			} 
			else if ((l > 30 & l < 60) /*|| population > 1000*/) {
				if (food_level > 0) food_level--;
				if (food_level==0) {
					message = "\nResources are shrinking! Food is too few!";
				}
				else message = "\nResources are shrinking! Food gets low!";
			}
			else if (l > 60) {
				if (landscape_compl > 0) landscape_compl--;
				if (landscape_compl==0) {
					message = "\nDrought destroys liquid water!";
				}
				else message = "\nDry winds brought the drought. Water is getting less!";
			}
			//System.out.println("Env changed!");
		}
		else if (k > 60) {
			if (l < 30) {
				ox_level++;
				message = "\nGoog news! Oxygen level is growing!";
			}
			else if (l > 30 & l < 60) {
				food_level++;
				message = "\nFood is getting more!";
				}
			else if (l > 60) {
				landscape_compl++;
				message = "\nA long-expected rain is coming! Water level increases!";
			}
			//System.out.println("Env changed!");
		}
		
		

	}

}
class Evolution {
	public static void main(String args[]) throws java.io.IOException, InterruptedException {
		int gen = 0, age = 0, ox, size, legs, ox_level=1, food_level=1, landscape_compl=1, arr_pos = 0, arr_died_pos = 0, survived = 0, died = 0;
		int[][] arr_DNA = new int[1000000][4];
		int[][] arr_DNA2 = new int[1000000][4];
		int[][] arr_DIED = new int[1000000][4];
		String[] arr_NAMES = new String[1000000];
		String[] arr_NAMES2 = new String[1000000];
		String[] arr_DIED_NAMES = new String[1000000];
		String[] arr_SURVIVED = new String[1000000];

//==============Random for static environment conditions:
		Random randOxLevel = new Random();
		ox_level = randOxLevel.nextInt(9);
		if (ox_level == 0) ox_level++;
		Random randFoodLevel = new Random();
		food_level = randFoodLevel.nextInt(9);
		if (food_level == 0) food_level++;
		Random randLandscapeCompl = new Random();
		landscape_compl = randLandscapeCompl.nextInt(9);
		if (landscape_compl == 0) landscape_compl++;
		System.out.println();
		System.out.println(" Environment\nOxygen level: " + ox_level + ", Food level: " + food_level + ", Water level: " + landscape_compl);	
		System.out.println();	
		System.out.println("GENERATION 0:");

//==============1st 'for' for the 1st generation:
		for (int i = 0; i < 100; i++) {
			Animal proconsul = new Animal();
			proconsul.CreateLastname();			

			Random randOx = new Random();
			ox = randOx.nextInt(9);
			if (ox == 0) ox++;
			Random randSize = new Random();
			size = randSize.nextInt(9);
			if (size == 0) size++;
			Random randLegs = new Random();
			legs = randLegs.nextInt(9);
			if (legs == 0) legs++;
			

			
//======================If an animal can survive, his DNA writes to the array:
			if (ox <= ox_level & size <= food_level & legs <= landscape_compl) {
				arr_DNA[arr_pos][0] = ox;
				arr_DNA[arr_pos][1] = size;
				arr_DNA[arr_pos][2] = legs;
				arr_DNA[arr_pos][3] = gen;
				arr_NAMES[arr_pos] = proconsul.lastname;
				arr_pos++;
				
			}
				
		}

		survived = arr_pos; //the variable to know, hom much survived

		
		System.out.println(" Survived DNAs: ");

//=============='for' for output survived DNAs form the 1st generation
		for (int i = 0; i < survived; i++) {
			Thread.sleep(250);
			System.out.print("(" + arr_NAMES[i] + "|");
			for (int j = 0; j <= 2; j++) {
				System.out.print(arr_DNA[i][j]);
			}
			System.out.print("|Age:" + arr_DNA[i][3] + "), ");
		} 

		System.out.println("\nTotal: " + survived);

		Environment env = new Environment();
		Animal anml = new Animal();		


	exit: do {
		died+=arr_died_pos;
		if (survived > 5000) {
			int s_ = 0;
			for (int s = 0; s < survived; s++) {
					 
				
				if(arr_NAMES[s] != arr_NAMES[s+1] & arr_NAMES[s] != null) {
					arr_SURVIVED[s_] = arr_NAMES[s];
					s_++;
				}
			}
			for (int s = 0; s < s_; s++) {
				for (int k = s + 1; k < s_; k++) {
					
					if (arr_SURVIVED[s] == arr_SURVIVED[k]) {
						arr_SURVIVED[k] = "-";
					}
				}
			}
			
			System.out.println();
			System.out.println("\nThe population survived with " + survived + " creatures!");
			System.out.println("\nThe following dynasties did survive for " + gen + " generations:");
			for (int s = 0; s < s_; s++) {
				if (arr_SURVIVED[s] != "-") System.out.println("Kids of " + arr_SURVIVED[s]);
			}
			System.out.println("\nRIP: " + died + " creatures of all generations.");
			break exit;
			
		}
		age = 0;    
		gen++;		//generation increase
//==============Environment conditions change (or not) (or yes?) - you never know:
		env.Change(ox_level, food_level, landscape_compl, arr_pos);
		ox_level = env.ox_level;
		food_level = env.food_level;
		landscape_compl = env.landscape_compl;
		System.out.println();	
		System.out.println(env.message);
		env.message = "";

		System.out.println(" Environment\nOxygen level: " + env.ox_level + ", Food level: " + env.food_level + ", Water level: " + env.landscape_compl);
		System.out.println();
		Thread.sleep(3000);
		System.out.println("GENERATION " + gen + ":");
		Thread.sleep(3000);

//==============2nd 'for' for 2nd generation:
		
                arr_pos = 0;
		arr_died_pos = 0;			
		for(int i = 0; i < survived; i++) {


			anml.ChangeAnimal(arr_DNA[i][0], arr_DNA[i][1], arr_DNA[i][2]);
			//anml.CreateLastname();
			
			

			if (anml.ox <= env.ox_level & anml.size <= env.food_level & anml.legs <= env.landscape_compl) {
				if (arr_DNA[i][3] > 5) {
					arr_DIED[arr_died_pos][0] = arr_DNA[i][0];
					arr_DIED[arr_died_pos][1] = arr_DNA[i][1];
					arr_DIED[arr_died_pos][2] = arr_DNA[i][2];
					arr_DIED[arr_died_pos][3] = arr_DNA[i][3];
					arr_DIED_NAMES[arr_died_pos] = arr_NAMES[i];
					arr_died_pos++;
//======================================Not sure if I won't use it someday:
					/*arr_DNA2[arr_pos][0] = anml.ox;
					arr_DNA2[arr_pos][1] = anml.size;
					arr_DNA2[arr_pos][2] = anml.legs;				
					arr_DNA2[arr_pos][3] = age;
					arr_pos++;*/

				}
				else { 
						if (arr_DNA[i][0] <= env.ox_level & arr_DNA[i][1] <= env.food_level & arr_DNA[i][2] <= env.landscape_compl) {
							arr_DNA2[arr_pos][0] = arr_DNA[i][0];
							arr_DNA2[arr_pos][1] = arr_DNA[i][1];
							arr_DNA2[arr_pos][2] = arr_DNA[i][2];				
							arr_DNA2[arr_pos][3] = arr_DNA[i][3]+1;
							arr_NAMES2[arr_pos] = arr_NAMES[i];
						}
					arr_DNA2[arr_pos+1][0] = anml.ox;
					arr_DNA2[arr_pos+1][1] = anml.size;
					arr_DNA2[arr_pos+1][2] = anml.legs;				
					arr_DNA2[arr_pos+1][3] = age;
					arr_NAMES2[arr_pos+1] = arr_NAMES[i];
					arr_pos+=2;	
					
	
				}
				
			}
			else {
				arr_DIED[arr_died_pos][0] = anml.ox;
				arr_DIED[arr_died_pos][1] = anml.size;
				arr_DIED[arr_died_pos][2] = anml.legs;
				arr_DIED[arr_died_pos][3] = /*age*/arr_DNA[i][3];
				arr_DIED_NAMES[arr_died_pos] = arr_NAMES[i];
				arr_died_pos++;
			
			}
/*			if (arr_pos == 200000) {
				int s_ = 0;
				for (int s = 0; s < 200000; s++) {
						 
					
					while (arr_NAMES[s] != arr_NAMES[s+1]) {
						arr_SURVIVED[s_] = arr_NAMES[s];
						s_++;
					}
				}
				
				System.out.println("The population survived!");
				System.out.println("They did survive for " + gen + " generations:");
				for (int s = 0; s < s_; s++) System.out.println(arr_SURVIVED[s]);
				break exit;
				
			}*/
		anml.randname = 0;

		}


		survived = arr_pos;

//==============Copying items from array arr_DNA2 to array arr_DNA1:
		for (int i = 0; i < survived; i++) {
			for (int j = 0; j < 4; j++) {
				arr_DNA[i][j] = arr_DNA2[i][j];
			}
		}
//==============Copying items from array arr_NAMES2 to array arr_NAMES:
		for (int i = 0; i < survived; i++) {
			
				arr_NAMES[i] = arr_NAMES2[i];
			
		}

		
		if (survived == 0) {
			System.out.println ("The population is destroyed!");
			break exit;
		}

		else {
			System.out.println(" Survived DNAs: ");
			for (int i = 0; i < survived; i++) {
				if (survived < 150) Thread.sleep(250);
				else if (survived > 150 & survived < 300) Thread.sleep(150);
				else if (survived > 300 & survived < 600) Thread.sleep(50);
				else if (survived > 600 & survived < 1000) Thread.sleep(25);				
				else if (survived > 1000 & survived < 10000) Thread.sleep(5);
				else if (survived > 10000 & survived < 200000) Thread.sleep(1);
				System.out.print("(" + arr_NAMES[i] + "|");
				for (int j = 0; j <= 2; j++) {
					System.out.print(arr_DNA[i][j]);
				}
			System.out.print("|Age:" + arr_DNA[i][3] + "), ");
			} 
		}


		
		System.out.print("\nTotal: " + survived);
		System.out.println();
		Thread.sleep(3000);
		if (arr_died_pos == 0) System.out.println ("No one died!");
		else {

			System.out.println(" RIP: ");
			for (int i = 0; i < arr_died_pos; i++) {
				if (arr_died_pos > 1 & arr_died_pos < 600) Thread.sleep(50);
				else if (arr_died_pos > 600 & arr_died_pos < 1000) Thread.sleep(25);				
				else if (arr_died_pos > 1000 & arr_died_pos < 10000) Thread.sleep(5);
				else if (arr_died_pos > 10000 & arr_died_pos < 200000) Thread.sleep(1);
				System.out.print("(" + arr_DIED_NAMES[i] + "|");
				for (int j = 0; j <= 2; j++) {
					System.out.print(arr_DIED[i][j]);
				}
				System.out.print("|Age:" + arr_DIED[i][3] + "), ");
			} 
		}
		//food_check = env.food_level;
		Thread.sleep(3000);


	}
	while (arr_pos < 1000000);
	Thread.sleep(500);
	System.out.println("\nTHE END");
	System.out.println();
}
}
