package com.xworkz.drinks.update;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.drinks.entity.DrinksEntity;

public class BlackDog {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is ok");
		try {
			entityTransaction.begin();
			DrinksEntity drinksEntity = new DrinksEntity();
			
			drinksEntity.setId(4);
			drinksEntity.setDrink_Name("Black Dog");
			drinksEntity.setDrink_price("350");
			entityManager.merge(drinksEntity);
			entityTransaction.commit();
			System.out.println("update  sucessfully");
		} catch (Exception e) {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}
}
