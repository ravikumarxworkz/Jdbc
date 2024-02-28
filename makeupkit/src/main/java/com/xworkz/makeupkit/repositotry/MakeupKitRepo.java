package com.xworkz.makeupkit.repositotry;

import java.util.ArrayList;

import com.xworkz.makeupkit.entity.MakeupKitEntity;

public interface MakeupKitRepo {

	boolean validate(MakeupKitEntity entity);

	ArrayList<MakeupKitEntity> read();

	boolean updateNameByPrice(String name, double price);

	boolean deleteById(int id);

}
