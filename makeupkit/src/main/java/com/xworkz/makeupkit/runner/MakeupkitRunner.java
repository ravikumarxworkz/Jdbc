package com.xworkz.makeupkit.runner;

import com.xworkz.makeupkit.dto.MakeupKitDto;
import com.xworkz.makeupkit.service.MakeipKitService;
import com.xworkz.makeupkit.service.MakeipKitServiceImpl;

public class MakeupkitRunner {

	public static void main(String[] args) {

		System.out.println("main method start");

		MakeipKitService kitService = new MakeipKitServiceImpl();

		System.out.println("data invoking to update by id method by calling service method in main mrthod");
		MakeupKitDto dto = new MakeupKitDto();
		dto.setId(5);
		dto.setName("earings");
		dto.setPrice(20.00);
		dto.setCompanyName("maruti");
		kitService.updateById(dto);
		System.out.println("data invoking to  updateNameByPrice method by calling service method in main method");
		MakeupKitDto dto1 = new MakeupKitDto();
		dto1.setName("nail folish");
		dto1.setPrice(34.99);
		kitService.updateNameByPrice(dto1);
		System.out.println("main method end");
		MakeupKitDto dto2 = new MakeupKitDto();
		dto2.setCompanyName("Organi Ltd.");
		dto2.setName("Glamour Glow");
		kitService.updateCompanyNameByName(dto2);
		MakeupKitDto dto3 = new MakeupKitDto();
		dto3.setCompanyName("Chic Cosmetics");
		dto3.setName("Smokey Eyes Palette");
		dto3.setPrice(24.99);
		kitService.updateCompanyNameByName(dto3);
		MakeupKitDto dto4 = new MakeupKitDto();
		dto4.setId(11);
		dto4.setName("Vintage Glamour ");
		dto4.setPrice(64.99);
		kitService.updateIdAndNameByPrice(dto4);
		System.err.println("end");
	}

}
