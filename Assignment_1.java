//Get HIP - Java 
//Assignment #1 - "Simple ATM"
//Created By Jason Huang
//+----Description------------------------------------------------------------------------------------------------------+
//| Huge Bank Inc. has contracted with my firm to implement the software for their new line of ATMs.           			|
//| I wrote a program that will allow their customers to access accounts, make deposits and make withdrawals.			|
//| Huge Bank Inc. has high expectations for quality, but will be blown away by my excellent coding. 			 		|	
//|																														|
//|	This program: 																										|
//|		1. Will take in user input for PIN, menu options, deposit amount, withdrawal amount.							|
//|		2. Is Resistant to crashing (Will not return any errors).														|	
//|		3. Stores the balance amount throughout the runtime. 															|
//| 	4. Deserves national recognition.																				|
//+---------------------------------------------------------------------------------------------------------------------+


import java.util.Scanner;

public class Assignment_1 {

	Scanner input = new Scanner(System.in);
	private int pin;
	private boolean locked = true;
	private double cash = 0;
	private int opt = -1;
	private double temp;

	//Constructor
	public Assignment_1() {
		
		//while "locked" is true it will keep the pin method in a loop
		while(locked == true) {
			pin();
		}
		//Calls for the Welcome method 
		welcome();
		
	}
	
	//Method for asking for the correct PIN. (PIN is set to "6 6 6 6").
	public void pin() {
		
		System.out.println("Welcome to Huge Bank Inc.");
		
		//while int pin is not equal to the assigned PIN, this loop will go on forever
		while(pin != 6666) {
			
			System.out.println("Please Enter your PIN: ");
			
			//This try and catch will attempt to take in a integer
			//if it takes in anything else, it will skip through the loop and try again. 
			try { 
				
				pin = input.nextInt();
				
			} catch (java.util.InputMismatchException e) {
			
				System.out.println("Error: Please enter numeric values.");
				System.out.println();
				input.next();
				continue;
			}
			
			//This if statement checks if int pin is not equal to the assigned PIN
			//If true it will return an error message and the loop will restart
			///Else it will unlock the loop on the constructor, and allow for the user to pass
			if(pin != 6666) {
				System.out.println("Incorrect PIN.");
				System.out.println();		
			} else {
				locked = false;
				System.out.println();
				System.out.println("You have logged in.");
				System.out.println();
			}
		}
		
	}
	
	//Method for the home menu w/ 3 options.
	public void welcome() {
		
		System.out.println("============ Home ============");
		System.out.printf("Your current balance is: $%.2f.\n", cash);
		System.out.println();
		
		System.out.println("\t1. Make a Deposit");
		System.out.println("\t2. Make a Withdrawal");
		System.out.println("\t3. Log out");
		
		//Calls for the menu method
		menu();
	
	}
	
	//Method for asking which option to choose.
	public void menu() {
		
		//creates a new "on" boolean
		boolean on = true;
		
		//while on is true, it will continue this loop forever
		while(on == true) {
		
			//This try and catch will attempt to take in a integer
			//if it takes in anything else, it will skip through the loop and try again. 
			try { 
				
				opt = input.nextInt();
				
			} catch (java.util.InputMismatchException e) {
		
				System.out.println("Please choose an option 1 - 3.");
				System.out.println();
				input.next();
				continue;
			}
			
			//This if statement checks if opt is between 1 - 3.
			//If it is, then switch through the 3 different options
			if(opt > 0 && opt < 4) {
				
				System.out.print("You have selected Option: ");
				
				switch (opt) {
					
					//If selected this will call on the deposit method 
					// and set on to false to discontinue the loop
					case 1:
						System.out.println("1");
						System.out.println();
						deposit();
						on = false;
						break;
					//If selected this will call on the withdrawal method 
					// and set on to false to discontinue the loop	
					case 2:
						System.out.println("2");
						System.out.println();
						withdrawal();
						on = false;
						break;
					//If selected this will terminate the program
					case 3:
						System.out.println("3");
						System.out.println();
						System.out.println("You have logged out.");
						System.exit(0);
				}

			//else if hacks are enabled, and brings you to the welcome menu
			// and set on to false to discontinue the loop	
			} else if(opt == 1337) {
				System.out.println();
				System.out.println("Hacks enabled.");
				System.out.println();
				cash = 999999999.99;
				welcome();
				on = false;
				
			//else if opt does not equal 1 - 3, the loop will restart 
			} else {
				
				System.out.println("Please choose an option 1 - 3.");
				System.out.println();
			}
		
		}
		
	}
	
	//Method for asking how much to deposit
	public void deposit() {
		
		while(true) {
			
			System.out.println("How much would you like to deposit?");
			
			//This try and catch will attempt to take in a integer
			//if it takes in anything else, it will skip through the loop and try again. 
			try { 
			
				temp = input.nextInt();
				
			} catch (java.util.InputMismatchException e) {
	
				System.out.println("Please enter a numerical ammount.");
				System.out.println();
				input.next();
				continue;
			}
			
			//checks if temp is not a negative number and checks if it does not exceed the double limit
			//if not then it will add temp amount to the total balance
			//and bring you back to the welcome menu
			if(cash + temp > 999999999.99) {
				
				System.out.println("That amount is too high!");
				System.out.println();
			} else if(temp >= 0) {
				
				cash = cash + temp;
				System.out.println();
				System.out.printf("You have successfully deposited $%.2f.\n", temp);
				System.out.println();
				welcome();
			//else it will return an error message and the loop will restart
			} else {
				
				System.out.println("You cannot deposit a negative ammount!");
				System.out.println();
			}
		}

	}
	
	//Method for asking how much to withdrawal
	public void withdrawal() {
		
		while(true) {
		
			System.out.println("How much would you like to withdrawal?");
			
			//This try and catch will attempt to take in a integer
			//if it takes in anything else, it will skip through the loop and try again. 
			try { 
			
				temp = input.nextInt();
				
			} catch (java.util.InputMismatchException e) {
	
				System.out.println("Please enter a numerical ammount.");
				System.out.println();
				input.next();
				continue;
			}
			
			//checks if temp is great than 0 but is not greater than the current balance
			//if not then it will subtract temp amount to the total balance
			//and bring you back to the welcome menu
			if(temp >= 0) {
				
				if(cash >= temp) {
				
					cash = cash - temp;
					System.out.println();
					System.out.printf("You have successfully withdrew $%.2f.\n", temp);
					System.out.println();
					welcome();
				} else {
					
					System.out.println("You can't afford that!");
					System.out.println();
				}

			//else it will return an error message and the loop will restart
			} else {
				
				System.out.println("You can't withdrawal a negative amount!");
				System.out.println();
			}
		}

	}
	
	//Main
	public static void main(String[] args) {
		
		//calls a new constructor
		new Assignment_1();
		
	}

}