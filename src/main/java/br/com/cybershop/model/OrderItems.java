package br.com.cybershop.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class OrderItems {
	
	private int quantity;
	private float subTotal;
	
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=false)
	private Product product;
	
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=false)
	private Order order;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	
	
	

}
