package br.com.cybershop.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.cybershop.model.Product;
import br.com.cybershop.model.ProductCategory;
import br.com.cybershop.repository.ProductCategoryRepository;
import br.com.cybershop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {


	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@GetMapping()
	public ModelAndView index() {
		List<Product> list = productService.getAll();
		 return new ModelAndView("product/index", "products", list);
	}
		 
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute Product product) {
		List<ProductCategory> listCategory = productCategoryRepository.findAll();
		return new ModelAndView("product/form", "listCategory", listCategory);
	}
	@PostMapping(params="form")
	public ModelAndView saveInsert(@Valid Product product,BindingResult result) 
	{
		List<ProductCategory> listCategory = productCategoryRepository.findAll();
		if(result.hasErrors()) {
			HashMap<String, Object> dados = new HashMap<>();
			dados.put("listCategory", listCategory);
			dados.put("product",product);
			return new ModelAndView("product/form",dados);
			
		}
		productService.save(product);
		return new ModelAndView("redirect:/product");
	}
	
	@PostMapping(params="details-edit")
	public ModelAndView saveEdit(@Valid Product product, BindingResult result) 
	{
		if(result.hasErrors()) {
			return new ModelAndView("product/details-edit");
		}
		productService.save(product);
		return new ModelAndView("redirect:/product");
	}
	
	@GetMapping(value="/details-edit/{id}")
	public ModelAndView edit(@PathVariable("id") Product product) {
		List<ProductCategory> listCategory = productCategoryRepository.findAll();
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("product", product);
		dados.put("listCategory", listCategory);
		return new ModelAndView("product/details-edit",dados);
	}
	
}
