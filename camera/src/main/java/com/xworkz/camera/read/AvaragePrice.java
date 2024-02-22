package com.xworkz.camera.read;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.camera.entity.CameraEntity;

public class AvaragePrice {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is done");

		try {

			entityTransaction.begin();

			javax.persistence.Query query = entityManager.createNamedQuery("avgprice");

			Object obj = query.getSingleResult();

			double avgprice = (double) obj;

			entityTransaction.commit();
			System.out.println("avgprice=" + avgprice);

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
