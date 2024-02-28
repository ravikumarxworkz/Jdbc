package com.xworkz.makeupkit.service;

import com.xworkz.makeupkit.dto.MakeupKitDto;

public interface MakeipKitService {

	boolean updateById(MakeupKitDto dto);

	boolean updateNameByPrice(MakeupKitDto dto);
	
	boolean updateCompanyNameByName(MakeupKitDto dto);
	
	boolean updateIdAndNameByPrice(MakeupKitDto dto);
	
	boolean updateCompanyNameByNameAndPrice(MakeupKitDto dto);
	

	
	

}
