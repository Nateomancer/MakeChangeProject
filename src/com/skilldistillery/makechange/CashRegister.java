//Nathan Hafley
//03.21.22
//SD Project 1
//Make Change

package com.skilldistillery.makechange;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {

		// Declare and initialize variables, make scanner
		// Used in program to determine price of items and the amount tendered by
		// customer
		double price;
		double amount;
		// Keeps while loop running while true to simulate open register
		boolean regOpen = true;
		// Scanner is user to collect input from user
		Scanner input1 = new java.util.Scanner(System.in);
		Scanner input2 = new java.util.Scanner(System.in);

		// Loop Keeps register open for as long as regOpen stays true
		do {

			// Header
			System.out.println("-------------------");
			System.out.println("---- QUICKSTOP ----");
			System.out.println("-------------------");

			// User Story #1
			// The user is prompted asking for the price of the item.
			System.out.println("Hello");
			System.out.println("Please enter the price of the item");
			price = input1.nextDouble();
			System.out.println("You entered: $" + price);

			// User Story #2
			// The user is then prompted asking how much money was tendered by the customer.
			System.out.println("");
			System.out.println("Please enter the ammount tendered by customer");
			amount = input1.nextDouble();

			System.out.println("You entered: $" + amount);
			System.out.println("");
			System.out.println("Calculating change...");
			System.out.println("");

			// User Story #3
			// Display an appropriate message if the customer provided too little money or
			// the exact amount

			// Customer provided exact amount
			if (price == amount) {

				System.out.println("Total: $" + price);
				System.out.println("Amount tendered: $" + amount);
				System.out.println("The amount tendered is equal to the total.");
				System.out.println("-----------------");
				System.out.println("Change Due $0.00");
				System.out.println("-----------------");
				System.out.println("");
				System.out.println("Thankyou. Have a great day!");
				System.out.println("");
				System.out.println("------------------");
				System.out.println("End of Transaction");
				System.out.println("------------------");
				System.out.println("");

				// Ask user if they would like to keep the register open
				System.out.println("Keep Register open? Enter (Y/N)");
				String regInput = input2.nextLine();

				// User answers yes, register stays open. Loop and program continues
				if (regInput.equals("Y") || regInput.equals("y")) {
					regOpen = true;
					System.out.println("");
					System.out.println("");
					// User says not, register closes.Ends the program
				} else if (regInput.equals("N") || regInput.equals("n")) {

					System.out.println("The register is now closed. Have a great day.");
					regOpen = false;
					input2.close();
				}

			}

			// Customer provided too little
			else if (amount < price) {
				System.out.println("***ERROR***");
				System.out.println("The amount tendered is not enough");
				System.out.println("The amount due is $" + price);
				System.out.println("Please try again");
				System.out.println("");
				System.out.println("");

			}

			// User Story #4
			// If the amount tendered is more than the cost of the item, display the number
			// of bills and coins that should be given to the customer.

			else if (amount > price) {

				// HOLDS CURRENT AMOUNT OF CHANGE TO BE RETURNED TO CUSTOMER
				double change;

				// Output change total
				change = amount - price;
				System.out.println("----------------------");
				System.out.print("Your change is $");
				System.out.printf("%.2f", change);
				System.out.println("");
				System.out.println("----------------------");

				// ****Calculates Dollar Change****
				// Change is provided using the largest bill and coin denominations as possible
				// Denominations that are not used are not displayed

				// ****Calculates Dollar Change amount in twenties****
				double changeTwentyDollar = (change / 20);
				if ((int) changeTwentyDollar != 0) {
					System.out.println("Twenty Dollar Bill(s): " + (int) changeTwentyDollar);
				}
				change = change - (20 * (int) changeTwentyDollar);

				// ****Calculates Dollar Change amount in tens****
				double changeTenDollar = (change / 10);
				if ((int) changeTenDollar != 0) {
					System.out.println("Ten Dollar Bill(s) " + (int) changeTenDollar);
				}
				change = change - (10 * (int) changeTenDollar);

				// ****Calculates Dollar Change amount in fives****
				double changeFiveDollar = (change / 5);
				if ((int) changeFiveDollar != 0) {
					System.out.println("Five Dollar Bill(s) " + (int) changeFiveDollar);
				}
				change = change - (5 * (int) changeFiveDollar);

				// ****Calculates Dollar Change amount in ones****
				double changeOneDollar = (change / 1);
				if ((int) changeOneDollar != 0) {

					System.out.println("One Dollar Bill(s): " + (int) changeOneDollar);
				}
				change = change - (1 * (int) changeOneDollar);

				// ****Calculates Coin Change.****

				// Makes remaining coin change a whole number so that is can be easier to
				// calculate
				double coinChange = change * 100;
				coinChange = Math.round(coinChange);

				// ****Calculates Quarter Coin Change Amount***
				double changeQuarters = (coinChange / 25);
				coinChange = coinChange - (25 * (int) changeQuarters);
				if ((int) changeQuarters != 0) {

					System.out.println("Quarter(s): " + (int) changeQuarters);
				}

				// ****Calculates Dime Coin Change Amount***
				double changeDimes = (coinChange / 10);
				coinChange = coinChange - (10 * (int) changeDimes);
				if ((int) changeDimes != 0) {

					System.out.println("Dime(s): " + (int) changeDimes);
				}

				// ****Calculates Nickel Coin Change Amount***
				double changeNickels = (coinChange / 5);
				coinChange = coinChange - (5 * (int) changeNickels);
				if ((int) changeNickels != 0) {

					System.out.println("Nickel(s): " + (int) changeNickels);
				}

				// ****Calculates Penny Coin Change Amount***
				double changePenny = (coinChange / 1);
				coinChange = coinChange - (1 * (int) changePenny);
				if (changePenny != 0) {

					System.out.println("Penny(s): " + (int) changePenny);
				}

				// Marks the end of the transaction
				System.out.println("");
				System.out.println("Thankyou. Have a great day!");
				System.out.println("");
				System.out.println("------------------");
				System.out.println("End of Transaction");
				System.out.println("------------------");
				System.out.println("");

				// Ask user if they would like to keep the register open for other transactions
				System.out.println("Keep Register open? Enter (Y/N)");
				String regInput = input2.nextLine();

				// User answers yes, register stays open. Loop and program continues
				if (regInput.equals("Y") || regInput.equals("y")) {
					regOpen = true;
					System.out.println("");
					System.out.println("");
					// User says no, register closes. Ends loop and the program
				} else if (regInput.equals("N") || regInput.equals("n")) {

					System.out.println("The register is now closed. Have a great day.");
					regOpen = false;
					input2.close();
				}

			}

			else {
				System.out.print("***Error***");
				System.out.println("Please try again");
				System.out.println("");
			}

			// End of while loop. Terminates when register is closed at the end of
			// transaction.
		} while (regOpen == true);

		// Closes scanner used to input price/amount
		input1.close();
	}

}
