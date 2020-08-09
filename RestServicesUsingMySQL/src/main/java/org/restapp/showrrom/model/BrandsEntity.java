package org.restapp.showrrom.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "brands")
@Table(name = "brands")
public class BrandsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brandId")
	private int brandId;

	@Column(name = "brandName")
	private String brandName;

	@Transient
	private List<RelationsLink> link;

	public BrandsEntity() {

	}

	public BrandsEntity(int brandId, String brandName) {

		this.brandId = brandId;
		this.brandName = brandName;
	}

	public BrandsEntity(int brandId, String brandName, List<RelationsLink> link) {

		this.brandId = brandId;
		this.brandName = brandName;
		this.link = link;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<RelationsLink> getLink() {
		return link;
	}

	public void setLink(List<RelationsLink> link) {
		this.link = link;
	}

}
