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

import br.com.cybershop.model.Promotion;
import br.com.cybershop.repository.PromotionRepository;
import br.com.cybershop.service.PromotionService;

@Controller
@RequestMapping("/promotion")
public class PromotionController {
	
	@Autowired
	private PromotionService promotionService;
	
	@Autowired
	private PromotionRepository promotionRepository;
	
	@GetMapping()
	public ModelAndView index() {
		List<Promotion> list = promotionService.getAll();
		return new ModelAndView("promotion/index", "promotion", list);
	}
	
	@GetMapping("/new")
	public String createForm(@ModelAttribute Promotion promotion) {
		return "promotion/form";
	}
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Promotion promotion) 
	{
		promotionService.save(promotion);
		return new ModelAndView("redirect:/promotion");
	}
	
	@PostMapping(params="details-edit")
	public ModelAndView save2(@Valid Promotion promotion) 
	{
		promotionService.save(promotion);
		return new ModelAndView("redirect:/promotion");
	}
	
	@GetMapping(value="/details-edit/{id}")
	public ModelAndView edit(@PathVariable("id") Promotion promotion) {
		return new ModelAndView("promotion/details-edit","promotion", promotion);
	}
}
