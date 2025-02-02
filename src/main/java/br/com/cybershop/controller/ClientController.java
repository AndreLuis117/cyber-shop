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

import br.com.cybershop.model.Client;
import br.com.cybershop.service.ClientService;

@Controller
@RequestMapping("/client")
@PreAuthorize("hasAuthority('admin')")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping()
	public ModelAndView index() {
		List<Client> list = clientService.getAll();
		 return new ModelAndView("client/index", "clients", list);
	}
		 
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute Client client) {
		return new ModelAndView("client/form");
	}
	@PostMapping(params="form")
	public ModelAndView saveInsert(@Valid Client client, BindingResult result) 
	{	
		if(result.hasErrors()) {
			return new ModelAndView("client/form");
		}
		client.setUser();
		clientService.save(client);
		return new ModelAndView("redirect:/client");
	}
	
	@PostMapping(params="details-edit")
	public ModelAndView saveEdit(@Valid Client client, BindingResult result) 
	{
		if(result.hasErrors()) {
			return new ModelAndView("client/details-edit");
		}
		client.setUser();
		clientService.save(client);
		return new ModelAndView("redirect:/client");
	}
	
	@GetMapping(value="/details-edit/{id}")
	public ModelAndView edit(@PathVariable("id") Client client) {
		return new ModelAndView("client/details-edit","client",client);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Client client) {
		 clientService.delete(client);
		return new ModelAndView("client/form","client",client);
	}

}
