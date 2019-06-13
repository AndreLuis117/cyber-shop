package br.com.cybershop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.cybershop.model.Product;
import br.com.cybershop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {


	@Autowired
	private ProductService productService;
	
	@GetMapping()
	public ModelAndView index() {
		List<Product> list = productService.getAll();
		 return new ModelAndView("product/index", "products", list);
	}
		 
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute Product product) {
		return new ModelAndView("product/form");
	}
	@PostMapping(params="form")
	public ModelAndView save(@Valid Product product) 
	{
		productService.save(product);
		return new ModelAndView("redirect:/product");
	}
	
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Product product) {
		return new ModelAndView("product/form","product",product);
	}
}
