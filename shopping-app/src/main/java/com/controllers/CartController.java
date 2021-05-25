package com.controllers;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CartController {

	@RequestMapping(value = "cart",method = RequestMethod.GET)
	public ModelAndView register(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session=request.getSession();
		Map<String, ArrayList<Float>> cart=(Map<String, ArrayList<Float>>)session.getAttribute("cart");
		if(cart==null) {
			session.setAttribute("totalItems", 0);
		}else {
			session.setAttribute("totalItems", cart.keySet().size());
		}
		mandv.setViewName("cart");
		return mandv;
	}
}
