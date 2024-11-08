package com.tech.snakeladder;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("Start a Snake And Ladder Game .....!");
         run();
	}

	private static void run() {
		// TODO Auto-generated method stub
		GameManager gamemanager = GameManager.getInstance();
		
		List<String> player1 = Arrays.asList("player 1", "player 2","player 3");
		gamemanager.startNewGame(player1);
		
		List<String> player2 = Arrays.asList("player 4","player 5");
		gamemanager.startNewGame(player2);
	}
	
	

}
