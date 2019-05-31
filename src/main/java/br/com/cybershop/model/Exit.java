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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Exit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long exitId;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date date;
	private float quantity;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();
	
	public long getExitId() {
		return exitId;
	}
	public void setExitId(long exitId) {
		this.exitId = exitId;
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
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
