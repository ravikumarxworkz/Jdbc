package com.xworkz.makeupkit.repositotry;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import com.xworkz.makeupkit.entity.MakeupKitEntity;

public class MakeupKitRepoImpl implements MakeupKitRepo {

	ArrayList<MakeupKitEntity> read;

	@Override
	public boolean validate(MakeupKitEntity entity) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		System.err.println("connection is ok");

		try {
			entityTransaction.begin();

			entityManager.persist(entity);

			entityTransaction.commit();

		} catch (PersistenceException e) {

			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}

		return false;
	}

	@Override
	public ArrayList<MakeupKitEntity> read() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		System.err.println("connection is ok");

		try {
			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("readAll");

			read = (ArrayList<MakeupKitEntity>) query.getResultList();

			entityTransaction.commit();

		} catch (PersistenceException e) {

			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}

		return read;
	}

	@Override
	public boolean updateNameByPrice(String name, double price) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("updateNamebyPrice");

			query.setParameter("name", name);
			query.setParameter("price", price);

			query.executeUpdate();

			entityTransaction.commit();

		} catch (PersistenceException e) {

			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
				return false;
			}
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}

		return true;
	}

	@Override
	public boolean deleteById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			MakeupKitEntity entity = entityManager.find(MakeupKitEntity.class, id);
			entityManager.remove(entity);
			entityTransaction.commit();
		} catch (PersistenceException e) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
				return false;
			}
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return true;
	}

}
