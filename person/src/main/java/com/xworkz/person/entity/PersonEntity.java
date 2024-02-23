package com.xworkz.person.entity;

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
@NamedQuery(name = "findByid", query = "SELECT  entity FROM PersonEntity entity WHERE entity.id=:id ")
@NamedQuery(name = "findByName", query = "SELECT  entity FROM PersonEntity entity WHERE entity.name=:name ")
@NamedQuery(name = "findByAge", query = "SELECT entity FROM PersonEntity entity WHERE entity.age=:age ")
@NamedQuery(name = "findBynumber", query = "SELECT entity  FROM PersonEntity entity WHERE entity.phone_number=:phone_number ")
///////////////////////by id//////////////////////
@NamedQuery(name = "findnameByid", query = "SELECT entity.name FROM PersonEntity entity WHERE entity.id=:id ")
@NamedQuery(name = "findageByid", query = "SELECT entity.age FROM PersonEntity entity WHERE entity.id=:id ")
@NamedQuery(name = "findphone_numberebyid", query = "SELECT entity.phone_number FROM PersonEntity entity WHERE entity.id=:id ")
//////////////////////////////// by name///////////////////////////////
@NamedQuery(name = "findidbyname", query = "SELECT entity.id FROM PersonEntity entity WHERE entity.name=:name ")
@NamedQuery(name = "findagebyname", query = "SELECT entity.age FROM PersonEntity entity WHERE entity.name=:name ")
@NamedQuery(name = "findphone_numberebyname", query = "SELECT entity.phone_number FROM PersonEntity entity WHERE entity.name=:name ")
////////////////////////////////////  by age /////////////////////
@NamedQuery(name = "findIdByage", query = "SELECT entity.name FROM PersonEntity entity WHERE entity.age=:age ")
@NamedQuery(name = "findNameByage", query = "SELECT entity.age FROM PersonEntity entity WHERE entity.age=:age ")
@NamedQuery(name = "findphone_numberebyage", query = "SELECT entity.phone_number FROM PersonEntity entity WHERE entity.age=:age ")
/////////////////////////////////// by phone number///////////////////////////
@NamedQuery(name = "findidBynumber", query = "SELECT entity.id FROM PersonEntity entity WHERE entity.phone_number=:phone_number ")
@NamedQuery(name = "findnameBynumber", query = "SELECT entity.name  FROM PersonEntity entity WHERE entity.phone_number=:phone_number ")
@NamedQuery(name = "findageBynumber", query = "SELECT entity.age  FROM PersonEntity entity WHERE entity.phone_number=:phone_number ")
//////////////////////////////////////// all aggregation  //////////////
@NamedQuery(name = "avgage", query = "SELECT  AVG(entity.age) FROM PersonEntity entity")
@NamedQuery(name = "count", query = "SELECT  COUNT(entity.id) FROM PersonEntity entity")
@NamedQuery(name = "sumOfAge", query = "SELECT  SUM(entity.age) FROM PersonEntity entity")
@NamedQuery(name = "findmaxAgePerson", query = "SELECT  MAX(entity.age) FROM PersonEntity entity")
@NamedQuery(name = "findminAgePerson", query = "SELECT  MIN(entity.age) FROM PersonEntity entity")
//////////////////////////////////////////////////////// less /greater/
@NamedQuery(name = "findnamelessthanage", query = "SELECT entity.name FROM PersonEntity entity WHERE entity.age<=:age ")
@NamedQuery(name = "findidgreaterthanage", query = "SELECT entity.id FROM PersonEntity entity WHERE entity.age<=:age ")
//////////////////////select * ///////////////
@NamedQuery(name = "readAll", query = "SELECT entity FROM PersonEntity entity ")
///////////////////////////////// mutiple row //////////
@NamedQuery(name = "findidAndnamebyname", query = "SELECT entity.id ,entity.name FROM PersonEntity entity WHERE entity.name=:name ")
@NamedQuery(name = "findageAndnumberbyname", query = "SELECT entity.age ,entity.phone_number  FROM PersonEntity entity WHERE entity.name=:name ")
public class PersonEntity {

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
