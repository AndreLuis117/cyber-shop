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
import br.com.cybershop.model.ProductCategory;
import br.com.cybershop.model.StockInput;
import br.com.cybershop.repository.ProductCategoryRepository;
import br.com.cybershop.repository.ProductRepository;
import br.com.cybershop.repository.StockInputRepository;
import br.com.cybershop.service.ProductService;
import br.com.cybershop.service.StockInputService;

@Controller
@RequestMapping("/stockInput")
public class StockInputController {
	
	@Autowired
	private StockInputService stockInputService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	public ModelAndView index() {
		List<StockInput> list = stockInputService.getAll();
		return new ModelAndView("stockInput/index", "stockInput", list);
	}
		 
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute StockInput stockInput) {
		List<Product> listProduct = productService.getAll();
		return new ModelAndView("stockInput/form", "listProduct", listProduct);
	}
	
	@PostMapping(params="form")
	public ModelAndView saveInsert(@Valid StockInput stockInput,BindingResult result) 
	{
		List<StockInput> listStockInput = stockInputService.getAll();
		if(result.hasErrors()) {
			HashMap<String, Object> dados = new HashMap<>();
			dados.put("listStockInput", listStockInput);
			dados.put("stockInput",stockInput);
			return new ModelAndView("stockInput/form",dados);
			
		}
		stockInputService.save(stockInput);
		return new ModelAndView("redirect:/stockInput");
	}
}
