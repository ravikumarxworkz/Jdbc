package com.xworkz.wallet.runner;

import javax.activation.CommandObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.wallet.entity.WalletEntity;

public class Prada {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {

			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("findcompanyByprice");

			query.setParameter("price", 150.0);

			Object object = (Object) query.getSingleResult();

			String company = (String) object;
			entityTransaction.commit();

			System.out.println("company=" + company);
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
