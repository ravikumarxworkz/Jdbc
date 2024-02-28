package com.xworkz.makeupkit.service;

import com.xworkz.makeupkit.dto.MakeupKitDto;
import com.xworkz.makeupkit.entity.MakeupKitEntity;
import com.xworkz.makeupkit.repositotry.MakeupKitRepo;
import com.xworkz.makeupkit.repositotry.MakeupKitRepoImpl;

public class MakeipKitServiceImpl implements MakeipKitService {

	MakeupKitRepo repo = new MakeupKitRepoImpl();
	MakeupKitEntity entity = new MakeupKitEntity();

	MakeupKitDto dto = new MakeupKitDto();

	@Override
	public boolean updateById(MakeupKitDto dto) {
		System.out.println("dto is coming from main method and set to entity");
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setCompanyName(dto.getCompanyName());
		System.out.println("sending entity to repo by calling update by id method in repo");
		boolean update = repo.updateById(entity);
		if (update) {
			System.out.println("update result is from repo");
			System.out.println("name=" + entity.getName());
			System.out.println("price=" + entity.getPrice());
			System.out.println("companyName=" + entity.getCompanyName());
			System.out.println("data is updated successfully");
		} else {

			System.out.println("data is not updated sucessfully");

		}
		return false;
	}

	@Override
	public boolean updateNameByPrice(MakeupKitDto dto) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		entity.setCompanyName(dto.getCompanyName());
		boolean update = repo.updateNameByPrice(entity);
		if (update) {
			System.out.println("name=" + entity.getName());
			System.out.println("price=" + entity.getPrice());
			System.out.println("data is updated successfully");
		} else {
			System.out.println("data is  not update successfully");
		}
		return false;
	}

	@Override
	public boolean updateCompanyNameByName(MakeupKitDto dto) {
		entity.setCompanyName(dto.getCompanyName());
		entity.setName(dto.getName());
		boolean update = repo.updateCompanyNameByName(entity);
		if (update) {
			System.out.println("CompanyName updated succesfully By Name");
		} else {
			System.out.println("CompanyName not updated By Name");
		}

		return false;
	}

	@Override
	public boolean updateCompanyNameByNameAndPrice(MakeupKitDto dto) {
		entity.setCompanyName(dto.getCompanyName());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		boolean update = repo.updateCompanyNameByNameAndPrice(entity);

		if (update) {
			System.out.println("update CompanyName By Name And Price successfully");
		} else {
			System.out.println("update CompanyName By Name And Price not successfully");

		}
		return false;
	}

	@Override
	public boolean updateIdAndNameByPrice(MakeupKitDto dto) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		boolean update = repo.updateIdAndNameByPrice(entity);

		if (update) {
			System.out.println("updateIdAndNameByPrice successfully");
		} else {
			System.out.println("updateIdAndNameByPrice not successfully");

		}
		return false;
	}
}
