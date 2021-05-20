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
import com.services.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public ModelAndView register(ModelAndView mandv) {
		LoginForm loginForm=new LoginForm();		
		mandv.addObject("loginForm", loginForm);
		mandv.setViewName("login");
		return mandv;
	}
	@RequestMapping(value = "submitLogin",method = RequestMethod.POST)
	public String submitLogin(ModelAndView mandv,@Valid LoginForm loginForm,BindingResult result,HttpServletRequest request) {
		String returnString="";
		if(result.hasErrors()) {
			returnString="login";
		}else {
			User user=loginService.isUserPresent(loginForm.getUsername());
			System.out.println(user);
			if(user!=null) {
				if(user.getPassword().equals(loginForm.getPassword())) {
					HttpSession session= request.getSession();
					session.setAttribute("user", user);
					returnString="redirect:/home";					
				}else {
					mandv.addObject("passwordError", ":password incorrect");
					returnString="login";
				}
			}else {
				mandv.addObject("usernameError", ":user doesn't exists");
				returnString="login";
			}
		}
		return returnString;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
}
