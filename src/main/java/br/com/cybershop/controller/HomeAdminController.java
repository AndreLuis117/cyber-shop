package br.com.cybershop.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value= {"/home-admin"})
@PreAuthorize("hasAuthority('admin')")
public class HomeAdminController {

	@RequestMapping(method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView index() {
		 return new ModelAndView("home-admin/index");
	}
}
