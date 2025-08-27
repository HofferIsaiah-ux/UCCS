package Default;
import java.util.*;
import java.math.*;
/* Isaiah Hoffer
 * CS1150 (M/W)
 * 9/23/24
 * Assignment 4
 * This code will use previous knowledge of nested if statements, with the use of switch statements 
 * and will introduce me to string methods, like charAt() and toUpperCase(). It will also convert 
 * numbers to letters using the ASCII table.
 */
public class HofferIsaiahAssignment4 {
	public static void main(String[] args) {
		//Create final char variables  
		//Letters
		final char VISA_CHAR = 'V';
		final char AMERICAN_EXPRESS_CHAR = 'A';
		final char DISCOVER_CHAR = 'D';
		
		//Numbers
		final char REGULAR_CREDIT_LEVEL = '1';
		final char GOLD_CREDIT_LEVEL = '2';
		final char PLATINUM_CREDIT_LEVEL = '3';
		
		//For Table 
		final String REGULAR_CREDIT_CARD = "Regular";
		final String GOLD_CREDIT_CARD = "Gold";
		final String PLATINUM_CREDIT_CARD = "Platinum"; 
		
		//Empty Variables for end display 
		String creditCardNumber = "";
		String creditCardType = "";
		String creditCardLevel = "";
		
		//Scanner for user input 
		Scanner input = new Scanner(System.in);
		System.out.println("What card do you want?\n"
				+ "Type: \n"
				+ "V: Visa A: American Express D: Discover\n"
				+ "Level: \n"
				+ "1: Regular 2: Gold 3: Platinum");
		String creditCard = input.next().toUpperCase();
		//Checking if valid   
		if ((creditCard.charAt(0) == VISA_CHAR) || (creditCard.charAt(0) == AMERICAN_EXPRESS_CHAR) || (creditCard.charAt(0) == DISCOVER_CHAR)) {
			if ((creditCard.charAt(1) == REGULAR_CREDIT_LEVEL) || (creditCard.charAt(1) == GOLD_CREDIT_LEVEL) || (creditCard.charAt(1) == PLATINUM_CREDIT_LEVEL)) {
				//Finding out what level card 
				switch (creditCard.charAt(1)) {
				case REGULAR_CREDIT_LEVEL:
					creditCardLevel = REGULAR_CREDIT_CARD;																																																																						
					break;
					
				case GOLD_CREDIT_LEVEL:
					creditCardLevel = GOLD_CREDIT_CARD;
					break;
					
				case PLATINUM_CREDIT_LEVEL:
					creditCardLevel = PLATINUM_CREDIT_CARD;
					break;
				}
				
				// Getting Card Number 
				switch (creditCard.charAt(0)){
				case VISA_CHAR: 
					int visaNumberBlockOne = (int) (Math.random() * 10000) + 1000; // Range from 1000 to ~10000
					int visaNumberBlockTwo = (int) (Math.random() * 10000) + 1000; // Range from 1000 to ~10000
					int visaNumberBlockThree = (int) (Math.random() * 10000) + 1000; // Range from 1000 to ~10000
					int visaNumberBlockFour  = (int) (+ Math.random() * 10000) + 1000; // Range from 1000 to ~10000
					
					//Setting type of card 
					creditCardType = "Visa";
					
					//Combining into one string 
					creditCardNumber = (visaNumberBlockOne + " " + visaNumberBlockTwo + " " + visaNumberBlockThree + " " + visaNumberBlockFour);
					
					//Displaying final results 
					System.out.printf("%s %s (%s)",creditCardType, creditCardNumber, creditCardLevel);
					break;
					
				case AMERICAN_EXPRESS_CHAR:
					int americanNumberBlockOne = (int) (Math.random() * 10000) + 1000; // range from 1000 to ~10000
					int americanNumberBlockTwo = (int) (Math.random() * 1000000) + 100000; // range from 100000 to ~1000000
					int americanNumberBlockThree = (int) (Math.random() * 100000) + 10000; // range from 10000 to ~100000
					
					//Setting type of card 
					creditCardType = "American Express";
					
					//Combining into one string 
					creditCardNumber = (americanNumberBlockOne + " " + americanNumberBlockTwo + " " + americanNumberBlockThree);
					
					//Displaying final results 
					System.out.printf("%s %s (%s)",creditCardType, creditCardNumber, creditCardLevel);
					break;
					
				case DISCOVER_CHAR: 
					//Making Random Letters from numbers 
					char discoverLetterBlockOne = (char) ((Math.random() * 25) + 65); // range from 65 to ~90
					char discoverLetterBlockTwo = (char) ((Math.random() * 25) + 65); // range from 65 to ~90
					char discoverLetterBlockThree = (char) ((Math.random() * 25) + 65); // range from 65 to ~90
					char discoverLetterBlockFour = (char) ((Math.random() * 25) + 65); // range from 65 to ~90
				
					//Making one string from letters
					String discoverNumberBlockOne = "" + discoverLetterBlockOne + discoverLetterBlockTwo + discoverLetterBlockThree + discoverLetterBlockFour;
					
					//Random Numbers 
					int discoverNumberBlockTwo = (int) (Math.random() * 10000) + 1000; // range from 1000 to ~10000
					int discoverNumberBlockThree = (int) (Math.random() * 100000) + 10000;//range from 10000 to ~100000
					
					//Setting type of card 
					creditCardType = "Discover";
					
					//Combining into one string 
					creditCardNumber = (discoverNumberBlockOne + " " + discoverNumberBlockTwo + " " + discoverNumberBlockThree);
					
					//Displaying final results 
					System.out.printf("%s %s (%s)",creditCardType, creditCardNumber, creditCardLevel);
					break;
				}
			}
			else // not valid 
				System.out.println("Please try again and enter a correct card level!");		
		}
		else // not valid 
			System.out.println("Please try again and enter a correct card type!");		
		

		 
	}
}
