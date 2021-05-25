package com.controllers;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CategoryController {

	@Autowired
	ServletContext context; 
	
	@RequestMapping(value = "category/{type}",method = RequestMethod.GET)
	public ModelAndView register(ModelAndView mandv,HttpServletRequest request,@PathVariable("type") String type) {
		HttpSession session=request.getSession();
		Map<String, ArrayList<Float>> cart=(Map<String, ArrayList<Float>>)session.getAttribute("cart");
		if(cart==null) {
			session.setAttribute("totalItems", 0);
		}else {
			session.setAttribute("totalItems", cart.keySet().size());
		}
		mandv.addObject("type", type);
		mandv.setViewName("category");
		return mandv;
	}
}
