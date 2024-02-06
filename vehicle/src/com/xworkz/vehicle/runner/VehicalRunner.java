package com.xworkz.vehicle.runner;

import com.xworkz.vehicle.dto.VehicleDto;
import com.xworkz.vehicle.service.VehicleService;
import com.xworkz.vehicle.service.VehicleServiceImpl;

public class VehicalRunner {

	public static void main(String[] args) {

		VehicleService service = new VehicleServiceImpl();

		VehicleDto dto = new VehicleDto();

		dto.setName("BMW");
		dto.setColor("white");
		dto.setPrice(2000000);
		service.save(dto);
	}

}
