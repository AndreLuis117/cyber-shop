package br.com.cybershop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value= {"/home-client","/"})
public class HomeClientController {
	@RequestMapping(method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView index() {
		 return new ModelAndView("home-client/index");
	}
}
