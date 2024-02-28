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
@NamedQuery(name = "updateNameByPrice", query = "UPDATE  MakeupKitEntity entity  SET entity.name=:name WHERE entity.price=:price")
@NamedQuery(name = "updateCompanyNameByName", query = "UPDATE  MakeupKitEntity entity  SET entity.companyName=:companyName WHERE entity.name=:name")
@NamedQuery(name = "updateCompanyNameByNameAndPrice", query = "UPDATE  MakeupKitEntity entity  SET entity.companyName=:companyName WHERE   entity.name=:name AND entity.price=:price")
@NamedQuery(name = "updateIdAndNameByPrice", query = "UPDATE MakeupKitEntity entity SET entity.id = :id, entity.name = :name WHERE entity.price = :price")

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
