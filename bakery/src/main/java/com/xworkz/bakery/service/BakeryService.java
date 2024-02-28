package com.xworkz.bakery.service;

import com.xworkz.bakery.dto.BakeryDto;

public interface BakeryService {

	void validateAndSave(BakeryDto dto);

	void read();

	void updateNameByPrice(BakeryDto dto);

	void deleteById(BakeryDto dto);

}
