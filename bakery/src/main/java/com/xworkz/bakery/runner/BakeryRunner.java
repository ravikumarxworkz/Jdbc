package com.xworkz.bakery.runner;

import com.xworkz.bakery.dto.BakeryDto;
import com.xworkz.bakery.service.BakeryService;
import com.xworkz.bakery.service.BakeryServiceImpl;

public class BakeryRunner {

	public static void main(String[] args) {

		System.out.println(" main method start");
		BakeryDto dto = new BakeryDto();
		BakeryService service = new BakeryServiceImpl();
		System.out.println(" create dto and  set value to  dto ");
		service.validateAndSave(dto);
		System.out.println("read all values");
		service.read();
		System.out.println("calling update name by price method");
		BakeryDto dto1 = new BakeryDto();
		dto1.setName("vanila cake");
		dto1.setPrice(5000.00);
		service.updateNameByPrice(dto1);
		System.out.println("delete by id");
		BakeryDto dto2 = new BakeryDto();
		service.deleteById(dto2);
		System.out.println("main method end");

	}

}
