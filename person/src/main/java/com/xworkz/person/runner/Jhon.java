package com.xworkz.person.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.person.entity.PersonEntity;

public class Jhon {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = null;
		entityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
             System.out.println("connection is done");
		try {

			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("findByName");

			query.setParameter("name","John Doe");

			PersonEntity entity = (PersonEntity) query.getSingleResult();

			entityTransaction.commit();
			System.out.println("entity by id=" + entity);
              
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
