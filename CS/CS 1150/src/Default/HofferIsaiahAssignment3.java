package Default;
import java.util.*;
/* Isaiah Hoffer
 * CS1150 (M/W)
 * 9/16/24
 * Assignment 3
 * This code shows that I understand the basics of nested if statements 
 * and gives me more practice with printf() and user input. This code 
 * will show a user a table and give them the option to choose from 
 * that table and it will use if statements to see if the user's response 
 * was valid
*/
public class HofferIsaiahAssignment3 {
	public static void main(String[] args) {
		// All the Constant Variables 
		 final Double PLATINUMCOSTPM = 29.99;
		 final Double GOLDCOSTPM = 19.99;
		 final Double BASICCOSTPM = 9.99;
		 final Double NOADDONCOST = 0.00;
		 final Double CHILDCARECOST = 5.00;
		 final Double PERSONALTRAININGCOST = 20.00;
		 final Double ENROLLMENTFEE = 20.00; //One time Enrollment Fee

		 //Create empty String and Double variables
		 String chosenMembershipName = "";
		 Double chosenMembershipCost = 0.0;
		 String chosenAddOnName = "";
		 Double chosenAddOnCost = 0.0;

		// Table for memberships 
		 System.out.println("Option\t  Membership\tMonthy Cost\n"
		 		+ "-------------------------------------");
		 System.out.printf("%d\t  %s\t%s%4.2f",1,"Platnium","$",PLATINUMCOSTPM); //Platinum 
		 System.out.printf("\n%d\t  %s\t\t%s%4.2f",2,"Gold","$",GOLDCOSTPM); // Gold
		 System.out.printf("\n%d\t  %s\t\t%s%4.2f",3,"Basic","$",BASICCOSTPM); // Basic 
		 
		 Scanner input = new Scanner(System.in); // Created a scanner named input 
		 
		// Asked the user for what membership they want 
		 System.out.println("\nWhat membership do you want to buy? 1, 2, or 3:");
		 int membership = input.nextInt();
		 
		// Statements to see if user imputed a valid response (1-3)
		 if ((membership > 0) && (membership < 4)) {
			 // Finding the name of membership chosen
			 if (membership == 1) {
				 chosenMembershipName = "Platinum";
				 chosenMembershipCost = PLATINUMCOSTPM;
			 }
			 else if (membership == 2) {
				 chosenMembershipName = "Gold";
				 chosenMembershipCost = GOLDCOSTPM;
			 }
			 else if (membership == 3) {
				 chosenMembershipName = "Basic";
				 chosenMembershipCost = BASICCOSTPM;
			 }

			 //Table for Add-Ons 
			 System.out.println("Option\t  Add-On\t   Price\n"
			 		+ "----------------------------------");
			 System.out.printf("%d\t%s\t   %s%4.2f",1,"No Add On","$",NOADDONCOST); // No add on
			 System.out.printf("\n%d\t%s\t   %s%4.2f",2,"Child Care","$",CHILDCARECOST); // Child Care
			 System.out.printf("\n%d\t%s  %s%4.2f",3,"Personal Training","$",PERSONALTRAININGCOST); // Personal Training 
			 
			 // Prompting user for what add-on they want 
			 System.out.println("\nWould you like to buy an add-on? 1, 2, or 3:");
			 int addOn = input.nextInt();
			 
			 if ((addOn > 0) && (addOn < 4)) {
				 //Finding what add-on user chose 
				 if (addOn == 1) {
					 chosenAddOnName = "No Add On";
					 chosenAddOnCost = NOADDONCOST;
				 }
				 else if (addOn == 2) {
					 chosenAddOnName = "Child Care";
					 chosenAddOnCost = CHILDCARECOST;
				 }
				 else if (addOn == 3) {
					 chosenAddOnName = "Personal Training";
					 chosenAddOnCost = PERSONALTRAININGCOST;
				 }
				 
				 //Final Table showing Total 
				 //Monthly Costs
				 System.out.println("Monthly Costs\n"
				 		+ "----------------------------------");
				 System.out.printf("%s\t%s%4.2f",chosenMembershipName + " Membership","$",chosenMembershipCost);
				 
				 //One Time Cost 
				 System.out.println("\n\n----------------------------------\n"
				 		+ "One Time Costs\n"
				 		+ "----------------------------------");
				 System.out.printf("%s\t%s%4.2f",chosenAddOnName,"$",chosenAddOnCost);
				 System.out.printf("\n%s\t\t%s%5.2f","Enrollment Fee","$",ENROLLMENTFEE);
				 System.out.println("\n----------------------------------");
				 
				 // Final Costs 
				 Double finalCost = chosenMembershipCost + chosenAddOnCost + ENROLLMENTFEE; // made variable to hold the total 
				 System.out.println("Due Today\n"
				 		+ "----------------------------------");
				 System.out.printf("%s\t\t%5.2f","Total Cost",finalCost);
			 }
			 // Not a Valid response 
			 else {
				 System.out.println("Sorry we do not have that option here. Please try again!");
			 }
		 }
		 // Not Valid Response 
		 else {
				 System.out.println("Sorry we do not have that option here. Please try again!");
		 }
	}
}
