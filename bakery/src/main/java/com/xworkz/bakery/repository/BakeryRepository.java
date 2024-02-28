package com.xworkz.bakery.repository;

import java.util.ArrayList;

import com.xworkz.bakery.entity.BakeryEntity;

public interface BakeryRepository {

	boolean save(BakeryEntity entity);

	ArrayList<BakeryEntity> read();

	boolean updateNameByPrice(BakeryEntity entity);

	boolean deleteById(BakeryEntity entity);

}
