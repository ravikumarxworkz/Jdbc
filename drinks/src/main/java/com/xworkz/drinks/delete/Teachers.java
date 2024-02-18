package com.xworkz.drinks.delete;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.drinks.entity.DrinksEntity;

public class Teachers {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("Connection is OK");

		try {
			entityTransaction.begin();

			DrinksEntity drinksEntity = entityManager.find(DrinksEntity.class, 8);

			if (drinksEntity != null) {
				entityManager.remove(drinksEntity);
				entityTransaction.commit();
				System.out.println("delete successful");
			} else {
				System.out.println("Entity with ID 8 not found");
			}
		} catch (Exception e) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

}
