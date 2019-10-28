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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cybershop.model.Catalog;
import br.com.cybershop.model.CatalogItems;
import br.com.cybershop.model.Product;
import br.com.cybershop.repository.CatalogItemsRepository;
import br.com.cybershop.repository.CatalogRepository;
import br.com.cybershop.repository.ProductRepository;
import br.com.cybershop.service.CatalogService;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CatalogItemsRepository catalogItemsRepository;
	
	@Autowired
	private CatalogRepository catalogRepository;
	
	@GetMapping("")
	public ModelAndView index() {
		List<Catalog> list =  catalogService.getAll();
		return new ModelAndView("catalog/index", "catalog", list);
	}
	
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute Catalog catalog) {
		List<Product> listProduct = this.productRepository.findAll();
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("listProduct", listProduct);
		dados.put("newCatalogItems", new CatalogItems());
		
		
		return new ModelAndView("catalog/form", dados);
	}
	
	@PostMapping(params = {"save"})
	public ModelAndView saveInsert(@Valid Catalog catalog, @Valid CatalogItems catalogItems, BindingResult result, RedirectAttributes redirect) {
		catalog = this.catalogRepository.save(catalog);
		return new ModelAndView("redirect:/catalog");
	}
	
	@PostMapping(params= {"insertproc"})
    public ModelAndView insertproc(Catalog catalog, CatalogItems catalogItems, BindingResult result, RedirectAttributes redirect) {
		List<Product> listProduct = this.productRepository.findAll();
		
		catalog.getCatalogItems().add(catalogItems);
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("catalgo", catalog);
		dados.put("listProduct", listProduct);
		dados.put("newCatalogItems", new CatalogItems());
		
		
		return new ModelAndView("catalog/form", dados);
    }
	
	@PostMapping(params= {"removeproc"})
    public ModelAndView removeproc(@RequestParam(name = "removeproc") int index, Catalog catalog, CatalogItems catalogItems, BindingResult result, RedirectAttributes redirect) {
		List<Product> listProduct = this.productRepository.findAll();
       
        catalog.getCatalogItems().remove(index);
   
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("catalgo", catalog);
		dados.put("listProduct", listProduct);
		dados.put("newCatalogItems", new CatalogItems());
       
		return new ModelAndView("catalog/form", dados);
    }
	
    @GetMapping(value="/details-edit/{id}")
    public ModelAndView edit(@PathVariable("id") Catalog catalog) {
    	List<Product> listProduct = this.productRepository.findAll();
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("catalgo", catalog);
		dados.put("listProduct", listProduct);
		dados.put("newCatalogItems", new CatalogItems());
       
        return new ModelAndView("catalog/form",dados);
    }
   
   
    @GetMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable ("id") Long id, RedirectAttributes redirect) {
        this.catalogRepository.deleteById(id);
        return new ModelAndView("redirect:/catalog");
    }
    
	/*
	
	@PostMapping(params="form")
	public ModelAndView saveInsert(@Valid Catalog catalog, BindingResult result) 
	{
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return new ModelAndView("catalog/form");
		}
		
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
		return new ModelAndView("catalog/details-edit", dados);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Catalog catalog) {
		 catalogService.delete(catalog);
		return new ModelAndView("client/form","catalog",catalog);
	}
*/

}
