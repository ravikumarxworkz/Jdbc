package com.xworkz.camera.read;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.camera.entity.CameraEntity;

public class Sony {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is done");

		try {

			entityTransaction.begin();

			javax.persistence.Query query = entityManager.createNamedQuery("readbyBrandAndPrice");

			query.setParameter("brand", "Sony");
			query.setParameter("price", 548.00);

			Object obj = query.getSingleResult();

			CameraEntity cameraEntity = (CameraEntity) obj;

			entityTransaction.commit();

			System.out.println("Megapixels"+cameraEntity.getMegapixels());

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
