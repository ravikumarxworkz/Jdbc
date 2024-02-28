package com.xworkz.makeupkit.runner;

import com.xworkz.makeupkit.dto.MakeupKitDto;
import com.xworkz.makeupkit.service.MakeipKitService;
import com.xworkz.makeupkit.service.MakeipKitServiceImpl;

public class MakeupkitRunner {

	public static void main(String[] args) {

		System.out.println("main method start");

		MakeupKitDto dto = new MakeupKitDto();

		MakeipKitService kitService = new MakeipKitServiceImpl();
		dto.setId(5);
		dto.setName("Mascara");
		dto.setPrice(30.00);
		dto.setCompanyName("L'Oréal");
		System.out.println("calling service save method");
		kitService.save(dto);
		System.out.println("calling service  read method");
		kitService.read();
		System.out.println("calling service  update method");
		kitService.updateNameByPrice("bindhi", 25.99);
		System.out.println("calling service  delete method");
		kitService.deleteById(2);
		System.out.println("calling service read byid method");
		kitService.readByID(1);
		System.out.println("calling service read by name method");
		kitService.readByName("Mascara");
		System.out.println("calling service read by price method");
		kitService.readByPrice(15.99);
		System.out.println("calling service read by company name method");
		kitService.readByCompanyName("MAC");
		System.out.println("calling service read only name method");
		kitService.readOnlyNames();
		System.out.println("calling service find Names And PricesBy Id method");
		kitService.findNamesAndPricesById(4);
		System.out.println("calling service find Names By CompanyName method");
		kitService.findNamesByCompanyName("NARS");

		System.out.println("main method end");

	}

}
