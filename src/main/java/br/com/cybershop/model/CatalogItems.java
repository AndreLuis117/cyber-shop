package br.com.cybershop.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=true)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalog == null) ? 0 : catalog.hashCode());
		result = prime * result + (int) (catalogItemsId ^ (catalogItemsId >>> 32));
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CatalogItems other = (CatalogItems) obj;
		if (catalog == null) {
			if (other.catalog != null)
				return false;
		} else if (!catalog.equals(other.catalog))
			return false;
		if (catalogItemsId != other.catalogItemsId)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}


	
}
