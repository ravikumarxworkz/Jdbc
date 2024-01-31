package com.xworkz.bottles.constans;

public enum BottleConnectionData {

	
	URL("jdbc:mysql://localhost:3306/bottles"), USER_NAME("root"), PASSWORD("123456789");

	private String value;

	private BottleConnectionData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}

