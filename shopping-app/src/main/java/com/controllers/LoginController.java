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
import com.utilities.SendMail;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public ModelAndView getLoginPage(ModelAndView mandv,HttpServletRequest request) {
		LoginForm loginForm=new LoginForm();		
		mandv.addObject("loginForm", loginForm);
		mandv.setViewName("login");
		HttpSession session= request.getSession();
		session.setAttribute("passwordError", "");
		session.setAttribute("usernameError", "");

		return mandv;
	}
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	public String logout(ModelAndView mandv,HttpServletRequest request) {
		LoginForm loginForm=new LoginForm();		
		mandv.addObject("loginForm", loginForm);
		mandv.setViewName("login");
		HttpSession session= request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping(value = "submitLogin",method = RequestMethod.POST)
	public String submitLogin(ModelAndView mandv,@Valid LoginForm loginForm,BindingResult result,HttpServletRequest request) {
		String returnString="";
		HttpSession session= request.getSession();
		if(result.hasErrors()) {
			returnString="login";
		}else {
			User user=loginService.isUserPresent(loginForm.getUsername());
			
			if(user!=null) {
				if(user.getPassword().equals(loginForm.getPassword())) {
					session.setAttribute("user", user);
					session.setAttribute("passwordError", "");
					session.setAttribute("usernameError", "");
					returnString="redirect:/home";					
				}else {
					session.setAttribute("passwordError", ":password incorrect");
					returnString="login";
				}
			}else {
				System.out.println("user doesn't exit");
				session.setAttribute("usernameError", ":user doesn't exists");
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
