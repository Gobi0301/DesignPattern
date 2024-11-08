package com.techymeet.railwayDao;

import java.util.ArrayList;
import java.util.List;

import com.techymeet.railwayBo.PassengerBO;

public class RailwayDaoImpl implements RailwayDao {

	 List<PassengerBO> passengers = new ArrayList<PassengerBO>();
	
	@Override
	public int createPassenger(PassengerBO passenger) {
		// TODO Auto-generated method stub
	   passengers.add(passenger); 
	  if(!passengers.isEmpty() && passengers != null) {
		  return 1;
	  }
		return 0;
	}

	@Override
	public List<PassengerBO> getAllPassenger() {
		// TODO Auto-generated method stub
		return passengers;
	}

	@Override
	public int cancelTicket(int id) {
		// TODO Auto-generated method stub
		boolean status = passengers.removeIf(passenger -> passenger.getId() == id);
		System.out.println("Passenger is deleted");
		if(status) {
			return 1;
		}
		return 0;
	}

}
