package com.xworkz.bakery.service;

import java.util.ArrayList;

import com.xworkz.bakery.dto.BakeryDto;
import com.xworkz.bakery.entity.BakeryEntity;
import com.xworkz.bakery.repository.BakeryRepository;
import com.xworkz.bakery.repository.BakeryRepositoryImpl;

public class BakeryServiceImpl implements BakeryService {

	private BakeryRepository repo = new BakeryRepositoryImpl();
	BakeryEntity entity = new BakeryEntity();
	BakeryDto dto = new BakeryDto();

	@Override
	public void validateAndSave(BakeryDto dto) {

		System.out.println(" this service class validateAndSave start ");

		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());

		repo.save(entity);
		System.out.println("data saved sucess ");
	}

	@Override
	public void read() {
		ArrayList<BakeryEntity> read = repo.read();
		for (BakeryEntity entity : read) {
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setPrice(entity.getPrice());
			System.out.println("vlaues=" + dto);

		}

	}

	@Override
	public void updateNameByPrice(BakeryDto dto) {

		dto.setName(dto.getName());
		dto.setPrice(dto.getPrice());

		boolean update = repo.updateNameByPrice(entity);

		if (update) {
			System.out.println("name is update sucessfully");
		} else {
			System.out.println("name is  not update  sucessfully");

		}
	}

	@Override
	public void deleteById(BakeryDto dto) {
		entity.setId(dto.getId());
		boolean delete = repo.deleteById(entity);

		if (delete) {
			System.out.println("data is delete ");
		} else {
			System.out.println("data is not deleted");
		}

	}

}
