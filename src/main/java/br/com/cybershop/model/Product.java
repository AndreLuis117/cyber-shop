package br.com.cybershop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	private String name;
	private Double unitPrice;
	@Column(length=800)
	private String description;
	private String brand;
	
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=true)
	private ProductCategory prodCat;
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public ProductCategory getProdCat() {
		return prodCat;
	}
	public void setProdCat(ProductCategory prodCat) {
		this.prodCat = prodCat;
	}
	

}
