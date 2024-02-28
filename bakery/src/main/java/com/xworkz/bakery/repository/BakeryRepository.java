package com.xworkz.bakery.repository;

import java.util.ArrayList;

import com.xworkz.bakery.entity.BakeryEntity;

public interface BakeryRepository {

	boolean save(BakeryEntity entity);

	ArrayList<BakeryEntity> read();

	boolean updateByName(String oldName, String newName);

	boolean deleteById(int id);
	
	boolean deleteByNAme(String name);

}
