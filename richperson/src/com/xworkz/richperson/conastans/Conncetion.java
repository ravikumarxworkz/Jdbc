package com.xworkz.richperson.conastans;

public enum Conncetion {

	URL("jdbc:mysql://localhost:3306/richperson"), USER_NAME("root"), PASSWORD("123456789");

	private String value;

	private Conncetion(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
