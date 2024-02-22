package com.xworkz.dance.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class Gujarat {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connected");
		try {

			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("findtypebystate");

			query.setParameter("state", "Gujarat");

			Object object = (Object) query.getSingleResult();

			String type = (String) object;
			entityTransaction.commit();
			System.out.println("type=" + type);
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
