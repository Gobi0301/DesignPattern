package com.techymeet.cricketmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CricketScoreCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of players in each team:");
		int numPlayers = sc.nextInt();
		System.out.println("Enter the number of Overs");
		int overs = sc.nextInt();
		
		System.out.println("Enter the batting order for Team 1:");
		List<String> team1Players = new ArrayList<>();
		for(int i=0;i<numPlayers;i++) {
			team1Players.add(sc.next());
		}
		System.out.println("Enter the batting order for Team 2:");
		List<String> team2Players = new ArrayList<>();
		for(int i=0;i<numPlayers;i++) {
			team2Players.add(sc.next());
		}
		
		
	}

}
