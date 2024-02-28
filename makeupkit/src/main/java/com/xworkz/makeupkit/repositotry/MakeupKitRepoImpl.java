package com.xworkz.makeupkit.repositotry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import com.xworkz.makeupkit.entity.MakeupKitEntity;

public class MakeupKitRepoImpl implements MakeupKitRepo {

	@Override
	public boolean updateById(MakeupKitEntity entity) {
		System.out.println("data is coming from service");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();
			MakeupKitEntity kitEntity = entityManager.find(MakeupKitEntity.class, entity.getId());
			if (kitEntity != null) {
				kitEntity.setName(entity.getName());
				kitEntity.setPrice(entity.getPrice());
				kitEntity.setCompanyName(entity.getCompanyName());

				entityManager.merge(kitEntity);
				entityTransaction.commit();
				System.out.println("Data updated successfully");
				return true;
			} else {
				System.out.println("Makeup kit with ID " + entity.getId() + " not found");
				return false;
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
	public boolean updateNameByPrice(MakeupKitEntity entity) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("updateNameByPrice");

			query.setParameter("name", entity.getName());
			query.setParameter("price", entity.getPrice());

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
	public boolean updateCompanyNameByName(MakeupKitEntity entity) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			System.err.println("connection is ok");
			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("updateCompanyNameByName");

			query.setParameter("companyName", entity.getCompanyName());
			query.setParameter("name", entity.getName());

			query.executeUpdate();

			entityTransaction.commit();
			System.out.println("data is updated");

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
	public boolean updateIdAndNameByPrice(MakeupKitEntity entity) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("updateIdAndNameByPrice");

			query.setParameter("id", entity.getId());
			query.setParameter("name", entity.getName());
			query.setParameter("price", entity.getPrice());

			query.executeUpdate();

			entityTransaction.commit();
			System.out.println("dat is updated");

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
	public boolean updateCompanyNameByNameAndPrice(MakeupKitEntity entity) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		try {
			entityTransaction.begin();

			Query query = entityManager.createNamedQuery("updateCompanyNameByNameAndPrice");

			query.setParameter("companyName", entity.getCompanyName());
			query.setParameter("name", entity.getName());
			query.setParameter("price", entity.getPrice());

			query.executeUpdate();

			entityTransaction.commit();
			System.out.println("data is update is data base");

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
