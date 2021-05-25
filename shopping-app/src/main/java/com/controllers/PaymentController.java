package com.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.customtags.GetCartItems;
import com.model.User;

import com.services.PaymentService;

@Controller
@RequestMapping("/")
@PropertySource(value= {"classpath:application.properties"})
public class PaymentController {
	
	@Autowired
	private Environment environment;
	
	public Environment getEnvironment() {
		return environment;
	}
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value = "payment",method = RequestMethod.GET)
	public ModelAndView getPaymentPage(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		Map<String,String> deliveryAddress=(Map<String,String>)session.getAttribute("deliveryAddress");
		mandv.addObject("deliveryAddress",deliveryAddress);
		mandv.setViewName("payment");
		return mandv;
	}
	@RequestMapping(value = "orderplaced",method = RequestMethod.GET)
	public ModelAndView orderPlaced(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");

		mandv.setViewName("orderplaced");
		return mandv;
	}
	@RequestMapping(value = "createOrder",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> createOrder(@RequestBody String total,HttpServletRequest request) {
		System.out.println(total);
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
	    JSONObject jsonObject=paymentService.createOrder(total, user);
		return new ResponseEntity<String>(String.valueOf(jsonObject) , HttpStatus.OK);
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@RequestMapping(value = "paymentSuccess",method = RequestMethod.POST)
	public ModelAndView paymentSuccess(ModelAndView mandv,HttpServletRequest request,@RequestBody String response) {
		System.out.println(response);
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		
		String invoiceNumber=String.valueOf(Math.random()).substring(2,10);
		
		Map<String,String> companyAddress=new HashMap<String, String>();
		companyAddress.put("name", "Presidio");
		companyAddress.put("doorno", "8th floor");
		companyAddress.put("street", "coda street");
		companyAddress.put("area", "guindy");
		companyAddress.put("city", "chennai");
		companyAddress.put("pincode", "600087");
		
		Map<String,ArrayList<Float>> cart=(Map<String,ArrayList<Float>>)session.getAttribute("cart");
		
		Map<String,String> deliveryAddress=(Map<String,String>)session.getAttribute("deliveryAddress");
		
		String filepath=environment.getRequiredProperty("filepath");
		
		Float discount=Float.valueOf(environment.getRequiredProperty("cart.discount"));
		
		Float tax=Float.valueOf(environment.getRequiredProperty("cart.tax"));
		
		
		paymentService.generatePDF(invoiceNumber, companyAddress, deliveryAddress, cart, discount, tax,filepath);
		paymentService.generateExcel(invoiceNumber, companyAddress, deliveryAddress, cart, discount, tax,filepath);
		
//		int Uid=(int) session.getAttribute("Uid");
//		paymentService.storeInvoice(invoiceNumber, LocalDateTime.now().toLocalDate().toString(), Uid, filepath+"/"+invoiceNumber+".pdf", filepath+"/"+invoiceNumber+".xlsx");
		
		String email=user.getEmail();
		try {			
			paymentService.sendEmail(new String[] {email}, "Invoice for your order", "", filepath+"/"+invoiceNumber+".pdf", filepath+"/"+invoiceNumber+".xlsx"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.removeAttribute("cart");
		session.removeAttribute("deliveryAddress");
		mandv.setViewName("orderplaced");
		return mandv;
	}

}
