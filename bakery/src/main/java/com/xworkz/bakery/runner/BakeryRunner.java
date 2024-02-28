package com.xworkz.bakery.runner;

import com.xworkz.bakery.dto.BakeryDto;
import com.xworkz.bakery.service.BakeryService;
import com.xworkz.bakery.service.BakeryServiceImpl;

public class BakeryRunner {

	public static void main(String[] args) {

		System.out.println("start");

		BakeryDto dto = new BakeryDto();

		BakeryService service = new BakeryServiceImpl();
		System.out.println(" create dto and  set value to  dto ");
		dto.setId(5);
		dto.setName("cake");
		dto.setPrice(500);
		// service.validateAndSave(dto);
		System.out.println("read all values");
		service.read();
		System.out.println("read by id");
		service.readByID(2);
		System.out.println("========== updated by name====================");
		service.updateByName("cake", "Sweets");
		System.out.println("delte by id");
		service.deleteById(2);
		System.out.println("end");
	}

}
