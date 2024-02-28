package com.xworkz.makeupkit.repositotry;


import com.xworkz.makeupkit.entity.MakeupKitEntity;

public interface MakeupKitRepo {

	boolean updateById(MakeupKitEntity entity);

	boolean updateNameByPrice(MakeupKitEntity entity);

	boolean updateCompanyNameByName(MakeupKitEntity entity);

	boolean updateIdAndNameByPrice(MakeupKitEntity entity);

	boolean updateCompanyNameByNameAndPrice(MakeupKitEntity entity);

}
