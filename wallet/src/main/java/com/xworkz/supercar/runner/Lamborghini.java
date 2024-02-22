package com.xworkz.supercar.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class Lamborghini {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connected");
		try {

			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("findcolorAndnamebyprice");

			query.setParameter("price", 300000.0);

			Object object[] = (Object[]) query.getSingleResult();

			String name = (String) object[0];
			String color = (String) object[1];
			entityTransaction.commit();
			System.out.println("car  name=" + name);
			System.out.println("car  color=" + color);
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
