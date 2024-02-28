package com.xworkz.unknown.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "person_detailes")
@NamedQuery(name = "readAll", query = "SELECT entity FROM UnknowEntity entity ")
@NamedQuery(name = "findByid", query = "SELECT  entity FROM UnknowEntity entity WHERE entity.id=:id ")
@NamedQuery(name = "findByName", query = "SELECT  entity FROM UnknowEntity entity WHERE entity.name=:name ")
@NamedQuery(name = "findidAndnamebyname", query = "SELECT entity.id ,entity.name FROM UnknowEntity entity WHERE entity.name=:name ")
@NamedQuery(name = "findageAndnumberbyname", query = "SELECT entity.age ,entity.phone_number  FROM UnknowEntity entity WHERE entity.name=:name ")
@NamedQuery(name = "count", query = "SELECT  COUNT(entity.id) FROM UnknowEntity entity")
@NamedQuery(name = "sumOfAge", query = "SELECT  SUM(entity.age) FROM UnknowEntity entity")
@NamedQuery(name = "findNamesGreaterThanAge", query = "SELECT entity.name FROM UnknowEntity entity WHERE entity.age<=:age ")
public class UnknowEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "phone_number")
	private long phone_number;

}
