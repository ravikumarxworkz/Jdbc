package com.xworkz.wallet.entity;

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
@Table(name = "wallet_table")
@NamedQuery(name = "findcompanyByprice", query = "SELECT entity.company FROM WalletEntity entity WHERE entity.price = :price")
@NamedQuery(name = "findpriceAndcolorBycompany", query = "SELECT entity.price,entity.color FROM WalletEntity entity WHERE entity.company = :company")
@NamedQuery(name = "findratingsBycolor", query = "SELECT entity.ratings FROM WalletEntity entity WHERE entity.color = :color")
public class WalletEntity {

	@Id
	private int id;
	@Column(name = "wallet_company")
	private String company;
	@Column(name = "wallet_price")
	private double price;
	@Column(name = "wallet_color")
	private String color;
	@Column(name = "wallet_ratings")
	private float ratings;
}
