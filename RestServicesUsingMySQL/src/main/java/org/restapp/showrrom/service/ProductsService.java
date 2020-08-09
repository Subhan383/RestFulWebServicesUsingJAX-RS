package org.restapp.showrrom.service;

import java.util.List;

import org.restapp.showrrom.dao.ProductsDAO;
import org.restapp.showrrom.model.ProductsEntity;

public class ProductsService {
	ProductsDAO dao=new ProductsDAO();
	
	public List<ProductsEntity> getProducts(int brandId){
		List<ProductsEntity> products=dao.getProductsByBrandID(brandId);
		return products;
	}

	public List<ProductsEntity> getProductsByBrandIDAndCategory(int brandId,String category){ 
		List<ProductsEntity> products=dao.getProductsByBrandIDAndCategory(brandId, category);
		return products;
	}
	
	
 }
