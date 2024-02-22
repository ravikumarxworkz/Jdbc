package com.xworkz.dance.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class Rajasthan {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connected");
		try {

			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("findstateAndtypebyid");

			query.setParameter("id", 2);

			Object[] object = (Object[]) query.getSingleResult();

			String state = (String) object[0];
			String type = (String) object[1];
			entityTransaction.commit();
			System.out.println("state=" + state);
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
