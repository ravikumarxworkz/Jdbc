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

			read = (ArrayList<BakeryEntity>)query.getResultList();

			entityTransaction.commit();

		} catch (PersistenceException e) {

			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
				//return null;
			}
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}

		return read;

	}

	@Override
	public boolean updateByName(String oldName, String newName) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			if (oldName != null && newName != null) {
				Query query = entityManager.createNamedQuery("updateByName");
				query.setParameter("newName", newName);
				query.setParameter("oldName", oldName);

				query.executeUpdate();

				entityTransaction.commit();

			}

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
			BakeryEntity entity = entityManager.find(BakeryEntity.class, id);

			entityManager.remove(entity);
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

	@Override
	public boolean deleteByNAme(String name) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			Query query = entityManager.createNamedQuery("deleteById");

			for (int i = 0; i < read.size(); i++) {
				
				if(read.get(i).getName().equalsIgnoreCase(name)) {
					
				}

			}
		
			
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
