package com.xworkz.drinks.insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.drinks.entity.DrinksEntity;

public class Kingfisher {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is ok");
		try {
			
			entityTransaction.begin();
			DrinksEntity drinksEntity = new DrinksEntity();
			drinksEntity.setDrink_Name("king fisher");
			drinksEntity.setDrink_price("210");
			entityManager.persist(drinksEntity);
			entityTransaction.commit();
			System.out.println("saved sucessfully");
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
