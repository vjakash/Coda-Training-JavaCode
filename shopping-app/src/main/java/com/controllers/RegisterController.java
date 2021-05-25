package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.LoginForm;
import com.model.User;
import com.services.RegisterService;

@Controller
@RequestMapping("/")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@RequestMapping(value = "register",method = RequestMethod.GET)
	public ModelAndView register(ModelAndView mandv,HttpServletRequest request) {
		User user=new User();		
		mandv.addObject("user", user);
		mandv.setViewName("register");
		HttpSession session= request.getSession();
		session.setAttribute("passwordError", "");
		session.setAttribute("usernameError", "");
		return mandv;
	}
	@RequestMapping(value = "submitRegister",method = RequestMethod.POST)
	public String submitRegister(ModelAndView mandv,@Valid User user,BindingResult result) {
		String resultPage="";
		if(result.hasErrors()) {
			resultPage="register";
		}else {
			if(registerService.isUsernameExist(user.getUsername())) {
				mandv.addObject("usernameError", ":user already exists");
				resultPage="register";
			}else {				
				registerService.registerUser(user);
				resultPage="redirect:/";
			}
		}
		return resultPage;
	}
	public RegisterService getRegisterService() {
		return registerService;
	}
	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}
}
