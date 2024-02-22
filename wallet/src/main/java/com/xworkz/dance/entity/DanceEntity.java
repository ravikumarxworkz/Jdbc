package com.xworkz.dance.entity;

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
@Table(name = "dance_table")
@NamedQuery(name = "findstatebytype", query = "SELECT entity.state FROM DanceEntity entity WHERE entity.type=:type ")
@NamedQuery(name = "findstateAndtypebyid", query = "SELECT entity.state,entity.type FROM DanceEntity entity WHERE entity.id=:id ")
@NamedQuery(name = "findtypebystate", query = "SELECT entity.type FROM DanceEntity entity WHERE entity.state=:state ")
public class DanceEntity {
	@Id
	private int id;
	@Column(name = "dance_state")
	private String state;
	@Column(name = "dance_type")
	private String type;

}
