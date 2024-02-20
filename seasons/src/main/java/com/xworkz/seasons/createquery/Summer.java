package com.xworkz.seasons.createquery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Summer {
	
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is ok");
		try {
			entityTransaction.begin();
			
			Query query = entityManager.createQuery("UPDATE  SeasonsEntity entity SET entity.temperature=:temperature WHERE entity.description=:description");

			query.setParameter("temperature", 60.00);
			query.setParameter("description",
					"Summer is the hottest of the four temperate seasons, falling between spring and autumn.");
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
