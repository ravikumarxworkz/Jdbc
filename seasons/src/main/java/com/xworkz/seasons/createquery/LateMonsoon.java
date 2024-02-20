package com.xworkz.seasons.createquery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LateMonsoon {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is ok");
		try {
			entityTransaction.begin();
			Query query = entityManager.createQuery("UPDATE  SeasonsEntity entity SET entity.temperature=:temperature WHERE entity.name=:name");
			query.setParameter("temperature",35.00);
			query.setParameter("name","LateMonsoon");
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
