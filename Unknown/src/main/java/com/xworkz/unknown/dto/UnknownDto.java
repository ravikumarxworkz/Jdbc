package com.xworkz.unknown.dto;


import javax.persistence.Id;

import lombok.Data;

@Data
public class UnknownDto {
	@Id
	private int id;
	private String name;
	private int age;
	private long phone_number;

}
