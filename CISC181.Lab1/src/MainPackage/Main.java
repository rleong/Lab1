package MainPackage;
import java.util.Scanner;

public class Main {
	
	//Variables 
	static Scanner reader = new Scanner(System.in);
	static int yearsToWork;
	static double annualReturn;
	static int yearsRetired;
	static double annualRetirement;
	static double requiredIncome;
	static double monthlySSI;
	static double total_saving;
	static double save_monthly;
	
	public static void welcomeMessage(){
		
		System.out.println("-------------------------------------------------------");
		System.out.println("|          Welcome to the retirement planner!         |");
		System.out.println("|          Created by Russell Leong, Kyle Wang,       |");
		System.out.println("|                    and Chu Qiao.                    |");
		System.out.println("-------------------------------------------------------");
		
	}
	
	public static void goodbyeMessage(){
		
		System.out.println("-------------------------------------------------------");
		System.out.println("|             Thanks for using the planner!           |");
		System.out.println("|                       Goodbye!                      |");
		System.out.println("-------------------------------------------------------");
		
	}
	
	public static void askInput(){ //Ask for inputs into variables
		
		System.out.println("How many years are you planning on working?");
		yearsToWork = reader.nextInt();
		
		System.out.println("Please enter a number from 0 to 20:");
		System.out.println("What is your expected average return in investment?");
		annualReturn = reader.nextDouble();
		//Must be in range of 0-20, if not, prompts the user again for the correct input
		while(annualReturn < 0 || annualReturn > 20){
			System.out.println("Please enter a number from 0 to 20!");
			System.out.println("What is your expected average return in investment?");
			annualReturn = reader.nextDouble();
		}
		
		System.out.println("How many years are you expecting to retire for?");
		yearsRetired = reader.nextInt();
		
		System.out.println("Please enter a number from 0 to 3!");
		System.out.println("What is your expected annual return from retirement?");
		annualRetirement = reader.nextDouble();
		//Must be in the range of 0-3, if not, prompts the user again for the correct input
		while(annualRetirement < 0 || annualRetirement > 3){
			System.out.println("Please enter a number from 0 to 3!");
			System.out.println("What is your expected annual return from retirement?");
			annualRetirement = reader.nextDouble();
		}
		
		System.out.println("What is your required income?");
		requiredIncome = reader.nextDouble();
		
		System.out.println("What is your expected Social Security Income?");
		monthlySSI = reader.nextDouble();
		
		
	}
	
	public static void doCalculations(){ //Calculates the results based off of the user's inputs
		
		total_saving = (requiredIncome-monthlySSI)*((1-(1/(Math.pow(1+(annualRetirement/100)/12,yearsRetired*12)))))/((annualRetirement/100)/12);
		save_monthly = total_saving * (((annualReturn/100)/12)/((Math.pow(1+(annualReturn/100)/12, yearsToWork*12))-1));
		
	}
	
	public static void spitOutput(){ //Spews out the results of the calculations.
		
		System.out.println("\nYour total savings are: ");
		System.out.printf("%.2f", total_saving);
		System.out.println("\nYour monthly savings are: ");
		System.out.printf("%.2f", save_monthly);
		System.out.println("\n");
		
	}
	
	public static void testing(){ //For debugging purposes only
		
		System.out.println(yearsToWork);
		System.out.println(annualReturn);
		System.out.println(yearsRetired);
		System.out.println(annualRetirement);
		System.out.println(requiredIncome);
		System.out.println(monthlySSI);
		System.out.println(total_saving);
		System.out.println(save_monthly);
		
	}
	
	public static void main(String[] args){
		
		//EXECUTE ALL THE CODE!!!!
		
		welcomeMessage();
		askInput();
		doCalculations();
		spitOutput();
		goodbyeMessage();
		
	}

}
