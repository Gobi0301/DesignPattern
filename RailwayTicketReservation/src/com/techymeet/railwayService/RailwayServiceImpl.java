package com.techymeet.railwayService;

import java.util.ArrayList;
import java.util.List;

import com.techymeet.railwayBo.PassengerBO;
import com.techymeet.railwayDao.RailwayDao;
import com.techymeet.railwayDao.RailwayDaoImpl;

public class RailwayServiceImpl implements RailwayService{

	RailwayDao rs = new RailwayDaoImpl();
	
	@Override
	public int createPassenger(PassengerBO passenger) {
		// TODO Auto-generated method stub
		return rs.createPassenger(passenger);
	}

	@Override
	public List<PassengerBO> getAllPassenger() {
		// TODO Auto-generated method stub
		return rs.getAllPassenger();
	}

	@Override
	public int cancelTicket(int id) {
		// TODO Auto-generated method stub
		int status = rs.cancelTicket(id);
		return status;
	}

}
