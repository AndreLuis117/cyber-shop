package br.com.cybershop.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cybershop.model.Product;
import br.com.cybershop.model.StockOutput;
import br.com.cybershop.service.ProductService;
import br.com.cybershop.service.StockOutputService;

@Controller
@RequestMapping("/stockOutput")
public class StockOutputController {
	
	@Autowired
	private StockOutputService stockOutputService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	public ModelAndView index() {
		List<StockOutput> list = stockOutputService.getAll();
		return new ModelAndView("stockOutput/index", "stockOutput", list);
	}
		 
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute StockOutput stockOutput) {
		List<Product> listProduct = productService.getAll();
		return new ModelAndView("stockOutput/form", "listProduct", listProduct);
	}
	
	@PostMapping(params="form")
	public ModelAndView saveInsert(@Valid StockOutput stockOutput,BindingResult result) 
	{
		List<Product> listProduct = productService.getAll();
		if(result.hasErrors()) {
			HashMap<String, Object> data = new HashMap<>();
			data.put("listProduct", listProduct);
			data.put("stockOutput", stockOutput);
			return new ModelAndView("stockOutput/form",data);
			
		}
		stockOutputService.save(stockOutput);
		return new ModelAndView("redirect:/stockOutput");
	}
}
