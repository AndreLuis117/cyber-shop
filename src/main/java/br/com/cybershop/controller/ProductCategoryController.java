package br.com.cybershop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cybershop.model.ProductCategory;
import br.com.cybershop.service.ProductCategoryService;

@Controller
@RequestMapping("/productCategory")
@PreAuthorize("hasAuthority('admin')")
public class ProductCategoryController {
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@GetMapping()
	public ModelAndView index() {
		List<ProductCategory> list = productCategoryService.getAll();
		return new ModelAndView("productCategory/index", "productCategory", list);
	}
	
	@GetMapping("/new")
	public String createForm(@ModelAttribute ProductCategory productCategory) {
		return "productCategory/form";
	}
	
	@PostMapping(params="form")
	public ModelAndView saveInsert(@Valid ProductCategory productCategory, BindingResult result) 
	{
		if(result.hasErrors()) {
			return new ModelAndView("productCategory/form");
		}
		productCategoryService.save(productCategory);
		return new ModelAndView("redirect:/productCategory");
	}
	
	@PostMapping(params="details-edit")
	public ModelAndView saveEdit(@Valid ProductCategory productCategory, BindingResult result) 
	{
		if(result.hasErrors()) {
			return new ModelAndView("productCategory/details-edit");
		}
		productCategoryService.save(productCategory);
		return new ModelAndView("redirect:/productCategory");
	}
	
	@GetMapping(value="/details-edit/{id}")
	public ModelAndView edit(@PathVariable("id") ProductCategory productCategory) {
		return new ModelAndView("productCategory/details-edit","productCategory", productCategory);
	}
	
}
