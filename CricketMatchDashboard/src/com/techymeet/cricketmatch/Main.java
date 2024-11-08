package com.techymeet.cricketmatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter TotalNo of Players in each Team:");
		int totalPlayers=Integer.parseInt(sc.next());
		System.out.println("Please Enter totalNo of Overs in match:");
		int totalOvers=Integer.parseInt(sc.next());
		ScoreCard.initialize(totalOvers,totalPlayers);
		ScoreCard team1 = new ScoreCard(1);
		ScoreCard team2 = new ScoreCard(2);

			//team1 batting
			while(team1.totalOversRemaining[0]!=totalOvers && team1.wickets!=totalPlayers-1){
			    System.out.println();
			    System.out.println("Team 1:");
			    System.out.println();
			    System.out.println("Enter ball ==> ");
			    String ball=sc.next();
			    team1.updateScoreCard(ball);
			    System.out.println();
			    team1.PrintScoreCard();
			    System.out.println();
			}
			
			//team2 batting
			while(team2.totalOversRemaining[0]!=totalOvers && team2.wickets!=totalPlayers-1){
			    System.out.println();
			    System.out.println("Team 2:");
			    System.out.println();
			    System.out.println("Enter ball ==> ");
			    String ball=sc.next();
			    team2.updateScoreCard(ball);
			    if(team2.totalRuns>team1.totalRuns){ 
			        System.out.println("Team2 won by "+(team2.totalRuns-team1.totalRuns)+" runs!");
			        System.out.println();
			        team2.PrintScoreCard();
			        System.out.println();
			        break;
			    } else if(team2.totalRuns<team1.totalRuns && team2.wickets==totalPlayers-1){
			        System.out.println("Team1 won by "+(totalPlayers-team1.wickets)+" wickets!");
			        System.out.println();
			        team2.PrintScoreCard();
			        System.out.println();
			        break;
			        
			    }
			    System.out.println();
			    team2.PrintScoreCard();
			    System.out.println();
			}
			
			if(team2.totalRuns>team1.totalRuns){ 
			   System.out.println("Team2 won by "+(team2.totalRuns-team1.totalRuns)+" runs!");
			} else if(team2.totalRuns<team1.totalRuns && team2.wickets==totalPlayers-1){
			   System.out.println("Team1 won by "+(totalPlayers-team2.wickets)+" wickets! and "+
			                      (team1.totalRuns-team2.totalRuns)+" runs!");
			}
			
		}


		static class ScoreCard {
		    public int team;
		    public static int totalOvers;
		    public static int totalPlayers;
		    public Queue<Integer> playersLineUp = new LinkedList<>();
		    public int[][] scoreCard;
		    public int[] totalOversRemaining;
		    public int totalRuns=0;
		    public int wickets=0;
		    public int wide=0;
		    public int curr1;
		    public int curr2;
		    
		    public static void initialize(int overs,int players){
		       totalOvers=overs;
		       totalPlayers=players;
		    }
		    
		    ScoreCard(int t){
		        this.team=t;
		        int i=1;
		        this.scoreCard = new int[totalPlayers][4];
		        while(i<=totalPlayers){ 
		            playersLineUp.offer(i); 
		            Arrays.fill(scoreCard[i-1],0);
		            i++;
		        }
		        this.totalOversRemaining=new int[2]; Arrays.fill(totalOversRemaining,0);
		        this.curr1=playersLineUp.poll();
		        this.curr2=playersLineUp.poll();
		    }
		    
		    void updateScoreCard(String ball){
		        if(ball.length()>1 && ball.equals("Wd")){
		            wide++; 
		            totalRuns++;
		            return;
		        }
		        if(ball.length()<1){ System.out.println("Invalid run/ball, please provide correct value"); return; }
		        if((ball.charAt(0)-'0')>0 && (ball.charAt(0)-'0')<7){
		            int run=(ball.charAt(0)-'0');
		            scoreCard[curr1-1][0]+=run;
		            scoreCard[curr1-1][1]=run==4?scoreCard[curr1-1][1]+1:scoreCard[curr1-1][1];
		            scoreCard[curr1-1][2]=run==6?scoreCard[curr1-1][2]+1:scoreCard[curr1-1][2];
		            scoreCard[curr1-1][3]+=1;
		            if((run%2!=0 && totalOversRemaining[1]!=5) || 
		               (run%2==0 && totalOversRemaining[1]==5)){
		                int tmp=curr1; curr1=curr2; curr2=tmp;
		            }
		            if(totalOversRemaining[1]==5){ totalOversRemaining[0]+=1; totalOversRemaining[1]=0; }
		            else{ totalOversRemaining[1]+=1; }
		            totalRuns+=run;
		            return;
		        }
		        if(ball.charAt(0)=='W'){
		            scoreCard[curr1-1][3]+=1;
		            if(playersLineUp.size()>0){
		               curr1=playersLineUp.poll();
		            }else{
		               curr1=curr2; 
		            }
		            if(totalOversRemaining[1]==5){
		                int tmp=curr1; curr1=curr2; curr2=tmp;
		            }
		            if(totalOversRemaining[1]==5){ totalOversRemaining[0]+=1; totalOversRemaining[1]=0; }
		            else{ totalOversRemaining[1]+=1; }
		            wickets++;
		        }
		    }
		    
		    void PrintScoreCard(){
		           System.out.println("Player Score 4s 6s balls");
		        for(int i=0;i<scoreCard.length;i++){
		           int pn=team==1?(i+1):(i+totalPlayers+1);
		           String star=curr1==(i+1)||curr2==(i+1)?"*":"";
		           System.out.println("P"+pn+star+"     "+scoreCard[i][0]+"   "+scoreCard[i][1]
		                              +"  "+scoreCard[i][2]+"  "+scoreCard[i][3]);
		        }
		           System.out.println("runs/wickets : "+totalRuns+"/"+wickets+"     wides: "+wide);
		           System.out.println("overs/totalOvers : "+
		                              totalOversRemaining[0]+"."+totalOversRemaining[1]+"/"+totalOvers);
		    }
		    
		}
}
