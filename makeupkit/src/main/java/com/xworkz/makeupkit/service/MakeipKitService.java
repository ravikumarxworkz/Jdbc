package com.xworkz.makeupkit.service;

import com.xworkz.makeupkit.dto.MakeupKitDto;

public interface MakeipKitService {

	void save(MakeupKitDto dto);

	void read();

	void readByID(int id);

	void readByName(String name);

	void readByPrice(double price);

	void readByCompanyName(String companyName);
	
	public void findNamesByCompanyName(String companyName);
	
	public void findNamesAndPricesById(int id);

	void readOnlyNames();

	boolean updateNameByPrice(String name, double price);

	boolean deleteById(int id);

}
