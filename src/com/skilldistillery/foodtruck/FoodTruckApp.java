package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {

//		only class that has scanner and menu

//		food truck ID will not be inputted by the user
//		will be automatically created by the FoodTruck constructor
//		from a static field that is incremented as each truck is created.

//		User Story #1
//		The user is prompted to input the name, food type, and rating for up to five
//		food trucks. For each set of input, a FoodTruck object is created, its fields
//		set to the user's input, and it is added to the array. The truck id is not
//		input by the user, but instead assigned automatically in the FoodTruck
//		constructor from a static field that is incremented as each truck is created.

		Scanner kb = new Scanner(System.in);
		FoodTruckApp app = new FoodTruckApp();
		final int MAX_TRUCKS = 5;
		int numTrucksEntered = 0;
		FoodTruck foodTruckList[];

		foodTruckList = new FoodTruck[MAX_TRUCKS];

		app.introMsg();

		// prompt for food truck info
		app.inputFoodTrucks(kb, foodTruckList);

//		User Story #4
//		After choosing a menu item, the user sees the menu again and can choose another item 
//		until the choose to quit.


		
		app.repeatOptions(app, kb, foodTruckList);

	}

	public void introMsg() {
		System.out.println("Thanks for using the Local Food Truck Rating App!");
	}

	private void enteringFoodTruckMenu() {
		System.out.println("\nPlease enter the food trucks: Name, food type, and a rating.");
		System.out.println("To stop adding trucks put \"exit\" as the truck name.");
	}

//		prompt user for name, food type, and rating for up to 5 food trucks
//		for each input create FoodTruck object
	public void inputFoodTrucks(Scanner kb, FoodTruck[] foodTruckList) {
		String name;
		String foodType;
		int rating;
		FoodTruck truck;

		for (int i = 0; i < foodTruckList.length; i++) {
			// prints what's needed and tells how to exit
			enteringFoodTruckMenu();

			System.out.print("Enter a truck name: ");
			name = kb.nextLine();

			// if user enters quit break out of truck q's
			if (name.equals("quit")) {
				break;
			} else {
				truck = new FoodTruck();
				truck.setName(name);

				System.out.print("Enter the food type: ");
				foodType = kb.nextLine();
				truck.setFoodType(foodType);

				System.out.print("Enter a rating (1, 2, 3, 4, or 5): ");
				rating = kb.nextInt();
				kb.nextLine(); // captures return key
				truck.setTruckRating(rating);

			}

			// sets array at i = to truck info
			System.out.println("Food Truck set at: " + i);
			foodTruckList[i] = truck;
		}

//		// DELETE
//		System.out.println("Hardcode array");
//		System.out.println("From array " + foodTruckList[0]);
//		System.out.println("From array " + foodTruckList[1]);
//		System.out.println("From array " + foodTruckList[2]);
//		System.out.println("From array " + foodTruckList[3]);
//		System.out.println("From array " + foodTruckList[4]);
//		System.out.println("Program has ended");
	}

//		User Story #3
//		After input is complete, the user sees a menu from which they can choose to:
//		List all existing food trucks.  DON'T SHOW NULL SPOTS
//		See the average rating of food trucks.  
//		Display the highest-rated food truck.
//		Quit the program.

	public void optionsMenu() {

		System.out.println("===================================");
		System.out.println("Please choose from the following...");
		System.out.println("1: A list of all food trucks");
		System.out.println("2: An average rating of food trucks");
		System.out.println("3: Display the highest-rated food truck");
		System.out.println("4: Quit program");
		System.out.println("===================================");

	}

	public void repeatOptions(FoodTruckApp app, Scanner kb, FoodTruck[] foodTruckList) {
		int userChoice;
		boolean keepGoing = true;
		
		do {
		// Display options user can choose
		app.optionsMenu();
		userChoice = kb.nextInt();

		switch (userChoice) {
		case 1:

			// DELETE test prints out truck array iteration
			for (int i = 0; i < foodTruckList.length; i++) {
				if (foodTruckList[i] != null) {
					System.out.println(foodTruckList[i]);
				}
			}
			break;
		case 2:

			break;
		case 3:
			calcAvgOfRatings(foodTruckList);
			break;
		case 4:
			app.exitMsg();
			keepGoing = false;
			break;
		default:
			System.out.println("That wasn't an option. Please choose again.");
		}
		}while (keepGoing);

	}
	
	public void calcAvgOfRatings(FoodTruck[] foodTruckList) {
		
		
		
	}

	public void exitMsg() {
		System.out.println("Thank you for using the app!");
	}

}
