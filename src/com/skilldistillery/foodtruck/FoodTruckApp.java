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

		// promt for food truck info
		app.inputFoodTrucks(kb, foodTruckList);

	}

	public void introMsg() {
		System.out.println("Thanks for using the Local Food Truck Rating App!");
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
				kb.nextLine(); 		// captures return key
				truck.setTruckRating(rating);
				
				// set truck ID
				truck.setTruckId();
			}
			
			// sets array at i = to truck info
			System.out.println("Food Truck set at: " + i);
			foodTruckList[i] = truck;
		}
		
		// DELETE test prints out truck array iteration 
		for (int i = 0; i < foodTruckList.length; i++) {
			if(foodTruckList[i] != null)
				System.out.println("Food Truck " + (i + 1));
				System.out.println(foodTruckList[i]);
			}
			
		// DELETE
		System.out.println("Hardcode array");
		System.out.println("From array " + foodTruckList[0]);
		System.out.println("From array " + foodTruckList[1]);
		System.out.println("From array " + foodTruckList[2]);
		System.out.println("From array " + foodTruckList[3]);
		System.out.println("From array " + foodTruckList[4]);
		System.out.println("Program has ended");
	}

	private void enteringFoodTruckMenu() {
		System.out.println("\nPlease enter the food trucks: Name, food type, and a rating.");
		System.out.println("To stop adding trucks put \"exit\" as the truck name.");
	}

}

//		User Story #2
//		If the user inputs quit for the food truck name, input ends immediately and the program continues.

//		User Story #3
//		After input is complete, the user sees a menu from which they can choose to:

//		List all existing food trucks.  DON'T SHOW NULL SPOTS
//		See the average rating of food trucks.  
//		Display the highest-rated food truck.
//		Quit the program.

//		User Story #4
//		After choosing a menu item, the user sees the menu again and can choose another item until the choose to quit.