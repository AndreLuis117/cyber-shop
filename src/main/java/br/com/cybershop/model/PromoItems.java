package br.com.cybershop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PromoItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> ItemsPromo = new ArrayList<Product>(); 
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Product> getItemsPromo() {
		return ItemsPromo;
	}

	public void setItemsPromo(List<Product> itemsPromo) {
		ItemsPromo = itemsPromo;
	}
		
}
