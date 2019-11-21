package br.com.cybershop.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ShoppingCart {
	
	private List<ShoppingCartItem> itens = new ArrayList<ShoppingCartItem>();
	private Double total = 0.0;
	
	public void add(ShoppingCartItem shoppingCartItem) {
	    itens.add(shoppingCartItem);
	    total += shoppingCartItem.getProduct().getUnitPrice() * shoppingCartItem.getQuantity();
	  }
	public List<ShoppingCartItem> getItens() {
		return itens;
	}
	public void setItens(List<ShoppingCartItem> itens) {
		this.itens = itens;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
}
