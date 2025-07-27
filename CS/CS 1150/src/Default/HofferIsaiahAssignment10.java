package Default;
/* Isaiah Hoffer
 * CS1150 (M/W)
 * 11/11/24
 * Assignment 10
 * This code will introduce me to objects and using object access information from an object array using 
 * methods in that object. It will use arrays and loops.
 */
public class HofferIsaiahAssignment10 {

	public static void main(String[] args) {
		
		/***********************************************
		 * 					Part 1: Transactions 
		 * *********************************************/
		
		// Initializing Object array 
		transaction[] transactionObjArray = new transaction[7];
		
		//Setting Values for transactionObjArray
		transactionObjArray[0] = new transaction("Amazon","Shopping", 127.50);
		transactionObjArray[1] = new transaction("Ace","Home", 290.00);
		transactionObjArray[2] = new transaction("Chegg","Education", 29.95);
		transactionObjArray[3] = new transaction("Safeway","Groceries", 145.50);
		transactionObjArray[4] = new transaction("AirBnB","Travel", 445.00);
		transactionObjArray[5] = new transaction("Target","Shopping", 12.00);
		transactionObjArray[6] = new transaction("Lowes","Home", 35.95);
		
		// Setting variables to hold largest Transaction amount and index
		double mostExpensiveTransactionAmount = 0;
		int mostExpensiveTransactionIndex = 0;
		//Pretext
		System.out.println("*****************************************************\n"
				+ "\t   Part 1: Transactions in Array\t  \n"
				+ "*****************************************************\n"
				+ "Merchant\t\tCategory\t\tAmount\n"
				+ "-----------------------------------------------------\n");
		
		//Displaying transaction and finding most expensive transaction 
		for(int i = 0; i < transactionObjArray.length; i++) {	
			//Displaying Transactions
			System.out.printf("%s\t\t%15s\t\t%14.2f\n",transactionObjArray[i].getMerchant(),
					transactionObjArray[i].getCategory(),transactionObjArray[i].getAmount());
			
			//Finding most expensive transaction 
			if(mostExpensiveTransactionAmount < transactionObjArray[i].getAmount()) {
				
				mostExpensiveTransactionAmount = transactionObjArray[i].getAmount();
				mostExpensiveTransactionIndex = i;
			}//If		
		}//For
		
		//Displaying Most Expensive Transaction 
		System.out.printf("\nMost Expensive Transaction\n"
				+ "--------------------------\n"
				+ "Merchant: %s\n"
				+ "Category: %s\n"
				+ "Amount: %8.2f\n",transactionObjArray[mostExpensiveTransactionIndex].getMerchant(),
				transactionObjArray[mostExpensiveTransactionIndex].getCategory(),transactionObjArray[mostExpensiveTransactionIndex].getAmount());
		
		/****************************************
		 * 			Part 2: Credit Card 
		 * **************************************/
		int maxAmountOfTransactions = 5;
		creditCard creditCardObj= new creditCard(maxAmountOfTransactions);
		
		//Pretext
		System.out.println("\n******************************************************\n"
				+ "\t  Part 2: Transactions in Credit Card\t  \n"
				+ "******************************************************\n");
		
		//Adding Transactions to creditCardObj and displaying if Successful 
		for(int i = 0; i < transactionObjArray.length; i++) {
			
			//Setting and returning true of false
			boolean addedToCreditCard = creditCardObj.setTransaction(transactionObjArray[i]);
			
			//Displaying result 
			System.out.printf("Was %s added to the credit card? %s\n",transactionObjArray[i].getMerchant(), addedToCreditCard);
		}//for
		
		//Calling displayAllTransaction
		creditCardObj.displayAllTransactions();
		
		//Calling findMostExpensiveTransaction
		transaction mostExpensiveCreditCardTransaction = creditCardObj.findMostExpensiveTransaction();
		
		//Pretext
		System.out.printf("\nMost Expensive Transaction on Credit Card\n"
				+ "-----------------------------------------\n"
				+ "Merchant: %s\n"
				+ "Category: %s\n"
				+ "Amount: %8.2f", mostExpensiveCreditCardTransaction.getMerchant(),
				mostExpensiveCreditCardTransaction.getCategory(), mostExpensiveCreditCardTransaction.getAmount());
		
		
	}// main Method 

}// Class

//Creates a transaction object to hold merchant,category, and amount
class transaction {
	
	private String merchant;
	private String category; 
	private double amount; 
	
	public transaction(String merchant, String category, double amount) {
		this.merchant = merchant; 
		this.category = category; 
		this.amount = amount; 
		
	}//Transaction Constructor 
	
	//Returns Merchant of Transaction 
	public String getMerchant() {
		
		return merchant;
	}// getMerchant method 
	
	//Returns category  of Transaction 
	public String getCategory() {
		
		return category; 
	}//getCategory 
	
	//Returns amount of Transaction 
	public double getAmount() {
		
		return amount;
	}//getAmount 
	
}//Transaction class 

// Create a creditCard object to hold transaction objects 
class creditCard {
	
	private int maxTransactions;
	private int currentNumberTransactions = 0;
	private transaction[] creditCardTransactions;
	public creditCard(int maxTransactions) {
		
		this.maxTransactions = maxTransactions;
		this.creditCardTransactions = new transaction[maxTransactions];
	}//creditCard class
	
	// Adds transaction object to transaction array made in credit card class---creditCardTransactions
	public boolean setTransaction(transaction addTransaction) {
		
		boolean addedTransactionSuccessful = false;
		
		if(currentNumberTransactions < maxTransactions) {
			
			creditCardTransactions[currentNumberTransactions] = addTransaction; 
			
			addedTransactionSuccessful = true; 
		}
		else {
			addedTransactionSuccessful = false;
		}
		
		currentNumberTransactions++;
		return addedTransactionSuccessful;
	}//setTransaction 
	
	//Finding most expensive transaction in credit card
	public transaction findMostExpensiveTransaction() {
		
		double mostExpensiveTransactionAmount = 0;
		int mostExpensiveTransactionIndex = 0;
		
		for(int i = 0; i < creditCardTransactions.length; i++) {
			
			if(mostExpensiveTransactionAmount < creditCardTransactions[i].getAmount()) {
				
				mostExpensiveTransactionAmount = creditCardTransactions[i].getAmount();
				mostExpensiveTransactionIndex = i;
			}//If
		}//for
		
		return creditCardTransactions[mostExpensiveTransactionIndex];
	}//findMostExpensiveTranaction
	
	// Displays transactions added to creditCardTransactions
	public void displayAllTransactions() {
		
		//Pretext
		System.out.println("\nMerchant\t\tCategory\t\tAmount\n"
				+ "-----------------------------------------------------");
		
		// Displaying Transactions 
		for(int i = 0; i < creditCardTransactions.length; i++) {
			
			System.out.printf("%s\t\t%15s\t\t%14.2f\n", creditCardTransactions[i].getMerchant(),
					creditCardTransactions[i].getCategory(),creditCardTransactions[i].getAmount());
		}//for 
	}//DisplayAllTransactions method 
	
	
}//creditCard class