package br.com.cybershop.controller;

import java.util.HashMap;
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

import br.com.cybershop.model.Catalog;
import br.com.cybershop.model.Product;
import br.com.cybershop.repository.ProductRepository;
import br.com.cybershop.service.CatalogService;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping()
	public ModelAndView index() {
		List<Catalog> list =  catalogService.getAll();
		return new ModelAndView("catalog/index", "catalog", list);
	}
	
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute Catalog catalog) {
		List<Product> listProduct = productRepository.findAll();
		return new ModelAndView("catalog/form", "listProduct", listProduct);
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Catalog catalog) 
	{
		catalogService.save(catalog);
		return new ModelAndView("redirect:/catalog");
	}
	
	@PostMapping(params="details-edit")
	public ModelAndView save2(@Valid Catalog catalog) 
	{
		catalogService.save(catalog);
		return new ModelAndView("redirect:/catalog");
	}
	
	@GetMapping(value="/details-edit/{id}")
	public ModelAndView edit(@PathVariable("id") Catalog catalog) {
		List<Product> listProduct = productRepository.findAll();
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("catalog", catalog);
		dados.put("listProduct", listProduct);
		return new ModelAndView("catalog/details-edit", dados);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Catalog catalog) {
		 catalogService.delete(catalog);
		return new ModelAndView("client/form","catalog",catalog);
	}


}
