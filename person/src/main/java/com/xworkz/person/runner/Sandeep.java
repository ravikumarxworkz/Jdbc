package com.xworkz.person.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class Sandeep {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		entityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is done");
		try {
			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("findphone_numberebyid");

			query.setParameter("id", 4);

			Object obj = (Object) query.getSingleResult();

			long number = (long) obj;

			entityTransaction.commit();
			System.out.println("number by id=" + number);
		} catch (Exception e) {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		} finally {

			entityManager.close();
			entityManagerFactory.close();

		}
	}

}
