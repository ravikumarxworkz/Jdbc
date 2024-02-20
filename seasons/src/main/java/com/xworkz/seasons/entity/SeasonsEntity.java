package com.xworkz.seasons.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Seasons")
@NamedQuery(name="UpdateByTemp" ,query="UPDATE  SeasonsEntity entity SET entity.name=:name WHERE entity.temperature=:temperature")
@NamedQuery(name="UpdateByName" ,query="UPDATE  SeasonsEntity entity SET entity.temperature=:temperature WHERE entity.name=:name")
@NamedQuery(name="UpdateById" ,query="UPDATE  SeasonsEntity entity SET entity.name=:name WHERE entity.temperature=:id")
@NamedQuery(name="UpdateByDescription" ,query="UPDATE  SeasonsEntity entity SET entity.temperature=:temperature WHERE entity.description=:description")
public class SeasonsEntity {
	
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Description")
	private String description;
	@Column(name="Average_Temperature")
	private double temperature;

}
