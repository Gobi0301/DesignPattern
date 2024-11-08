package com.tech.snakeladder;

public class Dice {

	private static int MIN_VALUE = 1;
	private static int MAX_VALUE = 6;
	
	public int roll() {
		return (int) (Math.random() * (MAX_VALUE - MIN_VALUE +1)+MIN_VALUE);
	}
	
}

