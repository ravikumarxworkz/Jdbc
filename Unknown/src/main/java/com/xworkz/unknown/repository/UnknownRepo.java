package com.xworkz.unknown.repository;

import java.util.ArrayList;

import com.xworkz.unknown.entity.UnknowEntity;

public interface UnknownRepo {

	ArrayList<UnknowEntity> readAll();

	UnknowEntity findById(UnknowEntity entity);

	UnknowEntity findByName(UnknowEntity entity);

	Object[] findIdAndNameByName(UnknowEntity entity);

	Object[] findAgeAndNumberByName(UnknowEntity entity);

	Object sumOfAge();

	Object count();

	ArrayList<String> findNamesGreaterThanAge(UnknowEntity entity);

}
