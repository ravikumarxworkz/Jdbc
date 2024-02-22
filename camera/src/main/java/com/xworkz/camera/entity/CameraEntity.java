package com.xworkz.camera.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Camera")
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "readAll", query = "SELECT entity FROM CameraEntity entity")
@NamedQuery(name = "readbybrand", query = "SELECT entity FROM CameraEntity entity WHERE entity.brand=:brand")
@NamedQuery(name = "readbyBrandAndPrice", query = "SELECT entity FROM CameraEntity entity WHERE entity.brand=:brand AND entity.price=:price")
@NamedQuery(name = "readbyprice", query = "SELECT entity FROM CameraEntity entity WHERE entity.price<=:price")
@NamedQuery(name = "avgprice", query = "SELECT AVG(entity.price) FROM CameraEntity entity")
//@NamedQuery(name = "findbrandAndModelByprice", query = "SELECT entity.brand,entiy.model FROM CameraEntity entity WHERE entity.price=:price")
//@NamedQuery(name = "findbrandStartwith", query = "SELECT entity FROM CameraEntity entity WHERE entity.brand like 'C%'=:brand")
public class CameraEntity {
	@Id
	private int id;
	private String brand;
	private String model;
	private int megapixels;
	private String sensorType;
	private double price;
}
