package com.skilldistillery.foodtruck;

public class FoodTruck {

	private String truckName;
	private String foodType;
	private int truckRating;
	private int truckId;
	private static int truckCounter = 1000;

	// Adds to all constructors
	{
		this.truckId = truckCounter++;
	}

	// Constructor
	public FoodTruck(String name, String foodType, int rating) {
		this.truckName = name;
		this.foodType = foodType;
		this.truckRating = rating;
	}

	public String getName() {
		return truckName;
	}

	public void setName(String name) {
		this.truckName = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getTruckRating() {
		return truckRating;
	}

	public void setTruckRating(int truckRating) {
		this.truckRating = truckRating;
	}

	public void displayFoodTruck() {
		String truckData = toString();
		System.out.println(truckData);
	}

	public String toString() {
		return "Truck: " + truckName + "\tFood: " + foodType + "\tRating: " + truckRating;
	}

}
