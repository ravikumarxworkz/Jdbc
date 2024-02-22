package com.xworkz.wallet.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class Chanel {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {

			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("findpriceAndcolorBycompany");

			query.setParameter("company", "chanel");

			Object[] object = (Object[]) query.getSingleResult();

			double price = (double) object[0];
			String color = (String) object[1];
			entityTransaction.commit();

			System.out.println("company=" + price);
			System.out.println("color=" + color);
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
