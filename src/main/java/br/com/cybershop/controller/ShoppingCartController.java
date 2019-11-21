package br.com.cybershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.cybershop.model.ShoppingCart;
import br.com.cybershop.model.ShoppingCartItem;

@Controller
public class ShoppingCartController {
	
	/*
	private final ShoppingCart shoppingCart;
	
	public ShoppingCartController(ShoppingCart shoppingCart) {
	    this.shoppingCart = shoppingCart;
	  }
	
	@PostMapping(params="shoppingCart")
	public void add(ShoppingCartItem shoppingCartItem) {
		shoppingCart.add(shoppingCartItem);
	  }
	  */
}
