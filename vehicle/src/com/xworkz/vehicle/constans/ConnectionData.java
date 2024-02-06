package com.xworkz.vehicle.constans;

public enum ConnectionData {

	URL("jdbc:mysql://localhost:3306/vehicle"), USER_NAME("root"), PASSWORD("123456789");

	private String value;

	private ConnectionData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}