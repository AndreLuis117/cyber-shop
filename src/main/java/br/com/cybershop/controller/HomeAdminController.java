package br.com.cybershop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value= {"/home-admin", "/"})
public class HomeAdminController {

	@GetMapping()
	public ModelAndView index() {
		 return new ModelAndView("home-admin/index");
	}
}
