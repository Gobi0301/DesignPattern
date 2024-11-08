import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Booking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Taxi> taxis = createTaxi(4);
		Scanner sc = new Scanner(System.in);
		int id = 1;
		while(true) {
			System.out.println("0 - > BookTaxi");
			System.out.println("1 -> Print Taxi Details");
			int opt = sc.nextInt();
			switch(opt) {
			case 0:
				System.out.println("Enter customer Id");
				int customerId  = id;
				System.out.println(customerId);
				System.out.println("Enter Pickup point");
				char pickupPoint = sc.next().charAt(0);
				System.out.println("Enter Drop Point");
				char dropPoint = sc.next().charAt(0);
				System.out.println("Enter PickUp Time");
				int pickupTime = sc.nextInt();
				
				if(pickupPoint < 'A' || dropPoint >'F' ||pickupPoint > 'F'||dropPoint< 'A' ) {
					System.out.println("Vaild pickup and drop are A,B,C,D,E,F.Existing");
					return;
				}
				List<Taxi> freetaxi = getFreeTaxi(taxis,pickupTime,pickupPoint);
				
				if(freetaxi.size() == 0) {	
					System.out.println("No taxi can be alloted.Exisisting....");
					return;
				}
				
				Collections.sort(freetaxi,(a,b)->a.totalEarnings - b.totalEarnings);
				bookTaxi(id,pickupPoint,dropPoint,pickupTime,freetaxi);
				id++;
				break;
			
			case 1:
				for(Taxi t: taxis) {
					t.printDetails();
			  }
				break;
		    default:
		    	return;
			}
		}

	}

	private static void bookTaxi(int customerId, char pickupPoint, char dropPoint, int pickupTime, List<Taxi> freetaxi) {
		// TODO Auto-generated method stub
		int min = 999;
		int distanceBetweenUpandDrop = 0;
		int earnings = 0;
		int nextfreeTime = 0;
		char nextSpot = 'z';
		Taxi bookedTaxi = null;
		String tripDetail = " ";
		for(Taxi t : freetaxi) {
			int distancebetweencustomerandTaxi = Math.abs((t.currentspot - '0')- (pickupPoint - '0')) * 15;
			if(distancebetweencustomerandTaxi < min) {
				
	            bookedTaxi = t;
			earnings = (distanceBetweenUpandDrop-5)+10+100;
			int dropTime = pickupTime + distanceBetweenUpandDrop/15;
			nextfreeTime = dropTime;
			nextSpot = dropPoint;
			tripDetail = customerId + "                    "+ customerId+ "                "+pickupPoint+"        "+dropPoint+"          "+pickupTime+"    "+dropTime;
			
		}
		}
		bookedTaxi.setDetails(true, nextSpot, nextfreeTime, bookedTaxi.totalEarnings+earnings, tripDetail);
		System.out.println("Taxi "+ bookedTaxi.id + "booked");
	}

	private static List<Taxi> getFreeTaxi(List<Taxi> taxis, int pickupTime, char pickupPoint) {
		// TODO Auto-generated method stub
		List<Taxi> freetaxi = new ArrayList<Taxi>();
		for(Taxi i :taxis) {
			if(i.freeTime <= pickupTime && (Math.abs((i.currentspot - '0') - (pickupPoint - '0')) <= pickupTime - i.freeTime))
            freetaxi.add(i);
		}
		return freetaxi;
	}

	private static List<Taxi> createTaxi(int n) {
		// TODO Auto-generated method stub
		List<Taxi> taxis = new ArrayList<Taxi>();
		for(int i=1;i<=n;i++) {
			Taxi t = new Taxi();
			taxis.add(t);
		}
		return taxis;
	}

}
