package br.com.cybershop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class PromoItems {
	
	private int quantity;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> ItemsPromo = new ArrayList<Product>(); 
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
}
