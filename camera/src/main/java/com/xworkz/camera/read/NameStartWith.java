package com.xworkz.camera.read;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class NameStartWith {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is done");

		try {

			entityTransaction.begin();

			javax.persistence.Query query = entityManager.createNamedQuery("findbrandStartwith");

//			query.setParameter("brand", "%C");

//			Object[] obj = (Object[]) query.getSingleResult();

			List<String> result = query.getResultList();
			
			entityTransaction.commit();
			for (String object : result) {
				System.out.println("name=" + object);
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
