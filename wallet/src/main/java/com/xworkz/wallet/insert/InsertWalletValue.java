package com.xworkz.wallet.insert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.wallet.entity.WalletEntity;

public class InsertWalletValue {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {

			entityTransaction.begin();

			WalletEntity entity = new WalletEntity(1, "rcb", 200, "red", 4.5f);
			WalletEntity entity1 = new WalletEntity(2, "Louis Vuitton", 100.0, "Red", 4.5f);
			WalletEntity entity2 = new WalletEntity(3, "Gucci ", 150.0, "Blue", 4.2f);
			WalletEntity entity3 = new WalletEntity(4, "Prada", 120.0, "Green", 4.8f);
			WalletEntity entity4 = new WalletEntity(5, "Chanel", 200.0, "Yellow", 4.0f);
			WalletEntity entity5 = new WalletEntity(6, "Hermès", 180.0, "Black", 4.7f);
			entityManager.persist(entity);
			entityManager.persist(entity1);
			entityManager.persist(entity2);
			entityManager.persist(entity3);
			entityManager.persist(entity4);
			entityManager.persist(entity5);
			entityTransaction.commit();
			System.out.println("data saved");
		} catch (PersistenceException e) {

			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

}
