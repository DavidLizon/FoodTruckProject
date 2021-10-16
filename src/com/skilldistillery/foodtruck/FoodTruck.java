package com.skilldistillery.foodtruck;

public class FoodTruck {
	
//	 has name, food type, rating, ID
//	 ID will be assigned automatically in the FoodTruck constructor from a 
//      static field that is incremented as each truck is created
	
	private String truckName;
	private String foodType;
	private int truckRating;
	private static int truckId;
	private int idNum = 1000;
	
	
	public FoodTruck() { }
	
	public FoodTruck(String name, String foodType, int rating) {
		this.truckName = name;
		this.foodType = foodType;
		this.truckRating = rating;

//		truckIdCreator(idNum);
	}
	
	private static int truckIdCreator(int id) {
		truckId = id;
//		idNum++; 
		return truckId;
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


	
	public String toString() {
		return "Truck: " + truckName + ", Food: " + foodType + ", Rating: " + truckRating
				+ ", idNum=" + idNum + "]";
	}
	
	public void displayFoodTruck() {
		String truckData = toString();
		System.out.println(truckData);
	}
	
}

	
