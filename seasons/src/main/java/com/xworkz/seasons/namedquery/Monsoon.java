package com.xworkz.seasons.namedquery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Monsoon {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is ok");
		try {
			entityTransaction.begin();
			Query query = entityManager.createNamedQuery("UpdateById");

			query.setParameter("name", "Autumn");
			query.setParameter("id", 3);
			query.executeUpdate();
			entityTransaction.commit();
			System.out.println("update  sucessfully");
		} catch (Exception e) {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
	}

}
