package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {

//		User Story #1
//		The user is prompted to input the name, food type, and rating for up to five
//		food trucks. For each set of input, a FoodTruck object is created, its fields
//		set to the user's input, and it is added to the array. The truck id is not
//		input by the user, but instead assigned automatically in the FoodTruck
//		constructor from a static field that is incremented as each truck is created.

		Scanner kb = new Scanner(System.in);
		FoodTruckApp app = new FoodTruckApp();
		final int MAX_TRUCKS = 5;

		FoodTruck foodTruckList[];

		// Construct food truck array
		foodTruckList = new FoodTruck[MAX_TRUCKS];

		app.introMsg();

		// Prompt user for food truck info (name, food type, rating)
		app.inputFoodTrucks(kb, foodTruckList);

//		User Story #4
//		Shows user menu (1: see list of trucks 2: view avg rating of all trucks 3: view highest rated truck
//		4: quit) After choosing a menu item, the user sees the menu again and can choose to another item 
//		until they choose to quit.
		app.repeatOptions(app, kb, foodTruckList);

		kb.close();
	}

	public void introMsg() {
		System.out.println("Thanks for using the Rusty Food Truck Rating App!");
	}

	private void foodTruckRatingDescription() {
		System.out.println("\nPlease enter the food trucks: Name, food type, and a rating.");
		System.out.println("To stop adding trucks put \"exit\" as the truck name.");
	}

	// Prompt user for name, food type, and rating for up to 5 food trucks
	// for each input create FoodTruck object
	public void inputFoodTrucks(Scanner kb, FoodTruck[] foodTruckList) {
		String name;
		String foodType;
		int rating;

		FoodTruck truck;

		for (int i = 0; i < foodTruckList.length; i++) {

			// Prints what to rate and tells how to exit
			foodTruckRatingDescription();

			System.out.print("Enter a truck name: ");
			name = kb.nextLine();

			// If user enters "quit" as name break out of rest of truck questions
			if (name.equals("quit")) {
				break;
			} else {

				System.out.print("Enter the food type: ");
				foodType = kb.nextLine();

				System.out.println("Enter a rating (1, 2, 3, 4, or 5): ");
				System.out.print("1 being poor and 5 being excellent: ");
				rating = kb.nextInt();
				kb.nextLine(); // captures return key
				truck = new FoodTruck(name, foodType, rating);
			}

			// Assign truck to array location at value i
			foodTruckList[i] = truck;
		}

	}

	public void optionsMenu() {

		System.out.println("\n===================================");
		System.out.println("Please choose from the following...");
		System.out.println("1: A list of all food trucks");
		System.out.println("2: An average rating of food trucks");
		System.out.println("3: Display the highest-rated food truck");
		System.out.println("4: Quit program");
		System.out.println("===================================");
		System.out.print("Option: ");
	}

	public void repeatOptions(FoodTruckApp app, Scanner kb, FoodTruck[] foodTruckList) {
		int userChoice;
		boolean keepGoing = true;
		double avgRating;

		do {
			// Display options user can choose
			app.optionsMenu();
			userChoice = kb.nextInt();
			kb.nextLine(); // captures return key

			switch (userChoice) {
			case 1:
				System.out.println();

				// Lists trucks in array.
				for (int i = 0; i < foodTruckList.length; i++) {
					if (foodTruckList[i] != null) {
						foodTruckList[i].displayFoodTruck();
					}
				}
				break;
			case 2:
				// Calculate average rating of trucks in array
				avgRating = calcAvgOfRatings(foodTruckList);
				System.out.println("\nThe avg rating of all the food trucks was: " + avgRating);
				break;
			case 3:
				// Displays highest rated truck.
				findHighestRated(foodTruckList);
				break;
			case 4:
				app.exitMsg();
				keepGoing = false;
				break;
			default:
				System.out.println("That wasn't an option. Please choose again.");
			}
		} while (keepGoing);

	}

	public double calcAvgOfRatings(FoodTruck[] foodTruckList) {
		double ratingAvg = 0;
		double ratingsTotal = 0;
		int totalTrucks = 0;

		for (int i = 0; i < foodTruckList.length; i++) {
			if (foodTruckList[i] != null) {
				totalTrucks += 1;
				ratingsTotal += foodTruckList[i].getTruckRating();
			}
			ratingAvg = (ratingsTotal / totalTrucks);
		}
		return ratingAvg;
	}

	public void findHighestRated(FoodTruck[] foodTruckList) {
		String highestRated = "";
		int highestRating = 0;

		// Checks if array spot is NOT null AND if the truck rating is lower than the
		// current truck
		for (int i = 0; i < foodTruckList.length; i++)
			if ((foodTruckList[i] != null) && highestRating < foodTruckList[i].getTruckRating()) {
				highestRated = foodTruckList[i].getName();
				highestRating = foodTruckList[i].getTruckRating();
			}

		System.out.println(
				"\nThe highest rated food truck was: " + highestRated + " with a rating of " + highestRating + ".");
	}

	public void exitMsg() {
		System.out.println("\nThank you for using the app! Next meal's on us!");
	}

}
