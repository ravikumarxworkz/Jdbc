package com.xworkz.wallet.insert;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.dance.entity.DanceEntity;

public class InsetDanceValue {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connected");

		try {
			entityTransaction.begin();

			DanceEntity[] dances = new DanceEntity[5];

			dances[0] = new DanceEntity(1, "Karnataka", "Folk");
			dances[1] = new DanceEntity(2, "Punjab", "Bhangra");
			dances[2] = new DanceEntity(3, "Gujarat", "Garba");
			dances[3] = new DanceEntity(4, "Tamil Nadu", "Bharatanatyam");
			dances[4] = new DanceEntity(5, "Rajasthan", "Ghoomar");

			for (DanceEntity dance : dances) {
				entityManager.persist(dance);
			}
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
