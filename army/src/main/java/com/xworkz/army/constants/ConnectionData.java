package com.xworkz.army.constants;

public enum ConnectionData {
	URL, USER_NAME, PASSWORD;

	String value;

	private ConnectionData() {
		// TODO Auto-generated constructor stub
	}

	public String getValue() {
		return this.value;

	}

	public void setValue(String value) {

		this.value = value;

	}

}
