package com.xworkz.bakery.dto;

import javax.persistence.Id;

import lombok.Data;

@Data
public class BakeryDto {
	
	@Id
	private int id;
	private String name;
	private double price;

}
