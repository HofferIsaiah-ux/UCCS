package Default;
import java.util.*;
/* Isaiah Hoffer
 * CS1150 (M/W)
 * 10/15/24
 * Assignment 7
 * This code will start to use methods. It will take in a user's password and check it with 4 methods 
 * to see if meets the requirements. It will also use another method to print out a specific error message.  
 */
public class HofferIsaiahAssignment7 {
	
	public static void main (String[] args) {
		//Setting constants for password requirements
		//Past Passwords 
		final String PREVIOUS_PASSWORD_ONE = "cooper11";
		final String PREVIOUS_PASSWORD_TWO = "to2mac2";
		
		//Min and Max password length
		final int MIN_PASSWORD_LENGTH = 7;
		final int MAX_PASSWORD_LENGTH = 10;
		
		//Constants Error 
		final int LENGTH_ERROR = 1;
		final int LETTERS_AND_DIGITS_ERROR = 2;
		final int TWO_DIGITS_ERROR = 3;
		final int SAME_PASSWORD_ERROR = 4;
		
		//Max Attempts 
		final int MAX_ATTEMPTS = 4;
		
		//Attempt Counter 
		int attemptCounter = 0;
		
		//Setting Password Pass to false 
		boolean passwordPassesTest = false;
		
		//Creating Scanner
		Scanner input = new Scanner(System.in);
		
		while(attemptCounter < MAX_ATTEMPTS && !passwordPassesTest) {
			//Adding to counter 
			attemptCounter++;
		
			//Asking User for Password  
			System.out.println("Please enter a Password: ");
			String inputedPassword = input.next(); 
		
			//Checking Password Length 
			boolean lengthCheck = lengthTest(inputedPassword, MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH);
			
			//Checking if pass or fail from methods 
			if (lengthCheck) {
				boolean lettersAndDigitsCheck = onlyLettersAndDigitsTest(inputedPassword);
				
				if (lettersAndDigitsCheck) {
					boolean containsTwoDigitsCheck = containsTwoDigitsTest(inputedPassword);
					
					if (containsTwoDigitsCheck) {
						boolean differentPasswordCheck = differentThanLastTwoPasswordsTest(inputedPassword, PREVIOUS_PASSWORD_ONE, PREVIOUS_PASSWORD_TWO);
					
						if (differentPasswordCheck) {
							passwordPassesTest = true;
							printErrorMessage(0);
						}//If
						else {
							printErrorMessage(SAME_PASSWORD_ERROR);
						}//else 
					}//If
					else {
						printErrorMessage(TWO_DIGITS_ERROR);
					}//Else 
				}//If
				else {
					printErrorMessage(LETTERS_AND_DIGITS_ERROR);
				}//Else
			}//If
			else {
				printErrorMessage(LENGTH_ERROR);
			}//Else
		}//While
		if (attemptCounter == 4) {
			System.out.println("\nYour 4 attempts did not meat the password requierments!");
		}
	}//Main 
		//Password Length checker 
	public static boolean lengthTest(String password, int minLength, int maxLength) {
			
		if (password.length() >= minLength && password.length() <= maxLength) {
			return true; 
		}//if
		else {
			return false;
		}//else 
			
	}//lengthTest
	
	//Password check to see if it contains only letters and digits 
	public static boolean onlyLettersAndDigitsTest(String password) {
		//Setting boolean for if statement 
		boolean noSpecialCharacters = false;
		
		//Using ASCII to check for special characters 
		for(int i = 0; i < password.length(); i++) {
			//Casting Chars from password to Ints for ASCII
			int passwordToInt = (int) password.charAt(i);
			
			if ((48 <= passwordToInt && passwordToInt <= 57) || (65 <= passwordToInt && passwordToInt <= 90) || (97 <= passwordToInt && passwordToInt <= 122)){
				noSpecialCharacters = true; 	
			} //If
			else {
				
				noSpecialCharacters = false; 
				return noSpecialCharacters;
			}//else
			
		}//for 
		
		return noSpecialCharacters;
	}//onlyLettersAndDigitsTest
	
	public static boolean containsTwoDigitsTest(String password) {
		int totalNumbersInPassword = 0;
		for(int i = 0; i < password.length(); i++) {
	
			if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
				totalNumbersInPassword++;
			}//If
			
		}//for
		if (totalNumbersInPassword <= 2) {
			return true;
		}
		else {
			return false;
			
		}
	}//containsTwoDigitsTest
	
	public static boolean differentThanLastTwoPasswordsTest(String password, String previousPasswordOne, String previousPasswordTwo) {
		// boolean: false = same previous password, true = different password
		boolean samePassword = true; 
		
		if (previousPasswordOne.equals(password) || previousPasswordTwo.equals(password)) {
			samePassword = false;
		}//If
		
		return samePassword;
	}//DifferentThanLastTwoPasswordsTest 
	
	public static void printErrorMessage(int errorCode) {
		//Checking what error user got 
		switch (errorCode) {
			case 1: 
				System.out.println("Password does not meet requirement: must be between 7 and 10 characters");
				break; 
			case 2: 
				System.out.println("Password does not meet requirement: must have 0 special characters");
				break;
			case 3: 
				System.out.println("Password does not meet requirement: must have and contain only 2 digits");
				break;
			case 4:
				System.out.println("Password does not meet requirement: must be different than previous 2 passwords");
				break;
			default: 
				System.out.println("Your password meets all requirements");
		}
	}//printErrorMessage
}// Class
