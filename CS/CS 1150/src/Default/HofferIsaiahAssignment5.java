package Default;
import java.util.*;
/* Isaiah Hoffer
 * CS1150 (M/W)
 * 10/6/24
 * Assignment 5
 * This code will introduce me to while loop and further my 
 * knowledge of if statements. It will use math functions and printf().
 * It will simulate of series of rolls to get a 4 of a kind. 
 */
public class HofferIsaiahAssignment5 {
	
	public static void main(String[] args) {	
		//Create counters for each 1-4 of a kind  
		int oneOfAKindCount = 0;
		int twoOfAKindCount = 0;
		int threeOfAKindCount = 0;
		int fourOfAKindCount =0;			

		//Create a total amount of rolls counter  
		int totalRolls = 0;
		
		//Create Strings to hold name of roll  
		final String ONE_OF_A_KIND_STR = "One of a Kind!";
		final String TWO_OF_A_KIND_STR = "Two of a Kind!";
		final String THREE_OF_A_KIND_STR = "Three of a Kind!";
		final String FOUR_OF_A_KIND_STR  = "Four of a Kind!";

		//Start of table 
		System.out.printf("Roll\tDie1\tDie2\tDie3\tDie4\tType\n"
				+ "-----------------------------------------------------\n");
		
		//While loop until 4 of a kind
		while (fourOfAKindCount == 0) {	
			//Add one to totalRolls 
			totalRolls++;
			
			//Variables for dice rolls  
			int rollOne =  1+ (int) (Math.random() * 6);
			int rollTwo =  1 + (int) (Math.random() * 6);
			int rollThree = 1 + (int) (Math.random() * 6);
			int rollFour = 1 + (int) (Math.random() * 6);
		
			//Checking for what # of kind we got 
			if ((rollOne == rollTwo) && (rollOne == rollFour) && (rollTwo == rollThree)) {
				// Four of a kind
				System.out.printf("#%d\t%d\t%d\t%d\t%d\t%s\n",totalRolls,rollOne,rollTwo,rollThree,rollFour,FOUR_OF_A_KIND_STR);
				fourOfAKindCount++; // Adding one to counter 
			}
			else if ((rollOne == rollTwo && rollOne == rollThree) || (rollOne == rollThree && rollOne == rollFour) || (rollOne == rollTwo && rollOne == rollFour) || (rollTwo == rollThree && rollTwo == rollFour)) {
				// Three of a kind
				System.out.printf("#%d\t%d\t%d\t%d\t%d\t%s\n",totalRolls,rollOne,rollTwo,rollThree,rollFour,THREE_OF_A_KIND_STR);
				threeOfAKindCount++; // Adding one to counter 
			}
			else if (rollOne == rollTwo || rollOne == rollThree || rollOne == rollFour || rollTwo == rollThree || rollTwo == rollFour || rollThree == rollFour) {
				// Two of a kind
				System.out.printf("#%d\t%d\t%d\t%d\t%d\t%s\n",totalRolls,rollOne,rollTwo,rollThree,rollFour,TWO_OF_A_KIND_STR);
				twoOfAKindCount++;// Adding one to counter 
			}
			else if (rollOne != rollTwo && rollOne != rollThree && rollOne != rollFour && rollTwo != rollThree && rollTwo != rollFour && rollThree != rollFour) {
				// One of a kind
				System.out.printf("#%d\t%d\t%d\t%d\t%d\t%s\n",totalRolls,rollOne,rollTwo,rollThree,rollFour,ONE_OF_A_KIND_STR); 
				oneOfAKindCount++;// Adding one to counter
			} 
		
		}
		
		// Probability for each type 
		Double oneOfAKindProb = (double) oneOfAKindCount / totalRolls * 100;
		Double twoOfAKindProb = (double) twoOfAKindCount / totalRolls * 100;
		Double threeOfAKindProb = (double) threeOfAKindCount / totalRolls * 100;
		Double fourOfAKindProb = (double) fourOfAKindCount / totalRolls *100;
		Double totalProbability = oneOfAKindProb + twoOfAKindProb + threeOfAKindProb + fourOfAKindProb;
		
		//Final Results
		System.out.printf("--------------------------------------------------------\n"
				+ "\t\tDice Rolling Results\t\t\n"
				+ "--------------------------------------------------------\n\n"
				+ "--------------------------------------------------------\n"
				+ "Type\t\t\tOccurances\tProbability\n"
				+ "--------------------------------------------------------\n");
		
		System.out.printf("%s\t\t\t%d\t%3.2f%%\n",ONE_OF_A_KIND_STR,oneOfAKindCount,oneOfAKindProb); // One of a kind 
		System.out.printf("%s\t\t\t%d\t%3.2f%%\n",TWO_OF_A_KIND_STR,twoOfAKindCount,twoOfAKindProb); // Two of a kind
		System.out.printf("%s\t\t%d\t%3.2f%%\n",THREE_OF_A_KIND_STR,threeOfAKindCount,threeOfAKindProb); // Three of a kind
		System.out.printf("%s\t\t\t%d\t%3.2f%%\n",FOUR_OF_A_KIND_STR,fourOfAKindCount,fourOfAKindProb); // Four of a kind 
		
		System.out.printf("--------------------------------------------------------\n"
				+ "Total\t\t\t\t%d\t%3.2f%%",totalRolls,totalProbability);
		
		
		
	}
}
