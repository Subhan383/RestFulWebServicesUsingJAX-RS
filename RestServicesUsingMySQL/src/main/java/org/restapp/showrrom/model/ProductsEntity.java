package org.restapp.showrrom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "products")
@Table(name = "products")
public class ProductsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private int productId;

	@ManyToOne(targetEntity = BrandsEntity.class)
	@JoinColumn(name = "brandId")
	private BrandsEntity brandsEntity;

	@Column(name = "productName")
	private String productName;

	@Column(name = "category")
	private String category;

	@Column(name = "cost")
	private String cost;

	public ProductsEntity() {

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public BrandsEntity getBrandsEntity() {
		return brandsEntity;
	}

	public void setBrandsEntity(BrandsEntity brandsEntity) {
		this.brandsEntity = brandsEntity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

}
