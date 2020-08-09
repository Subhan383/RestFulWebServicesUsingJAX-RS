package org.restapp.showrrom.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.restapp.showrrom.model.BrandsEntity;
import org.restapp.showrrom.model.ProductsEntity;

public class ProductsDAO {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ProductsEntity.class)
			.addAnnotatedClass(BrandsEntity.class).buildSessionFactory();

	public List<ProductsEntity> getProductsByBrandID(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<ProductsEntity> listOfProducts;
		String query = "from products where brandId= '" + brandId + "'";
		listOfProducts = session.createQuery(query).getResultList();
		return listOfProducts;
	}

	public List<ProductsEntity> getProductsByBrandIDAndCategory(int brandId, String category) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<ProductsEntity> listOfProductsByCategory;
		String query = "from products where brandId= '" + brandId + "' and category= '" + category + "'";
		listOfProductsByCategory = session.createQuery(query).getResultList();
		return listOfProductsByCategory;
	}

}
