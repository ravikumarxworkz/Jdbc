package com.xworkz.bakery.service;

import java.util.ArrayList;

import com.xworkz.bakery.dto.BakeryDto;
import com.xworkz.bakery.entity.BakeryEntity;
import com.xworkz.bakery.repository.BakeryRepository;
import com.xworkz.bakery.repository.BakeryRepositoryImpl;

public class BakeryServiceImpl implements BakeryService {

	private BakeryRepository repo = new BakeryRepositoryImpl();

	@Override
	public void validateAndSave(BakeryDto dto) {

		System.out.println(" this service class validateAndSave start ");

		BakeryEntity entity = new BakeryEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());

		repo.save(entity);
		System.out.println("data saved sucess ");
	}

	@Override
	public void read() {
		ArrayList<BakeryEntity> arrayList = repo.read();
		for (BakeryEntity bakeryEntity : arrayList) {
			System.out.println(bakeryEntity);
		}

	}

	@Override
	public boolean updateByName(String oldName, String newName) {

		boolean update = repo.updateByName(oldName, newName);

		if (update) {
			System.out.println("name is update sucessfully");
		} else {
			System.out.println("name is  not update  sucessfully");

		}
		return false;
	}

	@Override
	public boolean deleteById(int id) {

		boolean delete = repo.deleteById(id);

		if (delete) {
			System.out.println("data is delete ");
		} else {
			System.out.println("data is not deleted");
		}

		return false;
	}

	@Override
	public void readByID(int id) {
		if (id != 0) {
			ArrayList<BakeryEntity> arrayList = repo.read();
			for (int i = 0; i < arrayList.size(); i++) {
				if (arrayList.get(i).getId() == id) {
					System.out.println(arrayList.get(i));
				}

			}

		}

	}

	@Override
	public boolean deleteByName(String Name) {
		// TODO Auto-generated method stub
		return false;
	}

}
