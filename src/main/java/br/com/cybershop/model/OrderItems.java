package br.com.cybershop.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItems {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int quantity;
	private float subTotal;
	
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH},optional=false)
	private Product product;
	//
	@ManyToOne(cascade= CascadeType.ALL)
	private Order order;
	//
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	

}
