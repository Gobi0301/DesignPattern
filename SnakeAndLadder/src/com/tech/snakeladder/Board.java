package com.tech.snakeladder;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private static final int Board_Size = 100;
	private  List<Snake> snakes;
	private  List<Ladder> ladders;
	
	public Board() {
		snakes = new ArrayList<>();
		ladders = new ArrayList<>();
		intializeSnakesAndLadders();
	}

	private void intializeSnakesAndLadders() {
		// TODO Auto-generated method stub
		snakes.add(new Snake(16,6));
		snakes.add(new Snake(48,26));
		snakes.add(new Snake(64,60));
		snakes.add(new Snake(93,73));
		
		
		ladders.add(new Ladder(1,38));
		ladders.add(new Ladder(4,14));
		ladders.add(new Ladder(9,31));
		ladders.add(new Ladder(21,42));
		ladders.add(new Ladder(28,84));
		ladders.add(new Ladder(51,67));
		ladders.add(new Ladder(80,99));
	}

	public static int getBoardSize() {
		return Board_Size;
	}
	

	public int getNewPositionAfterSnakeOrLadder(int position) {
		for(Snake snake:snakes) {
			if(snake.getStart() == position) {
				return snake.getEnd();
			}
		}
		
		for(Ladder ladder:ladders) {
			if(ladder.getStart() == position) {
				return ladder.getEnd();
			}
		}
		return position;
	}
	
}
