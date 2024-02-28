package com.xworkz.makeupkit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "makeupkit_table")
@NamedQuery(name = "readAll", query = "SELECT entity FROM MakeupKitEntity entity")
@NamedQuery(name = "updateNamebyPrice", query = "UPDATE  MakeupKitEntity entity  SET entity.name=:name WHERE entity.price=:price")
public class MakeupKitEntity {

	@Id
	private int id;
	@Column(name = "makeupkit_name")
	private String name;
	@Column(name = "makeupkit_price")
	private double price;
	@Column(name = "makeupkit_companyname")
	private String companyName;

}
