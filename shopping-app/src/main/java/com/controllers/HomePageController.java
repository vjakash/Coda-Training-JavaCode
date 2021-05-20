package com.controllers;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class HomePageController {

	@Autowired
	ServletContext context; 
	
	@RequestMapping(value = "home",method = RequestMethod.GET)
	public ModelAndView register(ModelAndView mandv) {
		mandv.setViewName("home");
		return mandv;
	}
}
