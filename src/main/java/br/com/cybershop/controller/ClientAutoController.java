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

import br.com.cybershop.model.Client;
import br.com.cybershop.service.ClientService;

@Controller
@RequestMapping("/client-auto")
public class ClientAutoController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping()
	public ModelAndView index() {
		List<Client> list = clientService.getAll();
		 return new ModelAndView("client-auto/index", "clients", list);
	}
		 
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute Client client) {
		return new ModelAndView("client-auto/form");
	}
	@PostMapping(params="form")
	public ModelAndView save(@Valid Client client) 
	{
		client.setStatus(true);
		clientService.save(client);
		return new ModelAndView("redirect:/client-auto");
	}
	
	@GetMapping(value="/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Client client) {
		return new ModelAndView("client-auto/form","client",client);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Client client) {
		 clientService.delete(client);
		return new ModelAndView("client-auto/form","client",client);
	}

}
