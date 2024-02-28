package com.xworkz.bakery.service;

import com.xworkz.bakery.dto.BakeryDto;

public interface BakeryService {

	void validateAndSave(BakeryDto dto);

	void read();

	void readByID(int id);

	boolean updateByName(String oldName, String newName);

	boolean deleteById(int id);

	boolean deleteByName(String name);

}
