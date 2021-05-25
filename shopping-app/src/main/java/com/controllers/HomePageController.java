package com.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.AddToCartForm;


@Controller
@RequestMapping("/")
public class HomePageController {

	@Autowired
	ServletContext context; 
	
	@RequestMapping(value = "home",method = RequestMethod.GET)
	public ModelAndView register(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session=request.getSession();
		Map<String, ArrayList<Float>> cart=(Map<String, ArrayList<Float>>)session.getAttribute("cart");
		if(cart==null) {
			session.setAttribute("totalItems", 0);
		}else {
			session.setAttribute("totalItems", cart.keySet().size());
		}
		mandv.setViewName("home");
		return mandv;
	}
	
	@RequestMapping(value="addItem",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Integer> addItem(@RequestBody AddToCartForm jsonString,HttpServletRequest request) {
		HttpSession session=request.getSession();
		Map<String, ArrayList<Float>> cart=(Map<String, ArrayList<Float>>)session.getAttribute("cart");
		if(cart==null) {
			cart=new HashMap<String, ArrayList<Float>>();
			session.setAttribute("cart", cart);
		}
		if(jsonString.getQty()==0) {
			cart.remove(jsonString.getName());
		}else {
			ArrayList<Float> values=new ArrayList<Float>();
			values.add(jsonString.getQty());
			values.add(jsonString.getPrice());
			cart.put(jsonString.getName(), values);
		}
		System.out.println(cart);
		session.setAttribute("totalItems", cart.keySet().size());
		session.setAttribute("cart", cart);
		return  new ResponseEntity<Integer>(cart.keySet().size() , HttpStatus.OK);
	}
}
