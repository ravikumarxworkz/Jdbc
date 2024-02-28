package com.xworkz.makeupkit.dto;

import javax.persistence.Id;

import lombok.Data;

@Data
public class MakeupKitDto {

	@Id
	private int id;
	private String name;
	private double price;
	private String companyName;

}
