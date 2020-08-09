package org.restapp.showrrom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.restapp.showrrom.model.BrandsEntity;

public class BrandsDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BrandsEntity.class)
			.buildSessionFactory();

	public List<BrandsEntity> getBrands() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<BrandsEntity> listOfBrands = session.createQuery("from brands").getResultList();
		return listOfBrands;

	}

	public BrandsEntity getBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		return session.get(BrandsEntity.class, brandId);

	}

	public void addBrand(BrandsEntity brand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
	}

	public void updateBrand(BrandsEntity updateBrand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		int brandId = updateBrand.getBrandId();
		BrandsEntity brands = session.get(BrandsEntity.class, brandId);
		brands.setBrandName(updateBrand.getBrandName());
		session.getTransaction().commit();
	}

	public void deleteBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		BrandsEntity brand = session.get(BrandsEntity.class, brandId);
		session.delete(brand);
		session.getTransaction().commit();

	}
}
