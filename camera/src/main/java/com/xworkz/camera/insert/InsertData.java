package com.xworkz.camera.insert;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.camera.entity.CameraEntity;

public class InsertData {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		System.out.println("connection is ok");

		try {
			entityTransaction.begin();

			ArrayList<CameraEntity> cameraList = new ArrayList<>();

			cameraList.add(new CameraEntity(1, "Canon", "EOS Rebel T7", 24, "APS-C", 449.99));
			cameraList.add(new CameraEntity(2, "Nikon", "D3500", 24, "APS-C", 496.95));
			cameraList.add(new CameraEntity(3, "Sony", "Alpha a6000", 24, "APS-C", 548.00));
			cameraList.add(new CameraEntity(4, "Fujifilm", "X-T30", 26, "APS-C", 899.00));
			cameraList.add(new CameraEntity(5, "Panasonic", "Lumix G7", 16, "Micro Four Thirds", 497.99));
			for (CameraEntity camera : cameraList) {
				entityManager.persist(camera);
			}
			entityTransaction.commit();
			System.out.println("data saved");
		} catch (PersistenceException e) {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		} finally {
			entityManager.close();
			entityManagerFactory.close();

		}
	}

}
