package com.xworkz.vehicle.dto;

import java.util.Objects;

public class VehicleDto {
	private String name;
	private String color;
	private int price;

	public VehicleDto() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "VehicleDto [name=" + name + ", color=" + color + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleDto other = (VehicleDto) obj;
		return Objects.equals(color, other.color) && Objects.equals(name, other.name) && price == other.price;
	}

}
