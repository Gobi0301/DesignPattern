package com.techList.flight;

public enum MealOption {

	Veg(200),Non_Veg(300),Vegan(250),None(0);
	
	private int price;
	
	MealOption(int price){
		this.price =  price;
	}
	
	public int getPrice() {
		return price;
	}
}
