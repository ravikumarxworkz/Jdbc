package com.xworkz.camera.read;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class Model {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is done");

		try {

			entityTransaction.begin();

			javax.persistence.Query query = entityManager.createNamedQuery("findbrandAndModelByprice");

			query.setParameter("price", 449.99);

			Object[] obj = (Object[]) query.getSingleResult();
			entityTransaction.commit();

			for (Object object : obj) {
				System.out.println(object);
			}

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
