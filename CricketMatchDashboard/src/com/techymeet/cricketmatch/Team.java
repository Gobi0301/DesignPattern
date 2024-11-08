package com.techymeet.cricketmatch;

import java.util.ArrayList;
import java.util.List;

public class Team {

	List<Players> playerss;
	int totalRuns;
	int wickets;
	int extras;
	int overBowled;
	int ballsBowled;
	int currentPlayerIndex;
	
	public Team(List<String> playerNames) {
		playerss = new ArrayList<>();
		for(String name:playerNames) {
		//	playerss.add(new Players(name));
		}
	}
}
