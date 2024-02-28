package com.xworkz.unknown.runner;

import com.xworkz.unknown.dto.UnknownDto;
import com.xworkz.unknown.service.UnknownService;
import com.xworkz.unknown.service.UnknownServiceImpl;

public class UnknowRunner {

	public static void main(String[] args) {

		UnknownService service = new UnknownServiceImpl();

		System.out.println("main method start");

		System.out.println("read all method");
		service.readAll();

		System.out.println("find by id");
		UnknownDto dto = new UnknownDto();
		dto.setId(2);
		service.readById(dto);

		System.out.println("find by name");

		UnknownDto dto1 = new UnknownDto();
		dto.setName("soma");
		service.findByName(dto1);

		UnknownDto dto2 = new UnknownDto();
		dto.setName("Venki");
		service.findIdAndNameByName(dto2);

		UnknownDto dto3 = new UnknownDto();
		dto.setName("sandeep");
		service.findAgeAndNumberByName(dto3);

		System.out.println("count method");
		service.count();
		System.out.println("sum of age method");
		service.sumOfAge();

		
		System.out.println("grter than age method");
		UnknownDto dto4 = new UnknownDto();
		dto.setAge(30);
		service.findNamesGreaterThanAge(dto4);
		System.out.println("main method end");

	}

}
