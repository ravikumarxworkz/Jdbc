package com.xworkz.supercar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "supercar_table")
@NamedQuery(name = "findnamebyprice", query = "SELECT entity.name FROM SupercarEntity entity WHERE entity.price=:price ")
@NamedQuery(name = "findcolorAndnamebyprice", query = "SELECT entity.color,entity.name FROM SupercarEntity entity WHERE entity.price=:price ")
@NamedQuery(name = "findnamebycompany", query = "SELECT entity.name FROM SupercarEntity entity WHERE entity.company=:company ")
public class SupercarEntity {

	@Id
	private int id;
	@Column(name = "supercar_name")
	private String name;
	@Column(name = "supercar_price")
	private double price;
	@Column(name = "supercar_color")
	private String color;
	@Column(name = "supercar_company")
	private String company;
}
