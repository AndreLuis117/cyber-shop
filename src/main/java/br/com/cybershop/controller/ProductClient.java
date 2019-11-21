package br.com.cybershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cybershop.model.Client;
import br.com.cybershop.model.Product;
import br.com.cybershop.service.ProductService;

@Controller
@RequestMapping("/product-client")
public class ProductClient {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ModelAndView index() {
		List<Product> list = productService.getAll();
		return new ModelAndView("product-client/index", "product", list);
	}
	
	@GetMapping(value="/details-edit/{id}")
	public ModelAndView edit(@PathVariable("id") Product product) {
		return new ModelAndView("product-client/details-edit","product",product);
	}
	
}
