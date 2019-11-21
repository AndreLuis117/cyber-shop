package br.com.cybershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cybershop.model.Stock;
import br.com.cybershop.model.StockInput;
import br.com.cybershop.service.StockService;

@Controller
@RequestMapping("/stock")
@PreAuthorize("hasAuthority('admin')")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@GetMapping()
	public ModelAndView index() {
		List<Stock> list = stockService.getAll();
		return new ModelAndView("stock/index", "stock", list);
	}
}
