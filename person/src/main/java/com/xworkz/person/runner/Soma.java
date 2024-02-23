package com.xworkz.person.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.person.entity.PersonEntity;

public class Soma {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.xworkz");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is ok");

		try {
			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("findnameByid");

			query.setParameter("id", 6);

			Object obj = (Object) query.getSingleResult();

			String name = (String) obj;
		
			entityTransaction.commit();
			System.out.println("name by id=" + name);
		} catch (Exception e) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		} finally {
			entityManager.clear();
			entityManagerFactory.close();
		}
	}

}
