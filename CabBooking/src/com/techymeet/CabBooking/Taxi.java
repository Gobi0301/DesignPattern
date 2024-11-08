package com.techymeet.CabBooking;

public class Taxi {

	 char currentPosition;
	 int earnings;
	 int departureTime;
	 public Taxi() {
		 currentPosition = 'a';
	 }
	 public boolean isTaxiFree(int pickUpTime) {
		 if(departureTime<pickUpTime) {
			 return false;
		 }
		 return true;
	 }

	 public void departureTime(char pickUpPoint,char dropPoint,int pickUpTime) {
		 departureTime = pickUpTime + Math.abs(pickUpPoint - dropPoint);
	 }
}
