package com.xworkz.makeupkit.service;

import java.util.ArrayList;

import com.xworkz.makeupkit.dto.MakeupKitDto;
import com.xworkz.makeupkit.entity.MakeupKitEntity;
import com.xworkz.makeupkit.repositotry.MakeupKitRepo;
import com.xworkz.makeupkit.repositotry.MakeupKitRepoImpl;

public class MakeipKitServiceImpl implements MakeipKitService {

	MakeupKitRepo repo = new MakeupKitRepoImpl();

	@Override
	public void save(MakeupKitDto dto) {

		MakeupKitEntity entity = new MakeupKitEntity();

		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setCompanyName(dto.getCompanyName());

		repo.validate(entity);
		System.out.println("data saved sucess ");
	}

	@Override
	public void read() {
		repo.read().forEach(System.out::println);
	}

	@Override
	public boolean updateNameByPrice(String name, double price) {
		boolean update = repo.updateNameByPrice(name, price);
		if (update) {
			System.out.println("data is updated successfully");
		} else {
			System.out.println("data is  not update successfully");
		}
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		boolean delete = repo.deleteById(id);
		if (delete) {
			System.out.println("data is deleted successfully");
		} else {
			System.out.println("data is  not deleted successfully");
		}
		return false;
	}

	@Override
	public void readByID(int id) {
		repo.read().stream().filter(val -> val.getId() == id).forEach(System.out::println);

	}

	@Override
	public void readByName(String name) {
		repo.read().stream().filter(val -> val.getName().equalsIgnoreCase(name)).forEach(System.out::println);

	}

	@Override
	public void readByPrice(double price) {
		repo.read().stream().filter(val -> val.getPrice() == price).forEach(System.out::println);

	}

	@Override
	public void readByCompanyName(String companyName) {
		repo.read().stream().filter(val -> val.getCompanyName().equalsIgnoreCase(companyName))
				.forEach(System.out::println);

	}

	@Override
	public void readOnlyNames() {
		repo.read().stream().map(t -> t.getName()).forEachOrdered(System.out::println);
	}

	@Override
	public void findNamesByCompanyName(String companyName) {
		repo.read().stream().filter(t -> t.getCompanyName().equalsIgnoreCase(companyName)).map(v -> v.getName())
				.forEach(System.out::println);
	}

	@Override
	public void findNamesAndPricesById(int id) {
		repo.read().stream().filter(v -> v.getId() == id)
				.forEach(s -> System.out.println("name =" + s.getName() + "price=" + s.getPrice()));

	}

}
