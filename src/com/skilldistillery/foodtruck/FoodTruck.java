package com.skilldistillery.foodtruck;

public class FoodTruck {
	
//	 has name, food type, rating, ID
//	 ID will be assigned automatically in the FoodTruck constructor from a 
//      static field that is incremented as each truck is created
	
	private String truckName;
	private String foodType;
	private int truckRating;
	private int truckId;
	private static int truckCounter = 0;
	
	
	public FoodTruck() { }
	
	public FoodTruck(String name, String foodType, int rating) {
		
		this.truckName = name;
		this.foodType = foodType;
		this.truckRating = rating;
		this.truckId = truckIdCreator();
	}
	
	private int truckIdCreator() {
		
//		ATTEMPT TO FIX ON MY OWN
		int truckNum;
		truckNum = truckCounter;
		truckCounter++;
		System.out.println("TruckCounter: " + truckCounter);
		return truckNum;
		
		
//		Came up with TA
//		truckId = truckCounter;
//		truckCounter++;
//		return truckId;
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


//	public int getTruckId() {
//		return truckId;
//	}
//	
//	public void setTruckId() {
//		this.truckId = truckIdCreator(idNum);
//		idNum++;
//	}
	
	public String toString() {
		return "Truck: " + truckName + ", Food: " + foodType + ", Rating: " + truckRating
				+ ", Truck ID: " + truckId + "]";
	}
	
	
//	MAYBE DONT NEED
	public void displayFoodTruck() {
		String truckData = toString();
		System.out.println(truckData);
	}
	
}

	
