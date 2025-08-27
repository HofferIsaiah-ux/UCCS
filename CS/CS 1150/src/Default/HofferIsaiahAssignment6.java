package Default;
import java.util.*;
/* Isaiah Hoffer
 * CS1150 (M/W)
 * 10/14/24
 * Assignment 6
 * This code will test me in nested loops and also introduce me to for loops
 * This code will display a table of snacks for the user to choose and at 
 * the end of the loops it will display the amount of snacks bought and final price 
*/
public class HofferIsaiahAssignment6 {
	
	public static void main (String[] args) {
		//Constants, Snack Names 
		final String POTATO_CHIPS_STR = "Potato Chips";
		final String PRETZELS_STR = "Pretzels";
		final String KIND_BAR_STR  = "Kind Bar";

		// Constants, Snack Prices
		final Double POTATO_CHIP_PRICE = 1.75;
		final Double PRETZELS_PRICE = 1.50;
		final Double KIND_BAR_PRICE =.80;
		
		//Counters 
		int POTATO_CHIP_COUNT = 0;
		int PRETZELS_COUNT = 0;
		int KIND_BAR_COUNT = 0;
		int totalSnacks = 0;
		
		//Initializing variable 
		int snackAmountOrShutDown = 0;
		
		//Creating Scanner 
		Scanner input = new Scanner(System.in);
		
		
		//While loop until user enters shut down code 
		while (snackAmountOrShutDown != 999) {
			//Displaying vending machine 
			System.out.printf("***********************************************\n"
					+ "\t\tSnack Machine\t\t\n"
					+ "***********************************************\n");
			
			//Displaying Potato Chips row 
			System.out.printf("%s\t%s\t%s\nA1\t$%3.2f\tA2\t$%3.2f\tA3\t$%3.2f\t\n",POTATO_CHIPS_STR,POTATO_CHIPS_STR,POTATO_CHIPS_STR,POTATO_CHIP_PRICE,POTATO_CHIP_PRICE,POTATO_CHIP_PRICE);
			System.out.printf("-----------------------------------------------\n");
			
			//Displaying Pretzels row 
			System.out.printf("%s\t%s\t%s\nB1\t$%3.2f\tB2\t$%3.2f\tB3\t$%3.2f\t\n",PRETZELS_STR,PRETZELS_STR,PRETZELS_STR,PRETZELS_PRICE,PRETZELS_PRICE,PRETZELS_PRICE);
			System.out.printf("-----------------------------------------------\n");
			
			//Displaying Kind Bar row 
			System.out.printf("%s\t%s\t%s\nC1\t$%3.2f\tC2\t$%3.2f\tC3\t$%3.2f\t\n",KIND_BAR_STR,KIND_BAR_STR,KIND_BAR_STR,KIND_BAR_PRICE,KIND_BAR_PRICE,KIND_BAR_PRICE);
			System.out.printf("-----------------------------------------------\n");
			
			System.out.println("How many snacks do you want? No more than 3!\n"
					+ "Shutdown code is 999!");
			snackAmountOrShutDown = input.nextInt();
			
			// Loop for user error 
			while (snackAmountOrShutDown < 1 || (snackAmountOrShutDown > 3 && snackAmountOrShutDown != 999) ) {
				System.out.println("Incorrect amount, enter 1-3 or 999 to shutdown");
				snackAmountOrShutDown = input.nextInt();
			}
			
			//Snack Selection 
			if (snackAmountOrShutDown != 999) {
				for (int i = 1; i <= snackAmountOrShutDown; i++) { // loops for amount of snacks wanted
					//Initializing Variables 
					int wrongSnack = 0;
					int attemptTwo = 0;
					String inputedSnack = "";
					double snackPrice = 0.0;
					String snackName = "";
					
					do { //use for invalid inputs 
						// Different Statement with incorrect input 
						if (attemptTwo == 0) {
							System.out.println("What Snack do you want? ");
						}
						else if (attemptTwo == 1) {
							System.out.println("Invalid Snack! Try again? ");
						}
						inputedSnack = input.next();
						inputedSnack = inputedSnack.toUpperCase();
						
						// Checking user input 
						switch (inputedSnack) {
						
							case "A1","A2","A3": { // Potato Chips check 
								snackPrice =  POTATO_CHIP_PRICE;
								snackName = POTATO_CHIPS_STR;
								POTATO_CHIP_COUNT++;
								totalSnacks++;
								wrongSnack = 1;
								break;
							}
							case "B1","B2","B3": { // Pretzels check
								snackPrice =  PRETZELS_PRICE;
								snackName = PRETZELS_STR;
								PRETZELS_COUNT++;	
								totalSnacks++;
								wrongSnack = 1;
								break;
							}
							case "C1","C2","C3": { // Kind Bar check 
								snackPrice =  KIND_BAR_PRICE;
								snackName = KIND_BAR_STR;
								KIND_BAR_COUNT++;
								totalSnacks++;
								wrongSnack = 1;
								break;
							}
							default : {
								attemptTwo = 1;
							}
						} // Switch 
					} while (wrongSnack != 1); // do loop 
					
					//Displaying Items Info 
					System.out.printf("-----------------------------------------------\n"
							+ "\t\tSelection %s\t\t\t\n"
							+ "-----------------------------------------------\n",inputedSnack);
					System.out.printf("\t\tSnack Item: %s\n\t\tSnack Price: $%3.2f\n",snackName,snackPrice);
					
				} // for loop 		
				System.out.printf("Thank you for your business\n\n");			
			} // If 
		} // while loop 
		
		//Total Price
		double totalAmount =  POTATO_CHIP_PRICE * POTATO_CHIP_COUNT + PRETZELS_PRICE * PRETZELS_COUNT + KIND_BAR_PRICE * KIND_BAR_COUNT;
		
		// Final Display for total amount
		System.out.printf("\t\tTotal Sales: $%3.2f\n\t\tTotal Snacks Sold: %d\n\t\t%s: %d\n\t\t%s: %d\n\t\t%s: %d\n"
				,totalAmount,totalSnacks,POTATO_CHIPS_STR,POTATO_CHIP_COUNT,PRETZELS_STR,PRETZELS_COUNT,KIND_BAR_STR,KIND_BAR_COUNT);
		
	} // main 
} // class 
