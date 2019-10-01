package br.com.cybershop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	@NotNull()
	@NotEmpty(message="Preencha este campo")
	private String name;
	private Double unitPrice;
	@Column(length=800)
	@NotNull()
	@NotEmpty(message="Preencha este campo")
	private String description;
	@NotNull()
	@NotEmpty(message="Preencha este campo")
	private String brand;
	private boolean status;
	
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=true)
	private ProductCategory prodCat;
	
	/*@OneToMany(cascade = CascadeType.ALL)
	private List<CatalogItems> CatalogItems = new ArrayList<CatalogItems>();
	
	public List<CatalogItems> getCatalogItems() {
		return CatalogItems;
	}
	public void setCatalogItems(List<CatalogItems> catalogItems) {
		CatalogItems = catalogItems;
	}*/
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return name;
	}

}
