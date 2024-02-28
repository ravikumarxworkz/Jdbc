package com.xworkz.unknown.service;

import com.xworkz.unknown.dto.UnknownDto;

public interface UnknownService {

	void readAll();

	void readById(UnknownDto dto);

	void findByName(UnknownDto dto);

	void findIdAndNameByName(UnknownDto dto);

	void findAgeAndNumberByName(UnknownDto dto);

	void count();

	void sumOfAge();

	void findNamesGreaterThanAge(UnknownDto dto);

}
