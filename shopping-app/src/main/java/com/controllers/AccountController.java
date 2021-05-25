package com.controllers;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.AddToCartForm;
import com.model.Address;
import com.model.User;
import com.services.AccountService;
import com.services.LoginService;


@Controller
@RequestMapping("/")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "account",method = RequestMethod.GET)
	public ModelAndView getAccountPage(ModelAndView mandv,HttpServletRequest request) {
		HttpSession session=request.getSession();
		Map<String, ArrayList<Float>> cart=(Map<String, ArrayList<Float>>)session.getAttribute("cart");
		if(cart==null) {
			session.setAttribute("totalItems", 0);
		}else {
			session.setAttribute("totalItems", cart.keySet().size());
		}
		Address address=new Address();
		User user=(User)session.getAttribute("user");
		
		user=loginService.isUserPresent(user.getUsername());
		
		session.setAttribute("user",user);
		session.removeAttribute("succesMsg");
		
		mandv.addObject("user",user);
		mandv.addObject("address",address);
		mandv.addObject("addresses",user.getAddresses());
		
		mandv.setViewName("account");
		return mandv;
	}
	
	@RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
	public ModelAndView updateUserInfo(ModelAndView mandv,@Valid User user,BindingResult result,HttpServletRequest request) {
		String resultPage="";
		HttpSession session=request.getSession();
		if(result.hasErrors()) {
//			Address address=new Address();
//			mandv.addObject("address",address);
//			mandv.setViewName("account");
//			resultPage="account";
		}else {
			user.setUid(((User)session.getAttribute("user")).getUid());
			int count=accountService.updateUser(user);
			user=loginService.isUserPresent(user.getUsername());
			session.setAttribute("user",user);
			session.setAttribute("succesMsg", "Info Updated succefully");
		}
		Address address=new Address();
		mandv.addObject("address",address);
		mandv.addObject("addresses",user.getAddresses());
		mandv.setViewName("account");
		return mandv;
	}
	@RequestMapping(value = "saveAddress",method = RequestMethod.POST)
	public ModelAndView saveAddress(ModelAndView mandv,@Valid Address address,BindingResult result,HttpServletRequest request) {
		String resultPage="";
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(result.hasErrors()) {
			mandv.setViewName("account");
		}else {
			address.setUser(user);
			accountService.createAddress(address);
			mandv.setViewName("redirect:/account");
		}
		
		return mandv;
	}
	@RequestMapping(value = "deleteAddress/{addressId}",method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Integer> deleteAddress(ModelAndView mandv,@PathVariable("addressId") String addressId,HttpServletRequest request) {		
		accountService.deleteAddress(addressId);
//		mandv.setViewName("redirect:/account");		
		return new ResponseEntity<Integer>(200 ,HttpStatus.OK);
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
}
