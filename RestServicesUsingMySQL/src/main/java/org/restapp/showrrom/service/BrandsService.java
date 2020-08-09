package org.restapp.showrrom.service;

import java.util.List;

import org.restapp.showrrom.dao.BrandsDAO;
import org.restapp.showrrom.model.BrandsEntity;

public class BrandsService {
	
	BrandsDAO brandDao=new BrandsDAO();
	
	public List<BrandsEntity> getBrands(){
		return brandDao.getBrands();
	}

	
	public BrandsEntity getBrand(int brandId) {
		return brandDao.getBrand(brandId);
	}
	
	public void addBrand(BrandsEntity brand) {
		brandDao.addBrand(brand);
	}
	
	public void updateBrand(BrandsEntity brand) {
		brandDao.updateBrand(brand);
	}
	
	public void deleteBrand(int brandId) {
		brandDao.deleteBrand(brandId);
	}
	
	
}
