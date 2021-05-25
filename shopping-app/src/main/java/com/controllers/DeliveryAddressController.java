package com.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Address;
import com.model.User;

@Controller
@RequestMapping("/")
public class DeliveryAddressController {

	
	@RequestMapping(value = "deliveryAddress",method = RequestMethod.GET)
	public ModelAndView getDeliveryAddressPage(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session=request.getSession();
		Map<String, ArrayList<Float>> cart=(Map<String, ArrayList<Float>>)session.getAttribute("cart");
		if(cart==null) {
			session.setAttribute("totalItems", 0);
		}else {
			session.setAttribute("totalItems", cart.keySet().size());
		}
		User user=(User)session.getAttribute("user");
		Address address=new Address();
		mandv.addObject("address", address);
		mandv.addObject("addresses",user.getAddresses());
		mandv.setViewName("deliveryAddress");
		return mandv;
	}
	
	@RequestMapping(value = "addDeliveryAddress",method = RequestMethod.POST)
	public ModelAndView saveAddress(ModelAndView mandv,@Valid Address address,BindingResult result,HttpServletRequest request) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(result.hasErrors() && result.getErrorCount()>1) {
			mandv.setViewName("deliveryAddress");
		}else {
			System.out.println(address);
			Map<String,String> deliveryAddress=new HashMap<String, String>();
			deliveryAddress.put("name", user.getUsername());
			deliveryAddress.put("doorno", address.getDoorno());
			deliveryAddress.put("street", address.getStreet());
			deliveryAddress.put("area", address.getArea());
			deliveryAddress.put("city", address.getCity());
			deliveryAddress.put("pincode", address.getPincode());
			session.setAttribute("deliveryAddress", deliveryAddress);
			mandv.setViewName("redirect:/payment");
		}
		mandv.addObject("addresses",user.getAddresses());
		
		return mandv;
	}
}
