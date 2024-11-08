package com.techymeet.cricketmatch;

public class Players {

	String name;
	int runs;
	int balls;
	int fours;
	int sixes;
	
	public Players(String name,int runs ,int balls,int fours,int sixes) {
		this.name = name;
		this.runs = 0;
		this.balls = 0;
		this.fours = 0;
		this.sixes = 0;
	}
	
	public void addRuns(int runs) {
		this.runs += runs;
		this.balls++;
		
		if(runs == 4)
			this.fours++;
		if(runs == 6)
			this.sixes++;
	}
	
	 public String toString(boolean onStrike) {
	        return name + (onStrike ? "*" : "") + " " + runs + " " + fours + " " + sixes + " " + balls;
	    }
}
