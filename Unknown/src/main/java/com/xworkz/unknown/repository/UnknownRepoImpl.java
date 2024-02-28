package com.xworkz.unknown.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.unknown.entity.UnknowEntity;

public class UnknownRepoImpl implements UnknownRepo {

	ArrayList<UnknowEntity> read;
	UnknowEntity entity1;
	Object object;
	Object[] obj;

	@Override
	public ArrayList<UnknowEntity> readAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			Query query = entityManager.createNamedQuery("readAll");

			read = (ArrayList<UnknowEntity>) query.getResultList();

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
	public UnknowEntity findById(UnknowEntity entity) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			Query query = entityManager.createNamedQuery("findByid");

			query.setParameter("id", entity.getId());

			entity1 = (UnknowEntity) query.getSingleResult();

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

		return entity1;

	}

	@Override
	public UnknowEntity findByName(UnknowEntity entity) {
		EntityManagerFactory entityManagerFactory = null;
		entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is done");
		try {

			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("findByName");

			query.setParameter("name", entity.getName());

			entity1 = (UnknowEntity) query.getSingleResult();

			entityTransaction.commit();

		} catch (Exception e) {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		} finally {

			entityManager.close();
			entityManagerFactory.close();

		}
		return entity1;
	}

	@Override
	public Object[] findIdAndNameByName(UnknowEntity entity) {
		EntityManagerFactory entityManagerFactory = null;
		entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is done");
		try {

			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("findidAndnamebyname");

			query.setParameter("name", entity.getName());

			obj = (Object[]) query.getSingleResult();

			entityTransaction.commit();

		} catch (Exception e) {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		} finally {

			entityManager.close();
			entityManagerFactory.close();

		}
		return obj;
	}

	@Override
	public Object[] findAgeAndNumberByName(UnknowEntity entity) {
		EntityManagerFactory entityManagerFactory = null;
		entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is done");
		try {

			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("findageAndnumberbyname");

			query.setParameter("name", entity.getName());

			obj = (Object[]) query.getSingleResult();

			entityTransaction.commit();

		} catch (Exception e) {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		} finally {

			entityManager.close();
			entityManagerFactory.close();

		}
		return obj;
	}

	@Override
	public Object count() {
		EntityManagerFactory entityManagerFactory = null;
		entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is done");
		try {

			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("count");

			object = (Object) query.getSingleResult();

			entityTransaction.commit();

		} catch (Exception e) {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		} finally {

			entityManager.close();
			entityManagerFactory.close();

		}
		return object;
	}

	@Override
	public Object sumOfAge() {
		EntityManagerFactory entityManagerFactory = null;
		entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is done");
		try {

			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("sumOfAge");

			object = (Object) query.getSingleResult();

			entityTransaction.commit();

		} catch (Exception e) {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		} finally {

			entityManager.close();
			entityManagerFactory.close();

		}
		return object;
	}

	@Override
	public ArrayList<String> findNamesGreaterThanAge(UnknowEntity entity) {

		EntityManagerFactory entityManagerFactory = null;
		entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is done");
		try {

			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("findNamesGreaterThanAge");

			query.setParameter("age", entity.getAge());

			ArrayList<String> list = (ArrayList<String>) query.getResultList();

			entityTransaction.commit();

			return list;

		} catch (Exception e) {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		} finally {

			entityManager.close();
			entityManagerFactory.close();

		}
		return null;
	}
}
