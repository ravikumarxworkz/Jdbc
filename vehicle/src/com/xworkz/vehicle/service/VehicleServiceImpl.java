package com.xworkz.vehicle.service;

import com.xworkz.vehicle.dto.VehicleDto;
import com.xworkz.vehicle.repository.VehicleRepo;
import com.xworkz.vehicle.repository.VehicleRepoImpl;

public class VehicleServiceImpl implements VehicleService {

	  private VehicleRepo repo=new VehicleRepoImpl();
	  
	@Override
	public boolean save(VehicleDto dto) {
		
		   if(repo.save(dto)) {
			   System.out.println("vehicle data is saved sucessfully");
		   }
		return false;
	}

}
