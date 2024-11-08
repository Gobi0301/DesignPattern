package com.techymeet.CabBooking;

public class Booking {
	int customer_id;
	int pickUpTime;
	int dropTime;
	int taxiNo;
	int earnings;
	char pickUpPoint;
	char dropPoint;
	
	public Booking(int customer_id,int pickUpTime,char dropPoint,char pickUpPoint) {
		this.customer_id = customer_id;
		this.pickUpTime = pickUpPoint;
		this.dropPoint = dropPoint;
		this.pickUpPoint = pickUpPoint;	
	}
	public void dropTime() {
		this.dropTime = pickUpTime + Math.abs(pickUpPoint - dropPoint);
	}
	public int checkAvailability(Taxi[] taxi,int taxiCount) {
		int taxiId,taxiid = 0,shortestDistance = 6;
		for(taxiId = 0;taxiId<taxiCount;taxiId++) {
			if(taxi[taxiId].isTaxiFree(pickUpTime)) {
				if(Math.abs(taxi[taxiId].currentPosition-pickUpPoint)<shortestDistance) {
					taxiid = taxiId;
				}
				if(Math.abs(taxi[taxiId].currentPosition-pickUpPoint) == shortestDistance) {
					if(taxi[taxiId].earnings<taxi[taxiid].earnings)
						taxiid = taxiId;
				}
			}
			shortestDistance = Math.abs(taxi[taxiid].currentPosition-pickUpPoint);
		}
		if(shortestDistance!=6) {
			taxi[taxiid].departureTime(pickUpPoint,dropPoint,pickUpTime);
			taxi[taxiid].currentPosition = dropPoint;
			taxiNo = taxiid;
			return taxiNo;
		}
		return -1;
		
	}

}
