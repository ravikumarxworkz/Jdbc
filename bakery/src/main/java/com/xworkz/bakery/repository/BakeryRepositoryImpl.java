package com.xworkz.bakery.repository;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.bakery.entity.BakeryEntity;

public class BakeryRepositoryImpl implements BakeryRepository {

	ArrayList<BakeryEntity> read;

	@Override
	public boolean save(BakeryEntity entity) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();

			entityManager.persist(entity);

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
	public ArrayList<BakeryEntity> read() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			Query query = entityManager.createNamedQuery("readAll");

			read = (ArrayList<BakeryEntity>) query.getResultList();

			entityTransaction.commit();

		} catch (PersistenceException e) {

			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
				// return null;
			}
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}

		return read;

	}

	@Override
	public boolean updateNameByPrice(BakeryEntity entity) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			Query query = entityManager.createNamedQuery("updateNameByprice");
			query.setParameter("name", entity.getName());
			query.setParameter("oldName", entity.getPrice());

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
	public boolean deleteById(BakeryEntity entity) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			BakeryEntity entity1 = entityManager.find(BakeryEntity.class, entity.getId());

			entityManager.remove(entity1);
			entityTransaction.commit();
			System.out.println("data  delete");
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
