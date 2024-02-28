package com.xworkz.unknown.service;

import java.util.ArrayList;

import com.xworkz.unknown.dto.UnknownDto;
import com.xworkz.unknown.entity.UnknowEntity;
import com.xworkz.unknown.repository.UnknownRepo;
import com.xworkz.unknown.repository.UnknownRepoImpl;

public class UnknownServiceImpl implements UnknownService {

	UnknownRepo repo = new UnknownRepoImpl();
	UnknownDto dto = new UnknownDto();
	UnknowEntity entity = new UnknowEntity();

	@Override
	public void readAll() {
		ArrayList<UnknowEntity> read = repo.readAll();
		for (UnknowEntity entity : read) {
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setAge(entity.getAge());
			dto.setPhone_number(entity.getPhone_number());
			System.out.println(dto);

		}

	}

	@Override
	public void readById(UnknownDto dto) {
		entity.setId(dto.getId());

		UnknowEntity entity1 = repo.findById(entity);

		dto.setId(entity1.getId());
		dto.setName(entity1.getName());
		dto.setAge(entity1.getAge());
		dto.setPhone_number(entity1.getPhone_number());
		System.out.println(dto);

	}

	@Override
	public void findByName(UnknownDto dto) {
		entity.setName(dto.getName());
		UnknowEntity entity2 = repo.findByName(entity);
		dto.setId(entity2.getId());
		dto.setName(entity2.getName());
		dto.setAge(entity2.getAge());
		dto.setPhone_number(entity2.getPhone_number());
		System.out.println(dto);

	}

	@Override
	public void findIdAndNameByName(UnknownDto dto) {
		entity.setName(dto.getName());
		Object[] obj = repo.findIdAndNameByName(entity);
		dto.setId((int) obj[0]);
		dto.setName((String) obj[1]);
		System.out.println("id=" + dto.getId());
		System.out.println("name=" + dto.getName());

	}

	@Override
	public void findAgeAndNumberByName(UnknownDto dto) {
		entity.setName(dto.getName());
		Object[] obj = repo.findAgeAndNumberByName(entity);
		dto.setAge((int) obj[0]);
		dto.setPhone_number((long) obj[1]);
		System.out.println("age=" + dto.getAge());
		System.out.println("Phone_number=" + dto.getPhone_number());
	}

	@Override
	public void count() {

		Object object = repo.count();
		long count = (long) object;
		System.out.println("count=" + count);

	}

	@Override
	public void sumOfAge() {
		Object object = repo.sumOfAge();
		long sumOfAge = (long) object;
		System.out.println("count=" + sumOfAge);

	}

	@Override
	public void findNamesGreaterThanAge(UnknownDto dto) {
		entity.setAge(dto.getAge());
		ArrayList<String> read = repo.findNamesGreaterThanAge(entity);
		for (String string : read) {
			dto.setName(string);
			System.out.println("name=" + dto);
		}

	}

}
