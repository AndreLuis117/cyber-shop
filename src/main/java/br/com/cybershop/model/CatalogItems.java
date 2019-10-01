package br.com.cybershop.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CatalogItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long catalogItemsId;
	
	public long getCatalogItemsId() {
		return catalogItemsId;
	}

	public void setCatalogItemsId(long catalogItemsId) {
		this.catalogItemsId = catalogItemsId;
	}

	@OneToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=true)
	private Catalog catalog;
	
	@OneToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=true)
	private Product product;
	
	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


}
