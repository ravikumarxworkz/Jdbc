package com.xworkz.bakery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "bakery_table")
@NamedQuery(name = "readAll", query = "SELECT entity FROM BakeryEntity entity ")
@NamedQuery(name = "readbyId", query = "SELECT entity FROM BakeryEntity entity WHERE entity.id=:id")
@NamedQuery(name = "updateNameByprice", query = "UPDATE BakeryEntity entity SET entity.name=:price WHERE entity.price=:price")

public class BakeryEntity {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "bakery_item")
	private String name;
	@Column(name = "bakery_itemprice")
	private double price;
}
