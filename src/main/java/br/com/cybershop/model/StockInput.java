package br.com.cybershop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class StockInput {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long entryId;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date date;
	private float quantity;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Product product = new Product();
	
	public long getEntryId() {
		return entryId;
	}
	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProducts(Product product) {
		this.product = product;
	}

	
	
}
