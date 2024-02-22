package com.xworkz.wallet.insert;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.supercar.entity.SupercarEntity;

public class InsertSuperCarValue {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connected");

		try {
			entityTransaction.begin();
			ArrayList<SupercarEntity> supercars = new ArrayList<>();

			supercars.add(new SupercarEntity(1, "Ferrari", 250000.0, "Red", "Ferrari"));
			supercars.add(new SupercarEntity(2, "Lamborghini", 300000.0, "Yellow", "Lamborghini"));
			supercars.add(new SupercarEntity(3, "Bugatti", 1500000.0, "Blue", "Bugatti"));
			supercars.add(new SupercarEntity(4, "McLaren", 350000.0, "Orange", "McLaren"));
			supercars.add(new SupercarEntity(5, "Porsche", 200000.0, "Black", "Porsche"));

			for (SupercarEntity supercar : supercars) {

				entityManager.persist(supercar);
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
