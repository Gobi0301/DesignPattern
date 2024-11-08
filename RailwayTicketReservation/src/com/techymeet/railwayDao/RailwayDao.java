package com.techymeet.railwayDao;

import java.util.ArrayList;
import java.util.List;

import com.techymeet.railwayBo.PassengerBO;

public interface RailwayDao {

	
	public int createPassenger(PassengerBO passenger);
	public List<PassengerBO> getAllPassenger();
	public int cancelTicket(int id);
	
}
