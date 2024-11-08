package com.techboss.elevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Elevator {

	private static final int MIN_FLOOR = 0;
	private static final int MAX_FLOOR = 10;
	private static final int PROCESSING_TIME = 500;//millisecond
	
	private int currentFloor;
	private Direction currentDirection;
	private Map<Integer,List<Integer>> requestPathMap;
	private Boolean[] currentFloorDestinations;
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	public Map<Integer, List<Integer>> getRequestPathMap() {
		return requestPathMap;
	}

	public Boolean[] getCurrentFloorDestinations() {
		return currentFloorDestinations;
	}

	public Elevator() {
		this.currentFloor = 0;
		this.currentDirection = Direction.UP;
		this.requestPathMap = new HashMap<>();
		this.currentFloorDestinations = new Boolean[MAX_FLOOR+1];
		Arrays.fill(this.currentFloorDestinations, Boolean.FALSE);
	}
	
	public void start() throws InterruptedException{
		currentDirection = Direction.UP;
		do {
			System.out.println("-------------------");
			processFloor(currentFloor);
			System.out.println("--------------------");
		}while(currentDirection != Direction.IDLE); {
			System.out.println("No one is waiting and no one is looking to go anywhere");
			System.out.println("Chilling for now");
		}
	}
	
	public void lunchtimeElevatorRush() {
		Random random = new Random();
		for(int i=0;i<30;i++) {
			callElevator(random.nextInt(11),random.nextInt(10)+1);
		}
	}
	
	
	private void callElevator(int start, int destination) {
		// TODO Auto-generated method stub
		
		if(isInvalidFloor(start) || isInvalidFloor(destination) || start == destination) {
			System.out.println("INVALID FLOORS. TRY AGAIN");
			return;
		}
		requestPathMap.computeIfAbsent(start, k-> new ArrayList<>()).add(destination);
	}
	private void processFloor(int floor) throws InterruptedException {
		// TODO Auto-generated method stub
		if(currentFloorDestinations[floor]) {
			System.out.println("UN-BOARDING at floor: "+floor);
		}
		if(requestPathMap.containsKey(floor)) {
			System.out.println("BOARDING at Floor: "+floor);
			requestPathMap.get(floor).forEach(destinationFloor -> 
			                             currentFloorDestinations[destinationFloor] = true);
			requestPathMap.remove(floor);
		}
		currentFloorDestinations[floor] = false;
		moveElevator();
	}
	private void moveElevator() throws InterruptedException {
		// TODO Auto-generated method stub
		if(!Arrays.asList(currentFloorDestinations).contains(true) && requestPathMap.isEmpty()) {
			currentDirection = Direction.IDLE;
			return;
		}else if(isInvalidFloor(currentFloor +1)) {
			currentDirection = Direction.DOWN;
		}else if(isInvalidFloor(currentFloor - 1)) {
			currentDirection = Direction.UP;
		}
		
		if(currentDirection == Direction.UP) {
			moveUp();
		}else if(currentDirection == Direction.DOWN) {
			moveDown();
		}else {
			System.out.println("Elevator Malfunctioned");
		}
	}
	private boolean isInvalidFloor(int floor) {
		// TODO Auto-generated method stud
		return floor < MIN_FLOOR || floor >MAX_FLOOR;
	}
	private void moveUp() throws InterruptedException{
		// TODO Auto-generated method stub
		currentFloor++;
		System.out.println("GOING UP TO" + currentFloor);
		Thread.sleep(PROCESSING_TIME);
	}
	
	private void moveDown() throws InterruptedException{
		currentFloor--;
		System.out.println("GOING DOWN TO " + currentFloor);
		Thread.sleep(PROCESSING_TIME);
	}
	
}
