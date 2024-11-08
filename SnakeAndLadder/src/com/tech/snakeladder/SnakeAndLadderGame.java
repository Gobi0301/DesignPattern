package com.tech.snakeladder;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGame {

	private Board board;
	private List<Player> players;
	private Dice dice;
	private int currentPlayerIndex;
	
     public SnakeAndLadderGame(List<String> playerNames) {
    	 board = new Board();
    	 dice = new Dice();
    	 players = new ArrayList<>();
    	 for(String playerName : playerNames) {
    		 players.add(new Player(playerName));
    	 }
    	 currentPlayerIndex = 0;
     }
     
     public void play() {
    	 
    	 while(!isGameOver()) {
    		 Player currentPlayer = players.get(currentPlayerIndex);
    		 int diceRoll = dice.roll();
    		 int newPosition = currentPlayer.getPosition() + diceRoll;
    		 
    		 if(newPosition <= board.getBoardSize()) {
    			 currentPlayer.setPosition(board.getNewPositionAfterSnakeOrLadder(newPosition));
    			 System.out.println(currentPlayer.getName() + "  rolled a " + diceRoll + " "
    			 		+ "and moved positon " + currentPlayer.getPosition());
    		 }
    		 
    		 if(currentPlayer.getPosition() == board.getBoardSize()) {
    			 System.out.println(currentPlayer.getName() + "Wins !");
    			 break;
    		 }
    		 
    		 currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    	 }
     }

	private boolean isGameOver() {
		// TODO Auto-generated method stub
		for(Player player : players) {
			if(player.getPosition() == board.getBoardSize()) {
				return true;
			}
		}
		return false;
	}
     
}
